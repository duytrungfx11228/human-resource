package humanResources;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager extends Staff implements ICalculator{
    private String title;
    private static int mid = 1;
    private int id;
    public Manager() {
        this.id = mid++;
    }

    public Manager(String name, int age, double coefficientsSalary, Date date, String department, int dayOffNumber, String title) {
        super(name, age, coefficientsSalary, date, department, dayOffNumber);
        this.title = title;
        this.id = mid++;
    }
    // hàm tạo mã nhân viên theo dang M001
    @Override
    public String manv(){
        String maNV = "" + this.id;
        int lenNum = 3;
        int number0 = 3 - maNV.length();
        for (int i = 0; i < number0; i++) {
            maNV = "0" + maNV ;
        }
        maNV = "M" + maNV;
        return maNV;
    }
    // nhập thông tin cho nhân viên
    @Override
    public void input(){
        super.input();
        System.out.print("chức danh:\n"+
                "1. Business Leader\n"+
                "2. Project Leader\n"+
                "3. Technical Leader\n");
        System.out.print("chon chuc danh: ");
        int i = sc.nextInt();
        if(i==1){
            title = "Business Leader";
        } else if (i==2) {
            title = "Project Leader";
        } else {
            title = "Technical Leader";
        }
    }
    // tính lương nhân viên
    @Override
    public int calculateSalary() {
        if(title.equals("Business Leader")){
            return (int) (8000000 + getCoefficientsSalary()*500000);
        } else if (title.equals("Prọect Leader")) {
            return (int) (5000000 + getCoefficientsSalary()*500000);
        }
        return (int) (3000000 + getCoefficientsSalary()*500000);
    }
    // hiển thị nhân viên
    @Override
    public void displayInformation() {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        System.out.printf("|%-12s|%-20s|%-10d|%-20s|%-20s|%-20d|%-20s|%-20s|%-20s|%n",manv(),getName(),getAge(),getCoefficientsSalary()
                ,df.format(getDate()),getDayOffNumber(),getDepartment(),title,calculateSalary());
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
