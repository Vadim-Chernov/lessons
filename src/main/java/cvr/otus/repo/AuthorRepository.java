package cvr.otus.repo;

import cvr.otus.domain.Author;

import java.util.List;

public interface AuthorRepository {

    Author getById(int id);

    Author add(String name);

    List<Author> getAll();
}
//org.springframework.beans.factory.BeanCreationException:
//        Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
//        Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default]
//        Unable to build Hibernate SessionFactory; nested exception is org.hibernate.loader.MultipleBagFetchException:
//        cannot simultaneously fetch multiple bags: [cvr.otus.domain.Book.genres, cvr.otus.domain.Book.authors]