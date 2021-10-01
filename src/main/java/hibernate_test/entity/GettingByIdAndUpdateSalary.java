package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GettingByIdAndUpdateSalary {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//читаем конфигурационный файл
                .addAnnotatedClass(Employee.class)//будем читать аннотации из этого класса
                .buildSessionFactory();//собираем все это
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //variant1 with java
//            List<Employee> alexList = session.createQuery("from Employee where name = 'Alex'").getResultList();
//            for (Employee e: alexList)
//                e.setSalary(1000);

            //variant2 with HQL
            session.createQuery("update Employee set salary = 1200 where name = 'Alex'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
