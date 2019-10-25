package patterns.structural.composite;

public class Example {

    public static void main(String[] args) {

        final Track firstTrack = new Track("First track description");
        final Track secondTrack = new Track("Second track description");

        final PlayList playList = new PlayList("Playlist description");
        playList.add(firstTrack);
        playList.add(secondTrack);

        System.out.println(playList.getDescription());


    }

}
