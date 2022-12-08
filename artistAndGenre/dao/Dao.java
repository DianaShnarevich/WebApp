package web.artistAndGenre.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dao implements IDao {
    @Override
    public String getData(String URL) throws FileNotFoundException {
        try (Stream<String> line = Files.lines(Paths.get(URL), StandardCharsets.UTF_8)) {
            return line.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new FileNotFoundException(URL + " not found");
        }
    }
}
