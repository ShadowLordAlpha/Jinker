package com.shadowcs.jinker.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantLongInfo extends ConstantPoolInfo {

	private long value;

	ConstantLongInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_Long); // This is already known from the tag in the binary file

		int high_bytes = input.readInt();
		int low_bytes = input.readInt();
		value = ((long) high_bytes << 32) + low_bytes;
	}

	@Override
	public long getLong() {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (value ^ (value >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantLongInfo other = (ConstantLongInfo) obj;
		if(value != other.value) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantLongInfo [value=" + value + "]";
	}
}
