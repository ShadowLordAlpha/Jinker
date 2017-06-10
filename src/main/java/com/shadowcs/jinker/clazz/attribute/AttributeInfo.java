package com.shadowcs.jinker.clazz.attribute;

import java.io.DataInput;
import java.io.IOException;

public class AttributeInfo {

	private int attributeNameIndex;
	private byte[] info;
	
	public AttributeInfo(DataInput data) throws IOException {
		attributeNameIndex = data.readUnsignedShort();
		int attributeLength = data.readInt();
		info = new byte[attributeLength];
		data.readFully(info);
	}

	public static AttributeInfo[] parseAttributes(DataInput data) throws IOException {
		
		int attributesCount = data.readUnsignedShort();
		AttributeInfo[] attributes = new AttributeInfo[attributesCount];
		for(int i = 0; i < attributes.length; i++) {
			attributes[i] = new AttributeInfo(data);
		}
		
		return attributes;
	}
}
