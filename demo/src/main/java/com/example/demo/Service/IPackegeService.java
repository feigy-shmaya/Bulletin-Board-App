package com.example.demo.Service;
import com.example.demo.Entity.Package1;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface IPackegeService {
    public ArrayList<Package1> get();
    public void add(Package1 p);
    public Package1 getById(int id);
}
