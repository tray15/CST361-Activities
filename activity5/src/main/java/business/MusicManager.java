package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Album;
import beans.Track;
import data.MusicDataService;

@Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {
	MusicDataService dao;
	
	//HashMap<String, List<Track>> trackHash;
	
	public MusicManager() {
		/*
		 * trackHash = new HashMap<String, List<Track>>(); List<Track> tracksList = new
		 * ArrayList<Track>();
		 * 
		 * tracksList.add(new Track("First track", 1)); tracksList.add(new
		 * Track("Second track", 2)); tracksList.add(new Track("Third track", 3));
		 * tracksList.add(new Track("Fourth track", 4));
		 * 
		 * trackHash.put("AlbumName", tracksList);
		 */
		this.dao = new MusicDataService();
	}
	
	@Override
	public Album addAlbum(Album album) {
		Album createAlbum = this.dao.create(album);
		return createAlbum;
	}
	public Album getAlbum(Album album) {
		Album findAlbum = this.dao.findBy(album);
		return findAlbum;
	}
	
//	public List<Track> getTracks(Album album) {
//		String key = album.getTitle();
//		String key2 = album.getArtist();
//		String key3 = String.valueOf(album.getYear());
//		if (trackHash.containsKey(key) || trackHash.containsKey(key2) || trackHash.containsKey(key3)) {
//			return trackHash.get(key);
//		}
//		else {
//			return new ArrayList<Track>();
//		}
//	}
}