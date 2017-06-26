package com.shadowcs.jinker_old.clazz.constant;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((string == null) ? 0 : string.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(getClass() != obj.getClass()) return false;
		ConstantUtf8Info other = (ConstantUtf8Info) obj;
		if(string == null) {
			if(other.string != null) return false;
		} else if(!string.equals(other.string)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstantUtf8Info [string=" + string + "]";
	}
}
