package homework_23_09_11;

public class Main {


    public static void main(String[] args) {

        Processor processor = new Processor();
        Department department = new Department();

        Employee employees[] = {
                new Employee("Name1", "Surname1", 10000.0, 01),
                new Employee("Name2", "Surname2", 20000.0, 02),
                new Employee("Name3", "Surname3", 30000.0, 03),
                new Employee("Name4", "Surname4", 40000.0, 04),
                new Employee("Name5", "Surname5", 50000.0, 04),
                new Employee("Name6", "Surname3", 30000.0, 03),
                new Employee("Name7", "Surname7", 40000.0, 01),
                new Employee("Name8", "Surname8", 50000.0, 04)
        };

        Department[] departments = {
                new Department("Dep1", 01, department.getEmployees()),
                new Department("Dep2", 02, department.getEmployees()),
                new Department("Dep3", 03, department.getEmployees()),
                new Department("Dep4", 04, department.getEmployees())

        };

        processor.getAvgSalaryByDep(new Department("Dep1", 01, employees));
        processor.getMaxSalaryByDep(new Company("name", departments));
        processor.getSimilarSurname(new Company("name", departments));
    }
}
