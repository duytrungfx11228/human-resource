package humanResources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public abstract class Staff implements ICalculator{
    Scanner sc;

    private  String name;
    private int age;
    private double coefficientsSalary;
    private Date date;
    private String department;
    private int dayOffNumber;

    public Staff() {
    }

    public Staff(String name, int age, double coefficientsSalary, Date date, String department, int dayOffNumber) {
        this.name = name;
        this.age = age;
        this.coefficientsSalary = coefficientsSalary;
        this.date = date;
        this.department = department;
        this.dayOffNumber = dayOffNumber;

    }
    // tạo mã nhân viên
    public abstract String manv();
    // nhập dữ liệu nhân viên
    public void input(){
        sc = new Scanner(System.in);
        System.out.println("nhập tên nhân viên: ");
         name = sc.nextLine();
        System.out.println("nhập tuổi nhân viên: ");
        age = sc.nextInt();
        System.out.println("nhập hs lương nhân viên: ");
        coefficientsSalary = sc.nextDouble();
        // nhập ngày tháng
        sc.nextLine();
        System.out.println("nhập ngay vao lam (dd/mm/yyyy): ");
        String da = sc.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        date = new Date();
        try {
            date = df.parse(da);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.print("1. HC - Hành chính nhân sự\n"+
                         "2. IT - Lập trình viên\n"+
                         "3. MK - Marketing\n"
                );
        System.out.println("nhập bộ phân: ");
        int a = sc.nextInt();
        if(a==1){
            department = "Hành chính nhân sự";
        } else if (a==2) {
            department = "Lập trình viên";
        } else {
            department = "Marketing";
        }
        System.out.println("nhập số ngày nghỉ: ");
        dayOffNumber = sc.nextInt();
    }


    public abstract void displayInformation();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDayOffNumber() {
        return dayOffNumber;
    }

    public void setDayOffNumber(int dayOffNumber) {
        this.dayOffNumber = dayOffNumber;
    }

}
