package com.shadowcs.jinker_old.clazz.attribute;

import java.io.DataInput;
import java.io.IOException;

public class AttributeConstantValue extends AttributeInfo {
	
	private int constantValueIndex;

	public AttributeConstantValue(DataInput data) throws IOException {
		
		super("ConstantValue");
		
		if(data.readInt() != 2) {
			throw new RuntimeException();
		}
		
		constantValueIndex = data.readUnsignedShort() - 1;
	}

	public int getConstantValueIndex() {
		return constantValueIndex;
	}
}
