package com.gs.legostrore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collation = "legosets")//it will give error
//@Document("company")//this is the standard  way to do the declaration
@Document(collection = "legosets")
public class LegoSet {
    @Id
    private String id;
    @TextIndexed
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private LegoSetDifficulty difficulty;
    @TextIndexed
    private String theme;
    private Collection<ProductReview> reviews = new ArrayList<>();

    @Field("delivery")
    private DeliveryInfo deliveryInfo;

    @DBRef
    private PaymentOptions paymentOptions;
    //cascading need to implements

    // @Transient
    private int nbParts;



    @PersistenceConstructor
    public LegoSet(String name, String theme, LegoSetDifficulty difficulty, DeliveryInfo deliveryInfo, Collection<ProductReview> reviews, PaymentOptions paymentOptions) {
        this.name = name;
        this.theme = theme;
        this.difficulty = difficulty;
        this.deliveryInfo = deliveryInfo;
        this.paymentOptions = paymentOptions;
        if (reviews != null) {
            this.reviews = reviews;
        }
    }


}
