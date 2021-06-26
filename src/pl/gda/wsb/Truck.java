package pl.gda.wsb;

public class Truck extends Vehicle {
    String capacity;

    public Truck(String registration, String vinNumber, String kolor, Double prize, Double fuelConsumption, Double fuelTank, Double mileage,Double maxFuel, String capacity) {
        super(registration, vinNumber, kolor, prize, fuelConsumption, fuelTank, mileage,maxFuel);
        this.capacity = capacity;
    }

    @Override
    public void drive(Double kilometers) {
        if (checkToDrive() < kilometers) {
            System.out.println("brakuje wachy");
        } else {
            this.mileage = this.mileage + kilometers;
            this.fuelTank = this.fuelTank - (kilometers / 100) * this.fuelConsumption;
            System.out.println("ciężarówa pojechała");
            System.out.println("Pozostało Ci " + this.fuelTank + "l");
            System.out.println("na licznku masz teraz " + this.mileage);
        }

    }


    @Override
    public void refuel(double liters) {
        if(this.fuelTank + liters > this.maxFuel){
            System.out.println("tyle się nie dało, zatankowałeś do pełna");
            this.fuelTank = this.maxFuel;
        }else {
            this.fuelTank = this.fuelTank + liters;
            System.out.println("pojazd zatankowany, masz teraz " + this.fuelTank);
        }
        System.out.println("masz teraz "+ this.fuelTank +" litrów w baku");
    }


    @Override
    public Double checkToDrive() {
        Double a;
        a = (this.fuelTank / this.fuelConsumption) * 100;
        System.out.println("ciężarówka na zbiorniku przejedzie " + a);
        return a;
    }
}
