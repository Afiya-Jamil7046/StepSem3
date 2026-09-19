import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count = 0;

    Playlist(int maxSize) {
        songs = new String[maxSize];
    }

    void addSong(String title) {
        if (count >= songs.length) {
            System.out.println("Playlist is full, cannot add " + title);
            return;
        }
        songs[count] = title;
        count++;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(p.getSongs()[0]);  // still "Song A"
        System.out.println(copy[0]);          // "Hacked", only the copy changed
        System.out.println(p.getSongCount()); // 2
    }
}