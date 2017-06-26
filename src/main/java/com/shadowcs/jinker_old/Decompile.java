package com.shadowcs.jinker_old;

import java.util.ArrayList;
import java.util.List;
import com.shadowcs.jinker_old.clazz.ClassAccess;
import com.shadowcs.jinker_old.clazz.ClassInfo;
import com.shadowcs.jinker_old.clazz.constant.ConstantClassInfo;
import com.shadowcs.jinker_old.clazz.constant.ConstantPoolInfo;
import com.shadowcs.jinker_old.clazz.constant.ConstantType;
import com.shadowcs.jinker_old.clazz.field.FieldAccess;
import com.shadowcs.jinker_old.clazz.field.FieldInfo;
import com.shadowcs.jinker_old.clazz.method.MethodInfo;

public class Decompile {

	private Decompile(String... file) {

	}
	
	
	// TODO: this might switch from a direct decompile to a much more indirect one where it generates objects
	// and those objects are used to generate the java files
	
	// temp method
	public static String decompileClassInfo(ClassInfo classInfo) {
		
		ConstantPoolInfo[] cpInfo = classInfo.getConstantPool();
		
		String qualifiedClassName = cpInfo[cpInfo[classInfo.getThisClass()].getNameIndex()].getString().replace("/", ".");
		String pack = qualifiedClassName.substring(0, qualifiedClassName.lastIndexOf("."));
		String className = qualifiedClassName.substring(qualifiedClassName.lastIndexOf(".") + 1);

		// This section is the java code
		StringBuilder builder = new StringBuilder();

		// TODO: header comment?
		
		// package
		// TODO: maybe allow for repackaging of classes in the default package
		builder.append("package ").append(pack).append(";\n\n");
		
		// imports
		// TODO: later in like version 0.0.3
		
		// basic class definition
		int accessFlags = classInfo.getAccessFlags();
		if(ClassAccess.ACC_PUBLIC.checkMask(accessFlags)) {
			builder.append("public ");
		}
		
		if(ClassAccess.ACC_ENUM.checkMask(accessFlags)) {
			builder.append("enum ");
		} else if(ClassAccess.ACC_ANNOTATION.checkMask(accessFlags)) {
			builder.append("@interface ");
		} else if(ClassAccess.ACC_INTERFACE.checkMask(accessFlags)) {
			builder.append("interface ");
		} else if(ClassAccess.ACC_ABSTRACT.checkMask(accessFlags)) {
			builder.append("abstract class ");
		} else {
			builder.append("class ");
		}
		builder.append(className).append(" ");
		// TODO: super class and interfaces
		
		builder.append("{\n\n");
		
		// Fields
		for(FieldInfo fInfo: classInfo.getFields()) {
			builder.append("\t").append(parseField(cpInfo, fInfo));
			// TODO: we might actually need to parse the value of a field as it comes out if its constant so we add the semicolon and other things here
			builder.append(";\n");
		}
		builder.append("\n");
		
		// Methods
		for(MethodInfo mInfo: classInfo.getMethods()) {
			
		}
		builder.append("\n");
		
		builder.append("}\n");
		
		return builder.toString();
	}
	
	private static String parseField(ConstantPoolInfo[] cpInfo, FieldInfo fieldInfo) {
		
		StringBuilder builder = new StringBuilder();
		// TODO: check if enum or not
		
		int mask = fieldInfo.getAccessFlags();
		// Field Access modifier
		if(FieldAccess.ACC_PUBLIC.checkMask(mask)) {
			builder.append("public ");
		} else if(FieldAccess.ACC_PRIVATE.checkMask(mask)) {
			builder.append("private ");
		} else if(FieldAccess.ACC_PROTECTED.checkMask(mask)) {
			builder.append("protected ");
		} 
		// none of those above need to actually be triggered as default or blank is valid
		
		// static modifier
		if(FieldAccess.ACC_STATIC.checkMask(mask)) {
			builder.append("static ");
		}
		
		// final modifier
		if(FieldAccess.ACC_FINAL.checkMask(mask)) {
			builder.append("final ");
		} else if(FieldAccess.ACC_VOLATILE.checkMask(mask)) {
			builder.append("volatile ");
		}
		
		// transient modifier
		if(FieldAccess.ACC_TRANSIENT.checkMask(mask)) {
			builder.append("transient ");
		}
		
		// this just shows something was added by the compiler not in the code itself
		if(FieldAccess.ACC_SYNTHETIC.checkMask(mask)) {
			builder.append("/* synthetic */ ");
		}
		
		// TODO: parse actual object that the field is
		builder.append(parseFieldDescriptor(cpInfo[fieldInfo.getDescriptorIndex()].getString()));
		
		// name of the field
		builder.append(cpInfo[fieldInfo.getNameIndex()].getString());
		
		System.out.println(" " + fieldInfo.getAttributes().length);
		
		return builder.toString();
	}
	
	private static String parseFieldDescriptor(String desc) {
		
		StringBuilder builder = new StringBuilder();
		
		int arrayDim = desc.lastIndexOf("[") + 1; // the cool thing is we can use this value to help parse the others as well
		System.out.print(desc + " " + arrayDim);
		switch(desc.charAt(arrayDim)) {
			case 'B':
				builder.append("byte ");
				break;
			case 'C':
				builder.append("char ");
				break;
			case 'D':
				builder.append("double");
				break;
			case 'F':
				builder.append("float");
				break;
			case 'I':
				builder.append("int");
				break;
			case 'J':
				builder.append("long");
				break;
			case 'S':
				builder.append("short");
				break;
			case 'Z':
				builder.append("boolean");
				break;
			case 'L':
				// we need to get rid of the L and the ; and then replace / with . to make them valid
				builder.append(desc.substring((arrayDim + 1), (desc.length() - 1)).replace("/", "."));
				break;
		}
		for(int i = 0; i < arrayDim; i++) {
			builder.append("[]");
		}
		// add the final space
		builder.append(" ");
		
		return builder.toString();
	}
	
	private static String parseMethod(ConstantPoolInfo[] cpInfo, MethodInfo methodInfo) {
		
		StringBuilder builder = new StringBuilder();
		
		
		
		return builder.toString();
	}
}
