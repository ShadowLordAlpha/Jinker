package com.shadowcs.jinker.java;

import java.io.IOException;
import java.io.Writer;
import com.shadowcs.jinker.Writable;

public class JavaClass implements Writable<JavaClass> {

	private AccessLevel access = AccessLevel.PUBLIC;
	private String name;
	// TODO: Fields, Methods, other

	@Override
	public JavaClass write(Writer out) throws IOException {
		// TODO Auto-generated method stub
		
		out.write(access.getModifier());
		out.write("class ");
		out.write(name);
		out.write(" {\n\n");
		
		out.write("}\n");
		
		return this;
	}
}
