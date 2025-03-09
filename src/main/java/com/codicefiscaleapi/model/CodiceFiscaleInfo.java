package com.codicefiscaleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CodiceFiscaleInfo {
    private LocalDate dataDiNascita;
    private int eta;
}