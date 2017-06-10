package com.shadowcs.jinker.clazz.constant;

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
}
