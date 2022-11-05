package data;

import beans.Album;

public interface DataAccessInterface {
	Album create(Album album);
	Album findBy(Album album);
}
