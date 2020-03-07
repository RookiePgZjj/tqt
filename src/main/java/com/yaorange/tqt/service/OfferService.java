package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> findByUserId(Integer userId);

    void addOffer(Offer offer);

    void updateOffer(Offer offer);

    void updateEntry(Integer offerId, String isEntry);
}
