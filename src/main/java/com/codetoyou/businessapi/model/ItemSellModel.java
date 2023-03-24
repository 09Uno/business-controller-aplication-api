package com.codetoyou.businessapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemsell")
public class ItemSellModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sell_id")   
    private SellModel sell;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @Column(name = "quantity")
    private Integer quantity;

   

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public SellModel getSell() {
        return sell;
    }
    public void setSell(SellModel sell) {
        this.sell = sell;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
   
    public ProductModel getProduct() {
        return product;
    }
    public void setProduct(ProductModel product) {
        this.product = product;
    }
    @Override
    public String toString() {
        return "ItemSellModel [id=" + id + ", sell=" + sell + ", product=" + product + ", quantity=" + quantity + "]";
    }
    
    
    

}
