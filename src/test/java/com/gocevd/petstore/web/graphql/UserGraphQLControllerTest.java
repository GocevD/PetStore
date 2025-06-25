package com.gocevd.petstore.web.graphql;

import com.gocevd.petstore.model.User;
import com.gocevd.petstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@GraphQlTest(UserGraphQLController.class)
@ContextConfiguration(classes = UserGraphQLController.class)
public class UserGraphQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockitoBean
    private UserService userService;

    @Test
    void listUsers_query_invokesService() {
        when(userService.listUsers()).thenReturn(Collections.emptyList());
        String query = "{ listUsers { id } }";
        graphQlTester.document(query)
                .execute()
                .path("listUsers").entityList(User.class).hasSize(0);
        verify(userService).listUsers();
    }

    @Test
    void createUsers_mutation_invokesService() {
        when(userService.createUsers()).thenReturn(Collections.emptyList());
        String mutation = "mutation { createUsers { id } }";
        graphQlTester.document(mutation)
                .execute()
                .path("createUsers").entityList(User.class).hasSize(0);
        verify(userService).createUsers();
    }
} 