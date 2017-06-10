package com.shadowcs.jinker.clazz.method;

import java.io.DataInput;
import java.io.IOException;
import com.shadowcs.jinker.clazz.attribute.AttributeInfo;

public class MethodInfo {

	private int accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private AttributeInfo[] attributes;
	
	public MethodInfo(DataInput data) throws IOException {
		accessFlags = data.readUnsignedShort();
		nameIndex = data.readUnsignedShort() - 1;
		descriptorIndex = data.readUnsignedShort() - 1;
		attributes = AttributeInfo.parseAttributes(data);
	}

	public static MethodInfo[] parseMethods(DataInput data) throws IOException {
		
		int methodsCount = data.readUnsignedShort();
		MethodInfo[] methods = new MethodInfo[methodsCount];
		for(int i = 0; i < methods.length; i++) {
			methods[i] = new MethodInfo(data);
		}
		
		return methods;
	}
}
