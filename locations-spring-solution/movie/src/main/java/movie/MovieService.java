package movie;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    private ModelMapper modelMapper;

    public List<MovieDTO> getMovies() {
        return movieRepository.findAll().stream()
                .map(a -> modelMapper.map(a, MovieDTO.class))
                        .collect(Collectors.toList());
    }

    public MovieDTO createMovie(CreateMovieCommand command) {
        Movie movie = new Movie(command.getTitle());

        movieRepository.save(movie);

        return modelMapper.map(movie, MovieDTO.class);
    }

    @Transactional
    public MovieDTO addRatingToMovie(long id, CreateRatingCommand command) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find"));

        movie.addRating(command.getRating());

        return modelMapper.map(movie, MovieDTO.class);
    }
}
