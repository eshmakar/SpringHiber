import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddingEmployeesAndGettingById {
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

            Employee secondEmp = session.get(Employee.class, 5);//получение элемента по id
            System.out.println(secondEmp);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
