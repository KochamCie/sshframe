package com.hama.ssm.util.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;

public class ReadFile {

	/**
	 * 文件目录
	 */
	private final static String baseDir = "C:\\Users\\Administrator\\Downloads";

	/**
	 * 文件后缀
	 */
	private final static String suffix = "json";

	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");

	/**
	 * 正则匹配http地址
	 */
	private final static String regexForActivateUser = "(http)+://[^\\s]*";

	public static void main(String args[]) throws IOException {

		// 需求：获取文件中正则匹配的数据
		// 获取目录下的目标文件
		Collection<File> collection = FileUtils.listFiles(new File(baseDir),
				FileFilterUtils.suffixFileFilter(suffix),
				DirectoryFileFilter.INSTANCE);
		for (File file : collection) {

			// 最后一次更改时间，未做更改即是创建时间
			Long lastModifiedTime = file.lastModified();
			// 读取文件内容转成String
			String contentToString = FileUtils.readFileToString(file, "UTF-8");

			Matcher matcher = Pattern.compile(regexForActivateUser).matcher(
					contentToString);
			// 存放全部匹配记录，用于统计总数
			List<String> all = new ArrayList<String>();
			// 运用map的key唯一性去重
			Map<String, Object> distinct = new HashMap<String, Object>();
			
			String tem = "";
			String userId = "";
			int a = 0;
			while (matcher.find()) {
				tem = matcher.group();
				userId = tem.substring(tem.indexOf("activate/") + 9,
						tem.length());// 截取出userId
				all.add(userId);
				if(distinct.containsKey(userId)){
					a++;
				}
				distinct.put(userId, userId);
			}
			System.out.println("截止到[" + sdf.format(new Date(lastModifiedTime))
					+ "],请求总数为[" + all.size() + "],去重后总数为[" + distinct.size()
					+ "]");
		}

	}

}
