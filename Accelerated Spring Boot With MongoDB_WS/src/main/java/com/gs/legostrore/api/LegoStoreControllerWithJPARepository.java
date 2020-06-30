package com.gs.legostrore.api;

import com.gs.legostrore.model.LegoSet;
import com.gs.legostrore.model.LegoSetDifficulty;
import com.gs.legostrore.model.QLegoSet;
import com.gs.legostrore.persistence.LegoSetRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("legostore/repo/api")
@Slf4j
public class LegoStoreControllerWithJPARepository {

    @Autowired
    private LegoSetRepository legoSetRepository;


    @PostMapping
    public void insert(@RequestBody LegoSet legoSet) {
        LegoSet insert = legoSetRepository.insert(legoSet);
    }

    @GetMapping("/all")
    public Collection<LegoSet> getAll() {
        Sort sort = Sort.by("name").ascending();
        List<LegoSet> all = this.legoSetRepository.findAll(sort);
        System.out.println(all);
        return all;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        System.out.println("id value is " + id);
        log.info("id  is : " + id);
        legoSetRepository.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody LegoSet legoSet) {
        legoSetRepository.save(legoSet);
    }

    @GetMapping("/{Id}")
    public LegoSet findById(@PathVariable String Id) {
        LegoSet legoSet = legoSetRepository.findById(Id).orElse(null);
        log.info("legoSet is legoSet::" + legoSet.getId());
        return legoSet;
    }

    @GetMapping("/bytheme/{theme}")
    public Collection<LegoSet> findAllByTemContains(@PathVariable String theme) {
        log.debug("theme is :::" + theme);
        Sort sort = Sort.by("theme").ascending();
        Collection<LegoSet> allByThemContains = legoSetRepository.findAllByThemeContains(theme, sort);
        log.info("allByThemContains is allByThemContains::" + allByThemContains);
        return allByThemContains;
    }

    @GetMapping("/bydifficultyAndNameStartWithM")
    public Collection<LegoSet> findAllByDifficultyAndNameStartWithM() {
        Collection<LegoSet> allByThemContains = legoSetRepository.findAllByDifficultyAndNameStartsWith(LegoSetDifficulty.HARD, "M");
        log.info("allByThemContains is allByThemContains::" + allByThemContains);
        return allByThemContains;
    }

    @GetMapping("/byDeliveryFeeLessThan/{price}")
    public Collection<LegoSet> byDeliveryFeeLessThan(@PathVariable int price) {
        return this.legoSetRepository.findAllByDeliveryPriceLessThan(price);
    }

    @GetMapping("/greatReviews")
    public Collection<LegoSet> byGreatReviews() {
        return this.legoSetRepository.findAllByGreatReviews();
    }

    @GetMapping("/byPaymentOption/{id}")
    public Collection<LegoSet> byPaymentOption(@PathVariable String id) {
        return this.legoSetRepository.findByPaymentOptionId(id);
    }

    @GetMapping("/bestbuy")
    public Collection<LegoSet> bestBuys() {
        //build the query
        QLegoSet query = new QLegoSet("query");
        Predicate inStockFilter = query.deliveryInfo.inStock.isTrue();
        Predicate smallDeliveryFeeFilter = query.deliveryInfo.deliveryFee.lt(50);
        Predicate hasGreatReviews = query.reviews.any().rating.eq(10);
        Predicate bestBuysFilter = ((BooleanExpression) inStockFilter)
                .and(smallDeliveryFeeFilter)
                .and(hasGreatReviews);
        // pass the query to findAll()
        return (Collection<LegoSet>) this.legoSetRepository.findAll(bestBuysFilter);
    }

    @GetMapping("fullTextSearch/{text}")
    public Collection<LegoSet> fullTextSearch(@PathVariable String text){
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);
        return this.legoSetRepository.findAllBy(textCriteria);
    }


}
