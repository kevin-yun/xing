package com.kevin.xing.enums;

public interface GenericEnum<K, V, C extends Enum<?>> {
    C get();

    K getValue();

    V getDescription();
}
