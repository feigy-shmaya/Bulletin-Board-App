package com.example.demo.Controller;

import com.example.demo.Entity.Client;
import com.example.demo.Entity.Package1;
import com.example.demo.Entity.PackageDto;
import com.example.demo.Entity.PackageDtoReturn;
import com.example.demo.Service.IClientServic;
import com.example.demo.Service.IPackegeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/board/packeg")
public class PackegController {
    private IPackegeService packegeService;

    @Autowired
    public PackegController(IPackegeService packegeService) {
        this.packegeService = packegeService;
    }

    @PostMapping("/")
    public void add(@RequestBody PackageDto c) {
        ModelMapper modelMapper = new ModelMapper();
        Package1 p = modelMapper.map(c, Package1.class);
        packegeService.add(p);
    }
    @GetMapping("/")
    public List<PackageDtoReturn> get() {
        List<Package1> packages = packegeService.get();  // מביא את כל החבילות
        List<PackageDtoReturn> summaries = new ArrayList<>();

        // עבור כל חבילה, צור את ה-DTO המתאים והוסף לרשימה
        for (Package1 pkg : packages) {
            PackageDtoReturn summary = new PackageDtoReturn(pkg.getEnteries(), pkg.getDays(),pkg.getId());
            summaries.add(summary);
        }

        return summaries;  // מחזיר את רשימת ה-DTOs
    }

}
