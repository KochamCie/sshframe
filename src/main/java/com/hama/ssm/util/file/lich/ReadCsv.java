package com.hama.ssm.util.file.lich;/**
 * Created by Administrator on 2017/7/18.
 */

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rns
 * @create 2017-07-18 16:25
 */
public class ReadCsv {

    /**
     * 文件目录
     */
    private final static String baseDir = "C:\\Users\\Administrator\\Desktop\\logs\\ttt\\";

    /**
     * 文件后缀
     */
    private final static String suffix = "csv";

    private final static String regexForActivateUser = "^WHERE.*?2017$";

    private final static SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy-MM-dd hh:mm:ss");

    public static void main(String args[]) throws IOException {
        Long start = System.currentTimeMillis();
        ReadCsv rc = new ReadCsv();
        List<String> all = new ArrayList<String>();
        Map<String, Object> distinct = new HashMap<String, Object>();
        // 需求：获取文件中正则匹配的数据
        // 获取目录下的目标文件
        Collection<File> collection = FileUtils.listFiles(new File(baseDir),
                FileFilterUtils.suffixFileFilter(suffix),
                DirectoryFileFilter.INSTANCE);
        for (File file : collection) {

            List<String> list = FileUtils.readLines(file);
            // 比较相似性   统计情况
            for (int i= 0;i<list.size();i++){
                String string = list.get(i);
                Matcher matcher = Pattern.compile(regexForActivateUser).matcher(
                        string);
                if(string.contains("TB_LOAN WHERE (ID ='")){
                    String userId = string.substring(string.indexOf("TB_LOAN WHERE (ID ='")+19,
                            string.indexOf("2017")-3);// 截取出userId

                    all.add(userId);
                    distinct.put(userId,userId);
                }

            }
            System.out.println("总条数 ："+all.size());
            System.out.println("总条数为    ："+distinct.size());
        }

        String str = "1#2203NO525FANGXIEROADHUANGPUDISTRICTSHANGHAICHINA";
        String target = "1#2203NO525FANGXIEROADSHANGHAICN";
        String target2 = "1#2203NO525FANGXIEROADSHANGHAICN";
        //System.out.println("similarityRatio="+ rc.getSimilarityRatio(target2, target));
    }



    private int compare(String str, String target) {
        int d[][]; // 矩阵
        int n = str.length();
        int m = target.length();
        int i; // 遍历str的
        int j; // 遍历target的
        char ch1; // str的
        char ch2; // target的
        int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) { // 初始化第一列
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) { // 初始化第一行
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++) { // 遍历str
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }

                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    private int min(int one, int two, int three) {
        return (one = one < two ? one : two) < three ? one : three;
    }

    /**
     * 获取两字符串的相似度
     *
     * @param str
     * @param target
     * @return
     */
    public float getSimilarityRatio(String str, String target) {
        return 1 - (float)compare(str, target)/Math.max(str.length(), target.length());
    }

}
