package business;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import beans.Album;
import data.DataAccessInterface;

@Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {
	@EJB
	DataAccessInterface<Album> dao;
	
	@Inject
	TrackFinderInterface tf;
	
	public MusicManager() {

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