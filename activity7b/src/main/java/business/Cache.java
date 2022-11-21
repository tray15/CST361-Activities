package business;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import beans.Album;

/**
 * Session Bean implementation class Cache
 */
@Startup
@Singleton
@LocalBean
public class Cache {
	// String is title#artist#year, concatenated
	private HashMap<String, Album> cache;
    /**
     * Default constructor. 
     */
    public Cache() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init() {
    	cache = new HashMap<String, Album>();
    }
    public Album getObject(Album album) {
    	String albumKey = album.getTitle() + "#" + album.getArtist() + "#" + album.getYear();
    	Album found = cache.get(albumKey);
    	if (found != null) {
    		return found;
    	} else return null;
    }
    
    public void putObject(Album album) {
    	String albumKey = album.getTitle() + "#" + album.getArtist() + "#" + album.getYear();
    	cache.put(albumKey, album);
    	System.out.println("Album placed at: " + albumKey + ", " + this.getObject(album).toString());
    }
}