import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String ArtistName;
    private String AlbumName;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artistName, String albumName) {
        ArtistName = artistName;
        AlbumName = albumName;
        this.songs = new ArrayList<>();
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functions

    public boolean findSong(String name){
        for(Song s : songs){
            if(s.getSongtitle().equals(name)) return true;
        }
         return false;
    }

    String addSong(String name, double duration){
            if(!findSong(name)){
                Song s = new Song(name,duration);
                this.songs.add(s);
                return "Song is added successfully";
            }
            return "Song Already exists";
        }

        String addAlbumToPlaylist(String name, LinkedList<Song> playlist){
        for(Song song : songs){
            if(song.getSongtitle().equals(name)){
                playlist.add(song);
                return "Song added to playlist successfully";
            }
        }
        return "Song doesn't exist in the Album";
        }

    /**
     * Polymorphism : Method overloading ki hai
     * @param SongNo
     * @param playlist
     * @return
     */
    String addAlbumToPlaylist(int SongNo,LinkedList<Song> playlist){
        int index = SongNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));
            return "Song added to playlist successfully";
        }
        return "Please enter a valid index";
        }

    @Override
    public String toString() {
        return "Album{" +
                "ArtistName='" + ArtistName + '\'' +
                ", AlbumName='" + AlbumName + '\'' +
                ", songs=" + songs +
                '}';
    }
}
