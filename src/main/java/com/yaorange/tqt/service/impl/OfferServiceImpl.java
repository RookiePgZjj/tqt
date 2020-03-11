package com.yaorange.tqt.service.impl;

import com.yaorange.tqt.mapper.OfferMapper;
import com.yaorange.tqt.pojo.Offer;
import com.yaorange.tqt.service.OfferService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class OfferServiceImpl implements OfferService {

    @Resource
    private OfferMapper offerMapper;

    @Override
    public List<Offer> findByUserId(Integer userId) {
        Offer offer = new Offer();
        offer.setUserId(userId);
        List<Offer> result = offerMapper.select(offer);
        return result;
    }

    @Override
    public void addOffer(Offer offer) {
        offerMapper.insert(offer);
    }

    @Override
    public void updateOffer(Offer offer) {
        offerMapper.updateByPrimaryKey(offer);
    }

    @Override
    public void updateEntry(Integer offerId, String isEntry) {
        Offer offer = offerMapper.selectByPrimaryKey(offerId);
        offer.setIsEntry(isEntry);
        offerMapper.updateByPrimaryKey(offer);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        ids.forEach(id->{
            offerMapper.deleteByPrimaryKey(id);
        });
    }

}
