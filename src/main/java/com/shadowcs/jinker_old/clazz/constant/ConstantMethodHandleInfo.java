package com.shadowcs.jinker_old.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantMethodHandleInfo extends ConstantPoolInfo {

	private int referenceKind; // TODO: this should become an enum and not be an int
	private int referenceIndex;

	ConstantMethodHandleInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_MethodHandle); // This is already known from the tag in the binary file

		referenceKind = input.readUnsignedByte();
		/*
		 * This value is modified now so that we don't need to do so many times later in the code because someone
		 * thought it would be a good idea to start at 1 instead of 0
		 */
		referenceIndex = input.readUnsignedShort() - 1;
	}
	
	@Override
	public int getReferenceKind() {
		return this.referenceKind;
	}

	@Override
	public int getReferenceIndex() {
		return this.referenceIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + referenceIndex;
		result = prime * result + referenceKind;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantMethodHandleInfo other = (ConstantMethodHandleInfo) obj;
		if(referenceIndex != other.referenceIndex) return false;
		if(referenceKind != other.referenceKind) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantMethodHandleInfo [referenceKind=" + referenceKind + ", referenceIndex=" + referenceIndex + "]";
	}
}
