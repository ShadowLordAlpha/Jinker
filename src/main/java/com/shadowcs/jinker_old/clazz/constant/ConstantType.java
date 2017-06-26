package com.shadowcs.jinker_old.clazz.constant;

public enum ConstantType {

	// while normally I would fully capitalize these they are currently as they appear in the docs.
	CONSTANT_Class(7),
	CONSTANT_Fieldref(9),
	CONSTANT_Methodref(10),
	CONSTANT_InterfaceMethodref(11),
	CONSTANT_String(8),
	CONSTANT_Integer(3),
	CONSTANT_Float(4),
	CONSTANT_Long(5),
	CONSTANT_Double(6),
	CONSTANT_NameAndType(12),
	CONSTANT_Utf8(1),
	CONSTANT_MethodHandle(15),
	CONSTANT_MethodType(16),
	CONSTANT_InvokeDynamic(18);

	private int value;
	
	private ConstantType(int value) {
		this.value = value;
	}
	
	public static ConstantType getFromTag(int value) {
		for(ConstantType type: ConstantType.values()) {
			if(type.value == value) {
				return type;
			}
		}
		
		return null;
	}
}
