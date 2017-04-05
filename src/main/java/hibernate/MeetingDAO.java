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

        session.getTransaction().commit();
        session.close();
    }

    public static void deleteMeeting (long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("delete Meeting where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();

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

    public static int check (Meeting meeting) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT COUNT(*) FROM Meeting WHERE room = :room AND :startT BETWEEN startTime AND endTime OR :endT BETWEEN startTime AND endTime");
        query.setParameter("room", meeting.getRoom());
        query.setParameter("startT", meeting.getStartTime());
        query.setParameter("endT", meeting.getEndTime());

        int result;
        long count = (long) query.getSingleResult();
        if (count == 0) {
            result = 1;
        } else {
            result = -1;
        }

        session.getTransaction().commit();
        session.close();

        return result;
    }

}
