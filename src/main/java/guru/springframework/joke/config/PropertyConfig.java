package guru.springframework.joke.config;

import guru.springframework.joke.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${guru.username}")
    String user;

    @Value("${guru.password")
    String password;

    @Value("${guru.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUser(user);
        fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public static PropertyPlaceholderAutoConfiguration properties() {
        PropertyPlaceholderAutoConfiguration propertyPlaceholderAutoConfiguration = new PropertyPlaceholderAutoConfiguration();
        return propertyPlaceholderAutoConfiguration;
    }
}
