package com.shadowcs.jinker;

import java.util.ArrayList;
import java.util.List;
import com.shadowcs.jinker.clazz.ClassInfo;
import com.shadowcs.jinker.clazz.constant.ConstantClassInfo;
import com.shadowcs.jinker.clazz.constant.ConstantPoolInfo;
import com.shadowcs.jinker.clazz.constant.ConstantType;

public class Decompile {

	private Decompile() {

	}

	// temp method
	public static String decompileClassInfo(ClassInfo classInfo) {

		// The qualified name of the class being decompiled
		String qualifiedClassName = classInfo.getConstantPool()[classInfo.getConstantPool()[classInfo.getThisClass()].getNameIndex()].getString();
		System.out.println("Qualified Class Name: " + qualifiedClassName);

		// Gather all the different classes being used in this class
		List<ConstantClassInfo> classList = new ArrayList<ConstantClassInfo>();
		for(ConstantPoolInfo cInfo : classInfo.getConstantPool()) {
			if(cInfo.getConstantType() == ConstantType.CONSTANT_Class) {
				if(!classList.contains(cInfo)) {
					classList.add((ConstantClassInfo) cInfo);
				}
				System.out.println("[LOG] Value: " + cInfo.getConstantType() + " " + cInfo.getClass().getName());
			}
		}

		List<ConstantClassInfo> remove = new ArrayList<ConstantClassInfo>();
		for(ConstantClassInfo value : classList) {
			String sValue = classInfo.getConstantPool()[value.getNameIndex()].getString();
			if(value == classInfo.getConstantPool()[classInfo.getThisClass()]) {
				remove.add(value);
			} else if((sValue.split("/").length == 3) && sValue.startsWith("java/lang")) {
				remove.add(value);
			} else if(sValue.startsWith("[")) { // TODO: figure out why this was happening
				System.out.println("Some junk got mixed in somehow");
				remove.add(value);
			}
		}
		classList.removeAll(remove); // because dumb

		classList.forEach((value) -> System.out.println("Class Constant: " + classInfo.getConstantPool()[value.getNameIndex()].getString()));

		StringBuilder builder = new StringBuilder();

		builder.append("/*").append("\n");
		builder.append(" * Decompiled with Jinker").append("\n *\n");
		builder.append(" * Java Version: ").append(classInfo.getMajorVersion()).append("\n");
		builder.append(" * Minor Version: ").append(classInfo.getMinorVersion()).append("\n");
		builder.append(" */").append("\n\n");

		// I get the package from parsing the name of the class

		return builder.toString();
	}
}
