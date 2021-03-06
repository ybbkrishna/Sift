/*
 * Copyright 2012-2015, the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sift.runtime.spi;

import org.sift.runtime.Tuple;

/**
 * The <code>Processor</code> provides methods for processing a {@link Tuple} instance and emitting one or more instances of it using the {@link OutputCollector}
 * 
 * @author Regunath B
 * @version 1.0, 28 Jan 2013
 */
public interface Processor {

	/**
	 * Processes the specified Tuple and emits another(or more instances) containing processing results to the specified OutputCollector
	 * @param tuple the Tuple to process
	 * @param collector the OutputCollector to emit the processed Tuple(s) to 
	 */
	public void process(Tuple tuple, OutputCollector collector);
	
}
