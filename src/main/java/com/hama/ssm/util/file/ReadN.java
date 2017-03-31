package com.hama.ssm.util.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by rns on 2017/1/19.
 */
public class ReadN {

    private final static String baseDir = "H:\\xwjr\\tuojianlin";

    private final static String suffix = "csv";

    private final static SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy-MM-dd hh:mm:ss");

    private final static double total=21704.6;

    public static void main(String args []) throws Exception {

        // 获取目录下的目标文件
        Collection<File> collection = FileUtils.listFiles(new File(baseDir),
                FileFilterUtils.suffixFileFilter(suffix),
                DirectoryFileFilter.INSTANCE);
        for (File file : collection) {

            List<String> list=FileUtils.readLines(file);
            List<Double> doubles = new ArrayList<Double>(list.size());

            for(String str : list){
                doubles.add(Double.valueOf(str));
            }
            int loop=4;
            CombineAlgorithm ca=new CombineAlgorithm(doubles,loop);
            List c = ca.getResutl();
            for (Object o : c
                 ) {
                System.out.println(o);
            }

        }

    }

    public static void doCalc(int loop,List<Double> list){



    }



}
