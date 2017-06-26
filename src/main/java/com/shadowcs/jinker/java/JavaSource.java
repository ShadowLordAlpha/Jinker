package com.shadowcs.jinker.java;

import java.io.IOException;
import java.io.Writer;
import com.shadowcs.jinker.Writable;

/**
 * 
 * 
 * @author Josh "ShadowLordAlpha"
 *
 */
public class JavaSource implements Writable<JavaSource> {

	private String packaeg;
	
	
	public JavaSource() {
		
	}
	
	public JavaSource setPackage(String pack) {
		packaeg = pack;
		return this;
	}

	@Override
	public JavaSource write(Writer out) throws IOException {
		
		if(!(packaeg == null || packaeg.isEmpty())) {
			out.write("package ");
			out.write(packaeg);
			out.write(";\n\n");
		}
		
		return this;
	}
}
