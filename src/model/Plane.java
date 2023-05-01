package model;

public class Plane{
    private String name;
    private int rows;
    private int seatsByRows;
    private int firstClassRows;

    public Plane(String name, int rows, int seatsByRows, int firstClassRows) {
        this.name = name;
        this.rows = rows;
        this.seatsByRows = seatsByRows;
        this.firstClassRows = firstClassRows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsByRows() {
        return seatsByRows;
    }

    public void setseatsByRows(int seatsByRows) {
        this.seatsByRows = seatsByRows;
    }

    public int getFirstClassRows() {
        return firstClassRows;
    }

    public void setFirstClassRows(int firstClassRows) {
        this.firstClassRows = firstClassRows;
    }
}
