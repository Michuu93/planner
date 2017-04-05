package hibernate;

import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class RoomsDAO {
    public static List<String> getRooms() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT room FROM Room ORDER BY room");
        List<String> roomsList = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return roomsList;
    }
}