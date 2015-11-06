import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
        criteria.add(Restrictions.or(Restrictions.eq("id", 1), Restrictions.gt("id", 3)));
        List<UserDetails> list = criteria.list();

        session.getTransaction().commit();
        session.close();

        //System.out.println("List length: " + list.size());
        for (UserDetails user : list) {
            System.out.println("Name : " + user.getUserName());
        }
    }
}
