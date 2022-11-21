package business;

import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.Album;
import beans.Track;

@ManagedBean
@ViewScoped
public class TrackStorage {
	public static HashMap<Album, List<Track>> map = new HashMap<Album, List<Track>>();
	
	public static HashMap<Album, List<Track>> getMap() {
		return map;
	}
	public static void setMap(HashMap<Album, List<Track>> map) {
		TrackStorage.map = map;
	}
}