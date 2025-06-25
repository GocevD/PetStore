package com.gocevd.petstore.web.graphql;

import com.gocevd.petstore.model.Pet;
import com.gocevd.petstore.service.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@GraphQlTest(PetGraphQLController.class)
@ContextConfiguration(classes = PetGraphQLController.class)
public class PetGraphQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockitoBean
    private PetService petService;

    @Test
    void listPets_query_invokesService() {
        when(petService.listPets()).thenReturn(Collections.emptyList());
        String query = "{ listPets { name } }";
        graphQlTester.document(query)
                .execute()
                .path("listPets").entityList(Pet.class).hasSize(0);
        verify(petService).listPets();
    }

    @Test
    void createPets_mutation_invokesService() {
        when(petService.createPets()).thenReturn(Collections.emptyList());
        String mutation = "mutation { createPets { name } }";
        graphQlTester.document(mutation)
                .execute()
                .path("createPets").entityList(Pet.class).hasSize(0);
        verify(petService).createPets();
    }
} 