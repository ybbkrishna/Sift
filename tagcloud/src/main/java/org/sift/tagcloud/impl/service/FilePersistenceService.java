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
package org.sift.tagcloud.impl.service;

import org.sift.tagcloud.TagCloud;
import org.sift.tagcloud.spi.image.ImageFileWriter;
import org.sift.tagcloud.spi.service.PersistenceService;
import org.trpr.platform.core.spi.persistence.PersistenceException;

/**
 * The <code>FilePersistenceService</code> is an implementation of {@link PersistenceService} that writes the tag cloud as an image of suitable type
 * to the file system.
 * 
 * @author Regunath B
 * @version 1.0, 25 Jan 2013
 */
public class FilePersistenceService implements PersistenceService {
	
	/** The file type to store the TagCloud as. Initialized to type FilePersistenceService.PNG */
	private String fileType = ImageFileWriter.PNG;
	
	/** The absolute directory path where tag clouds will be stored*/
	private String tagCloudsDirectory;

	/**
	 * Persists the specified TagCloud as an image file on the file system. Uses the {@link TagCloud#getSubject()} as the file name
	 * @see org.sift.tagcloud.spi.service.PersistenceService#persistTagCloud(org.sift.tagcloud.TagCloud)
	 */
	public void persistTagCloud(TagCloud tagCloud) throws PersistenceException {
		if (tagCloud.getSubject() == null || tagCloud.getSubject().trim().length() == 0) {
			throw new PersistenceException("Tag cloud's subject cannot be empty! File cannot be created with empty name.");
		}
	}

	/**
	 * Interface method implementation. WARNING : Not implemented and throws an {@link UnsupportedOperationException} to the effect
	 * @see org.sift.tagcloud.spi.service.PersistenceService#loadTagCloud(org.sift.tagcloud.TagCloud)
	 */
	public TagCloud loadTagCloud(TagCloud tagCloud) throws PersistenceException {
		throw new UnsupportedOperationException("Loading of tag clouds from image files is not supported!");
	}
	
	/** Start Getter/Setter methods */
	public String getFileType() {
		return this.fileType;
	}
	/**
	 * Sets the file type for persistence to one of the supported types by this class. For example {@link ImageFileWriter#PNG}, 
	 * {@link ImageFileWriter#SVG}, {@link ImageFileWriter#POST_SCRIPT}
	 * @param fileType the valid file type supported by this class
	 * @throws PersistenceException in case of unsupported file types
	 */
	public void setFileType(String fileType) throws PersistenceException {
		if (!fileType.equalsIgnoreCase(ImageFileWriter.PNG) &&
				!fileType.equalsIgnoreCase(ImageFileWriter.SVG) &&
				!fileType.equalsIgnoreCase(ImageFileWriter.POST_SCRIPT)) {
			throw new PersistenceException("Unrecognized file type : " + fileType + ". Check JavaDoc of this class for supported types. Default is : " + ImageFileWriter.PNG);
		}
		this.fileType = fileType;
	}
	public String getTagCloudsDirectory() {
		return this.tagCloudsDirectory;
	}
	public void setTagCloudsDirectory(String tagCloudsDirectory) {
		this.tagCloudsDirectory = tagCloudsDirectory;
	}		
	/** End Getter/Setter methods */

}
