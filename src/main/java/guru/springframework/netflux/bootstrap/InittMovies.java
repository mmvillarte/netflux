package guru.springframework.netflux.bootstrap;

import guru.springframework.netflux.domain.Movie;
import guru.springframework.netflux.repositories.MoviesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
@Slf4j
public class InittMovies implements CommandLineRunner {
    private final MoviesRepository moviesRepository;

    @Override
    public void run(String... args) throws Exception {
        moviesRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas",
                                  "Aeon Flux",
                                  "Enter the Mono<Void>",
                                  "The fluxxinator",
                                  "Back to the future",
                                  "Meet the fluxes",
                                  "Lord of the fluxes")
                                .map(Movie::new)
                                .flatMap(moviesRepository::save)
                                )
                .subscribe(null, null, () -> {
                            moviesRepository.findAll().subscribe(System.out::println);
                        });
    }
}
