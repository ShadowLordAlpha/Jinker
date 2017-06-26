package com.shadowcs.jinker.java;

public enum AccessLevel {

	PUBLIC("public ", true),
	PROTECTED("protected "),
	DEFAULT("", true),
	PRIVATE("private ");

	private String modifier;
	private boolean top;

	private AccessLevel(String modifier) {
		this(modifier, false);
	}

	private AccessLevel(String modifier, boolean top) {
		this.modifier = modifier;
		this.top = top;
	}

	public String getModifier() {
		return modifier;
	}

	public boolean isTop() {
		return top;
	}
}
