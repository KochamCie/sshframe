package com.hama.ssm.informationDisclosure.web;

import com.hama.ssm.informationDisclosure.entity.EchartOption.*;
import com.hama.ssm.informationDisclosure.entity.HistogramOption;
import com.hama.ssm.informationDisclosure.entity.User;
import com.hama.ssm.informationDisclosure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rns on 2017/1/6.
 */
@Controller
@RequestMapping(value = "/user")
public class UserAPI {

    @Autowired
    private UserService userService;

    /**
     * @Description:获取用户信息
     * @Param:
     * @Return:
     * @Author: rns
     * @Date: 2017/4/17
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmployee(String id) {
        Map<String, Object> result = new HashMap<String, Object>();
        User user = userService.selectByPrimaryKey(id);
        result.put("user", user);
        return result;
    }

    @RequestMapping(value = "/monthlyLoanCount/{year}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> monthlyLoanCountByYear(@PathVariable String year) {
        Map<String, Object> result = new HashMap<String, Object>();


        // 组装返回柱状图
        HistogramOption ho = new HistogramOption();
        // title部分
        Title title = new Title();
        title.setText("借款笔数（数据更新至2017年04月17日）");
        ho.setTitle(title);
        // tooltip部分
        ho.setTooltip(new Tooltip());

        // legend部分
        Legend legend = new Legend();
        legend.setData("['借款笔数']");
        ho.setLegend(legend);

        // x轴对应的显示
        Xaxis xaxis = new Xaxis();
        String[] array = new String[]{
                "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"
        };
        xaxis.setData(array);
        ho.setxAxis(xaxis);

        // 数据
        Data data = new Data();
        data.setName("借款笔数");
        data.setType("bar");
        data.setBarWidth("60%");
        List<Integer> list = userService.monthlyLoanCountByYear(year);
        int[] intarr = new int[list.size()];
        int i = 0;
        for (Integer count : list
                ) {
            intarr[i] = count;
            i++;
        }
        data.setData(intarr);

        Data[] datas = new Data[]{
                data
        };

        // series部分
        ho.setSeries(datas);

        result.put("ho", ho);

        return result;
    }


}
