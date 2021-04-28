package com.example.testproject.test.proxy;

import com.example.testproject.test.PetSell;
import com.example.testproject.test.impl.CatPetShop;
import lombok.extern.slf4j.Slf4j;

/**
 * 宠物猫代理
 *
 * @author chenjian
 * @date 2021/4/14
 */
@Slf4j
public class CatPetProxy implements PetSell {

    private PetSell catPetShop;

    public CatPetProxy() {
        this.catPetShop = new CatPetShop();
    }

    @Override
    public void sellCat() {
        log.info("猫代理");
        catPetShop.sellCat();
    }

}
