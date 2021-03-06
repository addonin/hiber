import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import ua.epam.hiber.dto.UserDetails;

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

        /*Query query = session.createQuery("select userName from UserDetails where id > :id and userName = :userName");
        query.setInteger("id", 1);
        query.setString("userName", "User3");
        List<String> list = query.list();*/

        /*query = session.getNamedQuery("userName.byId");
        query.setInteger("id", 1);
        list = query.list();*/

        Criteria criteria = session.createCriteria(UserDetails.class);
        //fluent interface equals to AND, so the next example for OR
        //criteria.add(Restrictions.or(Restrictions.eq("id", 1), Restrictions.gt("id", 3)));

        UserDetails userDetails = new UserDetails();
        userDetails.setId(1); // PK's & null's are ignored
        userDetails.setUserName("User%");
        Example example = Example.create(userDetails).enableLike().excludeProperty("id");

        criteria.add(example)
                .setProjection(Projections.property("userName"))
                .addOrder(Order.desc("userName"));
        List<String> list = criteria.list();

        Query query = session.createQuery("from UserDetails");
        query.setCacheable(true);
        query.list();

        session.getTransaction().commit();
        session.close();

        //System.out.println("List length: " + list.size());
        for (String user : list) {
            System.out.println("Name : " + user);
        }

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Query query1 = session1.createQuery("from UserDetails");
        //caching query, the same as above, so that query-cache ask 2-level cache for result, no new query
        query1.setCacheable(true);
        query1.list();
        session1.getTransaction().commit();
        session1.close();
    }
}
