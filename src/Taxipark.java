import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Car {

   private int idn;
   private double price;
   private double maxSpeed;
   private double fuelCons;     //kg/h

    Car (int idn, double price, double maxSpeed, double fuelCons){
        this.idn=idn;
        this.price=price;
        this.maxSpeed=maxSpeed;
        this.fuelCons=fuelCons;
    }

    public int getIdn() {
        return idn;
    }

    public double getPrice() {
        return price;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelCons() {
        return fuelCons;
    }

    public void setFuelCons(double fuelCons) {
        this.fuelCons = fuelCons;
    }
}

class PassengerC extends Car {

    private int seatsNum;
    PassengerC(int idn, double price, double maxSpeed, double fuelCons, int seatsNum){
        super(idn, price, maxSpeed, fuelCons);
        this.seatsNum=seatsNum;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public String toString(){
        return String.format(getIdn() +" "+ getPrice() +" "+ getMaxSpeed()+" "+ getFuelCons()+" "+getSeatsNum());
    }
}

class Truck extends Car{

    private double loadCapacity;
    Truck(int idn, double price, double maxSpeed, double fuelCons, double loadCapacity){
        super(idn, price, maxSpeed, fuelCons);
        this.loadCapacity=loadCapacity;
    }
}

class Tank extends Truck{

    private double tankVol;
    Tank (int idn, double price, double maxSpeed, double fuelCons, double loadCapacity, double tankVol){
        super(idn, price, maxSpeed, fuelCons,loadCapacity);
        this.tankVol=tankVol;
    }

    public double getTankVol() {
        return tankVol;
    }
    public String toString(){
        return String.format(getIdn() +" "+ getPrice() +" "+ getMaxSpeed()+" "+ getFuelCons()+" "+getTankVol());
    }
}

class RefrigeratorC extends Truck{

    private double tempInLoadComp;
    RefrigeratorC(int idn, double price, double maxSpeed, double fuelCons, double loadCapacity, double tempInLoadComp){
        super(idn, price, maxSpeed, fuelCons,loadCapacity);
        this.tempInLoadComp=tempInLoadComp;
    }

    public double getTempInLoadComp() {
        return tempInLoadComp;
    }
    public String toString(){
        return String.format(getIdn() +" "+ getPrice() +" "+ getMaxSpeed()+" "+ getFuelCons()+" "+getTempInLoadComp());
    }
}

class SportC extends Car{

    private double weight;
    SportC(int idn, double price, double maxSpeed, double fuelCons, double weight){
        super(idn, price, maxSpeed, fuelCons);
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }
    public String toString(){
        return String.format(getIdn() +" "+ getPrice() +" "+ getMaxSpeed()+" "+ getFuelCons()+" "+getWeight());
    }
}



public class Taxipark {
    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Proz proz=new Proz();
        int n=10;

        Car[] cars = new Car [n];

        cars[1] = new SportC(1, 2000000,300, 100, 728);
        cars[2] = new PassengerC(2, 68000, 250, 11.4, 5);
        cars[3] = new PassengerC(3, 20100, 210, 6.4, 5);
        cars[4] = new Tank(4, 60000, 180, 16.7, 15000, 100);
        cars[5] = new RefrigeratorC(5, 96000, 200, 18.9, 11000, 2);
        cars[6] = new SportC(6, 390000, 410, 20.8, 1400);
        cars[7] = new Tank(7, 35000, 16000, 11.5, 13000, 55);
        cars[8] = new PassengerC(8, 80000, 290, 9.3, 7);
        cars[9] = new PassengerC(9, 16000, 270, 7.2, 5);
        cars[0] = new SportC(10, 90000, 350, 12.1, 1600);

        proz.SumTCost(cars);
        proz.Sort(cars);
        System.out.print("Мин скорость ");
        int minSpeed = Integer.parseInt(stdin.readLine());
        System.out.print("Макс скорость ");
        int maxSpeed = Integer.parseInt(stdin.readLine());
        proz.speedRange(cars, maxSpeed, minSpeed);
        }
}
