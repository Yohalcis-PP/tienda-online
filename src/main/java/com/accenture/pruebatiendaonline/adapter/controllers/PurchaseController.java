package com.accenture.pruebatiendaonline.adapter.controllers;

import com.accenture.pruebatiendaonline.adapter.controllers.dto.PurchaseDTO_Save;
import com.accenture.pruebatiendaonline.adapter.controllers.dto.PurchaseDTO_Update;
import com.accenture.pruebatiendaonline.adapter.controllers.mapper.IPurchaseDTOMapper;
import com.accenture.pruebatiendaonline.domain.PurchaseDTO;
import com.accenture.pruebatiendaonline.domain.services.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final IPurchaseDTOMapper mapperDTO;

    public PurchaseController(PurchaseService purchaseService, IPurchaseDTOMapper mapperDTO) {
        this.purchaseService = purchaseService;
        this.mapperDTO = mapperDTO;
    }

    @GetMapping()
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDTO>> getByClient(@PathVariable("id") String id) {
        return purchaseService.getPurchaseByClient(id).map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                                                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO_Save purchase) {
        return new ResponseEntity<>(purchaseService.save(mapperDTO.toPurchaseDTO(purchase)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int purchaseId) {
        if(purchaseService.delete(purchaseId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<PurchaseDTO> update(@RequestBody PurchaseDTO_Update purchase) {
        PurchaseDTO purchaseDto = purchaseService.update(mapperDTO.toPurchaseDTO(purchase));
        if(purchaseDto==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(purchaseDto, HttpStatus.OK);
        }

    }
}
