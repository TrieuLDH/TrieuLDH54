package it16306.assignment.beans;




import it16306.assignment.entities.Order;
import it16306.assignment.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {

private int orderId;
	
	private Product product;
	
	private double price;
	
	private int quantity;
}
