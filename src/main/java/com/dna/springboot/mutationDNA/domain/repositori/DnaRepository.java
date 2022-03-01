package com.dna.springboot.mutationDNA.domain.repositori;

import com.dna.springboot.mutationDNA.domain.Dna;

import java.util.List;
import java.util.Optional;

public interface DnaRepository {
    List<Dna> getAll();
    Dna save(Dna note);
}
