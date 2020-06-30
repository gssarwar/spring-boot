package com.gs.legostrore.persistence;

import com.gs.legostrore.model.LegoSet;
import com.gs.legostrore.model.LegoSetDifficulty;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Collection;

public interface LegoSetRepository extends MongoRepository<LegoSet,String>, QuerydslPredicateExecutor<LegoSet> {
    Collection<LegoSet> findAllByThemeContains(String theme,Sort sort);
    Collection<LegoSet> findAllByDifficultyAndNameStartsWith(LegoSetDifficulty legoSetDifficulty,String name);
    Collection<LegoSet> findAllBy(TextCriteria textCriteria);

    //to find the collections based on sub collections
  /*  @Query("{'delivery.deliveryFee' : {$lt : ?1}}")
    Collection<LegoSet> findAllByDeliveryPriceLessThan(int price,int price2);
    */
    @Query("{'delivery.deliveryFee' : {$lt : ?0}}")
    Collection<LegoSet> findAllByDeliveryPriceLessThan(int price);
    @Query("{'reviews.rating' : {$eq : 10}}")
    Collection<LegoSet> findAllByGreatReviews();
    @Query("{'paymentOptions.id' : ?0}")
    Collection<LegoSet> findByPaymentOptionId(String id);
}
