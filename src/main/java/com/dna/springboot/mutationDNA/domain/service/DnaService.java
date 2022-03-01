package com.dna.springboot.mutationDNA.domain.service;

import com.dna.springboot.mutationDNA.domain.Dna;
import com.dna.springboot.mutationDNA.domain.repositori.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnaService {
    @Autowired
    private DnaRepository dnaRepository;

    public List<Dna> getAll() {
        return dnaRepository.getAll();
    }

    public Dna save(Dna dna) {
        if (hasMutation(dna.getData())) {
            dna.setMutation(true);
        }

        return dna;
    }

    public boolean hasMutation(String [] dna) {
        boolean mutationFlag = false;
        String baseVertical = "";
        String baseOblique = "";

        int sequence = 0;
        int cntV = 0;

        for (String i : dna) {
            //verificación base horizontal
            if (verifySequence(i)) {
                sequence++;
            }

            baseVertical = "" + dna[0].charAt(cntV) + dna[1].charAt(cntV) + dna[2].charAt(cntV) +
                    dna[3].charAt(cntV) + dna[4].charAt(cntV) + dna[5].charAt(cntV);

            if (verifySequence(baseVertical)) {
                sequence++;
            }

            if (sequence > 1) {
                mutationFlag = true;
                break;
            }

            cntV++;
        }

        if (mutationFlag != true) {
            baseOblique = "" + dna[0].charAt(0) + dna[1].charAt(1) + dna[2].charAt(2) +
                    dna[3].charAt(3) + dna[4].charAt(4) + dna[5].charAt(5);

            if (verifySequence(baseOblique)) {
                sequence++;
            }

            baseOblique = "" + dna[5].charAt(0) + dna[4].charAt(1) + dna[3].charAt(2) +
                    dna[3].charAt(3) + dna[2].charAt(4) + dna[1].charAt(5);

            if (verifySequence(baseOblique)) {
                sequence++;
            }

            if (sequence > 1) {
                mutationFlag = true;
            }
        }

        return mutationFlag;
    }

    public static boolean verifySequence(String str) {
        String baseA = "AAAA";
        String baseT = "TTTT";
        String baseC = "CCCC";
        String baseG = "GGGG";

        if (str.contains(baseA) || str.contains(baseT) || str.contains(baseC) || str.contains(baseG)) {
            return true;
        } else {
            return false;
        }
    }
}
