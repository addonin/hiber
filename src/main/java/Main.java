import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.epam.hiber.dto.*;

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

        Vehicle vehicle = new Vehicle();
        vehicle.setType("car");
        //vehicle.setUser(user);
        //vehicle.getUsers().add(user);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setType("bike");
        //vehicle1.setUser(user);
        //vehicle1.getUsers().add(user);

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setType("bike");
        twoWheeler.setSteeringHandle("handle");

        FourWheel fourWheel = new FourWheel();
        fourWheel.setType("car");
        fourWheel.setSteeringWheel("wheel");

        Address address = new Address();
        address.setCity("homecity");
        address.setStreet("homestreet");

        Address address1 = new Address();
        address1.setCity("officecity");
        address1.setStreet("officestreet");

        /*user.getAddresses().add(address);
        user.getAddresses().add(address1);
        user.getVehicles().add(vehicle);
        user.getVehicles().add(vehicle1);*/

        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(vehicle);
        session.save(twoWheeler);
        session.save(fourWheel);
        /*session.save(vehicle1);*/
        //session.persist(user);//session.save(user);
        //System.out.println(((Vehicle) session.get(Vehicle.class, 20)).getUser());
        session.getTransaction().commit();
        session.close();

        /*user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (User) session.get(User.class, 2);
        session.getTransaction().commit();
        session.close();
        System.out.println("User : " + user.getName());*/

        /* Lazy/Eager example
        user = null;
        session = sessionFactory.openSession();
        user = (User) session.get(User.class, 6);
        session.close();
        System.out.println(user.getAddresses().size());*/
    }
}
