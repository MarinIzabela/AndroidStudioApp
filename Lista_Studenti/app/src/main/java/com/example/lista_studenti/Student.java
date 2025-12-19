package com.example.lista_studenti;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student implements Serializable {
    private String nume;
    private Date dataNasterii;
    private float medie;
    private String facultate; //CSIE, REI, FABIZ, MRK
    private String formaInvatamant; //IF,

    public Student(String nume, Date dataNasterii, float medie, String facultate, String formaInvatamant) {
        this.nume = nume;
        this.dataNasterii = dataNasterii;
        this.medie = medie;
        this.facultate = facultate;
        this.formaInvatamant = formaInvatamant;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public float getMedie() {
        return medie;
    }

    public void setMedie(float medie) {
        this.medie = medie;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public String getFormaInvatamant() {
        return formaInvatamant;
    }

    public void setFormaInvatamant(String formaInvatamant) {
        this.formaInvatamant = formaInvatamant;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        return nume + " | " + sdf.format(dataNasterii) + " | medie=" + medie + " | " + facultate + " | " + formaInvatamant;
    }
}
