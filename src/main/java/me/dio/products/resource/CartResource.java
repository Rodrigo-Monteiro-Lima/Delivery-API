package me.dio.products.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.products.model.Cart;
import me.dio.products.model.Item;
import me.dio.products.resource.dto.ItemDto;
import me.dio.products.service.CartService;

/**@Api(value="/ifood-devweek/sacolas")**/
@RestController
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class CartResource {
	
	private final CartService cartService;
	
	@PostMapping
	  public Item insertItem(@RequestBody ItemDto itemDto) {
	    return cartService.insertItem(itemDto);
	  }

	  @GetMapping("/{id}")
	  public Cart openCart(@PathVariable("id") Long id) {
	    return cartService.openCart(id);
	  }

	  @PatchMapping("/closeCart/{cartId}")
	  public Cart closeCart(@PathVariable("cartId") Long cartId,
	                             @RequestParam("paymentMethod") int paymentMethod) {
	    return cartService.closeCart(cartId, paymentMethod);
	  }

}
