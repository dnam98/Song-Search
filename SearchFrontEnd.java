// --== CS400 Project One File Header ==--
// Name: Dongwon Nam
// Email: dnam9@wisc.edu
// Team: RED
// Group: AD
// TA: Ilay
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// interface (implemented with proposal)

interface SearchFrontEndInterface {
  public void run(SearchBackEndInterface searchEngine);

  // Here is a sample of the minimal set of options that
  // this front end will support:

  // SongSearch Command Menu:
  // 1. Insert New Song into Database
  // 2. Search For Song Titles by Words in those Title
  // 3. Search For Artists by Words in their Song Titles
  // 4. Display number of songs with Word in Title
  // 5. Quit
}

// public class (implemented primarilly in final app week)


public class SearchFrontEnd implements SearchFrontEndInterface {

  @Override
  public void run(SearchBackEndInterface searchEngine) {
    boolean quit = false;
    Scanner scnr = new Scanner(System.in);
    char userInput;
    // Start program
    System.out.println("Starting Song Search Program");

    while (!quit) {
      System.out.println("Press the following key:");
      System.out.println("i: Insert new song");
      System.out.println("t: Search for song titles by words in those song titles");
      System.out.println("a: Search for artists by words in song titles");
      System.out.println("h: Display number of songs with a specific word in title");
      System.out.println("q: Quit program");
      userInput = scnr.next().toLowerCase().charAt(0);
      scnr.nextLine();

      // Insert new song
      if (userInput == 'i') {
        String songTitle;
        String songArtist;
        int songYear;

        System.out.println("Start inserting");
        System.out.println("Enter the title of the song: ");
        songTitle = scnr.nextLine();
        System.out.println("Enter the artist of the song: ");
        songArtist = scnr.nextLine();
        System.out.println("Enter the published year of the song");
        songYear = scnr.nextInt();
        searchEngine.addSong(new SongData(songTitle, songArtist, songYear));
        System.out.println("Song added!");
        continue;
      }

      // Search for song titles by word
      if (userInput == 't') {
        String keyword;
        List<String> songList;
        System.out.println("Start searching song by word");
        System.out.println("Type a keyword to search");

        keyword = scnr.next();
        songList = searchEngine.findTitles(keyword);

        System.out.println("List of song containing the keyword \"" + keyword + "\"");
        for (int i = 0; i < songList.size(); i++) {
          System.out.println("-" + songList.get(i));
        }
        continue;
      }

      // Search for artists who contributed in song with a give keyword
      if (userInput == 'a') {
        String keyword;
        List<String> songList;
        System.out.println("Start searching artist by word in title");
        System.out.println("Type a keyword to search");

        keyword = scnr.next();
        songList = searchEngine.findArtists(keyword);

        System.out
            .println("List of artists containing the keyword \"" + keyword + "\" in the title");
        for (int i = 0; i < songList.size(); i++) {
          System.out.println("-" + songList.get(i));
        }
        continue;
      }

      // Display histograms of song with specific keyword
      if (userInput == 'h') {
        String keyword;
        int minYear;
        int maxYear = 2021;

        System.out.println("Start display number of songs in each year with the keyword.");
        System.out.println("Type a keyword to search");
        keyword = scnr.next();

        for (minYear = 1900; minYear <= maxYear; minYear++) {
          if (searchEngine.findNumberOfSongsInYear(keyword, minYear) != 0) {
            System.out.print(minYear + "|| ");
            for (int k = 0; k < searchEngine.findNumberOfSongsInYear(keyword, minYear); k++) {
              System.out.print("*");
            }
            System.out.println();
          }
        }
        continue;
      }

      if (userInput == 'q') {
        quit = true;
      }
    }
    System.out.println("End Song Search program");
  }
}
