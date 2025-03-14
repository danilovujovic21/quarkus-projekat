package model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = Genre.GET_ALL_GENRES, query = "SELECT g FROM Genre g") })
public class Genre {

	public static final String GET_ALL_GENRES = "getAllGenres";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")

	private Long id;
	private String name;

	@ManyToMany(mappedBy = "genres")
	@JsonIgnore
	private List<Movie> movies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + ", movies=" + movies + "]";
	}

	
}	
	
	


