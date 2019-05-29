public class Proz {




    void SumTCost(Car [] cars){
        double Sum=0;
        for(int i=0;i<cars.length;i++){
            Sum+=cars[i].getPrice();
        }
        System.out.println("Стоимость таксопарка: "+Sum);
    }

    void Sort (Car [] cars){
        boolean isSorted = false;
        double temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < cars.length-1; i++) {
                if(cars[i].getFuelCons() > cars[i+1].getFuelCons()){
                    isSorted = false;

                    temp = cars[i].getFuelCons();
                    cars[i].setFuelCons(cars[i+1].getFuelCons());
                    cars[i+1].setFuelCons(temp);
                }
            }
        }
    }

    void speedRange (Car [] cars, double maxSpeed, double minSpeed){
        Car [] speedCarArr = new Car[0];
        for(int i=0;i<cars.length;i++) {
            if (minSpeed < cars[i].getMaxSpeed() && cars[i].getMaxSpeed() < maxSpeed) {

                if (speedCarArr.length == 0) {
                    speedCarArr = new Car[1];
                    speedCarArr[0] = cars[i];
                }
                else{
                    Car [] temp=new Car[speedCarArr.length];
                    temp=speedCarArr;
                    speedCarArr=new Car[speedCarArr.length+1];
                    for (int k=0;k<temp.length;k++){
                        speedCarArr[k]=temp[k];
                    }
                    speedCarArr[speedCarArr.length-1]=cars[i];
                }
            }
        }
        for (int n=0;n<speedCarArr.length;n++){
            System.out.println(speedCarArr[n]);
        }

    }

}
