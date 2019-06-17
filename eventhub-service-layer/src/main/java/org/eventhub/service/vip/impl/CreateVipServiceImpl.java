package org.eventhub.service.vip.impl;

import org.eventhub.common.model.entity.Vip;
import org.eventhub.dal.dao.VipRepository;
import org.eventhub.service.vip.CreateVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateVipServiceImpl implements CreateVipService {

    @Autowired
    VipRepository vipRepository;

    @Transactional
    @Override
    public Vip createVip(Vip vip) {
        Vip savedVip = vipRepository.save(vip);
        return savedVip;
    }

    @Transactional
    @Override
    public void updateVip(Vip vip) {
        vipRepository.update(vip);
    }

}
