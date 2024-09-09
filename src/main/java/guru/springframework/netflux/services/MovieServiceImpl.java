package guru.springframework.netflux.services;

import guru.springframework.netflux.domain.Movie;
import guru.springframework.netflux.repositories.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MoviesRepository moviesRepository;

    @Override
    public Mono<Movie> getMovieById(String id) {
        return moviesRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }
}
