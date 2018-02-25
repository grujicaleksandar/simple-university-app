package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import model.Students;

/**
 *
 * @author bagnes
 */
@Stateless
@LocalBean
public class StudentDAO {

    @PersistenceContext(unitName="university")
    private EntityManager em;
    
    public void addStudent(Students student) {
        em.persist(student);
    }
    public void editStudent(Students student){
        em.merge(student);
    }
    public void deleteStudent(String id){
        Students student = em.find(Students.class, id);
        em.remove(student);
    }
    public Students getStudent(String id){
        return em.find(Students.class, id);
    }
    public List<Students> getAllStudents() {
        TypedQuery<Students> query = em.createNamedQuery("Student.getAll", Students.class);
        List<Students> list = query.getResultList();
        return list;

}
 public String validateUser(String username,String password){
    	
    	if(username.equals("admin") && password.equals("admin123")){
    		return "success";
    	}else{
    		return "fail";
    	}
    }
    
    
    
    
}
