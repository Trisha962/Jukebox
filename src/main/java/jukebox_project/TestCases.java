package jukebox_project;

import static jukebox_project.DeleteSong.deleteSong;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void deleteSongTest() {
        String expected = "Song with id 603 has been deleted from the database.";
        deleteSong(603);
        Scanner scanner = new Scanner(testOut.toString());
        String result = scanner.nextLine();
        scanner.close();
        Assert.assertEquals(expected, result);
    }
    @Test
    public void testSongsMethod() {
        SongsMethod songsMethod = new SongsMethod();
        assertEquals(null, songsMethod.displaySongs());
    }

    @Test
    public void displayMenuTest() {
        DisplayMenu displayMenu = new DisplayMenu();
        assertEquals(null, displayMenu.Menu());
    }

}