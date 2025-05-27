package com.example.demo.Service;
import com.example.demo.Dao.jpaPackage1;
import com.example.demo.Entity.Package1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class PackegeService implements IPackegeService{
    jpaPackage1 _jpa;
    @Autowired
    public PackegeService(jpaPackage1 jpa){
        this._jpa=jpa;
    }
    public void add(Package1 p) {
        System.out.println("i come");
        _jpa.save(p);
    }
    public ArrayList<Package1> get() {

        return (ArrayList<Package1>)_jpa.findAll();
    }
    public Package1 getById(int id){
        return _jpa.findById(id).orElse(null);
    }
}
