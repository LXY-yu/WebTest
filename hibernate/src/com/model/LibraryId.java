package com.model;

/**
 * LibraryId entity. @author MyEclipse Persistence Tools
 */
public class LibraryId extends AbstractLibraryId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public LibraryId() {
	}

	/** minimal constructor */
	public LibraryId(String userid, String password) {
		super(userid, password);
	}

	/** full constructor */
	public LibraryId(String userid, String password, String songName) {
		super(userid, password, songName);
	}

}
