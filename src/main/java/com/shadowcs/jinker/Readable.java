package com.shadowcs.jinker;

import java.io.DataInput;

@FunctionalInterface
public interface Readable<C> {

	public C read(DataInput in);
}
