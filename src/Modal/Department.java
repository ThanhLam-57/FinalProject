package Modal;

import jdk.jfr.Label;
import jdk.jfr.Name;

public class Department {
    @Name("department_id")
    private int department_id;
    @Name("department_code")
    @Label("Mã phòng ban")
    private String department_code;
    @Name("department_name")
    @Label("Tên phòng ban")
    private String department_name;

    public Department(int department_id, String department_code, String department_name) {
        this.department_id = department_id;
        this.department_code = department_code;
        this.department_name = department_name;
    }

    public Department(String department_code, String department_name) {
        this.department_code = department_code;
        this.department_name = department_name;
    }

    public Department() {
    }
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_code() {
        return department_code;
    }

    public void setDepartment_code(String department_code) {
        this.department_code = department_code;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_code='" + department_code + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
