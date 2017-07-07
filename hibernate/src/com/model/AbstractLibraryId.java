package com.model;

/**
 * AbstractLibraryId entity provides the base persistence definition of the
 * LibraryId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLibraryId implements java.io.Serializable {

	// Fields

	private String userid;
	private String password;
	private String songName;

	// Constructors

	/** default constructor */
	public AbstractLibraryId() {
	}

	/** minimal constructor */
	public AbstractLibraryId(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	/** full constructor */
	public AbstractLibraryId(String userid, String password, String songName) {
		this.userid = userid;
		this.password = password;
		this.songName = songName;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSongName() {
		return this.songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractLibraryId))
			return false;
		AbstractLibraryId castOther = (AbstractLibraryId) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null && castOther.getUserid() != null && this
				.getUserid().equals(castOther.getUserid())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getSongName() == castOther.getSongName()) || (this
						.getSongName() != null
						&& castOther.getSongName() != null && this
						.getSongName().equals(castOther.getSongName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result
				+ (getSongName() == null ? 0 : this.getSongName().hashCode());
		return result;
	}

}