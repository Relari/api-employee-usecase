package com.pe.relari.employee.util;

import java.util.HashMap;

public class GenericMap<K, V> extends HashMap<K, V> {

    public V getValue(K key) {
        return super.get(key);
    }

}
