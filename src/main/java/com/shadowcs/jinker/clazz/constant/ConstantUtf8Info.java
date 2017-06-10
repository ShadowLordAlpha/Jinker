package com.shadowcs.jinker.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

public class ConstantUtf8Info extends ConstantPoolInfo {

	private String string;

	ConstantUtf8Info(DataInput input) throws IOException {
		super(ConstantType.CONSTANT_Utf8); // This is already known from the tag in the binary file

		string = input.readUTF();
	}

	@Override
	public String getString() {
		return this.string;
	}
}
