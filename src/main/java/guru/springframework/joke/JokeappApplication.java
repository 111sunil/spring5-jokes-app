package guru.springframework.joke;

import guru.springframework.joke.examplebeans.FakeDataSource;
import guru.springframework.joke.examplebeans.FakeJmsBroker;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml")
@PropertySource("classpath:datasource.properties")
public class JokeappApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JokeappApplication.class, args);

        FakeDataSource fakeDataSource = (FakeDataSource) context.getBean(FakeDataSource.class);

        System.out.println(fakeDataSource.getUser());

        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) context.getBean(FakeJmsBroker.class);

        System.out.println(fakeJmsBroker.getUsername());
    }

}
