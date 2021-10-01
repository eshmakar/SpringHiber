import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//читаем конфигурационный файл
                .addAnnotatedClass(Employee.class)//будем читать аннотации из этого класса
                .buildSessionFactory();//собираем все это
        try {
            Session session = factory.getCurrentSession();//открываем сессии
            Employee employee = new Employee("Evgenii", "Onegin", "writer", 550);
            session.beginTransaction();//начинаем сессию
            session.save(employee);//сохраняем на базу
            session.getTransaction().commit();//делаем коммит

            session = factory.getCurrentSession();//еще раз открываем сессию, так как предыдущий закрывается после коммита
            session.beginTransaction();
            Employee secondEmp = session.get(Employee.class, 4);//получение элемента по id
            System.out.println(secondEmp.getName());
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
