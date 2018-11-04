package com.training.epam.Prj02.entity;

public class Song {

	private String nameSinger;
	private String nameAlbom;
	private String nameSong;
	private String timeLasting;
	private String link;

	public Song() {
		super();
	}

	public Song(String nameSinger, String nameSong, String timeLasting, String link) {
		super();
		this.nameSinger = nameSinger;
		this.nameSong = nameSong;
		this.timeLasting = timeLasting;
		this.link = link;
	}

	public Song(String nameSinger, String nameAlbom, String nameSong, String timeLasting, String link) {
		super();
		this.nameSinger = nameSinger;
		this.nameAlbom = nameAlbom;
		this.nameSong = nameSong;
		this.timeLasting = timeLasting;
		this.link = link;
	}

	public String getNameSinger() {
		return nameSinger;
	}

	public void setNameSinger(String nameSinger) {
		this.nameSinger = nameSinger;
	}

	public String getNameAlbom() {
		return nameAlbom;
	}

	public void setNameAlbom(String nameAlbom) {
		this.nameAlbom = nameAlbom;
	}

	public String getNameSong() {
		return nameSong;
	}

	public void setNameSong(String nameSong) {
		this.nameSong = nameSong;
	}

	public String getTimeLasting() {
		return timeLasting;
	}

	public void setTimeLasting(String timeLasting) {
		this.timeLasting = timeLasting;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Song [nameSong=" + nameSong + ", timeLasting=" + timeLasting + ", link=" + link + "]";
	}

	
}
