//package com.example.demo.Controller;
//
//import com.example.demo.Entity.AdvDto;
//import com.example.demo.Entity.Advertisement;
//import com.example.demo.Service.IAdverService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/api/board/Advertisment")
//public class AdvertismentController {
//    private IAdverService adverService;
//    @Autowired
//    public AdvertismentController(IAdverService adverService) {
//        this.adverService = adverService;
//    }
//    @PostMapping ("/")
//    public void add(@RequestBody AdvDto adm) {
//        ModelMapper m=new ModelMapper();
//        Advertisement advertising = m.map(adm, Advertisement. class );
//        adverService.add(advertising);
//    }
//    @PutMapping ("/{id}")
//    public void put(@PathVariable int id){
//         adverService.update(id);
//    }
//    @GetMapping("/{place}")
//    public ResponseEntity<AdvDto> get(@PathVariable int place){
//        ModelMapper m=new ModelMapper();
//        Advertisement advertisement = adverService.get(place);
//        System.out.println(advertisement);
//        if (advertisement == null) {
//            return ResponseEntity.noContent().build(); // מחזיר סטטוס 204
//        }
//        else{
//            return ResponseEntity.ok(m.map(advertisement,AdvDto.class));
//        }
//    }
//}


package com.example.demo.Controller;

import com.example.demo.Entity.AdvDto;
import com.example.demo.Entity.Advertisement;
import com.example.demo.Service.IAdverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/board/Advertisment")
public class AdvertismentController {

    private final IAdverService adverService;

    @Autowired
    public AdvertismentController(IAdverService adverService) {
        this.adverService = adverService;
    }

    @PostMapping("/")
    public void add(@RequestBody AdvDto adm) {
//        ModelMapper modelMapper = new ModelMapper();
//        Advertisement advertisement = modelMapper.map(adm, Advertisement.class);
        System.out.println("i in post adv");
        adverService.add(adm);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id) {
        adverService.update(id);
    }

    @GetMapping("/{place}")
    public ResponseEntity<AdvDto> get(@PathVariable int place) {
        ModelMapper modelMapper = new ModelMapper();
        Advertisement advertisement = adverService.get(place);

        if (advertisement == null) {
            return ResponseEntity.noContent().build(); // מחזיר סטטוס 204 אם לא נמצא
        } else {
            return ResponseEntity.ok(modelMapper.map(advertisement, AdvDto.class));
        }
    }
}
