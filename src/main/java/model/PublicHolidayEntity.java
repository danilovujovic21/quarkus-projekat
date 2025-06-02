package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "public_holiday",
    uniqueConstraints = @UniqueConstraint(columnNames = {"year", "country_code"})
)
public class PublicHolidayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String localName;
    private String name;

    @Column(name = "country_code")
    private String countryCode;

    private int year; 

    @OneToMany(mappedBy = "publicHoliday", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TypeEntity> types = new ArrayList<>();

    public void setYearFromDate() {
        this.year = LocalDate.parse(this.date).getYear();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<TypeEntity> getTypes() {
		return types;
	}

	public void setTypes(List<TypeEntity> types) {
		this.types = types;
	}
	
	public PublicHolidayEntity( ) {
		
	}

    
}

