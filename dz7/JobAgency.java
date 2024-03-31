package dz7;

import java.util.ArrayList;
import java.util.Collection;

public class JobAgency implements Publisher {

    private Collection<Observer> observers = new ArrayList<>();

    // public void sendOffer(String companyName, int salary){
    //     for (Observer observer : observers){
    //         observer.receiveOffer(companyName, salary);
    //     }
    // }

    @Override
    public void sendOffer(Vacancy vacancy) {
        for (Observer observer : observers){
            observer.receiveOffer(vacancy);
        }
        System.out.println();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void showJobSeekers(){
        System.out.println("Список всех зарегистрированный в агенстве соискателей:");
        for (Observer observer : observers) {
            System.out.print(observer);
        }
        System.out.println("_________");
    }


}
