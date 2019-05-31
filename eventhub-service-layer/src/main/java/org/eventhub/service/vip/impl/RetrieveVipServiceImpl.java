package org.eventhub.service.vip.impl;

import org.eventhub.common.model.entity.Vip;
import org.eventhub.dal.dao.VipRepository;
import org.eventhub.service.vip.RetrieveVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RetrieveVipServiceImpl implements RetrieveVipService {
    @Autowired
    VipRepository vipRepository;

    @Transactional
    @Override
    public Vip getById(UUID uuid) {
       return vipRepository.getOne(uuid);
    }
}
