package humanResources;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class Employee extends Staff {
    private double timeOver;
    private int id;
    private  static  int curentID = 1;
    public Employee() {
        this.id = curentID++;
    }

    public Employee(String name, int age, double coefficientsSalary, Date date, String department, int dayOffNumber, double timeOver) {
        super( name, age, coefficientsSalary, date, department, dayOffNumber);
        this.timeOver = timeOver;
        this.id = curentID++;

    }
    // hàm nhập thông tin nhân viên
    @Override
    public void input(){
        super.input();
        System.out.println("nhập số giờ làm thêm:");
        timeOver = sc.nextDouble();
    }
    // hàm trả về mã nhân viên theo dạng E001
    @Override
     public String manv(){
        String maNV = "" + this.id;
        int lenNum = 3;
        int number0 = 3 - maNV.length();
        for (int i = 0; i < number0; i++) {
            maNV = "0" + maNV ;
        }
        maNV = "E" + maNV;
        return maNV;
    }
    // hàm hiện thị thông tin nhân viên
    @Override
    public void displayInformation() {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

        System.out.printf("|%-12s|%-20s|%-10s|%-20s|%-20s|%-20d|%-20s|%-20s|%-20s|%n",manv(),getName(),getAge(),getCoefficientsSalary()
        ,df.format(getDate()),getDayOffNumber(),getDepartment(),timeOver,calculateSalary());
    }
    // hàm tính lương nhân viên
    @Override
    public int calculateSalary() {
        int salary = (int) (this.getCoefficientsSalary() * 3000000 + this.timeOver * 200);
        return salary;
    }

    public double getTimeOver() {
        return timeOver;
    }

    public void setTimeOver(double timeOver) {
        this.timeOver = timeOver;
    }

}
