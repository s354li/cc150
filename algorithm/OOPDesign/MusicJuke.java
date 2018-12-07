// 3. Design a musical juke box using object oriented principles.
public class Song {
	public String songName;
	public int songTime;
	public Song(Sting name) {
		songName = name;
	}
	public void Play() {
		// playing the song
	}
}

public class Playlist {
	public String name;
	public Queue<Song> songs;
	public Playlist(String value) {
		name = value;
		songs = new Queue<Song>();
	}
	public void addSongs(Song value) {
		songs.push(value);
	}
	public Song playNext(Song current) {
		Queue<Song> searchQueue = songs;
		while (!searchQueue.empty()) {
			Song sng = searchQueue.pop();
			if (sng == current) {
				return searchQueue.pop();
			}
		}
		return null;
	}
	public Song playPrevious(Song current) {
		Queue<Song> searchQueue = songs;
		Song previous = null;
		while (!searchQueue.empty()) {
			Song sng = searchQueue.pop();
			if (sng == current) {
				return previous;
			} else {
				previous = sng;
			}
		}
		return null;
	}
}

public class CD {
	public String cdName;
	public ArrayList<Song> songs;
	public int songNum;
	public CD(String name, ArrayList<Song> allSong) {
		cdName = name;
		songs = allSong;
	}
	public boolean containSong(Song current) {
		for(Song item : songs) {
			if (current == item) {
				return true;
			}
		}
		return false;
	}
}

public class PlayingSongs implements Runnable {
	public Playlist songs;
	public int playType;
	private int generateRandom(int max, int min) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	public void run(){  
    	if (playType == 0) {
    		// random playing songs
    		ArrayList<Song> allSongs = new ArrayList(songs.songs);
    		int min = 0;
    		while (min < allSongs.length()) {
    			int currentIndex = generateRandom(min, allSongs.length() - 1);
    			allSongs.get(currentIndex).Play();
    			Song temp = allSongs.get(currentIndex);
    			allSongs.set(currentIndex, allSongs.get(min));
    			allSongs.set(min, temp);
    			min++;
    			if (min == allSongs.length()) {
    				min = 0;
    			}
    		}
    	} else {
    		// sequence playing songs
    		Queue<Song> waitingSongs = songs.songs;
    		while (waitingSongs.empty()) {
    			Song current = waitingSongs.pop();
    			current.Play();
    			waitingSongs.push(current);
    		}
    	}
  	}
  	public PlayingSongs(Playlist waitingforplay, int playtype) {
  		songs = waitingforplay;
  		playType = playtype;
  	}
}

public class JunkBox {
	public Set<CD> cds;
	public Hashtable<String, Playlist> playlists;
	public Thread playing;
	public String currentList;
	public Song currentSong;
	public JunkBox() {
		cds = new Set<CD>();
		currentSong = null;
		playlists = new Hashtable<String, Playlist>();
		Playlist default = new Playlist("Default playlist");
		for(CD item : cds) {
			for(Song songItem : item.songs) {
				defalt.addSongs(songItem);
			}
		}
		playlists.add("Default playlist", default);
	}
	public void addCD(CD album) {
		cds.add(album);
	}
	public void createPlaylist(String name) {
		playlists.put(name, new Playlist(name))
	}
	public void addToPlaylist(Song currentSong, String name) {
		playlists.get(name).addSongs(currentSong);
	}
	public Song nextSong() {
		Playlist currentlist = playlists.get(currentList);
		Song nextSong = currentlist.playNext(currentSong);
		currentSong = nextSong;
		return currentSong;
	}
	public Song previousSong() {
		Playlist currentlist = playlists.get(currentList);
		Song previousSong = currentlist.playPrevious();
		currentSong.previousSong;
	}
	public void ShufflePlay(String name) {
		Playlist currentlist = playlists.get(currentList);
		if (currentlist == null) {
			currentlist = playlists.get("Default playlist");
		}
		PlayingSongs threadplaying = new PlayingSongs(currentlist, 0);
		playing = new Thread(threadplaying);
		playing.start();
	}
	public void SequencePlay(String name) {
		Playlist currentlist = playlists.get(currentList);
		if (currentlist == null) {
			currentlist = playlists.get("Default playlist");
		}
		PlayingSongs threadplaying = new PlayingSongs(currentlist, 1);
		playing = new Thread(threadplaying);
		playing.start();
	}
	public void StopPlay() {
		if (playing != null) {
			playing.stop();
		}
	}
}
