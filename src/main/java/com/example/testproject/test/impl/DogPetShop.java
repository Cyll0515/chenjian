package com.example.testproject.test.impl;

import com.example.testproject.test.PetSell;
import lombok.extern.slf4j.Slf4j;

/**
 * 宠物店狗(产品2)
 *
 * @author chenjian
 * @date 2021/4/14
 */
@Slf4j
public class DogPetShop implements PetSell {


    @Override
    public void sellCat() {
        log.info("出售狗狗");
    }

}
