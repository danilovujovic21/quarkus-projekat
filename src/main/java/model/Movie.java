 package model;

import jakarta.persistence.*;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = Movie.GET_ALL_MOVIES, query = "Select m from Movie m"),
		@NamedQuery(name = Movie.GET_MOVIE_BY_NAME, query = "Select m from Movie m where m.name = :name")})
public class Movie {

	public static final String GET_ALL_MOVIES = "getAllMovies";
	public static final String GET_MOVIE_BY_NAME = "getMovieByName";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
	private Long id;
	
	private String name;
	private double duration;
	private int quantity;
	private double pricePerDay;

	@ManyToOne
	@JoinColumn(name = "director_id")
	private Director director;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(
	    name = "movie_genre",
	    joinColumns = @JoinColumn(name = "movie_id"),
	    inverseJoinColumns = @JoinColumn(name = "genre_id")
	)
	private Set<Genre> genres = new HashSet<>();

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<LoanMovies> loanMovies = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "actor_id")
	private Actor actor;

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

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<LoanMovies> getLoanMovies() {
		return loanMovies;
	}

	public void setLoanMovies(Set<LoanMovies> loanMovies) {
		this.loanMovies = loanMovies;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", duration=" + duration + ", quantity=" + quantity + ", director="
				+ director + ", genres=" + genres + ", loanMovies=" + loanMovies + "]";
	}

}
