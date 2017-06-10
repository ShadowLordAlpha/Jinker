package com.shadowcs.jinker.clazz.constant;

import java.io.DataInput;
import java.io.IOException;

/**
 * The constant_pool is a table of structures (§4.4) representing various string constants, class and interface names,
 * field names, and other constants that are referred to within the ClassFile structure and its substructures. The
 * format of each constant_pool table entry is indicated by its first "tag" byte.
 * 
 * The constant_pool table is indexed from 1 to constant_pool_count - 1.
 *
 */
public abstract class ConstantPoolInfo {

	private ConstantType constantType;

	public ConstantPoolInfo(ConstantType type) {
		this.constantType = type;
	}
	
	public ConstantType getConstantType() {
		return this.constantType;
	}
	
	// Technically a number of these could be condenced into one or two fields but doing it this way allows for runtime errors when the wrong class is
	// used but has an index and they line up better with the documentation
	public int getNameIndex() {
		throw new UnsupportedOperationException();
	}
	
	public int getClassIndex() {
		throw new UnsupportedOperationException();
	}
	
	public int getNameAndTypeIndex() {
		throw new UnsupportedOperationException();
	}
	
	public int getStringIndex() {
		throw new UnsupportedOperationException();
	}
	
	public int getDescriptorIndex() {
		throw new UnsupportedOperationException();
	}
	
	public int getReferenceKind() {
		throw new UnsupportedOperationException();
	}
	
	public int getReferenceIndex() {
		throw new UnsupportedOperationException();
	}
	
	public int getBootstrapMethodAttrIndex() {
		throw new UnsupportedOperationException();
	}
	
	// These are a little odd as there is no way of getting a primitive byte or short or char
	
	// not supported by string but by utf8
	public String getString() {
		throw new UnsupportedOperationException();
	}
	
	public int getInt() {
		throw new UnsupportedOperationException();
	}
	
	public float getFloat() {
		throw new UnsupportedOperationException();
	}
	
	// TODO: long and double need to be checked that they decode their values properly as
	// the decoding is a little odd
	public long getLong() {
		throw new UnsupportedOperationException();
	}
	
	public double getDouble() {
		throw new UnsupportedOperationException();
	}
	
	public static ConstantPoolInfo[] parseConstantPool(DataInput data) throws IOException {

		int constantPoolCount = data.readUnsignedShort();
		ConstantPoolInfo[] constantPool = new ConstantPoolInfo[constantPoolCount - 1];
		for(int i = 0; i < constantPool.length; i++) {
			constantPool[i] = parseConstant(data);
		}

		return constantPool;
	}

	private static ConstantPoolInfo parseConstant(DataInput data) throws IOException {
		
		switch(ConstantType.getFromTag(data.readUnsignedByte())) {
			case CONSTANT_Class:
				return new ConstantClassInfo(data);
			case CONSTANT_Double:
				return new ConstantDoubleInfo(data);
			case CONSTANT_Fieldref:
				return new ConstantFieldrefInfo(data);
			case CONSTANT_Float:
				return new ConstantFloatInfo(data);
			case CONSTANT_Integer:
				return new ConstantIntegerInfo(data);
			case CONSTANT_InterfaceMethodref:
				return new ConstantInterfaceMethodrefInfo(data);
			case CONSTANT_InvokeDynamic:
				return new ConstantInvokeDynamicInfo(data);
			case CONSTANT_Long:
				return new ConstantLongInfo(data);
			case CONSTANT_MethodHandle:
				return new ConstantMethodHandleInfo(data);
			case CONSTANT_MethodType:
				return new ConstantMethodTypeInfo(data);
			case CONSTANT_Methodref:
				return new ConstantMethodrefInfo(data);
			case CONSTANT_NameAndType:
				return new ConstantNameAndTypeInfo(data);
			case CONSTANT_String:
				return new ConstantStringInfo(data);
			case CONSTANT_Utf8:
				return new ConstantUtf8Info(data);
			default:
				System.out.println("Something dun fuked up");
				return null;
		}
	}
}
