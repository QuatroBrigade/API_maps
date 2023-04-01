package APIMaps.server;


import APIMaps.server.webService.MapServiceREST;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Dominik Ivanoc
 */


@SpringBootApplication
@Configuration                           // spring scan all classes where is @Configuration annotation
@EntityScan("APIMaps.entity")     // locate entity package bcs its another package lvl
public class DataWebServer {

    public static void main(String[] args) {
        SpringApplication.run(DataWebServer.class, args);
    }


    // entity service for bibtex
    @Bean
    public MapServiceREST mapService() {
        return new MapServiceREST();
    }


/*    // ------------------------------------------------------
    //temp test JPA things


    @Bean
    public CommandLineRunner runner(TestMain testMain){
        return args -> testMain.make();
    }

    @Bean
    public TestMain testMain(){
        return new TestMain();
    }*/
}
