package com.shadowcs.jinker_old.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantStringInfo extends ConstantPoolInfo {

	private int stringIndex;

	ConstantStringInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_String); // This is already known from the tag in the binary file

		/*
		 * This value is modified now so that we don't need to do so many times later in the code because someone
		 * thought it would be a good idea to start at 1 instead of 0
		 */
		stringIndex = input.readUnsignedShort() - 1;
	}

	@Override
	public int getStringIndex() {
		return this.stringIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + stringIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantStringInfo other = (ConstantStringInfo) obj;
		if(stringIndex != other.stringIndex) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantStringInfo [stringIndex=" + stringIndex + "]";
	}
}
