package com.shadowcs.jinker.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantInterfaceMethodrefInfo extends ConstantPoolInfo {

	private int classIndex;
	private int nameAndTypeIndex;

	ConstantInterfaceMethodrefInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_InterfaceMethodref); // This is already known from the tag in the binary file

		/*
		 * This value is modified now so that we don't need to do so many times later in the code because someone
		 * thought it would be a good idea to start at 1 instead of 0
		 */
		classIndex = input.readUnsignedShort() - 1;
		nameAndTypeIndex = input.readUnsignedShort() - 1;
	}

	@Override
	public int getClassIndex() {
		return this.classIndex;
	}
	
	@Override
	public int getNameAndTypeIndex() {
		return this.nameAndTypeIndex;
	}
}
