package com.shadowcs.jinker_old.clazz.attribute;

import java.io.DataInput;
import java.io.IOException;

public class AttributeCode extends AttributeInfo {
	
	private byte[] value;

	public AttributeCode(DataInput data) throws IOException {

		super("Code");
		
		value = new byte[data.readInt()]; // not honestly needed whenever I bother to finish this class
		data.readFully(value);
		
	}

}
