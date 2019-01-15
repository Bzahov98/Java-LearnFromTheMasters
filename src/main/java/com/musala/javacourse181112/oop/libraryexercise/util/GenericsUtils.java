package com.musala.javacourse181112.oop.libraryexercise.util;

import com.musala.javacourse181112.oop.libraryexercise.model.AbstractItem;

import java.lang.reflect.InvocationTargetException;

public class GenericsUtils {

    public static <T extends AbstractItem> T getInstace(final Class<T> inputClass) {
        assert inputClass != null;
        try {

            return inputClass.getConstructor().newInstance();

        } catch (IllegalAccessException | InvocationTargetException |
                  NoSuchMethodException | InstantiationException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
