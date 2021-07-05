package cinema;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private ModelMapper modelMapper;

    public MovieService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private AtomicLong idGenerator = new AtomicLong();

    private List<Movie> movieList = Collections.synchronizedList(new ArrayList<>());

    public List<MovieDTO> listMovies(Optional<String> title) {
        Type targetListType = new TypeToken<List<MovieDTO>>(){}.getType();

        List<Movie> filtered = movieList.stream()
                .filter(i -> title.isEmpty() || i.getTitle().equalsIgnoreCase(title.get()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }

    public MovieDTO listMovieById(long id) {
        Movie movie = movieList.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Movie not found: " + id));

        return modelMapper.map(movie, MovieDTO.class);

    }

    public MovieDTO createMovie(CreateMovieCommand command) {
        Movie movie = new Movie(idGenerator.incrementAndGet()
                , command.getTitle()
                , command.getDate()
                , command.getMaxReservation()
                , command.getMaxReservation());

        movieList.add(movie);
        return modelMapper.map(movie, MovieDTO.class);

    }

    public MovieDTO createReservation(long id, CreateReservationCommand command) {
            Movie movie = movieList.stream()
                    .filter(i -> i.getId() == id)
                    .findFirst().orElseThrow(() -> new IllegalArgumentException("Movie not found: " + id));

            movie.reservation(command.getReservation());
            return modelMapper.map(movie, MovieDTO.class);
        }

    public MovieDTO updateMovie(long id, UpdateDateCommand command) {
            Movie movie = movieList.stream()
                    .filter(i -> i.getId() == id)
                    .findFirst().orElseThrow(() -> new IllegalArgumentException("Movie not found: " + id));

            movie.setDate(command.getDate());
            return modelMapper.map(movie, MovieDTO.class);

        }

    public void deleteMovieAll() {
        movieList.clear();
        idGenerator = new AtomicLong();
    }
}
