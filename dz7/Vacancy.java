package dz7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Vacancy {

    private int salary;
    private String profession;
    private String companyName;
    private ArrayList<Observer>candidates = new ArrayList<>();
    private String status;

    public Vacancy(String companyName, int salary, String profession){
        this.companyName = companyName;
        this.salary = salary;
        this.profession = profession;
        this.status = "открытая";
    }

    public void addCandidates(Observer candidate) {
        candidates.add(candidate);
    }

    public ArrayList<Observer> getCandidates() {
        sortCandidates();
        return new ArrayList<Observer>(candidates);
    }


    public ArrayList<Observer> getOldCandidates() {
        return this.candidates;
    }

    public String getProfession() {
        return profession;
    }

    public int getSalary() {
        return salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setClose() {
        this.status = "закрыта";
    }

    // public String getQualification() {
    //     return qualification;
    // }

    private void sortCandidates(){
        Comparator<Observer> comparator = Comparator.comparing(obj -> obj.getQualification());
        candidates.sort(comparator.reversed());
    }

    public String toString() {
        return String.format("Вакансия - %s - %s; должность - %s ; зарплата: %d руб." , this.companyName, this.status, this.profession, this.salary);
     }

}
