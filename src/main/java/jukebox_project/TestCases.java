package jukebox_project;

import static jukebox_project.DeleteSong.deleteSong;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.List;
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
    //setUpOutput() method indicates that this method should be run before each test method
    public void setUpOutput() {
        //ByteArrayOutputStream so that the output can be captured and tested
        // This stream is used to capture the output of the system, which is usually sent to the standard output stream
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    //method should be run after each test method,
    public void restoreSystemInputOutput() {
        //restoreSystemInputOutput() sets the standard input stream to the value stored in the systemIn
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