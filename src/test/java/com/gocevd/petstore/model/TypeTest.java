package com.gocevd.petstore.model;

import com.gocevd.petstore.model.enumerations.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {
    @Test
    void testEnumValues() {
        Type[] values = Type.values();
        assertArrayEquals(new Type[]{Type.CAT, Type.DOG}, values);
    }
} 