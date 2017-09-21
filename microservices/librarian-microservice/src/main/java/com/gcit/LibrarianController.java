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
public class LibrarianController {

	private static final Logger logger = LoggerFactory
			.getLogger(LibrarianController.class);

	@PersistenceContext
	private EntityManager em;

	//view branches
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
	
	//update branch
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
	
	//get the list of available books for the branch
	@RequestMapping(value = "/bookCopies/{branchId}", method = { RequestMethod.GET }, produces = "application/json")
	public List<TblBookCopies> getAllBookCopies(@PathVariable Integer branchId) {
		try {
			@SuppressWarnings("unchecked")
			List<TblBookCopies> list = em.createQuery("from TblBookCopies where branchId = :branchId and noOfCopies > 0").setParameter("branchId", branchId).getResultList(); 
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
}
