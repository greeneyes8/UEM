package it.unical.uniexam.mvc.controll.secretary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.unical.uniexam.hibernate.domain.DegreeCourse;
import it.unical.uniexam.hibernate.domain.Department;
import it.unical.uniexam.hibernate.domain.Manager;
import it.unical.uniexam.hibernate.domain.Secretary;
import it.unical.uniexam.mvc.service.SecretaryService;
import it.unical.uniexam.mvc.service.UtilsService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SecretaryController {
	
	@Autowired
	SecretaryService secretaryService;
	
	
	@RequestMapping(value=SecretaryService.SECRETARY_HOME, method=RequestMethod.GET)
	public String home(HttpServletRequest request,Model model){
//		Secretary u = null;
//		String redirect = null;
//		ArrayList<Secretary> ulist = new ArrayList<Secretary>();
//		redirect = setSecretaryOrRedirect(request, model, ulist);
//		if(redirect!=null)
//			return redirect;
//		u = ulist.get(0);
		
		Secretary u=(Secretary)(request.getSession().getAttribute("user")!=null?request.getSession().getAttribute("user"):null);
		if(u==null) return UtilsService.LOGIN;
		
		model.addAttribute("I",u);
		
		return SecretaryService.SECRETARY_HOME;
	}
	
	@RequestMapping(value=SecretaryService.SECRETARY_DEPARTMENT, method=RequestMethod.GET)
	public String department(HttpServletRequest request, Model model) {
		Secretary u=(Secretary)(request.getSession().getAttribute("user")!=null?request.getSession().getAttribute("user"):null);
		if(u==null) return UtilsService.LOGIN;
		
		
		model.addAttribute("I",u);
		
		Set<Department> departments = secretaryService.getDepartment();
		model.addAttribute("departments", departments);
		
		return SecretaryService.SECRETARY_DEPARTMENT;
	}

	@RequestMapping(value=SecretaryService.SECRETARY_REGISTER_DEPARTMENT, method=RequestMethod.GET)
	public ModelAndView getRegisterDepartmentForm(@ModelAttribute("department") Department department, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView(SecretaryService.SECRETARY_REGISTER_DEPARTMENT, "model", model);
	}
	
	@RequestMapping("secretary/saveDepartment")
	public ModelAndView saveDepartment(@ModelAttribute("department") Department department, BindingResult result) {
		secretaryService.addDepartment(department);
		return new ModelAndView(SecretaryService.SECRETARY_HOME);
	}
	
	@RequestMapping(value=SecretaryService.SECRETARY_REGISTER_DEGREECOURSE, method=RequestMethod.GET)
	public ModelAndView getRegisterDegreeCourseForm(@ModelAttribute("degreeCourse") DegreeCourse degreeCourse, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView(SecretaryService.SECRETARY_REGISTER_DEGREECOURSE, "model", model);
	}
	
	@RequestMapping(value=SecretaryService.SECRETARY_REGISTER_MANAGER, method=RequestMethod.GET)
	public ModelAndView getRegisterManagerForm(@ModelAttribute("manager") Manager manager, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView(SecretaryService.SECRETARY_REGISTER_MANAGER, "model", model);
	}
	
	
//	String setSecretaryOrRedirect(HttpServletRequest request,Model model, ArrayList<Secretary> ulist) {
//		Secretary user=secretaryService.getSession(request.getSession().getId());
//		if(user==null){
//			HttpSession session = Secretary.getSession(false);
//			if(session!=null){
//				session.invalidate();
//			}
//			return UtilsService.redirectToErrorPageGeneral("Sessione scaduta Error code 1", "sessione", model);
//		}
//		if(user.getClass()!=Secretary.class){
//			return UtilsService.redirectToErrorPageGeneral("Errore, Utente non riconosciuto", "Classe Utente", model);
//		}
//		ulist.add((Secretary)user);
//		return null;
//	}
	
}
