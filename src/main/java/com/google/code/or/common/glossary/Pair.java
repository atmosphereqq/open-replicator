/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.code.or.common.glossary;

import java.io.Serializable;

import com.google.code.or.common.util.ToStringBuilder;

/**
 * 
 * @author Jingqi Xu
 */
public final class Pair<T> implements Serializable {
	private static final long serialVersionUID = 4187733310664848686L;
	//
	private T before;
	private T after;

	/**
	 * 
	 */
	public Pair() {}

	public Pair(T before, T after) {
		this.before = before;
		this.after = after;
	}

	/**
	 * 
	 */
	public String toString() {
		return new ToStringBuilder(this).append("before", before).append("after", after).toString();
	}

	/**
	 * 
	 */
	public T getBefore() {
		return before;
	}

	public void setBefore(T before) {
		this.before = before;
	}

	public T getAfter() {
		return after;
	}

	public void setAfter(T after) {
		this.after = after;
	}

	/**
	 * 
	 */
	public void swap() {
		final T t = this.before;
		this.before = this.after;
		this.after = t;
	}

	/**
	 * 
	 */
	public static void swap(Pair<?> p) {
		doSwap(p); // Nothing but capture the <?>
	}

	private static <T> void doSwap(Pair<T> p) {
		synchronized (p) {
			final T t = p.before;
			p.before = p.after;
			p.after = t;
		}
	}
}
