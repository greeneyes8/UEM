package it.unical.uniexam.hibernate.mokTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.uniexam.MokException;
import it.unical.uniexam.hibernate.dao.DepartmentDAO;
import it.unical.uniexam.hibernate.dao.ProfessorDAO;
import it.unical.uniexam.hibernate.dao.impl.DepartmentDAOImpl;
//import it.unical.uniexam.hibernate.dao.impl.DepartmentDaoImpl;
//import it.unical.uniexam.hibernate.dao.impl.ProfessorDaoImp;
import it.unical.uniexam.hibernate.domain.utility.Address;
import it.unical.uniexam.hibernate.domain.Professor;
import static org.junit.Assert.*;

/**
 * 
 * @author luigi
 *
 */
public class DBTest {
	private static DepartmentDAO departmentDao=new DepartmentDAOImpl();
	//private static ProfessorDao professorDao=new ProfessorDaoImp();


	@BeforeClass
	public static void prepareBD(){
		List<Professor>professors=new ArrayList<Professor>();
		Address address = new Address();
		//	address.setCity("Acri");
		//	address.setState("ITALY");
		//	address.setStreet("Europa");
		//	address.setZip("83843");
		//		Long idDep =departmentDao.addDepartment("12", "Informatica",professors, address);
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			new MokException(e);
		}
		//	
		//	professorDao.addProfessor("mok", "klui", idDep);
		//	professorDao.addProfessor("madsfdok2", "lDsdff", idDep);

	}

	@Test
	public void prooova(){
		//		assertTrue(departmentDao.listDepartment().size()==2);
	}

}