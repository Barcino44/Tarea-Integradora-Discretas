package model;

public class Plane{
    private String name;
    private int rows;
    private int chairsByRows;
    private int firstClassRows;

    public Plane(String name, int rows, int chairsByRows, int firstClassRows) {
        this.name = name;
        this.rows = rows;
        this.chairsByRows = chairsByRows;
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

    public int getChairsByRows() {
        return chairsByRows;
    }

    public void setChairsByRows(int chairsByRows) {
        this.chairsByRows = chairsByRows;
    }

    public int getFirstClassRows() {
        return firstClassRows;
    }

    public void setFirstClassRows(int firstClassRows) {
        this.firstClassRows = firstClassRows;
    }
}
