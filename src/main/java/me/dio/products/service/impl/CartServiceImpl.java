package me.dio.products.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.products.enumeration.PaymentMethod;
import me.dio.products.model.Cart;
import me.dio.products.model.Item;
import me.dio.products.model.Restaurant;
import me.dio.products.repository.CartRepository;
import me.dio.products.repository.ItemRepository;
import me.dio.products.repository.ProductRepository;
import me.dio.products.resource.dto.ItemDto;
import me.dio.products.service.CartService;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
	
	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	private final ItemRepository itemRepository;
	
	@Override
	  public Item insertItem(ItemDto itemDto) {
	    Cart cart = openCart(itemDto.getCartId());

	    if (cart.isClosed()) {
	      throw new RuntimeException("Esta sacola está fechada.");
	    }

	    Item itemTobeInsert = Item.builder()
	        .amout(itemDto.getAmount())
	        .cart(cart)
	        .product(productRepository.findById(itemDto.getProductId()).orElseThrow(
	            () -> {
	              throw new RuntimeException("Esse produto não existe!");
	            }
	        ))
	        .build();

	    List<Item> itens = cart.getItens();
	    if (itens.isEmpty()) {
	      itens.add(itemTobeInsert);
	    } else {
	      Restaurant currentRestaurante = itens.get(0).getProduct().getRestaurant();
	      Restaurant addRestaurantItem = itemTobeInsert.getProduct().getRestaurant();
	      if (currentRestaurante.equals(addRestaurantItem)) {
	        itens.add(itemTobeInsert);
	      } else {
	        throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferentes. Feche a sacola ou esvazie.");
	      }
	    }

	    List<Double> itensValue = new ArrayList()<>();
	    for (Item item: itens) {
	      double itemTotalValue =
	          item.getProduct().getUnitaryValue() * item.getAmount();
	      itensValue.add(itemTotalValue);
	    }

	    double cartTotalValue = itensValue.stream()
	        .mapToDouble(eachItemTotalValue -> eachItemTotalValue)
	        .sum();

	    cart.setTotal(cartTotalValue);
	    cartRepository.save(sacola);
	    return itemTobeInsert;
	  }

	  @Override
	  public Cart openCart(Long id) {
	    return cartRepository.findById(id).orElseThrow(
	        () -> {
	          throw new RuntimeException("Essa sacola não existe!");
	        }
	    );
	  }

	  @Override
	  public Cart closeCart(Long id, int numPaymentMethod) {
	    Cart cart = openCart(id);
	    if (cart.getItens().isEmpty()) {
	      throw new RuntimeException("Inclua ítens na sacola!");
	    }
	    /*if (numeroformaPagamento == 0) {
	      sacola.setFormaPagamento(FormaPagamento.DINHEIRO);
	    } else {
	      sacola.setFormaPagamento(FormaPagamento.MAQUINETA);
	    }*/
	    PaymentMethod paymentMethod =
	    		numPaymentMethod == 0 ? PaymentMethod.CASH : PaymentMethod.CARD;
	    cart.setPaymentMethod(paymentMethod);
	    cart.setClosed(true);
	    return cartRepository.save(cart);
	  }

}
