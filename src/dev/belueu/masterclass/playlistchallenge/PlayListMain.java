package dev.belueu.masterclass.playlistchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PlayListMain {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Album album = new Album("New world", "Dire Straits");
        album.addSong("Desert Rose", 3.41);
        album.addSong("New world", 3.45);
        albums.add(album);

        album = new Album("Mix", "Mixers");
        album.addSong("Three little birds", 4.51);
        album.addSong("Brother in arms", 5.23);
        album.addSong("You could be mine", 5.55);
        albums.add(album);


        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("Desert Rose", playList);
        albums.get(0).addToPlaylist("New world", playList);
//        albums.get(0).addToPlaylist("You", playList);
        albums.get(1).addToPlaylist("Three little birds", playList);
        albums.get(1).addToPlaylist("Brother in arms", playList);
        albums.get(1).addToPlaylist("You could be mine", playList);
//        albums.get(1).addToPlaylist(4, playList);

        playMusic(playList);
    }

    private static void playMusic(LinkedList<Song> playList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false;
        boolean goAhead = true;
        ListIterator<Song> songListIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("Empty playlist");
            return;
        } else {
            System.out.println("Now playing -> " + songListIterator.next().toString());
        }

        printMenu();
        while (!quit) {
            int option = Integer.parseInt(reader.readLine());
            switch (option) {
                case 0 -> {
                    System.out.println("Exiting play list ...");
                    quit = true;
                }
                case 1 -> {
                    if (!goAhead) {
                        if (songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        goAhead = true;
                    }
                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing -> " + songListIterator.next().toString());
                    } else {
                        System.out.println("End of playlist");
                        goAhead = false;
                    }
                }
                case 2 -> {
                    if (goAhead) {
                        if (songListIterator.hasPrevious()) {
                            songListIterator.previous();
                        }
                        goAhead = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing -> " + songListIterator.previous().toString());
                    } else {
                        System.out.println("Beginning of playlist");
                        goAhead = true;
                    }
                }
                case 3 -> {
                    if (goAhead) {
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Now replaying -> " + songListIterator.previous().toString());
                            goAhead = false;
                        } else {
                            System.out.println("Beginning of list");
                        }
                    } else {
                        if (songListIterator.hasNext()) {
                            System.out.println("Now replaying -> " + songListIterator.next().toString());
                            goAhead = true;
                        } else {
                            System.out.println("End of the list");
                        }
                    }
                }
                case 4 -> {
                    displaySongs(playList);
                }
                case 5 -> {
                    printMenu();
                }
                case 6 -> {
                    if (playList.size() > 0) {
                        songListIterator.remove();
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing -> " + songListIterator.next().toString());
                        } else if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing -> " + songListIterator.previous().toString());
                        }
                    }
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options: ");
        System.out.println("Press 0 -> Quit");
        System.out.println("Press 1 -> Play next");
        System.out.println("Press 2 -> Play previous");
        System.out.println("Press 3 -> Replay current song");
        System.out.println("Press 4 -> List all songs");
        System.out.println("Press 5 -> Display menu options");
        System.out.println("Press 6 -> Remove current song");
    }

    private static void displaySongs(LinkedList<Song> playList) {
        System.out.println("======================================");
        playList.forEach(song -> System.out.println(song.toString()));
        System.out.println("======================================");
    }
}
