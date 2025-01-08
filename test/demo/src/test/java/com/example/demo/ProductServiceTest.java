package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.Entities.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Services.ProductService;

public class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<Product> mockProducts = Arrays.asList(
            new Product() {{ setId(1); setName("Product A"); setPrice(10.0); setQuantity(5); }},
            new Product() {{ setId(2); setName("Product B"); setPrice(20.0); setQuantity(10); }}
        );
        when(repository.findAll()).thenReturn(mockProducts);

        // Act
        List<Product> products = service.getAllProducts();

        // Assert
        assertEquals(2, products.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetProductById() {
        // Arrange
        Product mockProduct = new Product();
        mockProduct.setId(1);
        mockProduct.setName("Product A");
        mockProduct.setPrice(10.0);
        mockProduct.setQuantity(5);
        when(repository.findById(1)).thenReturn(java.util.Optional.of(mockProduct));
    }

    /* 
     * @ExtendWith(MockitoExtension.class)
public class FriendControllerTest {

    @Mock
    private IFriendService friendService;

    @InjectMocks
    private FriendController friendController;

    @Test
    void testDeleteFriend_Success() {
        long idPlayer = 1L;
        long idFriend = 2L;

        doNothing().when(friendService).deleteFriend(idPlayer, idFriend);
        doNothing().when(friendService).deleteFriend(idFriend, idPlayer);

        ResponseEntity<String> response = friendController.deleteFriend(idPlayer, idFriend);

        verify(friendService, times(1)).deleteFriend(idPlayer, idFriend);
        verify(friendService, times(1)).deleteFriend(idFriend, idPlayer);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("L'amitié a été supprimé avec succès", response.getBody());
    }

    @Test
    void testDeleteFriend_NotFound() {
        long idPlayer = 1L;
        long idFriend = 2L;

        doThrow(new IllegalStateException("Friendship not found"))
                .when(friendService).deleteFriend(idPlayer, idFriend);

        ResponseEntity<String> response = friendController.deleteFriend(idPlayer, idFriend);

        verify(friendService, times(1)).deleteFriend(idPlayer, idFriend);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertEquals("Friendship not found", response.getBody());
    }
}
     * 
    */
}

