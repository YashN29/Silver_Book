package com.example.studypartner;

public class Doubts_Model {

    int id;
    String Doubts;

    public Doubts_Model(int id, String doubts) {
        this.id = id;
        Doubts = doubts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoubts() {
        return Doubts;
    }

    public void setDoubts(String doubts) {
        Doubts = doubts;
    }
}
