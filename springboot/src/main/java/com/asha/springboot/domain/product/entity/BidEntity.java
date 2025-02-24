package com.asha.springboot.domain.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.asha.springboot.domain.user.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 입찰 정보 엔티티
 */
@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BidEntity {

    // 입찰 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidId;

    // 경매 (외래키)
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "auction_id") // auction_id 외래키
    private AuctionEntity auction; // 경매 엔티티

    // 입찰 금액
    @Column(name = "bid_price", nullable = false)
    private BigDecimal bidPrice;

    // 입찰 시간
    @Column(name = "bid_time", nullable = false)
    private LocalDateTime bidTime;

    // 입찰자 (사용자)
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "customer_id") // 고객 ID 외래키
    private UserEntity user; // 입찰한 사용자

    @Builder
    public BidEntity(Long bidId, AuctionEntity auction, BigDecimal bidPrice, LocalDateTime bidTime, UserEntity user) {
        this.bidId = bidId;
        this.auction = auction;
        this.bidPrice = bidPrice;
        this.bidTime = bidTime;
        this.user = user;
    }
}
