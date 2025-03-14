package model;

import jakarta.persistence.*;
//import java.util.List;
import java.sql.Date;



@Entity
public class IpLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iplog_seq")
	private Long id;
	private String ipString;
	private String ipType;
	private Date createdDate;

	public IpLog() {
		super();
	}

	public IpLog(String ipString, String ipType, Date createdDate) {
		super();
		this.ipString = ipString;
		this.ipType = ipType;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpString() {
		return ipString;
	}

	public void setIpString(String ipString) {
		this.ipString = ipString;
	}

	public String getIpType() {
		return ipType;
	}

	public void setIpType(String ipType) {
		this.ipType = ipType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "IpLog [id=" + id + ", ipString=" + ipString + ", ipType=" + ipType + ", createdDate=" + createdDate
				+ "]";
	}


}
