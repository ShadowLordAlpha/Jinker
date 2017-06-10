package com.shadowcs.jinker.clazz.field;

import java.io.DataInput;
import java.io.IOException;
import com.shadowcs.jinker.clazz.attribute.AttributeInfo;

public class FieldInfo {

	private int accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private AttributeInfo[] attributes;

	public FieldInfo(DataInput data) throws IOException {
		accessFlags = data.readUnsignedShort();
		nameIndex = data.readUnsignedShort() - 1;
		descriptorIndex = data.readUnsignedShort() - 1;
		attributes = AttributeInfo.parseAttributes(data);
	}

	public static FieldInfo[] parseFields(DataInput data) throws IOException {

		int fieldsCount = data.readUnsignedShort();
		FieldInfo[] fields = new FieldInfo[fieldsCount];
		for(int i = 0; i < fields.length; i++) {
			fields[i] = new FieldInfo(data);
		}
		
		return fields;
	}
}
