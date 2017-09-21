package com.gcit;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.library.hbm.entities.TblAuthor;
import com.gcit.library.hbm.entities.TblBook;
import com.gcit.library.hbm.entities.TblBookCopies;
import com.gcit.library.hbm.entities.TblBookCopiesId;
import com.gcit.library.hbm.entities.TblBookLoans;
import com.gcit.library.hbm.entities.TblBookLoansId;
import com.gcit.library.hbm.entities.TblBorrower;
import com.gcit.library.hbm.entities.TblGenre;
import com.gcit.library.hbm.entities.TblLibraryBranch;
import com.gcit.library.hbm.entities.TblPublisher;

/**
 * Handles requests for the application home page.
 */
@RestController
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	@PersistenceContext
	private EntityManager em;

	//author
	//create
	@Transactional
	@RequestMapping(value = "/author", method = {RequestMethod.POST }, consumes = "application/json")
	public String addAuthor(@RequestBody TblAuthor author) {
		try {
			em.persist(author);
		} catch (Exception e) {
			e.printStackTrace();
			return "Author create failed: " + e.getMessage();
		}
		return "Author created succesfully!";
	}
	
	//read
	@RequestMapping(value = "/authors", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblAuthor> getAllAuthors() {
		try {
//			em.createQuery(
//					"from TblAuthor where authorName = :aName and authorId = :aId")
//					.setParameter("aName", "Search String")
//					.setParameter("aId", "Search String").getResultList();
			//em.createQuery("from TblAuthor").setFirstResult(21).setMaxResults(10).getResultList();
			@SuppressWarnings("unchecked")
			List<TblAuthor> list = em.createQuery("from TblAuthor").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	@Transactional
	@RequestMapping(value = "/author", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updateAuthor(@RequestBody TblAuthor author) {
		try {
			em.merge(author);
		} catch (Exception e) {
			e.printStackTrace();
			return "Author update failed: " + e.getMessage();
		}
		return "Author updated succesfully!";
	}	
	
	//delete
	@Transactional
	@RequestMapping(value = "/author", method = {RequestMethod.DELETE }, consumes = "application/json")
	public String deleteAuthor(@RequestBody Integer authorId) {
		try {
			em.remove(em.getReference(TblAuthor.class, authorId));
		} catch (Exception e) {
			e.printStackTrace();
			return "Author delete failed: " + e.getMessage();
		}
		return "Author deleted succesfully!";
	}
	
	
	
	//Book
	//create
	@Transactional
	@RequestMapping(value = "/book", method = {RequestMethod.POST }, consumes = "application/json")
	public String addBook(@RequestBody TblBook book) {
		try {
			em.persist(book);
		} catch (Exception e) {
			e.printStackTrace();
			return "Book create failed: " + e.getMessage();
		}
		return "Book created succesfully!";
	}
	
	//read
	@RequestMapping(value = "/books", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblBook> getAllBooks() {
		try {
			@SuppressWarnings("unchecked")
			List<TblBook> list = em.createQuery("from TblBook").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	@Transactional
	@RequestMapping(value = "/book", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updateBook(@RequestBody TblBook book) {
		try {
			em.merge(book);
		} catch (Exception e) {
			e.printStackTrace();
			return "Book update failed: " + e.getMessage();
		}
		return "Book updated succesfully!";
	}	
	
	//delete
	@Transactional
	@RequestMapping(value = "/book", method = {RequestMethod.DELETE }, consumes = "application/json")
	public String deleteBook(@RequestBody Integer bookId) {
		try {
			em.remove(em.getReference(TblBook.class, bookId));
		} catch (Exception e) {
			e.printStackTrace();
			return "Book delete failed: " + e.getMessage();
		}
		return "Book deleted succesfully!";
	}
	
	
	
	//Branch
	//create
	@Transactional
	@RequestMapping(value = "/branch", method = {RequestMethod.POST }, consumes = "application/json")
	public String addBranch(@RequestBody TblLibraryBranch branch) {
		try {
			em.persist(branch);
		} catch (Exception e) {
			e.printStackTrace();
			return "Branch create failed: " + e.getMessage();
		}
		return "Branch created succesfully!";
	}
	
	//read
	@RequestMapping(value = "/branches", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblLibraryBranch> getAllBranches() {
		try {
			@SuppressWarnings("unchecked")
			List<TblLibraryBranch> list = em.createQuery("from TblLibraryBranch").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	@Transactional
	@RequestMapping(value = "/branch", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updateBranch(@RequestBody TblLibraryBranch branch) {
		try {
			em.merge(branch);
		} catch (Exception e) {
			e.printStackTrace();
			return "Branch update failed: " + e.getMessage();
		}
		return "Branch updated succesfully!";
	}	
	
	//delete
	@Transactional
	@RequestMapping(value = "/branch", method = {RequestMethod.DELETE }, consumes = "application/json")
	public String deleteBranch(@RequestBody Integer branchId) {
		try {
			em.remove(em.getReference(TblLibraryBranch.class, branchId));
		} catch (Exception e) {
			e.printStackTrace();
			return "Branch delete failed: " + e.getMessage();
		}
		return "Branch deleted succesfully!";
	}
	
	
	
	//Genre
	//create
	@Transactional
	@RequestMapping(value = "/gerne", method = {RequestMethod.POST }, consumes = "application/json")
	public String addGenre(@RequestBody TblGenre genre) {
		try {
			em.persist(genre);
		} catch (Exception e) {
			e.printStackTrace();
			return "Genre create failed: " + e.getMessage();
		}
		return "Genre created succesfully!";
	}
	
	//read
	@RequestMapping(value = "/genres", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblGenre> getAllGenres() {
		try {
			@SuppressWarnings("unchecked")
			List<TblGenre> list = em.createQuery("from TblGenre").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	@Transactional
	@RequestMapping(value = "/genre", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updateGenre(@RequestBody TblGenre genre) {
		try {
			//@SuppressWarnings("unchecked")
			//List<TblBook> list = em.createQuery("from TblBook where bookId IN (from Tbl= :genreId)").setParameter("genreId", genre.getGenreId()).getResultList();
			//remove existing books for genre
//			TblGenre g = em.getReference(TblGenre.class, genre.getGenreId());
//            g.setTblBooks(null);
//            em.merge(g);
			//update
			em.merge(genre);
		} catch (Exception e) {
			e.printStackTrace();
			return "Genre update failed: " + e.getMessage();
		}
		return "Genre updated succesfully!";
	}	
	
	//delete
	@Transactional
	@RequestMapping(value = "/genre", method = {RequestMethod.DELETE }, consumes = "application/json")
	public String deleteGenre(@RequestBody Integer genreId) {
		try {
			em.remove(em.getReference(TblGenre.class, genreId));
		} catch (Exception e) {
			e.printStackTrace();
			return "Genre delete failed: " + e.getMessage();
		}
		return "Genre deleted succesfully!";
	}
	
	
	
	//Book Copies
	//create
	@Transactional
	@RequestMapping(value = "/bookCopies", method = {RequestMethod.POST }, consumes = "application/json")
	public String addBookCopies(@RequestBody TblBookCopies bookCopies) {
		try {
			em.persist(bookCopies);
		} catch (Exception e) {
			e.printStackTrace();
			return "BookCopies create failed: " + e.getMessage();
		}
		return "BookCopies created succesfully!";
	}
	
	//read
	@RequestMapping(value = "/bookCopies", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblBookCopies> getAllBookCopies() {
		try {
			@SuppressWarnings("unchecked")
			List<TblBookCopies> list = em.createQuery("from TblBookCopies").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	@Transactional
	@RequestMapping(value = "/bookCopies", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updateBookCopies(@RequestBody TblBookCopies bookCopies) {
		try {
			em.merge(bookCopies);
		} catch (Exception e) {
			e.printStackTrace();
			return "BookCopies update failed: " + e.getMessage();
		}
		return "BookCopies updated succesfully!";
	}	
	
	//delete
	@Transactional
	@RequestMapping(value = "/bookCopies", method = {RequestMethod.DELETE }, consumes = "application/json")
	public String deleteBookCopies(@RequestBody Integer bookId, Integer branchId) {
		try {
			em.remove(em.getReference(TblBookCopies.class, new TblBookCopiesId(bookId, branchId)));
		} catch (Exception e) {
			e.printStackTrace();
			return "BookCopies delete failed: " + e.getMessage();
		}
		return "BookCopies deleted succesfully!";
	}
	
	
	
	//Borrower
	//create
	@Transactional
	@RequestMapping(value = "/borrower", method = {RequestMethod.POST }, consumes = "application/json")
	public String addBorrower(@RequestBody TblBorrower borrower) {
		try {
			em.persist(borrower);
		} catch (Exception e) {
			e.printStackTrace();
			return "Borrower create failed: " + e.getMessage();
		}
		return "Borrower created succesfully!";
	}
	
	//read
	@RequestMapping(value = "/borrowers", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblBorrower> getAllBorrowers() {
		try {
			@SuppressWarnings("unchecked")
			List<TblBorrower> list = em.createQuery("from TblBorrower").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	@Transactional
	@RequestMapping(value = "/borrower", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updateBorrower(@RequestBody TblBorrower borrower) {
		try {
			em.merge(borrower);
		} catch (Exception e) {
			e.printStackTrace();
			return "Borrower update failed: " + e.getMessage();
		}
		return "Borrower updated succesfully!";
	}	
	
	//delete
	@Transactional
	@RequestMapping(value = "/borrower", method = {RequestMethod.DELETE }, consumes = "application/json")
	public String deleteBorrower(@RequestBody Integer borrowerId) {
		try {
			em.remove(em.getReference(TblBorrower.class, borrowerId));
		} catch (Exception e) {
			e.printStackTrace();
			return "Borrower delete failed: " + e.getMessage();
		}
		return "Borrower deleted succesfully!";
	}
	
	
	
	//Loans
	//read
	@RequestMapping(value = "/loans", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblBookLoans> getAllLoans() {
		try {
			@SuppressWarnings("unchecked")
			List<TblBookLoans> list = em.createQuery("from TblBookLoans where dateIn IS NULL").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//update
	@Transactional
	@RequestMapping(value = "/loan", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updateLoan(@RequestBody Integer bookId, Integer branchId, Integer cardNo, String dateOut, String dueDate) {
		try {
			TblBookLoans loan = em.getReference(TblBookLoans.class, new TblBookLoansId(bookId, branchId, cardNo, dateOut));
			loan.setDueDate(dueDate);
			em.merge(loan);
		} catch (Exception e) {
			e.printStackTrace();
			return "Loan update failed: " + e.getMessage();
		}
		return "Loan updated succesfully!";
	}	

	
	
	//Publisher
	//create
	@Transactional
	@RequestMapping(value = "/publisher", method = {RequestMethod.POST }, consumes = "application/json")
	public String addPublisher(@RequestBody TblPublisher publisher) {
		try {
			em.persist(publisher);
			if(publisher.getTblBooks() != null) {
				for(TblBook b : publisher.getTblBooks()) {
					em.flush();
					TblBook book = em.getReference(TblBook.class, b.getBookId());
					book.setTblPublisher(publisher);
					em.merge(book);
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Publisher create failed: " + e.getMessage();
		}
		return "Publisher created succesfully!";
	}
	
	//read
	@RequestMapping(value = "/publishers", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblPublisher> getAllPublishers() {
		try {
			@SuppressWarnings("unchecked")
			List<TblPublisher> list = em.createQuery("from TblPublisher").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//update
	@Transactional
	@RequestMapping(value = "/publisher", method = {RequestMethod.PUT }, consumes = "application/json")
	public String updatePublisher(@RequestBody TblPublisher publisher) {
		try {
			em.merge(publisher);
			//remove all existing books
			@SuppressWarnings("unchecked")
			List<TblBook> list = em.createQuery("from TblBook where pubId = :publisherId").setParameter("publisherId", publisher.getPublisherId()).getResultList();
			for(TblBook b : list) {
				em.flush();
				b.setTblPublisher(null);
				em.merge(b);
			}
			//add new book list
			//if(publisher.getTblBooks() != null) {
				for(TblBook b : publisher.getTblBooks()) {
					em.flush();
					TblBook book = em.getReference(TblBook.class, b.getBookId());
					book.setTblPublisher(publisher);
					em.merge(book);
				}				
			//}
		} catch (Exception e) {
			e.printStackTrace();
			return "Publisher update failed: " + e.getMessage();
		}
		return "Publisher updated succesfully!";
	}	
	
	//delete
	@Transactional
	@RequestMapping(value = "/publisher", method = {RequestMethod.DELETE }, consumes = "application/json")
	public String deletePublisher(@RequestBody Integer publisherId) {
		try {
			TblPublisher pub = em.getReference(TblPublisher.class, publisherId);
			if (pub.getTblBooks() != null) {
				for(TblBook b : pub.getTblBooks()) {
					em.flush();
					TblBook book = em.getReference(TblBook.class, b.getBookId());
					book.setTblPublisher(null);
					em.merge(book);
				}	
			}
			em.remove(em.getReference(TblPublisher.class, publisherId));
		} catch (Exception e) {
			e.printStackTrace();
			return "Publisher delete failed: " + e.getMessage();
		}
		return "Publisher deleted succesfully!";
	}
}
