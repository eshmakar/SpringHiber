package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GettingAllEmployees {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//читаем конфигурационный файл
                .addAnnotatedClass(Employee.class)//будем читать аннотации из этого класса
                .buildSessionFactory();//собираем все это
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();//начинаем сессию

            List<Employee> employeeList = session.createQuery("from Employee where surname = 'Ivanov' and salary>600").getResultList();//получаем полный список используя HQL
            for (Employee e: employeeList)
                System.out.println(e);
//                if (e.surname.equals("Ivanov"))
//                    System.out.println(e);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
