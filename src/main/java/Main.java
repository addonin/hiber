import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.epam.hiber.dto.Address;
import ua.epam.hiber.dto.User;

import java.util.Date;

/**
 * Created by Dmytro_Adonin on 11/3/2015.
 */
public class Main {

    public static void main(final String[] args) throws Exception {

        /*System.out.println("querying all the managed entities...");
        final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
        for (Object key : metadataMap.keySet()) {
            final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
            final String entityName = classMetadata.getEntityName();
            final Query query = session.createQuery("from " + entityName);
            System.out.println("executing: " + query.getQueryString());
            for (Object o : query.list()) {
                System.out.println("  " + o);
            }
        }*/

        User user = new User();
        user.setDescription("desc");
        user.setJoinDate(new Date());
        user.setTranscient("transient");
        user.setName("name2");

        Address address = new Address();
        address.setCity("homecity");
        address.setStreet("homestreet");

        Address address1 = new Address();
        address1.setCity("officecity");
        address1.setStreet("officestreet");


        user.getAddresses().add(address);
        user.getAddresses().add(address1);

        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        /*user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (User) session.get(User.class, 2);
        session.getTransaction().commit();
        session.close();
        System.out.println("User : " + user.getName());*/

        user = null;
        session = sessionFactory.openSession();
        user = (User) session.get(User.class, 6);
        session.close();
        System.out.println(user.getAddresses().size());
    }
}
