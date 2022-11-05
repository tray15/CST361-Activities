package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class Album {
	private int id;
	@NotNull
	@Size(min=5, max=50)
	private String title;
	
	@NotNull
	@Size(min=5, max=50)
	private String artist;
	
	@Min(1920)
	@Max(2020)
	private int year;
	
	private List<Track> tracks;
	
	public Album() {
		title = "";
		artist = "";
		year = 0;
		tracks = new ArrayList<Track>();
	}
	
	public Album(String title, String artist, int year, List<Track> tracks) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.tracks = tracks;
	}
	
	public int getNumberTracks() { 
		return tracks.size();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public void setId(int id) {
		this.id = id;		
	}

	public int getId() {
		return id;
	}
}