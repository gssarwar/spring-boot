package com.gs.legostrore.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gs.legostrore.model.DeliveryInfo;
import com.gs.legostrore.model.LegoSet;
import com.gs.legostrore.model.LegoSetDifficulty;
import com.gs.legostrore.model.ProductReview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
       /* LegoSet milleniumFalcon = new LegoSet(
                "Millennium Falcon",
                "Star Wars",
                LegoSetDifficulty.HARD,
                new DeliveryInfo(localDate, 30, true),
                Arrays.asList(new ProductReview("Dan", 7)));*/

      /*  ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString

        String jsonString = mapper.writeValueAsString(milleniumFalcon);
        System.out.println(jsonString);*/
    }
}
