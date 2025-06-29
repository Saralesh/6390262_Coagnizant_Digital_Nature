package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {
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

    @Test
    void testExternalApiMock() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mocked Response");

        MyService service = new MyService(mockApi);
        assertEquals("Mocked Response", service.fetchData());
    }
}
