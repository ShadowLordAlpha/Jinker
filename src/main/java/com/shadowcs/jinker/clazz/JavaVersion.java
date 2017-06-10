package com.shadowcs.jinker.clazz;


public enum JavaVersion {

	JAVA_SE_9("Java SE 9", 0x35),
	JAVA_SE_8("Java SE 8", 0x34),
	JAVA_SE_7("Java SE 7", 0x33),
	JAVA_SE_6_0("Java SE 6.0", 0x32),
	JAVA_SE_5_0("Java SE 5.0", 0x31),
	JDK_1_4("JDK 1.4", 0x30),
	JDK_1_3("JDK 1.3", 0x2F),
	JDK_1_2("JDK 1.2", 0x2E),
	JDK_1_1("JDK 1.1", 0x2D);
	
	private String name;
	private int number; // technically a short but it really shouldn't matter unless sign comes into play and memory should be about the same
	
	private JavaVersion(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	private int getNumber() {
		return this.number;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public static JavaVersion getJavaVersion(int number) {
		for(JavaVersion javaVersion: JavaVersion.values()) {
			if(javaVersion.getNumber() == number) {
				return javaVersion;
			}
		}
		
		return null;
	}
}
