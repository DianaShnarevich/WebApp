package web.artistAndGenre.repository;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IVoiceRepository {
    boolean vote(HttpServletRequest req);

    Map<String, Integer> getArtist();
    Map<String, Integer> getGenre();
    Map<String, String> getText();
}
