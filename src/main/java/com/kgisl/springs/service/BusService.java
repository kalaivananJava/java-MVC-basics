package com.kgisl.springs.service;

import java.util.List;

import com.kgisl.springs.entity.Bus;

public interface BusService {

    public List<Bus> getBus();

    public void saveBus(Bus theBus);

    public void updateBus(Bus theBus);

    public Bus getBusById(int theId);

    public void deleteBus(int theId);

}

