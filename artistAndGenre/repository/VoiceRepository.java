package web.artistAndGenre.repository;

import web.artistAndGenre.dao.IDao;
import web.artistAndGenre.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VoiceRepository implements IVoiceRepository {
    private final Map<String, Integer> artist;
    private final Map<String, Integer> genre;
    private final Map<String, String> text;
    private final IDao dao = new Dao();

    public VoiceRepository() {
        artist = new HashMap<>();
        genre = new HashMap<>();
        text = new HashMap<>();
        initMap("src/main/resources/Artist.txt", artist);
        initMap("src/main/resources/Genre.txt", genre);
    }

    @Override
    public boolean vote(HttpServletRequest req) {
        boolean voice = checkVoice(req);
        if (voice) {
            artistUpdate(req);
            genreUpdate(req);
            aboutUpdate(req);
            return true;
        } else {
            return false;
        }
    }

    private void initMap(String URL, Map<String, Integer> dataMap) {
        try {
            String lines = dao.getData(URL);

            Arrays.stream(lines.split("\n"))
                    .forEach(line -> dataMap.put(line, 0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean checkVoice(HttpServletRequest req) {
        String[] genres = req.getParameterValues("genre");
        if (genres == null || genres.length < 3 || genres.length > 5) {
            return false;
        }
        String[] actors = req.getParameterValues("artist");
        return artist != null && actors.length <= 1;
    }

    private void artistUpdate(HttpServletRequest req) {
        String artists = req.getParameter("artist");
        artist.merge(artists, 1, (oldValue, newValue) -> oldValue + 1);
    }

    private void genreUpdate(HttpServletRequest req) {
        String[] genres = req.getParameterValues("genre");
        Arrays.stream(genres)
                .forEach(genre -> this.genre.merge(
                        genre, 1, (oldValue, newValue) -> oldValue + 1));
    }

    private void aboutUpdate(HttpServletRequest req) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy.MM.dd   HH:mm:ss:SSS");
        String dateTimeNow = formatter.format(LocalDateTime.now());
        text.put(dateTimeNow, req.getParameter("text"));
    }

    @Override
    public Map<String, Integer> getArtist() {
        return artist;
    }

    @Override
    public Map<String, Integer> getGenre() {
        return genre;
    }

    @Override
    public Map<String, String> getText() {
        return text;
    }
}
