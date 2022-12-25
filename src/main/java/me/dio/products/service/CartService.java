package me.dio.products.service;

import me.dio.products.model.Cart;
import me.dio.products.model.Item;
import me.dio.products.resource.dto.ItemDto;

public interface CartService {
	 Item insertItem(ItemDto itemDto);
	 Cart openCart(Long id);
	 Cart closeCart(Long id, int paymentMethod);
}
