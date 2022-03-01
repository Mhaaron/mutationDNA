package com.dna.springboot.mutationDNA.web.controller;

import com.dna.springboot.mutationDNA.domain.Dna;
import com.dna.springboot.mutationDNA.domain.service.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class dna {
    @Autowired
    private DnaService dnaService;

    @GetMapping("/all")
    public List<Dna> getAll() {
        return dnaService.getAll();
    }

    @PostMapping("/mutation")
    public Dna save(@RequestBody Dna dna) {
        return dnaService.save(dna);
    }
}
