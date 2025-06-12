package com.asha.springboot.domain.product.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

/**
 * 상품 정보를 담는 엔티티
 */

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {

    // 상품 ID
    @Id // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    // 상품 이름
    @Column(name = "product_name", nullable = false) // Null 허용하지 않음
    private String productName;

    // 상품 설명
    @Column(name = "description", columnDefinition = "TEXT") // TEXT 타입으로 설정
    private String description;

    // 카테고리 ID (외래키)
    // 외래키 컬럼 설정 many-to-many 관계 (Category 엔티티와 연결)
    @ManyToMany(fetch = FetchType.EAGER) // 즉시 로딩으로 설정
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;

    // 상품 이미지 URL
    @Column(name = "image_url")
    private String imageUrl;

    @Builder
    public ProductEntity(Long productId, String productName, String description, List<CategoryEntity> categories,
            String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.categories = categories;
        this.imageUrl = imageUrl;
    }


    // 상품 정보 수정 메서드
    public void updateProduct(String productName, String description, String imageUrl) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("상품명은 비워둘 수 없습니다.");
        }
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

}