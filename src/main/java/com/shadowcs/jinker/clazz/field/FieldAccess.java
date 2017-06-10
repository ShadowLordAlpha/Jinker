package com.shadowcs.jinker.clazz.field;


public enum FieldAccess {

	// TODO: these might actually be able to be merged into the other access enums
	ACC_PUBLIC(0x0001),
	ACC_PRIVATE(0x0002),
	ACC_PROTECTED(0x0004),
	ACC_STATIC(0x0008),
	ACC_FINAL(0x0010),
	ACC_VOLATILE(0x0040),
	ACC_TRANSIENT(0x0080),
	ACC_SYNTHETIC(0x1000),
	ACC_ENUM(0x4000);

	private int flag;

	private FieldAccess(int flag) {
		this.flag = flag;
	}
	
	public boolean checkMask(int mask) {
		if((this.flag & mask) == this.flag) {
			return true;
		}
		
		return false;
	}
}
