package com.gocevd.petstore;

import com.gocevd.petstore.model.Cat;
import com.gocevd.petstore.model.enumerations.Type;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PetStoreApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testPetAgeCalculation() {
        // Create a birth date for a pet that is exactly 3 years old
        LocalDate birthDate = LocalDate.now().minusYears(3);

        // Create a Cat instance with the birth date
        Cat cat = new Cat("TestCat", "Test cat for age calculation", birthDate);

        // Verify the age is calculated correctly
        int expectedAge = 3;
        int actualAge = cat.getAge();

        System.out.println("[DEBUG_LOG] Expected age: " + expectedAge);
        System.out.println("[DEBUG_LOG] Actual age: " + actualAge);

        assertEquals(expectedAge, actualAge, "Pet age should be calculated correctly");
    }

}
