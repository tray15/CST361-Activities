package business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Album;
import beans.Track;

@Stateless
@Local(TrackFinderInterface.class)
@LocalBean
@Alternative
public class TrackFinder1 implements TrackFinderInterface {

	public TrackFinder1() {
		
	}

	@Override
	public List<Track> getTracks(Album album) {
		return TrackStorage.getMap().get(album);
	}

}
