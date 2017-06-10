package com.shadowcs.jinker.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantNameAndTypeInfo extends ConstantPoolInfo {

	private int nameIndex;
	private int descriptorIndex;

	ConstantNameAndTypeInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_NameAndType); // This is already known from the tag in the binary file

		/*
		 * This value is modified now so that we don't need to do so many times later in the code because someone
		 * thought it would be a good idea to start at 1 instead of 0
		 */
		nameIndex = input.readUnsignedShort() - 1;
		descriptorIndex = input.readUnsignedShort() - 1;
	}

	public int getNameIndex() {
		return this.nameIndex;
	}
	
	public int getDescriptorIndex() {
		return this.descriptorIndex;
	}
}
