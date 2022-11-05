package business;

import javax.ejb.Local;

import beans.Album;

@Local
public interface MusicManagerInterface {
	Album addAlbum(Album model);
}
