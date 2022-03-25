package mk.ukim.finki.wtshop.web.controller;

import mk.ukim.finki.wtshop.service.ProductService;
import mk.ukim.finki.wtshop.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping
    public String getShoppingCartPage(Model model) {
        model.addAttribute("items", shoppingCartService.getShoppingCart(1L).getProducts());
        model.addAttribute("bodyContent", "shoppingCart");

        return "master-template";
    }
    @GetMapping("/buy")
    public String getBuyPage(Model model)
    {
        model.addAttribute("bodyContent", "shoppingCartSuccess");
        shoppingCartService.removeAllFromCart(1L,0L);
        return "master-template";
    }
    @PostMapping("/add/{productId}")
    public String addProductToCart(@PathVariable Long productId) {
        this.shoppingCartService.addMoreToCart(1L, productId);
        return "redirect:/shopping-cart";
    }

    @PostMapping("/remove/{productId}")
    public String removeProductFromCart(@PathVariable Long productId) {
        this.shoppingCartService.removeFromCart(1L, productId);
        return "redirect:/shopping-cart";
    }
    @PostMapping("/sum")
    public String sumOfItems()
    {
        this.shoppingCartService.getFullPriceOfCart(1L);
        return "redirect:/shopping-cart";
    }
    @RequestMapping(value="/total", method=GET)
    @ResponseBody
    public String foo() {
        return Double.toString(shoppingCartService.getFullPriceOfCart(1L));
    }




}
