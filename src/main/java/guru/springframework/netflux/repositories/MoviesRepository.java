package guru.springframework.netflux.repositories;

import guru.springframework.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MoviesRepository extends ReactiveMongoRepository<Movie, String> {
}
