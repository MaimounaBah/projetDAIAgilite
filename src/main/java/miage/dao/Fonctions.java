package miage.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class Fonctions {

    private final SessionFactory SESSION_FACTORY = HibernateUtil.getSessionFactory();

    protected final Transaction getTransaction(Session session) {
        Transaction transaction = session.getTransaction();
        if (!TransactionStatus.ACTIVE.equals(transaction.getStatus())) {
            transaction = session.beginTransaction();
        }
        return transaction;
    }

}
