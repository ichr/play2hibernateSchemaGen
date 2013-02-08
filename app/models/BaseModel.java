package models;

import play.db.jpa.JPA;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Query;

/**
 * @author Kristof Dombi <kd@nq.io>
 */
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue
    public Long id;

    public Long getId() {
        return id;
    }

    public static class Finder<I,T> {

        private final Class<I> idType;
        private final Class<T> type;

        /**
         * Creates a finder for entity of type <code>T</code> with ID of type <code>I</code>.
         */
        public Finder(Class<I> idType, Class<T> type) {
            this.idType = idType;
            this.type = type;
        }

        public T findById(I id) {
            return JPA.em().find(type, id);
        }

        public Query find(String query) {
            return JPA.em().createQuery(query);
        }

    }

}