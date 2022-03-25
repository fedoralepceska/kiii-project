package mk.ukim.finki.wtshop.service.impl;

import mk.ukim.finki.wtshop.model.Product;
import mk.ukim.finki.wtshop.model.ShoppingCart;
import mk.ukim.finki.wtshop.repository.ProductRepository;
import mk.ukim.finki.wtshop.repository.ShoppingCartRepository;
import mk.ukim.finki.wtshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    public ShoppingCart getShoppingCart(Long id) {
        if (shoppingCartRepository.findById(id).isPresent())
            return shoppingCartRepository.getById(id);
        ShoppingCart shoppingCart = new ShoppingCart();
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addMoreToCart(Long id, Long productId) {
        ShoppingCart cart = getShoppingCart(id);
        List<Product> productList = cart.getProducts();
        productList.add(this.productRepository.getById(productId));
        cart.setProducts(productList);
        this.shoppingCartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Long id, Long productId) {
        ShoppingCart cart = getShoppingCart(id);
        Product product = productRepository.findById(productId).orElseThrow();
        List<Product> products = cart.getProducts();
        products.remove(product);
        cart.setProducts(products);
        this.shoppingCartRepository.save(cart);
    }

    @Override
    public void removeAllFromCart(Long id, Long productId) {
        ShoppingCart cart = getShoppingCart(id);
        cart.setProducts(new ArrayList<>());
        this.shoppingCartRepository.save(cart);
    }


    @Override
    public double getFullPriceOfCart(Long id) {
        return shoppingCartRepository.getById(id).getProducts().stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public long getProductsInCart(Long id) {
        return shoppingCartRepository.getById(id).getProducts().size();
    }
}
