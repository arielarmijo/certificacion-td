package tk.monkeycode.classicmodels.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
	
	@Id
	@Column(name = "ordernumber")
	private Integer orderNumber;
	
	@Column(name = "orderdate")
	private Date orderDate;
	
	@Column(name = "requireddate")
	private Date requiredDate;
	
	@Column(name = "shippeddate")
	private Date shippedDate;
	
	private String status;
	
	private String comments;

}
