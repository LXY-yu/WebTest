package com.model;

/**
 * Song entity. @author MyEclipse Persistence Tools
 */

public class Song implements java.io.Serializable {

	// Fields

	private SongId id;

	// Constructors

	/** default constructor */
	public Song() {
	}

	/** full constructor */
	public Song(SongId id) {
		this.id = id;
	}

	// Property accessors

	public SongId getId() {
		return this.id;
	}

	public void setId(SongId id) {
		this.id = id;
	}

}