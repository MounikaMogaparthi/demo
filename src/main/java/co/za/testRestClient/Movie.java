package co.za.testRestClient;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue()
    private  int movieId;

    @Column(name = "movie_name")
    private  String movieName;

    public Movie()
    {}

    public Movie( String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
