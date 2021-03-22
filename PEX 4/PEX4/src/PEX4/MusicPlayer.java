/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX4;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Andrew
 */
public class MusicPlayer extends Thread{
    private Clip musicClip;
    private String song;

    public void run(String FX) {
        if(FX.equals("N")) {
            startMusic(song);
        }
        else if(FX.equals("Y")) {
            startFX(song);
        }
    }
   
    
    public void setSong(String path) {
        song = path;
    }
    
    public void startMusic(String pathname) {
        try {
            musicClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource(song));
            musicClip.open(ais);
        } catch(IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("Music loading failed - " + e);
        }
        musicClip.loop(musicClip.LOOP_CONTINUOUSLY);
        }
    
    public void startFX(String pathname) {
        try {
            musicClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource(song));
            musicClip.open(ais);
        } catch(IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("Music loading failed - " + e);
        }
        musicClip.start();
        }
    
    public void stopMusic() {
        musicClip.stop();
    }
    }

