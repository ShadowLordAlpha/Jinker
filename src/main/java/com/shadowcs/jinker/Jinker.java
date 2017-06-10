package com.shadowcs.jinker;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.shadowcs.jinker.clazz.ClassInfo;
import com.shadowcs.jinker.util.CliArgs;

public class Jinker {
	
	private static final Logger LOG = LoggerFactory.getLogger(Jinker.class);
	
	public Jinker() {
		try {
			System.out.println(Decompile.decompileClassInfo(new ClassInfo(new DataInputStream(new FileInputStream("CliArgs.class")))));
		} catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String... args) {
		
		CliArgs cliArgs = new CliArgs(args);
		
		new Jinker();
	}
}
