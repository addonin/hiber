import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Dmytro_Adonin on 11/3/2015.
 */
public class Main {

    public static void main(final String[] args) throws Exception {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //Query query = session.createQuery("from UserDetails where id > 1");
        //Query query = session.createQuery("select userName from UserDetails");
        //query.setFirstResult(2);
        //query.setMaxResults(10);
        Query unusedQuery = session.createQuery("from UserDetails where id > ?");
        unusedQuery.setInteger(0, 1);

        Query query = session.createQuery("select userName from UserDetails where id > :id and userName = :userName");
        query.setInteger("id", 1);
        query.setString("userName", "User3");
        List<String> list = query.list();

        session.getTransaction().commit();
        session.close();

        //System.out.println("List length: " + list.size());
        for (String name : list) {
            System.out.println("Name : " + name);
        }
    }
}
