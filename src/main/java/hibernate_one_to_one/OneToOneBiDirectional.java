package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiDirectional {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//читаем конфигурационный файл
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();//собираем все это
        Session session = null;

        try {
            session = factory.getCurrentSession();
            //добавление данных
          /*  Employee employee = new Employee("Nikolai", "Ivanov", "HR", 850);
            Detail detail = new Detail("New-York", "56549653656510", "nikolay@gmail.com");

            employee.setEmpDetail(detail);//здесь необходимо использовать оба сеттера друг другу
            detail.setEmployee(employee);//иначе в базе в столбе details_id будет null

            session.beginTransaction();
            session.save(detail);*/
            //получение данных
            /*session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            System.out.println(detail.getEmployee());*/
            //удаление данных
            /*session.beginTransaction();
            Detail detail = session.get(Detail.class, 3);
            session.delete(detail);*/

            session.beginTransaction();
            Detail d = session.get(Detail.class, 4);
            d.getEmployee().setEmpDetail(null);//без этого обрывания связи, данные не будут удалены
            session.delete(d);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
