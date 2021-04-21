package tk.monkeycode.classicmodels.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

	@Id
	@Column(name = "customernumber")
	private Integer customerNumber;
	
	@Column(name = "customername")
	private String customerName;
	
}
