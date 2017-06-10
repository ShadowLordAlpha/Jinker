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
}
