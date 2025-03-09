package com.codicefiscaleapi.service;

import com.codicefiscaleapi.model.CodiceFiscaleInfo;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

@Service
public class CodiceFiscaleService {

    // Estrae info demographiche dal codice fiscale e calcola l'età e la data di nastica
    public CodiceFiscaleInfo calcolaEta(String codiceFiscale) {
        try {
            if (codiceFiscale == null || codiceFiscale.length() != 16) {
                throw new IllegalArgumentException("Il codice fiscale deve essere di 16 caratteri. Trovati: " + codiceFiscale.length());
            }
            // Prefisso del anno dinamico
            String anno = Integer.parseInt(codiceFiscale.substring(6, 8)) < 40 ? "20" + codiceFiscale.substring(6, 8) : "19" + codiceFiscale.substring(6, 8);
            String mese = convertiMese(codiceFiscale.substring(8, 9));
            String giorno = codiceFiscale.substring(9, 11);

            if (Integer.parseInt(giorno) > 40) { // Per le signore
                giorno = Integer.toString(Integer.parseInt(giorno) - 40);
            }

            LocalDate dataDiNascita = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
            LocalDate oggi = LocalDate.now();
            int eta = Period.between(dataDiNascita, oggi).getYears();

            return new CodiceFiscaleInfo(dataDiNascita, eta);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Errore nel formato dei numeri nel codice fiscale: " + e.getMessage());
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Data di nascita non valida");
        } catch (Exception e) {
            throw new IllegalArgumentException("Errore nel processare il codice fiscale: " + e.getMessage());
        }
    }

    private String convertiMese(String letteraMese) {
        // Converta la lettera del mese nel codice numerico
        Map<String, String> mesi = Map.ofEntries(
                Map.entry("A", "01"),
                Map.entry("B", "02"),
                Map.entry("C", "03"),
                Map.entry("D", "04"),
                Map.entry("E", "05"),
                Map.entry("H", "06"),
                Map.entry("L", "07"),
                Map.entry("M", "08"),
                Map.entry("P", "09"),
                Map.entry("R", "10"),
                Map.entry("S", "11"),
                Map.entry("T", "12")
        );
        if (mesi.get(letteraMese) == null) {
            throw new IllegalArgumentException("Lettera mese non valida: " + letteraMese);
        }
        return mesi.get(letteraMese);
    }
}
