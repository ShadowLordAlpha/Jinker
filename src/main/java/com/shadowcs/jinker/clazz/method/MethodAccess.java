package com.shadowcs.jinker.clazz.method;


public enum MethodAccess {

	// these can't they override some values in the other files
	ACC_PUBLIC(0x0001),
	ACC_PRIVATE(0x0002),
	ACC_PROTECTED(0x0004),
	ACC_STATIC(0x0008),
	ACC_FINAL(0x0010),
	ACC_SYNCHRONIZED(0x0020),
	ACC_BRIDGE(0x0040),
	ACC_VARARGS(0x0080),
	ACC_NATIVE(0x0100),
	ACC_ABSTRACT(0x0400),
	ACC_SYNTHETIC(0x1000);

	private int flag;

	private MethodAccess(int flag) {
		this.flag = flag;
	}
	
	public boolean checkMask(int mask) {
		if((this.flag & mask) == this.flag) {
			return true;
		}
		
		return false;
	}
}
