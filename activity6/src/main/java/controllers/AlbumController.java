package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Album;
import business.MusicManager;
import util.TracksNotFoundException;

@ManagedBean
@ViewScoped
public class AlbumController {
	public String onSubmit(Album album) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.getExternalContext().getRequestMap().put("album", album);
		
		MusicManager musicManager = new MusicManager();
		
		try {
			album = musicManager.addAlbum(album);
		}
		catch (TracksNotFoundException e) {
			System.out.println("Tracks not found");
		}
		context.getExternalContext().getRequestMap().put("album", album);
		context.getExternalContext().getRequestMap().put("trackCount", album.getNumberTracks());
		return "AddAlbumResponse.xhtml";
	}
	public String onFind(Album album) {
		FacesContext context = FacesContext.getCurrentInstance();
		Album findAlbum = null;
		MusicManager manager = new MusicManager();
		findAlbum = manager.getAlbum(album);
		
		context.getExternalContext().getRequestMap().put("album", findAlbum);
		context.getExternalContext().getRequestMap().put("trackCount", findAlbum.getNumberTracks());

		return "AddAlbumResponse.xhtml";
	}
}
