package jukebox_project;// Java program to play an Audio

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static jukebox_project.DeleteSong.songs;

public class AudioInputStream extends database{
    int currentSongIndex = 0;
    public int fetchSong()
    {
        Scanner sc = new Scanner(System.in);
       Connection con = getConnection();

        System.out.println("\033[33m" + "--->Please Enter ID Of The Song You Want To Play" + "\033[0m");
        int songId = sc.nextInt();
        try
        {
            String loginDet = "select songid, path from songs";
            PreparedStatement Stmt = con.prepareStatement(loginDet);
          //  The ResultSet rs stores the results of the query.
            ResultSet rs = Stmt.executeQuery();

            int id =0;
            String path = "";

            while (rs.next()) {
                id = rs.getInt("songid");
                path = rs.getString("path");
                File file = new File(path);

                if(songId==id)
                {
                    //The code uses the javax.sound.sampled API to play the audio files and the java.sql API to interact with the database.
                    // The code also uses the java.io API to access the audio files on disk
                    javax.sound.sampled.AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);

                    String response = "";
                   // The method enters a loop that runs until the user enters 'Q' as the response.
                    while(!response.equals("Q")) {
                        System.out.println("P = play, S = Stop,  L =Loop, Q = Quit, N=Next, SH= Shuffle");
                        System.out.print("--->Enter Your Choice: ");
                        response = sc.next();
                        response = response.toUpperCase();
                        switch(response)
                        {
                            case ("P"): clip.start();  // to play the song
                                // clip.loop(1);    // to play song in a loop
                                break;
                            case ("S"): clip.stop();  // to stop the song
                                break;

                            case("L"):  clip.loop(1);       // to play song in the loop
                                break;
                            case("Q"):
                                System.out.println("Exiting the program...");
                                clip.stop();
                                break;
                            case("N"):
                                clip.close();
                                if (rs.next())
                                {
                                    id = rs.getInt("songid");
                                    path = rs.getString("path");
                                    file = new File(path);
                                    audioStream = AudioSystem.getAudioInputStream(file);
                                    clip = AudioSystem.getClip();
                                    clip.open(audioStream);
                                    clip.start();
                                } else
                                {
                                    System.out.println("You have reached end of Queue");
                                    response = "Q";
                                }
                                break;

                        }
                    }

                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Error is "+ e);
        }

        return songId;
    }


}