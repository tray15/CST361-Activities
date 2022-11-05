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
	
	public MusicManager() {
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
}