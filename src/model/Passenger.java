package model;

import Exception.RowNoExistInPlaneException;
import Exception.SeatNotExistInPlaneException;

public class Passenger {
    private String id;
    private String name;
    private int miles;
    private int age;
    private int entryOrder;
    private int row;
    private int seat;
    private Plane plane;

    public Passenger(String id, String name, int miles, int age, Plane plane, int row, int seat) throws RowNoExistInPlaneException, SeatNotExistInPlaneException {
        this.id = id;
        this.name = name;
        this.miles = miles;
        this.age = age;
        this.plane = plane;
        this.row = row;
        if (this.row > plane.getRows()) {
            throw new RowNoExistInPlaneException();
        }
        this.seat = seat;
        if (this.seat > plane.getSeatsByRows()) {
            throw new SeatNotExistInPlaneException();
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

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setEntryOrder(int entryOrder) {
        this.entryOrder = entryOrder;
    }

    public boolean isFirstClass() {
        if (this.row <= plane.getFirstClassRows()) {
            return true;
        } else {
            return false;
        }
    }

    public double priortyFirstClass() {
        int totalPriorty = plane.getRows() + 1;
        if (miles > 800) {
            totalPriorty += 1;
        }
        if (age > 50) {
            totalPriorty += 2;
        }
        return totalPriorty;
    }

    public double priortyStandarClass() {
        return this.row;
    }

    public double priortyEntry() {
        double entryOrder = Math.abs((((double) this.entryOrder / 100) - 1));
        if (isFirstClass()) {
            return priortyFirstClass() + entryOrder;
        } else {
            return priortyStandarClass() + entryOrder;
        }
    }

    public double priorityOut() {
        double totalPriority = Math.abs(this.seat - Math.ceil(((double) plane.getSeatsByRows() / 2)));
        if (plane.getSeatsByRows() % 2 == 0) {
            if (this.seat > plane.getSeatsByRows() / 2) {
                totalPriority = totalPriority - 1;
            }
        }
        return this.row - Math.abs(((totalPriority / 100) - 1) / 10)- Math.abs((((double) this.entryOrder / 100) - 1) / 1000);
        //filas                    //silla                        //Orden de llegada
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", miles=" + miles +
                ", age=" + age +
                ", entryOrder=" + entryOrder +
                ", row=" + row +
                ", seat=" + seat +
                ", priorityIn=" + Math.round(priortyEntry()) +
                ", priorityOut=" +Math.round(priorityOut()) +
                '}';
    }
}