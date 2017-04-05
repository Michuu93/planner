package hibernate;

import models.Meeting;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class MeetingDAO {

    public static void saveMeeting(Meeting meeting) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(meeting);

        session.getTransaction().commit();
        session.close();
    }

    public static void deleteMeeting(long id) {
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

        Query query = session.createQuery("from Meeting ORDER BY startTime");
        List<Meeting> meetings = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return meetings;
    }

    public static boolean check(Meeting meeting) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT COUNT(*) FROM Meeting WHERE room = :room AND (:startT BETWEEN startTime AND endTime OR :endT BETWEEN startTime AND endTime OR startTime BETWEEN :startT AND :endT OR endTime BETWEEN :startT AND :endT)");
        query.setParameter("room", meeting.getRoom());
        query.setParameter("startT", meeting.getStartTime());
        query.setParameter("endT", meeting.getEndTime());

        boolean result;
        long count = (long) query.getSingleResult();
        if (count == 0) {
            result = true;
        } else {
            result = false;
        }

        session.getTransaction().commit();
        session.close();
        return result;
    }

}
