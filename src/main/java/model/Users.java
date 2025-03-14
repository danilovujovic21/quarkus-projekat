package model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = Users.GET_ALL_USERS, query = "Select u from Users u"),
		@NamedQuery(name = Users.GET_USER_BY_NAME, query = "Select u from Users u where u.name = :name") })
public class Users {

	public static final String GET_ALL_USERS = "getAllUsers";
	public static final String GET_USER_BY_NAME = "getUserByName";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Long id;
	private String name;
	private String lastName;
	private String jmbg;
	private String email;
	@Lob
	private byte[] image;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Phone> phones;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private List<LoanMovies> loanMovies;

	@OneToOne(cascade = { CascadeType.ALL })
	@JsonIgnore
	private IpLog ipLog;

	public IpLog getIpLog() {
		return ipLog;
	}

	public void setIpLog(IpLog ipLog) {
		this.ipLog = ipLog;
	}

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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<LoanMovies> getLoanMovies() {
		return loanMovies;
	}

	public void setLoanMovies(List<LoanMovies> loanMovies) {
		this.loanMovies = loanMovies;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Users [idUser=" + id + ", name=" + name + ", lastName=" + lastName + ", jmbg=" + jmbg + ", email="
				+ email + ", phones=" + phones + ", loanMovies=" + loanMovies + "]";
	}
	
	
}
