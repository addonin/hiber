import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.epam.hiber.dto.UserDetails;

/**
 * Created by Dmytro_Adonin on 11/3/2015.
 */
public class Main {

    public static void main(final String[] args) throws Exception {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            UserDetails user = new UserDetails();
            user.setUserName("User" + i);
            session.save(user);
        }

        UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 3);
        System.out.println("User: " + userDetails.getUserName());
        userDetails.setUserName("updated");
        session.update(userDetails);
        userDetails = (UserDetails) session.get(UserDetails.class, 3);
        session.delete(userDetails);

        session.getTransaction().commit();
        session.close();

        System.out.println("User: " + userDetails.getUserName());
    }
}
