package com.shadowcs.jinker_old.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantDoubleInfo extends ConstantPoolInfo {

	private double value;

	ConstantDoubleInfo(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_Double); // This is already known from the tag in the binary file

		int high_bytes = input.readInt();
		int low_bytes = input.readInt();
		value = Double.longBitsToDouble(((long) high_bytes << 32) + low_bytes); // I think this is correct;
	}

	@Override
	public double getDouble() {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantDoubleInfo other = (ConstantDoubleInfo) obj;
		if(Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantDoubleInfo [value=" + value + "]";
	}
}
