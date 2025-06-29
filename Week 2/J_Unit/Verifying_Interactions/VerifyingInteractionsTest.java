package com.example;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.List;

public class VerifyingInteractionsTest {
    @Test
    void testVerify() {
        List<String> mockList = mock(List.class);

        mockList.add("Hello");
        mockList.clear();

        verify(mockList).add("Hello");
        verify(mockList).clear();
    }
}