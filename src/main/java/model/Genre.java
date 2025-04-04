package model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
	private Set<Movie> movies = new HashSet<>();

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

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(movies, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(movies, other.movies) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + ", movies=" + movies + "]";
	}

	
}	
	
	


