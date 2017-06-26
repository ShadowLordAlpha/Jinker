package com.shadowcs.jinker_old.clazz;

public enum ClassAccess {

	ACC_PUBLIC(0x0001),
	ACC_FINAL(0x0010),
	ACC_SUPER(0x0020),
	ACC_INTERFACE(0x0200),
	ACC_ABSTRACT(0x0400),
	ACC_SYNTHETIC(0x1000),
	ACC_ANNOTATION(0x2000),
	ACC_ENUM(0x4000);

	private int flag;

	private ClassAccess(int flag) {
		this.flag = flag;
	}
	
	public boolean checkMask(int mask) {
		if((this.flag & mask) == this.flag) {
			return true;
		}
		
		return false;
	}
}
