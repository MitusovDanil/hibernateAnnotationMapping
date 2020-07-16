import org.hibernate.Session;

import java.util.List;

public class Domain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();

        user.setName("Danil");
        user.setEmail("minus94@mail.ru");
        user.setPassword("123456");

        session.save(user);

        session.getTransaction().commit();

        session.beginTransaction();
        List result = session.createQuery("from User").list();
        for (User users : (List<User>) result) {
            System.out.println("Users: " + users.getName() + " : " + users.getEmail()
                    + " : " + users.getPassword());
        }
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
