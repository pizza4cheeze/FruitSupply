package grushevskaya.test.develop.FruitSupply.controllers;

import grushevskaya.test.develop.FruitSupply.TO.SupplyTO;
import grushevskaya.test.develop.FruitSupply.services.ReportDocumentService;
import grushevskaya.test.develop.FruitSupply.services.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
public class SuppliesController {

    @Autowired
    private final SuppliesService suppliesService;

    @Autowired
    private final ReportDocumentService reportDocumentService;


    public SuppliesController(SuppliesService suppliesService, ReportDocumentService reportDocumentService) {
        this.suppliesService = suppliesService;
        this.reportDocumentService = reportDocumentService;
    }

    @PostMapping(path = "/take-supply")
    public String takeASupply(@RequestBody SupplyTO supplyTO) {
        return suppliesService.takeASupply(supplyTO);
    }

    @GetMapping(path = "/get-report/{startDate}/{endDate}")
    public ResponseEntity<ByteArrayResource> getReport(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) throws IOException {
        byte[] excelBytes = reportDocumentService.generateExcelReport(suppliesService.getReportByPeriod(startDate, endDate));

        ByteArrayResource resource = new ByteArrayResource(excelBytes);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(excelBytes.length)
                .body(resource);
    }
}
