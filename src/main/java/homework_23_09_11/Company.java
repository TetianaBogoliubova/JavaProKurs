package homework_23_09_11;

//- Company
//        -
//        -
//        - Department[]
//        -
//        -
//        - Employee[]
//        -
//        - salary
//        - name
//        - surName
//        - Processor
//        - in: Department out: avg salary
//        - in: Company out: dep with max average salary
//        - in: Company out: Employee with similar surName
public class Company {

    private String name;
    private static Department[] departments;

    public Company() {
    }

    public Company(String name, Department[] departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

}
