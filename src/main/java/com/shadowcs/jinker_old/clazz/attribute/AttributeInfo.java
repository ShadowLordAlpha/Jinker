package com.shadowcs.jinker_old.clazz.attribute;

import java.io.DataInput;
import java.io.IOException;
import com.shadowcs.jinker_old.clazz.constant.ConstantPoolInfo;

public abstract class AttributeInfo {

	private String attributeName;
	
	/*public AttributeInfo(DataInput data) throws IOException {
		attributeNameIndex = data.readUnsignedShort();
		int attributeLength = data.readInt();
		info = new byte[attributeLength];
		data.readFully(info);
	}*/
	
	public AttributeInfo(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public String getAttributeName() {
		return this.attributeName;
	}

	public static AttributeInfo[] parseAttributes(ConstantPoolInfo[] cpInfo, DataInput data) throws IOException {
		
		int attributesCount = data.readUnsignedShort();
		AttributeInfo[] attributes = new AttributeInfo[attributesCount];
		for(int i = 0; i < attributes.length; i++) {
			attributes[i] = parseAttribute(cpInfo, data);
		}
		
		return attributes;
	}
	
	public static AttributeInfo parseAttribute(ConstantPoolInfo[] cpInfo, DataInput data) throws IOException {
		
		// Why a string and not a number value??
		switch(cpInfo[data.readUnsignedShort() - 1].getString()) {
			case "ConstantValue":
				return new AttributeConstantValue(data);
			case "Code":
				return new AttributeCode(data);
			default:
				System.out.println("Something dun fuked it up");
				return null;
		}
	}
}
