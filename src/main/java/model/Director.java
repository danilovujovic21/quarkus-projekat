package model;

//import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
//import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "director")
@NamedQueries({ @NamedQuery(name = Director.GET_ALL_DIRECTORS, query = "Select d from Director d") })
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "director_seq")
	@SequenceGenerator(name = "director_seq", sequenceName = "director_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastName;

	public static final String GET_ALL_DIRECTORS = "getAllDirectors";

	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Movie> movies;

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
	
	public Set<Movie> getMovies() { // Promenjeno iz getMovie() u getMovies()
	        return movies;
	}
	
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (lastName == null) {
			return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", lastName=" + lastName + "]";
	}

}
