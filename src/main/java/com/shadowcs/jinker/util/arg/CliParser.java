package com.shadowcs.jinker.util.arg;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class CliParser {

	// private Set<String> classSet;
	private Set<Field> fieldSet;

	public CliParser(Class<?>... classes) {
		// classSet = new HashSet<String>();
		fieldSet = new HashSet<Field>();

		for(Class<?> klass: classes) {
			
			if(klass.isAnnotationPresent(Config.class)) {
				for(Field field: klass.getFields()) {
					if(field.isAnnotationPresent(Option.class)) {
						fieldSet.add(field);
					}
				}
			} else {
				// TODO: log message and not print it out
				System.err.println("Class is not an annotated Config");
			}
		}
	}

	public void parse(String[] args) {

	}
}
