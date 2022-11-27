package business;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import beans.Album;
import data.DataAccessInterface;
import util.LoggingInterceptor;

@Stateless
@Local(MusicManagerInterface.class)
@LocalBean
@Interceptors(LoggingInterceptor.class)
public class MusicManager implements MusicManagerInterface {
	@EJB
	DataAccessInterface<Album> dao;
	
	@EJB
	Cache cache;
	
	@Inject
	TrackFinderInterface tf;
	
	public MusicManager() {

	}
	
	@Override
	public Album addAlbum(Album album) {
		this.cache.putObject(album);
		Album createAlbum = this.dao.create(album);
		return createAlbum;
	}
	public Album getAlbum(Album album) {
		Album a = this.cache.getObject(album);
		if (a != null)
			return a;
		Album findAlbum = this.dao.findBy(album);
		return findAlbum;
	}
}