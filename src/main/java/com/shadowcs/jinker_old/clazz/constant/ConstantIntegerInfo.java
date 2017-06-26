package com.shadowcs.jinker_old.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantIntegerInfo extends ConstantPoolInfo {

	private int bytes;

	ConstantIntegerInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_Integer); // This is already known from the tag in the binary file

		/*
		 * This value is modified now so that we don't need to do so many times later in the code because someone
		 * thought it would be a good idea to start at 1 instead of 0
		 */
		bytes = input.readInt();
	}

	@Override
	public int getInt() {
		return this.bytes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bytes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantIntegerInfo other = (ConstantIntegerInfo) obj;
		if(bytes != other.bytes) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantIntegerInfo [bytes=" + bytes + "]";
	}
}
