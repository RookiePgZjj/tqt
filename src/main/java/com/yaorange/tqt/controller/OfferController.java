package com.yaorange.tqt.controller;

import com.yaorange.tqt.pojo.Offer;
import com.yaorange.tqt.service.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/offer")
public class OfferController {

    @Resource
    private OfferService offerService;

    @GetMapping("load")
    public ResponseEntity<List<Offer>> queryList(@RequestParam("userId") Integer userId){
        List<Offer> result = offerService.findByUserId(userId);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<String> addOffer(@RequestBody Offer offer,@RequestParam("access_token") String accessToken){
        offerService.addOffer(offer);
        return ResponseEntity.ok("1");
    }

    @PutMapping
    public ResponseEntity<String> updateOffer(@RequestBody Offer offer,@RequestParam("access_token") String accessToken){
        offerService.updateOffer(offer);
        return ResponseEntity.ok("1");
    }
//    /api/offer/entry/' + params.row.offerId + '/' + (!params.row.isEntry),

    @PutMapping("entry/{offerId}/{isEntry}")
    public ResponseEntity<String> updateEntry(@PathVariable("offerId") Integer offerId,
                                              @PathVariable("isEntry")String isEntry){
        offerService.updateEntry(offerId,isEntry);
        return ResponseEntity.ok("1");
    }
}
