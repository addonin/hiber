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

        UserDetails user = new UserDetails();
        user.setUserName("User");
        session.save(user);

        user.setUserName("User1");
        //in case 2 updates during the session 1st update intelligently ignored
        user.setUserName("User2");

        session.getTransaction().commit();
        session.close();

        //in case of updating object after session was closed no changes saved to DB
        user.setUserName("User3");
    }
}
