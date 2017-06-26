package com.shadowcs.jinker_old.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantFloatInfo extends ConstantPoolInfo {

	private float bytes;

	ConstantFloatInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_Float); // This is already known from the tag in the binary file

		/*
		 * This value is modified now so that we don't need to do so many times later in the code because someone
		 * thought it would be a good idea to start at 1 instead of 0
		 */
		bytes = input.readFloat();
	}

	@Override
	public float getFloat() {
		return this.bytes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(bytes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantFloatInfo other = (ConstantFloatInfo) obj;
		if(Float.floatToIntBits(bytes) != Float.floatToIntBits(other.bytes)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantFloatInfo [bytes=" + bytes + "]";
	}
}
