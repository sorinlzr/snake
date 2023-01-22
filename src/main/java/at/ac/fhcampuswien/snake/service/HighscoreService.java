package at.ac.fhcampuswien.snake.service;

import at.ac.fhcampuswien.snake.util.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static at.ac.fhcampuswien.snake.util.Constants.HIGHSCORE_SEPARATOR;

public class HighscoreService {

    private final static Logger LOG = LoggerFactory.getLogger(HighscoreService.class);

    private static File getHighscoresFile() throws URISyntaxException, IOException {
        String path = "src/main/resources/highscores.txt";
        URL url = HighscoreService.class.getResource(path);
        File highscoreFile = null;

        if (url == null) {
            highscoreFile = new File(path);
            highscoreFile.createNewFile();
        } else {
            highscoreFile = new File(url.toURI());
            if (!highscoreFile.exists()) {
                highscoreFile.createNewFile();
            }
        }

        return highscoreFile;
    }

    private static List<String> getFileContent(File file) {
        List<String> ret = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                ret.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ret;
    }

    private static List<Player> getPlayerFromList(List<String> list) {
        List<Player> ret = new ArrayList<>();

        if (!list.isEmpty()) {
            for (String line : list) {
                String[] parts = line.split(HIGHSCORE_SEPARATOR);
                Player player = new Player(parts[0], Integer.parseInt(parts[1]));
                ret.add(player);
            }
        }
        return ret;
    }

    public static List<Player> getSavedPlayerList() {
        List<Player> ret = null;

        try {
            File highscoreFile = getHighscoresFile();
            List<String> fileContent = getFileContent(highscoreFile);
            ret = getPlayerFromList(fileContent);
        } catch (IOException ex) {
            LOG.error("Error reading from file on disk");
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            LOG.error("Path to the high scores file is wrong");
        }

        return ret;
    }

}
