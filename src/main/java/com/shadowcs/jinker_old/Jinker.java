package com.shadowcs.jinker_old;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.shadowcs.jinker_old.clazz.ClassInfo;
import com.shadowcs.jinker_old.util.CliArgs;

public class Jinker {
	
	
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
