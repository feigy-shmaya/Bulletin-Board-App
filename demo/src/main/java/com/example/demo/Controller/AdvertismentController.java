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
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(modelMapper.map(advertisement, AdvDto.class));
        }
    }
}
