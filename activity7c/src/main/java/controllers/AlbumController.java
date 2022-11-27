package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;

import beans.Album;
import business.MusicManager;
import business.MusicManagerInterface;
import util.LoggingInterceptor;
import util.TracksNotFoundException;

@ManagedBean
@ViewScoped
@Interceptors(LoggingInterceptor.class)
public class AlbumController {
	@EJB
	MusicManagerInterface mgr;
	
	public String onSubmit(Album album) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.getExternalContext().getRequestMap().put("album", album);
		
		try {
			mgr.addAlbum(album);
			context.getExternalContext().getRequestMap().put("album", album);
			context.getExternalContext().getRequestMap().put("trackCount", album.getNumberTracks());

		}
		catch (TracksNotFoundException e) {
			System.out.println("Tracks not found");
		}
		return "AddAlbumResponse.xhtml";
	}
	public String onFind(Album album) {
		FacesContext context = FacesContext.getCurrentInstance();
		Album findAlbum = null;
		
		findAlbum = mgr.getAlbum(album);
		
		context.getExternalContext().getRequestMap().put("album", findAlbum);
		context.getExternalContext().getRequestMap().put("trackCount", findAlbum.getNumberTracks());

		return "AddAlbumResponse.xhtml";
	}
}
