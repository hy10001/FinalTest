package cn.lanqiao.finalTest.entity.dto;


import java.time.LocalDate;


public class FinancialBoDTO   {
    private LocalDate currentDate;
    private String type;
    private int currentNum;
    private int size;

    @Override
    public String toString() {
        return "FinancialBoDTO{" +
               "currentDate=" + currentDate +
               ", type=" + type +
               ", currentNum=" + currentNum +
               ", size=" + size +
               '}';
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
