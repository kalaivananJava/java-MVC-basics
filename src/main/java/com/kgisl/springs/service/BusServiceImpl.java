package com.kgisl.springs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kgisl.springs.dao.BusDAO;
import com.kgisl.springs.entity.Bus;

import jakarta.transaction.Transactional;

public class BusServiceImpl implements BusService{

    @Autowired
    private BusDAO busDao;

    @Override
    @Transactional
    public List<Bus> getBus() {
        return busDao.getBus();
    }

    @Override
    @Transactional
    public void saveBus(Bus theBus) {
        busDao.saveBus(theBus);
    }

    @Override
    @Transactional
    public void updateBus(Bus theBus) {
      busDao.updateBus(theBus);
    }

    @Override
    public Bus getBusById(int theId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBusById'");
    }

    @Override
    public void deleteBus(int theId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBus'");
    }
    
}
