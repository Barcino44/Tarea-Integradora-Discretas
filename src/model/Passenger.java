package model;

import Exception.RowNoExistInPlaneException;

public class Passenger{
    private String id;
    private String name;
    private int miles;
    private int age;
    private int entryOrder;
    private int row;
    private Plane plane;
    public Passenger(String id, String name, int miles, int age, Plane plane, int row) throws RowNoExistInPlaneException {
        this.id = id;
        this.name = name;
        this.miles = miles;
        this.age = age;
        this.plane=plane;
        this.row= row;
        if(this.row> plane.getRows()){
            throw new RowNoExistInPlaneException();
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEntryOrder() {
        return entryOrder;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setEntryOrder(int entryOrder) {
        this.entryOrder = entryOrder;
    }
    public boolean isFirstClass(){
        if(this.row<=plane.getFirstClassRows()){
            return true;
        }
        else{
            return false;
        }
    }
    public double priortyFirstClass(){
        int totalPriorty=plane.getRows()+1;
            if (miles>800){
                totalPriorty+=1;
            }
            if (age>50){
                totalPriorty+=2;
            }
        return totalPriorty;
    }
    public double priortyStandarClass(){
        return this.row;
    }
    public double priorty(){                                                   //Numero de sillas
        double entryOrder=Math.abs((((double) this.entryOrder / 1000.0)-1));
        if(isFirstClass()) {
            return priortyFirstClass()+entryOrder;
        }
        else{
            return priortyStandarClass()+entryOrder;
        }
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", miles=" + miles +
                ", age=" + age +
                ", entryOrder=" + entryOrder +
                ", priorty="+ Math.round(priorty())+
                ", row=" + row+
                '}';
    }
}
