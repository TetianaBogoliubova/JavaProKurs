package homework_23_09_11;

//import static lesson7.companyTask.Department.employees;

//in: Department out: avg salary
//        - in: Company out: dep with max average salary
//        - in: Company out: Employee with similar surName

public class Processor {

    public void getAvgSalaryByDep(Department department) {

        double sum = 0;
        Employee[] employees = department.getEmployees();
        for (Employee x : employees) {
            sum += x.getSalary();
        }
        System.out.println("Средняя зарплата работников: " + sum / employees.length);
    }

    public void getMaxSalaryByDep(Company company) {

        Department[] departments = company.getDepartments();

        Department max = null;
        double maxSalary = Double.MIN_VALUE;
        for (Department dep : departments) {
            Employee[] employees = dep.getEmployees();
            for (Employee emp : employees) {
                double salary = emp.getSalary();
                if (salary > maxSalary) {
                    maxSalary = salary;
                    max = dep;
                }
            }
        }
        if (max != null) {
            System.out.println("Максимальная зарплата: " + maxSalary);
        }
    }

    public void getSimilarSurname(Company company) {
        Department[] departments = company.getDepartments();
        for (Department dep : departments) {
            Employee[] employees = dep.getEmployees();

            for (int i = 0; i < employees.length; i++) {
                for (int j = i + 1; j < employees.length; j++) {
                    Employee emp1 = employees[i];
                    Employee emp2 = employees[j];

                    String surName1 = emp1.getSurName();
                    String surName2 = emp2.getSurName();

                    if (surName1.equals(surName2)) {
                        System.out.println("Одинаковые фамилии есть в департаменте: " + dep.getDepName());
                        System.out.println(emp1.getSurName() + " = " + emp2.getSurName());
                    }
                }
            }
        }
    }
}






