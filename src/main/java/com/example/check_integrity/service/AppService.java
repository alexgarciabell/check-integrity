package com.example.check_integrity.service;

import com.example.dto.Dummy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Service
public class AppService {
    private static final List<Dummy> payload = readDataFile("data.json");


    //Helper method
    public static List<Dummy> readDataFile(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream input = AppService.class.getClassLoader().getResourceAsStream(filename)) {
            if (input != null) {
                Dummy[] data = mapper.readValue(input.readAllBytes(), Dummy[].class);
                return Arrays.stream(data).toList();
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return null;
    }
}
