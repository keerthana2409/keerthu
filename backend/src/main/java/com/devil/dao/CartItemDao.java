package com.devil.dao;

import java.util.List;

import com.devil.models.CartItem;
import com.devil.models.CustomerOrder;
import com.devil.models.User;

public interface CartItemDao {
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem> getCartItems(String email);
	void removeCartItem(int cartItemId);
	void updateCartItem(int cartItemId, int requestedQuantity);
	CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}
