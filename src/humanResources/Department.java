package humanResources;

public class Department {
    private String maBP;
    private String tenBP;
    private  int numberEmployee;

    public Department() {
    }

    public Department(String maBP, String tenBP, int numberEmployee) {
        this.maBP = maBP;
        this.tenBP = tenBP;
        this.numberEmployee = numberEmployee;
    }


    public void tostring(){
        System.out.printf("|%-10s|%-20s|%-30s%n",maBP,tenBP,numberEmployee);
    }

    public String getMaBP() {
        return maBP;
    }

    public void setMaBP(String maBP) {
        this.maBP = maBP;
    }

    public String getTenBP() {
        return tenBP;
    }

    public void setTenBP(String tenBP) {
        this.tenBP = tenBP;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }
}
