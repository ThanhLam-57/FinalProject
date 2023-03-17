package Modal;

public class Department {
    private int department_id;
    private String department_code;
    private String department_name;

    public Department(int department_id, String department_code, String department_name) {
        this.department_id = department_id;
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
}
