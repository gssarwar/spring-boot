package com.gs.legostrore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeliveryInfo {
    private LocalDate deliveryDate;
    private int deliveryFee;
    private boolean inStock;

}
