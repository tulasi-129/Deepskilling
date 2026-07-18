package com.example.VerifyingInteractions;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

interface ExternalApi {
    String getData();
}

class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Step 1: Create Mock Object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Create Service Object
        MyService service = new MyService(mockApi);

        // Step 3: Call Method
        service.fetchData();

        // Step 4: Verify Interaction
        verify(mockApi).getData();

        System.out.println("Interaction Verified Successfully!");
    }
}