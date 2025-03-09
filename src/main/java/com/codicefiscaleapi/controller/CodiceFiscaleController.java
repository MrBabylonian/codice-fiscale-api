package com.codicefiscaleapi.controller;

import com.codicefiscaleapi.service.CodiceFiscaleService;
import com.codicefiscaleapi.model.CodiceFiscaleInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Codice Fiscale", description = "Calcola l'età e la data di nascita dal codice fiscale")
public class CodiceFiscaleController {

    private final CodiceFiscaleService codiceFiscaleService;

    public CodiceFiscaleController(CodiceFiscaleService codiceFiscaleService) {
        this.codiceFiscaleService = codiceFiscaleService;
    }

    @GetMapping("codicefiscale") // Endpoint per estrarre informazioni dal codice fiscale
    @Operation(
            summary = "Calcola l'età e la data di nascita dal codice fiscale",
            description = "Restituisce l'età e la data di nascita calcolate dal codice fiscale",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Codice fiscale processato con successo"),
                    @ApiResponse(responseCode = "400", description = "Errore nel processare il codice fiscale")
            }
    )
    public ResponseEntity<CodiceFiscaleInfo> getInfoCodiceFiscale(@RequestParam(required = true) String codiceFiscale) {
        CodiceFiscaleInfo info = codiceFiscaleService.calcolaEta(codiceFiscale.toUpperCase());
        return ResponseEntity.ok(info);
    }
}