package entitites;

import java.util.Date;

public class Appointment {

    private int id;
    private Date dato;
    private int varighed;
    private String type;
    private int personID;
    private int sygehusID;

    public Appointment(){}

    public Appointment(int id, Date dato, int varighed, String type, int personID, int sygehusID) {
        this.id = id;
        this.dato = dato;
        this.varighed = varighed;
        this.type = type;
        this.personID = personID;
        this.sygehusID = sygehusID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public int getVarighed() {
        return varighed;
    }

    public void setVarighed(int varighed) {
        this.varighed = varighed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getSygehusID() {
        return sygehusID;
    }

    public void setSygehusID(int sygehusID) {
        this.sygehusID = sygehusID;
    }
}
