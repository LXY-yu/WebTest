package com.model;

/**
 * AbstractLibrary entity provides the base persistence definition of the
 * Library entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLibrary implements java.io.Serializable {

	// Fields

	private LibraryId id;

	// Constructors

	/** default constructor */
	public AbstractLibrary() {
	}

	/** full constructor */
	public AbstractLibrary(LibraryId id) {
		this.id = id;
	}

	// Property accessors

	public LibraryId getId() {
		return this.id;
	}

	public void setId(LibraryId id) {
		this.id = id;
	}

}