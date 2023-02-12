package at.ac.fhcampuswien.snake.util;

import javafx.scene.media.AudioClip;

import java.net.URISyntaxException;
import java.util.Objects;

public class SoundFX {

    private final static String INTRO_SOUND = "/sounds/game-intro.wav";
    private final static String BONUS_POINT_SOUND = "/sounds/bonus-point.wav";
    private final static String EATING_SOUND = "/sounds/eat.mp3";
    private final static String GAME_OVER_SOUND = "/sounds/game-over.wav";

    public static void playIntroSound() {
        playSoundFx(INTRO_SOUND);
    }

    public static void playEatingSound() {
        playSoundFx(EATING_SOUND);
    }

    public static void playBonusPointSound() {
        playSoundFx(BONUS_POINT_SOUND);
    }

    public static void playGameOverSound() {
        playSoundFx(GAME_OVER_SOUND);
    }

    private static void playSoundFx(String resourcePath) {
        try {
            String path = Objects.requireNonNull(SoundFX.class.getResource(resourcePath)).toURI().toString();
            AudioClip audioClip = new AudioClip(path);
            audioClip.play();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
