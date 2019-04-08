package cvr.otus.repo;

import cvr.otus.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author,Long> {

    Author getById(Long id);

    @SuppressWarnings("unchecked")
    Author save(Author author);

    List<Author> findAll();
}
//org.springframework.beans.factory.BeanCreationException:
//        Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
//        Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default]
//        Unable to build Hibernate SessionFactory; nested exception is org.hibernate.loader.MultipleBagFetchException:
//        cannot simultaneously fetch multiple bags: [cvr.otus.domain.Book.genres, cvr.otus.domain.Book.authors]