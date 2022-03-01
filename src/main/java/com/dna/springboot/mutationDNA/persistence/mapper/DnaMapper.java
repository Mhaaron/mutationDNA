package com.dna.springboot.mutationDNA.persistence.mapper;

import com.dna.springboot.mutationDNA.domain.Dna;
import com.dna.springboot.mutationDNA.persistence.entity.Adn;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DnaMapper {
    @Mappings({
            @Mapping(source = "adnId", target = "dnaId"),
            @Mapping(source = "datos", target = "data"),
            @Mapping(source = "mutacion", target = "mutation")
    })
    Dna toDna(Adn adn);
    List<Dna> toDna(List<Adn> adn);

    @InheritInverseConfiguration
    Adn toAdn(Dna dna);
}
