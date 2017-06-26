package com.shadowcs.jinker_old.clazz.field;

import java.io.DataInput;
import java.io.IOException;
import com.shadowcs.jinker_old.clazz.attribute.AttributeInfo;

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

	public int getAccessFlags() {
		return accessFlags;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	public AttributeInfo[] getAttributes() {
		return attributes;
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
