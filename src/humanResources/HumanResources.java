import humanResources.Department;
import humanResources.Employee;
import humanResources.Manager;
import humanResources.Staff;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HumanResources {
    List<Staff> staff = new ArrayList<>();
    List<Department> departments = new ArrayList<>();
    SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
     Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        HumanResources humanResources = new HumanResources();
        humanResources.creatNv();
        boolean bl = true;
        do {
            System.out.print("-------Menu----------\n"+
                    "1. Hiển thị danh sách nhân viên hiện có\n"+
                    "2. Hiển thị các bộ phận trong công ty\n"+
                    "3. Hiển thị nhân viên theo từng bộ phân\n"+
                    "4. Thêm nhân viên mới\n"+
                    "5. Tìm kiếm nhân viên theo tên hoặc mã nhân viên\n"+
                    "6. Hiển thị bảng lương nhân viên toàn công ty\n"+
                    "7. Hiên thị bảng lương của nhân viên theo thứ tự tăng dần\n"+
                    "0. Thoát chương trình\n"
                    );
            System.out.println("lựa chọn của ban: ");
            int choose = sc.nextInt();
            if(choose==1){
                //1. Hiển thị danh sách nhân viên hiện có
                humanResources.output();
            } else if (choose==2) {
                //2. Hiển thị các bộ phận trong công ty
                humanResources.displayBp();
            } else if (choose==3) {
                humanResources.danhSachNVtheoBP();
                //3. Hiển thị nhân viên theo từng bộ phân
            } else if (choose==4) {
                //4. Thêm nhân viên mới
                System.out.print("1. Nhân viên thường\n"+
                                "2. Nhân viên Quản lý\n"
                        );
                System.out.println("chọn cấp nhân viên cần thêm:");
                int cap = sc.nextInt();
                humanResources.addEmp(cap);

            } else if (choose==5) {
                //5. Tìm kiếm nhân viên theo tên hoặc mã nhân viên
                humanResources.searchByNameORmaNV();
            } else if (choose==6) {
                //6. Hiển thị bảng lương nhân viên toàn công ty
                humanResources.output();
            } else if (choose==7) {
                //7. Hiên thị bảng lương của nhân viên theo thứ tự tăng dần
                humanResources.sortNV();
            } else if (choose==0){
                //0. Thoát chương trình
                System.out.println("Goodbye!!!");
                bl = false;
            } else {
                System.out.println("bạn chọn sai chức năng hãy chọn lại");
            }
        } while (bl);

    }
    // khơi tạo danh sách bộ phận ban đầu
    public void creatNv() throws ParseException {

        Staff staff11 = new Employee("ng van a",24,3.4,df.parse("23/4/2013"),
                "Hành chính nhân sự",3,20);
        staff.add(staff11);
        Staff staff12 = new Employee("duong thi b",34,3.4,df.parse("23/4/2013"),
                "Lập trình viên",3,30);
        staff.add(staff12);
        Staff staff13 = new Manager("tr dinh c",34,3.4,df.parse("23/4/2013"),
                "Lập trình viên",3,"Technical Leader");
        staff.add(staff13);
        Department dp1 = new Department("HC","Hành chính nhân sự",1);
        Department dp2 = new Department("IT","Lập trình viên",2);
        Department dp3 = new Department("MK","Marketing",0);

        departments.add(dp1);
        departments.add(dp2);
        departments.add(dp3);
    }

    // hàm thêm nhân viên vào danh sách
    public void addEmp(int a){
        Staff epl;
         if(a == 1){
             // nhập thông tin nhân viên thường
             epl = new Employee();
             epl.input();
             staff.add(epl);// thêm vào danh sách
         } else {
             // nhập nhân viên quản ly
             epl = new Manager();
             epl.input();
             staff.add(epl);// thêm vào danh sách
         }
         // kiểm tra nhân viên thêm vào danh sách bộ phận
        for (Department dpt: departments) {
            if (epl.getDepartment().equals(dpt.getTenBP())){
                int count = dpt.getNumberEmployee() + 1;
                dpt.setNumberEmployee(count);
            }
        }
    }
    // hiện thị danh sách nhân viên
    public void output(){
        System.out.printf("|%-10s|%-20s|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%n",
                "Mã nhân viên","Tên nhân viên","Tuổi","HS Lương","Ngày vào làm","Ngày nghỉ phép","Bộ phân","Giờ làm thêm/chức vụ","Lương");
        System.out.println("---------------------------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------");
        for (Staff item: staff) {
            item.displayInformation();
        }
    }
    // hiện thị bộ phận trong công ty.
    public void displayBp(){
        System.out.printf("|%-10s|%-20s|%-30s%n","MA BP","Ten Bp","So nguoi hien co");
        for (Department dp: departments) {
            dp.tostring();
        }
    }
    // hiện thị danh sách nhân viên theo bộ phận
    public void danhSachNVtheoBP(){

        // hiện thị danh sách theo bộ phận hành chính nhân sự
        System.out.println("Hành chính nhân sự");
        System.out.println("------------------");
        System.out.printf("|%-10s|%-20s|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%n",
                "Mã nhân viên","Tên nhân viên","Tuổi","HS Lương","Ngày vào làm","Ngày nghỉ phép","Bộ phân","Giờ làm thêm/chức vụ","Lương");
        // duyệt qua từng phần tử của list và kiểm tra bộ phận của nhân viên
        for (Staff item: staff) {
            if(item.getDepartment().equals("Hành chính nhân sự")){
                item.displayInformation();
            }
        }
        //hiện thị danh sách bộ phận Lập trình viên
        System.out.println("Lập trình viên");
        System.out.println("------------------");
        System.out.printf("|%-10s|%-20s|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%n",
                "Mã nhân viên","Tên nhân viên","Tuổi","HS Lương","Ngày vào làm","Ngày nghỉ phép","Bộ phân","Giờ làm thêm/chức vụ","Lương");
        // duyệt qua từng phần tử của list và kiểm tra bộ phận của nhân viên
        for (Staff item: staff) {
            if (item.getDepartment().equals("Lập trình viên")){
                item.displayInformation();
            }
        }
        // hiện thị danh sách bộ phận Marketing
        System.out.println("Marketing");
        System.out.println("------------------");
        System.out.printf("|%-10s|%-20s|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%n",
                "Mã nhân viên","Tên nhân viên","Tuổi","HS Lương","Ngày vào làm","Ngày nghỉ phép","Bộ phân","Giờ làm thêm/chức vụ","Lương");
        // duyệt qua từng phần tử của list và kiểm tra bộ phận của nhân viên
        for (Staff item: staff) {
            if (item.getDepartment().equals("Marketing")){
                item.displayInformation();
            }
        }
    }
    // tìm nhân viên theo tên hoặc mã nhân viên
    public void searchByNameORmaNV(){
        System.out.println("nhập tên hoặc mã nhân viên cần tìm");
        String search = sc.nextLine();
        boolean isno = false;
        System.out.printf("|%-10s|%-20s|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%n",
                "Mã nhân viên","Tên nhân viên","Tuổi","HS Lương","Ngày vào làm","Ngày nghỉ phép","Bộ phân","Giờ làm thêm/chức vụ","Lương");
        // duyệt qua từng phần tử của list
        for (Staff item: staff) {
            if (item.getName().toLowerCase().contains(search.toLowerCase()) || item.manv().toLowerCase().contains(search.toLowerCase())){
                item.displayInformation();
                isno = true;
            }
        }
        if (isno==false){
            System.out.println("không tìm thấy nhân viên cần tìm");
        }
    }
    // hiện thị bảng lương theo thứ tự tăng dần
    public void sortNV() {
        // tiêu chi sắp xếp theo lương;
        Comparator<Staff> copm = new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if(o1.calculateSalary()>o2.calculateSalary()){
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(staff,copm);
        output();
    }
}


