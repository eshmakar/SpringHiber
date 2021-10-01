package hibernate_test2;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//читаем конфигурационный файл
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();//собираем все это
        Session session = null;

        try {
             session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 750);
//            Detail detail = new Detail("Moscow", "987465412", "olejka@gmail.com");
//            employee.setEmpDetail(detail);

            session.beginTransaction();
//            Employee firstEmpl = session.get(Employee.class, 1);
//            System.out.println(firstEmpl.getEmpDetail());

            Employee oleg = session.get(Employee.class, 2);
            session.delete(oleg);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
