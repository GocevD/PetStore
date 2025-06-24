package com.gocevd.petstore.repository.jpa;

import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findFirstByOwnerIsNullOrderById();
}
