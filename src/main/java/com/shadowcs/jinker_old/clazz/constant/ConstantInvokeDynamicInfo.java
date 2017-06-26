package com.shadowcs.jinker_old.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantInvokeDynamicInfo extends ConstantPoolInfo {

	private int bootstrapMethodAttrIndex;
	private int nameAndTypeIndex;

	ConstantInvokeDynamicInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_InvokeDynamic); // This is already known from the tag in the binary file

		/*
		 * This value is modified now so that we don't need to do so many times later in the code because someone
		 * thought it would be a good idea to start at 1 instead of 0
		 */
		bootstrapMethodAttrIndex = input.readUnsignedShort() - 1;
		nameAndTypeIndex = input.readUnsignedShort() - 1;
	}

	public int getBootstrapMethodAttrIndex() {
		return this.bootstrapMethodAttrIndex;
	}
	
	public int getNameAndTypeIndex() {
		return this.nameAndTypeIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bootstrapMethodAttrIndex;
		result = prime * result + nameAndTypeIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantInvokeDynamicInfo other = (ConstantInvokeDynamicInfo) obj;
		if(bootstrapMethodAttrIndex != other.bootstrapMethodAttrIndex) return false;
		if(nameAndTypeIndex != other.nameAndTypeIndex) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantInvokeDynamicInfo [bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex + ", nameAndTypeIndex=" + nameAndTypeIndex + "]";
	}
}
