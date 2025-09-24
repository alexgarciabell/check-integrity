package com.example.check_integrity;

import com.example.check_integrity.service.AppService;
import com.example.dto.Dummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IntegrityAppTests {

    @Autowired
    private AppService service;

    private List<Dummy> payload;

    @BeforeEach
    void setup() {
        payload = AppService.readDataFile("test_data.json");
    }

    @Test
    void integrityTest() {
        assertNotNull(payload);
        assertEquals(2, payload.size());
        assertTrue(payload.stream()
                .map(Dummy::getId)
                .anyMatch(d -> d.equals("85A8CE0BAF9008040533")));
    }

}
