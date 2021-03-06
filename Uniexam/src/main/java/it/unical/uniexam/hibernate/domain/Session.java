//package it.unical.uniexam.hibernate.domain;
//
//import it.unical.uniexam.MokException;
//import it.unical.uniexam.hibernate.domain.utility.SessionAttribute;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//import java.util.UUID;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.PrePersist;
//import javax.persistence.Table;
//
//
///**
// * @category Event 
// * 
// * This class describe the Session 
// * each Session have a id, a start date, a end date
// * At each Session 		is associated with a DC (Degree Course)
// * 
// * 					something else?
// * 
// * 
// * @author luigi
// *
// */
//
//@Entity
//@Table(name="SESSION")
//public class Session {
//
//	
//	@Id
//	@Column(name="SESSION_ID")
//	String id;
//	
//	public void ensureId(){
//	    this.setId(UUID.randomUUID().toString());
//	}
//	
//	@Column(name="OWNER")
//	Long owner;
//	
//	@Column(name="TYPE")
//	User.TYPE type;
//	
////	public static String getAttributesFromMap(Map<String,Object>map){
////		StringBuilder sb=new StringBuilder();
////		Set<Entry<String,Object>> entrySet = map.entrySet();
////		for (Entry<String, Object> entry : entrySet) {
////			sb.append(entry.getKey());
////			sb.append("=");
////			sb.append(entry.getValue().toString());
////			sb.append("&");
////		}
////		sb.deleteCharAt(sb.length()-1);
////		return sb.toString();
////	}
////	// stringa tipo prof=[Professor.class:name?cicio$surname?pasticcio]&stud=[#Student.class:id?125]
////	public static Map<String,Object> getMapFromAttributes(String attributes){
////		Map<String,Object>res=new HashMap<String, Object>();
////		String []pairs=attributes.split("&");
////		for (String pair : pairs) {
////			String [] one=pair.split("=");
////			if(one[0]!=null && one[1]!=null){
////				if(one[1].startsWith("[")){//quindi si tratta di un oggetto avanzato
////					String object=one[1].replaceAll("[", "");
////					object=object.replaceAll("]", "");
////					String []cla=object.split(":");
////					object=cla[1];
////					String clazz=cla[0];
////					Object obj=null;
////					try {
////						Class c=Class.forName(clazz);
////						Class[]arg={String.class};
////						Method m=c.getDeclaredMethod("getIntanceFromAttributes", arg);
////						obj=m.invoke(null, object);
////					} catch (Exception e) {
////						new MokException(e);
////					}
////					if(obj!=null)
////						res.put(one[0], obj);
////				}else if(one[1].startsWith("[#")){
////					//allora prendo solo l'id e con una chiamata alla DAO mi faccio restituire l'ogetto
////				}else
////					res.put(one[0], one[1]);
////			}
////		}
////		return null;
////	}
////	
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public Long getOwner() {
//		return owner;
//	}
//
//	public void setOwner(Long owner) {
//		this.owner = owner;
//	}
//
//	public User.TYPE getType() {
//		return type;
//	}
//
//	public void setType(User.TYPE type) {
//		this.type = type;
//	}
//
////	public Date getExpire() {
////		return expire;
////	}
////
////	public void setExpire(Date expire) {
////		this.expire = expire;
////	}
////
////	public Boolean getValid() {
////		return valid;
////	}
////
////	public void setValid(Boolean valid) {
////		this.valid = valid;
////	}
////
////	public Date getCreated() {
////		return created;
////	}
////
////	public void setCreated(Date created) {
////		this.created = created;
////	}
////	
////	public String getAttributes() {
////		return attributes;
////	}
////
////	public void setAttributes(String attributes) {
////		this.attributes = attributes;
////	}
//	
//}
