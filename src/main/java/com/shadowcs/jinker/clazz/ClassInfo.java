package com.shadowcs.jinker.clazz;

import java.io.DataInput;
import java.io.IOException;
import com.shadowcs.jinker.clazz.attribute.AttributeInfo;
import com.shadowcs.jinker.clazz.constant.ConstantPoolInfo;
import com.shadowcs.jinker.clazz.field.FieldInfo;
import com.shadowcs.jinker.clazz.method.MethodInfo;

public class ClassInfo {

	private int minorVersion;
	private JavaVersion majorVersion;
	private ConstantPoolInfo[] constantPool;
	private int accessFlags;
	private int thisClass;
	private int superClass;
	private int[] interfaces;
	private FieldInfo[] fields;
	private MethodInfo[] methods;
	private AttributeInfo[] attributes;

	public ClassInfo(DataInput data) throws IOException {

		// Magic number that shows a file is a class file
		int magic = data.readInt();
		if(!(magic == 0xCAFE_BABE)) { throw new RuntimeException("Data is not recognized as a Class file!"); }

		minorVersion = data.readUnsignedShort();
		majorVersion = JavaVersion.getJavaVersion(data.readUnsignedShort());

		constantPool = ConstantPoolInfo.parseConstantPool(data);

		accessFlags = data.readUnsignedShort();

		thisClass = data.readUnsignedShort() - 1;
		superClass = data.readUnsignedShort() - 1;

		int interfaceCount = data.readUnsignedShort();
		interfaces = new int[interfaceCount];
		for(int i = 0; i < interfaces.length; i++) {
			interfaces[i] = data.readUnsignedShort() - 1;
		}

		fields = FieldInfo.parseFields(data);
		methods = MethodInfo.parseMethods(data);
		attributes = AttributeInfo.parseAttributes(data);
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public JavaVersion getMajorVersion() {
		return majorVersion;
	}

	public ConstantPoolInfo[] getConstantPool() {
		return constantPool;
	}

	public int getAccessFlags() {
		return accessFlags;
	}

	public int getThisClass() {
		return thisClass;
	}

	public int getSuperClass() {
		return superClass;
	}

	public int[] getInterfaces() {
		return interfaces;
	}

	public FieldInfo[] getFields() {
		return fields;
	}

	public MethodInfo[] getMethods() {
		return methods;
	}

	public AttributeInfo[] getAttributes() {
		return attributes;
	}
}
