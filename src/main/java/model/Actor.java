package model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
//import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = Actor.GET_ALL_ACTORS, query = "Select a from Actor a") })
public class Actor {

	public static final String GET_ALL_ACTORS = "getAllActors";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq")
	private Long id;
	private String name;
	private String lastName;
	private String role;
	@OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	public static String getGetAllActors() {
		return GET_ALL_ACTORS;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(movies, id, lastName, name, role);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(movies, other.movies) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role);
	}

	
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", lastName=" + lastName + ", role=" + role + ", movies=" + movies
				+ "]";
	}
}
