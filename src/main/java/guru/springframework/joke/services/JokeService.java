package guru.springframework.joke.services;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

public interface JokeService {

    String getJoke();
}
