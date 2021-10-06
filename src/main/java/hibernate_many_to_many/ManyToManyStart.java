package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ManyToManyStart {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            //Добавление детей в секции
            /*Child child1 = new Child("Pavlik", 8);
            Child child2 = new Child("Kolya", 10);
            Child child3 = new Child("Andrey", 11);

            Section chess = new Section("Chess");
            chess.addChildToSection(child1);
            chess.addChildToSection(child2);
            chess.addChildToSection(child3);

            session.beginTransaction();

            session.save(chess);

            session.getTransaction().commit();*/

            //Добавление секции
            /*         Section math = new Section("Math");
            Section Quran = new Section("Quran");
            Child Ahmad = new Child("Ahmad", 12);
            Ahmad.addSectionToChild(math);
            Ahmad.addSectionToChild(Quran);
            session.beginTransaction();
            session.save(Ahmad);
            session.getTransaction().commit();*/

            //Получение ребенка и его секции
            /*session.beginTransaction();
            Child child = session.get(Child.class,4);
            System.out.println(child);
            System.out.println(child.getSection());
            session.getTransaction().commit();*/

            //чтобы при удалении секции не удалять и детей, каскад не должен быть all
            /*session.beginTransaction();
            Section math = session.get(Section.class, 2);
            session.delete(math);

            session.getTransaction().commit();*/

            //если каскад не all, то тогда при удалении одного объекта все объекты уже не удалятся
            /*session.beginTransaction();
            Section section = session.get(Section.class, 4);
            session.delete(section);

            session.getTransaction().commit();*/

            //чтобы каскадно добавлять элементов, необходимо испльзовать session.persist вместо session.save
            Child child1 = new Child("Vasya", 5);
            Child child2 = new Child("Anton", 8);
            Child child3 = new Child("Igor", 7);

            session.beginTransaction();

            Section section = session.get(Section.class, 1);//всех этих детей добавляем в секцию chess
            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);

            session.persist(section);

            session.getTransaction().commit();


        } finally {
            factory.close();
            session.close();
        }
    }

}
