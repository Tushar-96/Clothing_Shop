/*
 * package com.Clothing_Shop.CartItem.entity;
 * 
 * import jakarta.persistence.Entity; import jakarta.persistence.GeneratedValue;
 * import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
 * import jakarta.persistence.Table; import lombok.AllArgsConstructor; import
 * lombok.Getter; import lombok.NoArgsConstructor; import lombok.Setter;
 * 
 * @Entity
 * 
 * @Table(name = "cartitem")
 * 
 * @Getter
 * 
 * @Setter
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor public class CartItem {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * private Long cart_id;
 * 
 * private Long product_id;
 * 
 * private int quantity;
 * 
 * private double price;
 * 
 * 
 * }
 */

package com.Clothing_Shop.CartItem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long cartId; // comes from ShoppingCart microservice
	private Long productId; // comes from Product microservice

	private int quantity;
	private double price;
}
