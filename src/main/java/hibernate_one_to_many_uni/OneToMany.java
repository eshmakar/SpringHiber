package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            //Добавление работников и департаментов
    /*        Employee employee1 = new Employee("Valerii", "Ivanov", 650);
            Employee employee2 = new Employee("Pavel", "Durov", 1300);
            Department department = new Department("IT", 850, 1800);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();*/

            //Получение работников вместе с департаментами
       /*     session.beginTransaction();
            Department department = session.get(Department.class, 4);
            System.out.println(department);
            System.out.println(department.getEmp());
            session.getTransaction().commit();*/

            //При удалении одного работника удаляется его департамент и все работники к-ые относятся к этому департаменту тоже
            //в этом случае нельзя использовать CascadeType.ALL
          /*  session.beginTransaction();
            Employee emp = session.get(Employee.class, 4);
            System.out.println(emp);
            System.out.println(emp.getDepartment());
            session.delete(emp);
            System.out.println("Был удален рабочий (а так же все рабочие) и его департамент");

            session.getTransaction().commit();*/

            session.beginTransaction();
           Department department = session.get(Department.class, 3);
           session.delete(department);

            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }
    }
}
