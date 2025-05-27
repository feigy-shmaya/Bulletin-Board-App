package com.example.demo.Service;
import com.example.demo.Entity.AdvDto;
import com.example.demo.Entity.Advertisement;

public interface IAdverService {
    public Advertisement add(AdvDto a);
    public boolean update(int id);
    public Advertisement get(int place);
}
