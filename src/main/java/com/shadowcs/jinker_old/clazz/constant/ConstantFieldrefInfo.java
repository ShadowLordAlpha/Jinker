package com.shadowcs.jinker_old.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantFieldrefInfo extends ConstantPoolInfo {

	private int classIndex;
	private int nameAndTypeIndex;

	ConstantFieldrefInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_Fieldref); // This is already known from the tag in the binary file

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + classIndex;
		result = prime * result + nameAndTypeIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantFieldrefInfo other = (ConstantFieldrefInfo) obj;
		if(classIndex != other.classIndex) return false;
		if(nameAndTypeIndex != other.nameAndTypeIndex) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantFieldrefInfo [classIndex=" + classIndex + ", nameAndTypeIndex=" + nameAndTypeIndex + "]";
	}
}
