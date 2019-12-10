package com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundEffect {

	public static void play(card[] Card, int cardNum) {

		System.out.println("PLAYING");
		// File sound = new File("C:\\Users\\maste\\Desktop\\" +
		// Card[cardNum].getCardNumber() + ".wav");

		try {
			System.out.println("FOR REAL");
			URL sound = SoundEffect.class.getClassLoader().getResource("/sounds/" + Card[cardNum].getCardNumber() + ".wav");
			File soundFile = new File("C:\\Users\\lpare\\Desktop\\Sounds\\" + Card[cardNum].getCardNumber() + ".wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} 
	}
}
