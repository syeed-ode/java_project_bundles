package com.syeedode.authservices.dishes;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DishBuildingService {

    public List<Dish> getDishList() {
        return Arrays.asList(
                  new Dish("pork",false,800,Type.MEAT)
                , new Dish("beef", false, 700, Type.MEAT)
                , new Dish("chicken",false, 400, Type.MEAT)
                , new Dish("french fries", true, 530, Type.OTHER)
                , new Dish("rice",true,350,Type.OTHER)
                , new Dish("season fruit",true, 120, Type.OTHER)
                , new Dish("prawns",false, 300, Type.FISH)
                , new Dish("salmon",false, 450, Type.FISH)
        );
    }
}
