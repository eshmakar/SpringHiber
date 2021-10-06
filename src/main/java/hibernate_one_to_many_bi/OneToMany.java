package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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
            /*Employee employee1 = new Employee("Anton", "Pavlov", 950);
            Employee employee2 = new Employee("Nancy", "Smith", 1200);
            Department department = new Department("HR", 650, 1500);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();*/

            //Получение работников вместе с департаментами
            /*session.beginTransaction();
            Department department = session.get(Department.class, 1);
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
            Employee employee = session.get(Employee.class, 6);
            session.delete(employee);

            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }
    }
}
