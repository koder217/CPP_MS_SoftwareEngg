package edu.cpp.mscs.assignment5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Assignment5Controller {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/orders")
    public void createOrder(Order order){
        //Create
        orderRepository.save(order);
    }

    @DeleteMapping("/orders")
    public void deleteOrder(Order order){
        //Delete
        orderRepository.delete(order);
    }

    @PostMapping("/products")
    public void createProducts(Product product){
        //Create
        productRepository.save(product);

    }

    @PostMapping("/products")
    public void deleteProduct(Product product){
        //Delete
        productRepository.delete(product);
    }
}
