package com.shadowcs.jinker.clazz.constant;

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
}
