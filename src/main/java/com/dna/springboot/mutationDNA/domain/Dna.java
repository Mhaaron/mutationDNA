package com.dna.springboot.mutationDNA.domain;

public class Dna {
    private int dnaId;
    private String data[];
    private boolean mutation;

    public Dna(int dnaId, String[] data, boolean mutation) {
        this.dnaId = dnaId;
        this.data = data;
        this.mutation = mutation;
    }

    public int getDnaId() {
        return dnaId;
    }

    public void setDnaId(int dnaId) {
        this.dnaId = dnaId;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public boolean isMutation() {
        return mutation;
    }

    public void setMutation(boolean mutation) {
        this.mutation = mutation;
    }
}
