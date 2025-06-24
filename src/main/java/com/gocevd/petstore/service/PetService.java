package com.gocevd.petstore.service;

import com.gocevd.petstore.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {
    void createPets();
    Pet savePet(Pet pet);
    List<Pet> listPets();
    Pet findPetWithoutOwner();
}
