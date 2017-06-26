package com.shadowcs.jinker;

import java.io.IOException;
import java.io.StringWriter;
import com.shadowcs.jinker.java.JavaSource;
import com.shadowcs.jinker.util.arg.CliParser;
import com.shadowcs.jinker.util.arg.Option;

public class Jinker {
	
	@Option
	private boolean help;

	public static void main(String[] args) {
		StringWriter sw = new StringWriter();
		try {
			new JavaSource().setPackage("test").write(sw);
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sw);
	}
}
