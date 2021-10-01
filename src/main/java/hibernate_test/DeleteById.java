package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteById {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//читаем конфигурационный файл
                .addAnnotatedClass(Employee.class)//будем читать аннотации из этого класса
                .buildSessionFactory();//собираем все это
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //variant1
//            Employee emp = session.get(Employee.class, 1);
//            session.delete(emp);

            //variant2
            session.createQuery("delete Employee where name = 'Alex'").executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
