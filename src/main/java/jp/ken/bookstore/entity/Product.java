package jp.ken.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	private Integer product_id;
	
	private String product_name;
	
	private Integer publication_year;
	
	private Integer price;
	
	@OneToOne
	@JoinColumn(name = "author_id")
	private Author at;
	
	public Author getAt() {
		return at;
	}
	public void setAt(Author at) {
		this.at = at;
	}
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(Integer publication_year) {
		this.publication_year = publication_year;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
