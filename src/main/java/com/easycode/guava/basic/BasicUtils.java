package com.easycode.guava.basic;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.Ordering;

public class BasicUtils {

    public static void main(String arg[]){
        Optional.absent();
        Optional.of("");

        Objects.equal("a", "b");

        Ordering.natural();
    }



}
