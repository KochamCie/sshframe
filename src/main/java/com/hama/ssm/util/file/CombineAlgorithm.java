package com.hama.ssm.util.file;

import org.apache.commons.beanutils.converters.DoubleArrayConverter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by rns on 2017/1/19.
 */
public class CombineAlgorithm {
    private final static String baseDir = "H:\\xwjr\\tuojianlin";

    private final static String suffix = "csv";
    /* 原M个数据数组 */
    private List src;

    /* src数组的长度 */
    private int m;

    /* 需要获取N个数 */
    private int n;

    //临时变量，obj的行数
    private int objLineIndex;

    /* 存放结果的二维数组 */
    //public Object[][] obj;
    public List objList;


    public CombineAlgorithm(List src, int getNum) throws Exception {
        if (src == null)
            throw new Exception("原数组为空.");
        if (src.size() < getNum)
            throw new Exception("要取的数据比原数组个数还 大 .");
        this.src = src;
        m = src.size();
        n = getNum;

        /*  初始化  */
        objLineIndex = 0;
        //obj = new Object[combination(m,n)][n];
        objList=new ArrayList();
        List tmp = new ArrayList();
        combine(src, 0, 0, n, tmp);
    }

    /**
     * <p>
     * 计算 C(m,n)个数 = (m!)/(n!*(m-n)!)
     * </p>
     * 从M个数中选N个数，函数返回有多少种选法 参数 m 必须大于等于 n m = 0; n = 0; retuan 1;
     *
     * @param m
     * @param n
     * @return
     * @since royoan 2014-6-13 下午8:25:33
     */
    public int combination(int m, int n) {
        if (m < n)
            return 0; // 如果总数小于取出的数，直接返回0

        int k = 1;
        int j = 1;
        // 该种算法约掉了分母的(m-n)!,这样分子相乘的个数就是有n个了
        for (int i = n; i >= 1; i--) {
            k = k * m;
            j = j * n;
            m--;
            n--;
        }
        return k / j;
    }

    /**
     * <p> 递归算法，把结果写到obj二维数组对象 </p>
     * @param src
     * @param srcIndex
     * @param i
     * @param n
     * @param tmp
     * @since royoan 2014-6-15 上午11:22:24
     */
    private void combine(List src, int srcIndex, int i, int n, List tmp) {
        int j;
        for (j = srcIndex; j < src.size() - (n - 1); j++ ) {
            tmp.add(j,src.get(j));
            if (n == 1) {
                //System.out.println(Arrays.toString(tmp));
                objList.addAll(tmp);

                //System.arraycopy(tmp, 0, obj[objLineIndex], 0, tmp.size());
                //obj[objLineIndex] = tmp;
                objLineIndex ++;
            } else {
                n--;
                i++;
                combine(src, j+1, i, n, tmp);
                n++;
                i--;
            }
        }

    }

    public List getResutl() {
        return objList;

    }

    /**
     * 用法实例
     * @param args
     * @throws Exception
     * @since royoan 2014-6-15 下午8:21:05
     */
    public static void main(String[] args) throws Exception {
        List a = new ArrayList();
        for (int i = 0; i <10 ; i++) {
            a.add(i);
        }

        CombineAlgorithm ca = new CombineAlgorithm(a, 7);

        List c = ca.getResutl();
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }

    }
}
