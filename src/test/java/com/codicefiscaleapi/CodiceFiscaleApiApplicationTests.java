package com.codicefiscaleapi;

import com.codicefiscaleapi.controller.CodiceFiscaleController;
import com.codicefiscaleapi.model.CodiceFiscaleInfo;
import com.codicefiscaleapi.service.CodiceFiscaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CodiceFiscaleApplicationTests {

    @Autowired
    private CodiceFiscaleController controller;

    @Autowired
    private CodiceFiscaleService service;

    @Test
    void contextLoads() {
    }

    @Test
    void testCodiceFiscaleParsing() {
        // Caso di test 1: Uomo nato il 1990/01/01
        String codiceFiscale = "RSSMRA90A01H501Z";
        CodiceFiscaleInfo info = service.calcolaEta(codiceFiscale);
        assertNotNull(info);
        assertEquals(LocalDate.of(1990, 1, 1), info.getDataDiNascita());
        System.out.println("Test result 1: " + info.getDataDiNascita());

        // Caso di test 2: Donna nata il 1985/04/04
        codiceFiscale = "RSSMRA85D44H501Z";
        info = service.calcolaEta(codiceFiscale);
        assertNotNull(info);
        assertEquals(LocalDate.of(1985, 4, 4), info.getDataDiNascita());
        System.out.println("Test result 2: " + info.getDataDiNascita());

        // Caso di test 3: Donna nata il 2005/02/10
        codiceFiscale = "RSSMRA05B50H501Z";
        info = service.calcolaEta(codiceFiscale);
        assertNotNull(info);
        assertEquals(LocalDate.of(2005, 2, 10), info.getDataDiNascita());
        System.out.println("Test result 3: " + info.getDataDiNascita());
    }
}