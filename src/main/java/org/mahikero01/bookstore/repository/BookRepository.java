package org.mahikero01.bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mahikero01.bookstore.model.Book;

public class BookRepository {
	
	@PersistenceContext(unitName="bookStorePU")
	private EntityManager em;
	
	public Book find(Long id) {
		return em.find(Book.class, id);
	}
	
	public Book create(Book book) {
		em.persist(book);
		return book;
	}
	
	public void delete(Long id) {
		em.remove(em.getReference(Book.class, id));
	}
	
	public List<Book> findAll() {
		TypedQuery<Book> query = em.createQuery("SELECT b from Book b order by b.title", Book.class);
		return query.getResultList();
	}
	
	public Long countAll() {
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Book b", Long.class);
        return query.getSingleResult();
	}

}
