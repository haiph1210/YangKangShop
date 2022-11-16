package com.YangKang.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",nullable = false,unique = true,length = 50)
    private String name;
    @Column(name = "sale_price")
    private Integer salePrice = 0;
    @Column(name = "price",nullable = false)
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(name = "ram" ,nullable = false,length =6)
    private Ram ram;
    @Column(name = "thumbnail_url",nullable = false)
    private String thumbnailUrl;
    @Column(name = "description",length = 1500,nullable = false)
    private String description;
    @Column(name = "amount" ,nullable = false)
    private Integer amount;
    @Column(name = "money")
//    @Formula("concat('money', ,VND)")
    private Double money;

    @Column(name = "created_date",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;
    @Column(name = "update_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id",nullable = false)
    private Category category;



    public enum Ram{
        _4GB,_8GB,_16GB,_32GB,_64GB,_128GB,_256GB,_1TB
    }

//    public Double getMoney() {
//        if (getSalePrice() == 0){
//            this.money = getPrice() * getAmount();
//            System.out.printf("%.3f",money);
//            return money;
//        }else {
//            this.money = getPrice() * getAmount();
//            Double moneySale = money - money *(1/getSalePrice());
//            System.out.printf("%.3f",moneySale);
//            return moneySale;
//        }
//
//    }
}
