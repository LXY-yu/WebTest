package com.model;

/**
 * SongId entity. @author MyEclipse Persistence Tools
 */

public class SongId implements java.io.Serializable{
	

	// Fields

	private String songName;
	private Integer songCount;

	// Constructors

	/** default constructor */
	public SongId() {
	}



	// Property accessors

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public SongId(String songName, Integer songCount) {
		//super();
		this.songName = songName;
		this.songCount = songCount;
	}

	public Integer getSongCount() {
		return songCount;
	}

	@Override
	public String toString() {
		return "SongId [songName=" + songName + ", songCount=" + songCount
				+ "]";
	}

	public void setSongCount(Integer songCount) {
		this.songCount = songCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SongId))
			return false;
		SongId castOther = (SongId) other;

		return ((this.getSongName() == castOther.getSongName()) || (this
				.getSongName() != null && castOther.getSongName() != null && this
				.getSongName().equals(castOther.getSongName())))
				&& ((this.getSongCount() == castOther.getSongCount()) || (this
						.getSongCount() != null
						&& castOther.getSongCount() != null && this
						.getSongCount().equals(castOther.getSongCount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSongName() == null ? 0 : this.getSongName().hashCode());
		result = 37 * result
				+ (getSongCount() == null ? 0 : this.getSongCount().hashCode());
		return result;
	}
	
	

}