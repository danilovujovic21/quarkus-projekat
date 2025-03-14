package model;

import jakarta.persistence.*;
//import java.util.List;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = LoanMovies.GET_ALL_LOAN_MOVIES, query = "Select lm from LoanMovies lm") })
public class LoanMovies {

	public static final String GET_ALL_LOAN_MOVIES = "getAllLoanMovies";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loanMovies_seq")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users user;

	@JsonIgnore
	private Date loanDate;
	private Date returnDate;
	@JsonIgnore
	private boolean returned = false;
	@JsonIgnore
	private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LoanMovies [id=" + id + ", movie=" + movie + ", user=" + user + ", loanDate=" + loanDate + ", returnDate="
				+ returnDate + ", returned=" + returned + ", price=" + price + "]";
	}

}
