package mk.ukim.finki.wtshop.service;

import mk.ukim.finki.wtshop.model.ShoppingCart;

public interface ShoppingCartService {
    void addMoreToCart(Long id, Long productId);
    void removeFromCart(Long id,Long productId);
    void removeAllFromCart(Long id,Long productId);
    double getFullPriceOfCart(Long id);
    long getProductsInCart(Long id);
    ShoppingCart getShoppingCart(Long id);
}
