package com.shadowcs.jinker.java;

import java.io.IOException;
import java.io.Writer;
import com.shadowcs.jinker.Writable;

public class JavaField implements Writable<JavaField> {

	private AccessLevel access = AccessLevel.DEFAULT;
	private String type; // TODO: maybe make this another class at some point
	private String name;
	// TODO: code is sometimes used to set here so it needs to be representable here

	// Access Modifiers
	public AccessLevel getAccessLevel() {
		return this.access;
	}

	// TODO: maybe make this private
	public JavaField setAccessLevel(AccessLevel access) {
		this.access = access;
		return this;
	}

	public JavaField setPublic() {
		return setAccessLevel(AccessLevel.PUBLIC);
	}

	public JavaField setProtected() {
		return setAccessLevel(AccessLevel.PROTECTED);
	}

	// Also known as default and default is what i normally use
	public JavaField setPackagePrivate() {
		return setAccessLevel(AccessLevel.DEFAULT);
	}

	public JavaField setPrivate() {
		return setAccessLevel(AccessLevel.PRIVATE);
	}
	// -----------

	public String getType() {
		return type;
	}

	public JavaField setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public JavaField setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public JavaField write(Writer out) throws IOException {

		out.write(access.getModifier());
		out.write(type);
		out.write(" ");
		out.write(name);
		out.write(";\n");
		
		return this;
	}
}
