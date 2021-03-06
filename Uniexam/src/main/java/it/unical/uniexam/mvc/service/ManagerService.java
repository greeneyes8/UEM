package it.unical.uniexam.mvc.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import it.unical.uniexam.hibernate.domain.Course;
import it.unical.uniexam.hibernate.domain.DegreeCourse;
import it.unical.uniexam.hibernate.domain.Department;
import it.unical.uniexam.hibernate.domain.ExamSession;
import it.unical.uniexam.hibernate.domain.Manager;
import it.unical.uniexam.hibernate.domain.Professor;
import it.unical.uniexam.hibernate.domain.RequestedCourse;
import it.unical.uniexam.hibernate.domain.User;


public interface ManagerService extends UserService {
	
	public final static String MANAGER_HOME="manager/home";
	public final static String MANAGER_QUERY_ID="idManager";
	public static final String MANAGER_IMAGE = "manager/image";
	public static final String MANAGER_ACCOUNT = "manager/account";
	public static final String MANAGER_UPLOAD ="manager/upload";
	public static final String MANAGER_EXAM ="manager/exam_session";
	public static final String MANAGER_COURSE ="manager/course";
	public static final String MANAGER_COURSELIST= "manager/course/list";
	public static final String MANAGER_ASSIGNCOURSE="manager/assignCourse";
	public static final String MANAGER_ORDINAMENTO="manager/ordinamento";
	
	public Manager getManager(Long idUser);
	public Boolean streamImage(Manager m, OutputStream outputStream);
	public void putImage(Manager m, InputStream is,int length);
	public Map<String, String> getPersonalizzationValues(Long id);
	public void updatePersonalizzationValues(String stringValues,Long id);
	public Set<DegreeCourse> getAssociatedCourseWithDepartment(Long id);
	public Set<ExamSession> getExamSession();
	public Set<ExamSession> getExamsessionfromdepartment(Department department);
	public Set<ExamSession> getExamSessionfromDegreeCourse(DegreeCourse degreecourse);
	
	public ExamSession getExamsession(Long id);
	
	public Boolean addExamsession(ExamSession es);
	public Boolean removeExamsession(Long id);
	
	public Boolean changeExamSessionField(Long idexamsession, String variable,String value, String clazz);

	public ArrayList<Course> getCourses();
	public ArrayList<Course> getCoursesFromDegreeCourse(Long idDegreeCourse);

	
	
	
	public Course getCourseDetails(Long idCourse);
	public Boolean addCourse(Course course);

	public Boolean removeCourse(Long idCourse,Long idDegreeCourse);

	public Boolean addRequestedCourse(Long idCourse,RequestedCourse requestedCourse);
	public Boolean removeRequestedCourse(Long idcourse,Long idcourserequested);
	
	public Set<Professor> getProfessorfromDepartment(Long idDep);
	public Set<Professor> getProfessors();

	public Boolean setHolderProfessor(Long idCourse, Long idProfessor);
	public Boolean removeHolderProfessor(Long idCourse,Long idprofessor);

	
	
}
