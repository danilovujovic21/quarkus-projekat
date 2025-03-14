package model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = Director.GET_ALL_DIRECTORS, query = "Select d from Director d") })
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "director_seq")
	private Long id;
	private String name;
	private String lastName;

	public static final String GET_ALL_DIRECTORS = "getAllDirectors";

	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", lastName=" + lastName + "]";
	}

}
