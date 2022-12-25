package me.dio.products.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Product {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  private String name;
	  private double unitaryValue;
	  @Builder.Default
	  private Boolean avaliable = true;
	  @ManyToOne
	  @JsonIgnore
	  private Restaurant restaurant;
}
