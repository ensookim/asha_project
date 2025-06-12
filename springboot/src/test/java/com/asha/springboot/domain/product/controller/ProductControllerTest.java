package com.asha.springboot.domain.product.controller;

import com.asha.springboot.domain.product.dto.ProductDTO;
import com.asha.springboot.domain.product.entity.CategoryEntity;
import com.asha.springboot.domain.product.entity.ProductEntity;
import com.asha.springboot.domain.product.repository.ProductRepository;
import com.asha.springboot.domain.product.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private CategoryEntity testCategory;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        testCategory = categoryRepository.save(CategoryEntity.builder().categoryName("전자기기").build());
    }

    @Test
    void createProduct() throws Exception {
        ProductDTO dto = ProductDTO.builder()
                .productName("테스트 상품")
                .description("설명입니다")
                .categories("전자기기") // 단일 String 필드 사용
                .imageUrl("http://test.image")
                .build();

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.productName").value("테스트 상품"))
                .andExpect(jsonPath("$.imageUrl").value("http://test.image"));
    }

    @Test
    void getAllProducts() throws Exception {
        ProductEntity product = ProductEntity.builder()
                .productName("상품 1")
                .description("설명")
                .categories(Collections.singletonList(testCategory))
                .imageUrl("http://image.com")
                .build();
        productRepository.save(product);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void getProductById() throws Exception {
        ProductEntity product = ProductEntity.builder()
                .productName("상품 2")
                .description("설명")
                .categories(Collections.singletonList(testCategory))
                .imageUrl("http://image.com/2")
                .build();
        ProductEntity saved = productRepository.save(product);

        mockMvc.perform(get("/products/" + saved.getProductId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName").value("상품 2"));
    }

    @Test
    void updateProduct() throws Exception {
        ProductEntity product = ProductEntity.builder()
                .productName("구상품")
                .description("구설명")
                .categories(Collections.singletonList(testCategory))
                .imageUrl("구이미지")
                .build();
        ProductEntity saved = productRepository.save(product);

        saved.setProductName("신상품");

        mockMvc.perform(put("/products/" + saved.getProductId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName").value("신상품"));
    }

    @Test
    void deleteProduct() throws Exception {
        ProductEntity product = ProductEntity.builder()
                .productName("삭제용 상품")
                .description("삭제 설명")
                .categories(Collections.singletonList(testCategory))
                .imageUrl("삭제 이미지")
                .build();
        ProductEntity saved = productRepository.save(product);

        mockMvc.perform(delete("/products/" + saved.getProductId()))
                .andExpect(status().isNoContent());
    }
}
