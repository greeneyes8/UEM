package it.unical.uniexam.hibernate.domain;

/**
 * @category Event 
 * 
 * This class describe a Exam
 * each Exam have a code, a date, (many student inscribed ***); 
 * At each Exam 	have a professor like holder (titolare) same prof. that is holder in the course!,
 * 			 		have many professors like a commission
 * 					refer exact a one course
 * 					refer exact a one session of exam
 *					have zero or many students inscribed ? *** 
 * 					
 * 					something else?
 * 
 * @functions
 * 	can inscribes at this exam this student? this function have to use a Facade structure in which 
 * 		it ask at this class without know how this class works, and trust the result	
 * 
 * @author luigi
 *
 */

public class Exam {

}
