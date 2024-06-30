/*
// * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	 private static final String MUSIC_POKEMON_PATH = "C:\\Users\\Dell\\eclipse-workspace\\Pikachu_MVC\\src\\sound\\nhacNenMapleStory.wav";
	    private static final String MatchBtn_PATH = "C:\\Users\\Dell\\eclipse-workspace\\Pikachu_MVC\\src\\sound\\danLv12.wav";
	    private static final String NotMatchBtn_PATH = "C:\\Users\\Dell\\eclipse-workspace\\Pikachu_MVC\\src\\sound\\tiepDat.wav";
	    private static final String LOSTGAME = "C:\\Users\\Dell\\eclipse-workspace\\Pikachu_MVC\\src\\sound\\mixkit-arcade-retro-game-over-213.wav";
	    private static final String WINNERGAME = "C:\\Users\\Dell\\eclipse-workspace\\Pikachu_MVC\\src\\sound\\winnergame.wav";
	    public Clip clip;

	    public Music() {
	    }

	    public Clip startMusic() {
	        return playMusic(MUSIC_POKEMON_PATH);
	    }

	    public Clip MatchButton() {
	        return playMusic(MatchBtn_PATH);
	    }

	    public Clip NotMatchButton() {
	        return playMusic(NotMatchBtn_PATH);
	    }

	    public Clip lostGame() {
	        return playMusic(LOSTGAME);
	        
	    }
	    public Clip winnerGame() {
	        return playMusic(WINNERGAME);
	        
	    }

	    public Clip playMusic(String musicPath) {
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicPath).getAbsoluteFile());
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();
	        //  // Chờ nhạc kết thúc
	          Thread.sleep(clip.getMicrosecondLength() / 100);
	            return clip;
	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            System.out.println("Error playing music: " + e.getMessage());
	            return null;
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clip;
	    }

	    public void stopMusic() {
	        if (clip != null) {
	            clip.close();
	        }
	    }

	    public void pauseMusic() {
	        if (clip != null) {
	            clip.stop();
	        }
	    }

	    public void resumeMusic() {
	    		System.out.println("reseum");
	            clip.start();
	   
	    }

	    public long getMicrosecondPosition() {
	        if (clip != null) {
	            return clip.getMicrosecondPosition();
	        }
	        return 0;
	    }

	    public void setMicrosecondPosition(long position) {
	        if (clip != null) {
	            clip.setMicrosecondPosition(position);
	        }
	    }
	    
	    public static void main(String[] args) {
			Music ms = new Music();
			ms.NotMatchButton();
		}
	    
	       
}



