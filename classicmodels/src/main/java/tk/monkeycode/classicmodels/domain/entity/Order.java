package tk.monkeycode.classicmodels.domain.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column(name = "requireddate")
	@Temporal(TemporalType.DATE)
	private Date requiredDate;
	
	@Column(name = "shippeddate")
	@Temporal(TemporalType.DATE)
	private Date shippedDate;
	
	private String status;
	
	private String comments;

}
