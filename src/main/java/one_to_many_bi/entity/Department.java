package one_to_many_bi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String departmentName;
    @Column(name = "max_salary")
    int maxSalary;
    @Column(name = "min_salary")
    int minSalary;

    //если выбрать CascadeType.ALL - то при удалении одного элемента будут удалены все!
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE}, mappedBy = "department")
    private List<Employee> emps;

    public void addEmployeeToDepartment(Employee empl){
        if (emps==null)
            emps = new ArrayList<>();
        emps.add(empl);
        empl.setDepartment(this);//это двунаправленный связь, поэтому на рабочий добавляем департамент

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return departmentName;
    }

    public void setName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmp() {
        return emps;
    }

    public void setEmp(List<Employee> emp) {
        this.emps = emp;
    }

    public Department() {
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    @Override
    public String toString() {
        return "Departmets{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
