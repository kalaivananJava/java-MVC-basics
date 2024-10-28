package com.kgisl.springs.dao;

import java.util.List;

import com.kgisl.springs.entity.Bus;

public interface BusDAO {
    
    public List<Bus> getBus();
    public void saveBus(Bus theBus);
    public void updateBus(Bus theBus);
    public void  getBusById(int id);
    public void deleteBus(int id);

    
}
