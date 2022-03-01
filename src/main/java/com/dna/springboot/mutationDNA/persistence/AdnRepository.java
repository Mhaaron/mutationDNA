package com.dna.springboot.mutationDNA.persistence;

import com.dna.springboot.mutationDNA.domain.Dna;
import com.dna.springboot.mutationDNA.domain.repositori.DnaRepository;
import com.dna.springboot.mutationDNA.persistence.crud.AdnCrudRepository;
import com.dna.springboot.mutationDNA.persistence.entity.Adn;
import com.dna.springboot.mutationDNA.persistence.mapper.DnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdnRepository implements DnaRepository {
    @Autowired
    private AdnCrudRepository adnCrudRepository;

    @Autowired
    private DnaMapper mapper;

    @Override
    public List<Dna> getAll() {
        List<Adn> adn = (List<Adn>) adnCrudRepository.findAll();
        return mapper.toDna(adn);
    }

    @Override
    public Dna save(Dna dna) {
        Adn adn = mapper.toAdn(dna);
        return mapper.toDna(adnCrudRepository.save(adn));
    }
}
