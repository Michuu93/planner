package hibernate;

import models.Meeting;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class MeetingDAO {

    public static void saveMeeting (Meeting meeting) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(meeting);
        System.out.println(meeting);

        session.getTransaction().commit();
        session.close();
    }

    public static void deleteMeeting (long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("delete Meeting where id = :id");
        query.setParameter("id", id);

        session.getTransaction().commit();
        session.close();
    }

    public static List<Meeting> getMeetings() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Meeting");
        List<Meeting> meetings = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return meetings;
    }

}
