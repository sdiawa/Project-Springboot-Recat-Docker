package net.javaguides.springbootrestapi.bean;

public  class Student {

private  int id;
private  String firstName;
private String lastName;
private String adresse;
    public Student(int id, String firstName, String lastName, String adresse) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}