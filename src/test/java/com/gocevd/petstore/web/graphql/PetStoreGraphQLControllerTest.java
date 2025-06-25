package com.gocevd.petstore.web.graphql;

import com.gocevd.petstore.model.HistoryLog;
import com.gocevd.petstore.service.HistoryLogService;
import com.gocevd.petstore.service.PetStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@GraphQlTest(PetStoreGraphQLController.class)
@ContextConfiguration(classes = PetStoreGraphQLController.class)
public class PetStoreGraphQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockitoBean
    private PetStoreService petStoreService;
    @MockitoBean
    private HistoryLogService historyLogService;

    @Test
    void buy_mutation_invokesService() {
        HistoryLog log = new HistoryLog();
        when(petStoreService.buy()).thenReturn(log);
        String mutation = "mutation { buy { id } }";
        graphQlTester.document(mutation)
                .execute()
                .path("buy").entity(HistoryLog.class);
        verify(petStoreService).buy();
    }

    @Test
    void historyLog_query_invokesService() {
        when(historyLogService.historyLog()).thenReturn(Collections.emptyList());
        String query = "{ historyLogs { id } }";
        graphQlTester.document(query)
                .execute()
                .path("historyLogs").entityList(HistoryLog.class).hasSize(0);
        verify(historyLogService).historyLog();
    }
} 