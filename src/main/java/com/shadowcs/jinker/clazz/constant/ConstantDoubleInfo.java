package com.shadowcs.jinker.clazz.constant;

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
}
