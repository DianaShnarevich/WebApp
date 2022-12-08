package web.artistAndGenre.dao;

import java.io.FileNotFoundException;

public interface IDao {
    String getData(String URL) throws FileNotFoundException;
}
