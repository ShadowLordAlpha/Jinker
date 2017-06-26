package com.shadowcs.jinker;

import java.io.IOException;
import java.io.Writer;

@FunctionalInterface
public interface Writable<C> {

	public C write(Writer out) throws IOException;
}
