package com.example.testproject.test.proxy;

import com.example.testproject.test.PetSell;
import com.example.testproject.test.impl.CatPetShop;
import com.example.testproject.test.impl.DogPetShop;
import lombok.extern.slf4j.Slf4j;

/**
 * 宠物猫代理
 *
 * @author chenjian
 * @date 2021/4/14
 */
@Slf4j
public class DogPetProxy implements PetSell {

    private PetSell dogPetProxy;

    public DogPetProxy() {
        this.dogPetProxy = new DogPetShop();
    }

    @Override
    public void sellCat() {
        log.info("狗代理");
        dogPetProxy.sellCat();
    }

}
