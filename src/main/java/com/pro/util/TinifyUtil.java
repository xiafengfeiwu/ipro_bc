package com.pro.util;

import java.io.IOException;

import com.tinify.Options;
import com.tinify.Source;
import com.tinify.Tinify;

public class TinifyUtil {
	private final static String key = "BftUrs-GOyNz4N7Uc95Z6Z8PwgFYZ0Bj";
	private final static int default_width = 84;
	private final static int default_height = 84;

	/***
	 * 覆盖源文件压缩
	 * 
	 * @param filePath
	 * @return
	 */
	public static void coverCompress(String filePath) {
		Tinify.setKey(key);
		try {
			Tinify.fromFile(filePath).toFile(filePath);
		} catch (IOException e) {
		}
	}

	/***
	 * 宽高比例1:1剪切压缩本地文件
	 * 
	 * @param fromFilePath
	 * @param toSavePath
	 */
	public static void compressLocalFile(String fromFilePath, String toSavePath) {
		Tinify.setKey(key);
		try {
			Source source = Tinify.fromFile(fromFilePath);
			Options options = new Options().with("method", "cover").with("width", default_width).with("height",
					default_height);
			source.resize(options).toFile(toSavePath);
		} catch (IOException e) {
		}
	}

	/***
	 * 获取网络图片压缩处理并存储到本地
	 * 
	 * @param url
	 * @param toSavePath
	 * @return
	 */
	public static void compressNetFile(String url, String toSavePath) {
		Tinify.setKey(key);
		try {
			Source source = Tinify.fromUrl(url);
			Options options = new Options().with("method", "fit").with("width", default_width).with("height",
					default_height);
			source.resize(options).toFile(toSavePath);
		} catch (IOException e) {
		}
	}

}
