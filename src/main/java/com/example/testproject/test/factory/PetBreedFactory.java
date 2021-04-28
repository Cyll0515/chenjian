package com.example.testproject.test.factory;

import com.example.testproject.test.PetSell;
import com.example.testproject.test.proxy.CatPetProxy;
import com.example.testproject.test.proxy.DogPetProxy;

/**
 * 猫繁育工厂
 *
 * @author chenjian
 * @date 2021/4/14
 */
public class PetBreedFactory {

    public static PetSell getPetProxy(String type) {

        PetSell petSell = null;

        if ("1".equals(type)) {
            return new CatPetProxy();
        }
        if ("2".equals(type)) {
            return new DogPetProxy();
        }
        return petSell;
    }

}
