package webproba.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import ejb.StudentDAO;
import model.Students;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentsWebService {

	@PersistenceContext(unitName="university")
    private EntityManager em;
	
	@EJB
	StudentDAO sd;

	@GET
	public List<Students> getStudents(){
		List<Students> list = sd.getAllStudents();
		return list;
	}
	
	@GET
	@Path("/{studentID}")
	public Students getStudent(@PathParam("studentID") String id){
		return sd.getStudent(id);
		
	}
	
	@POST
	public void addStudents(Students student){
		sd.addStudent(student);
	}
	
	@PUT
	@Path("/{studentID}")
	public void updateStudent(@PathParam("studentID") String id,Students student){
		 sd.editStudent(student);
	}
	
	@DELETE
	@Path("/{studentID}")
	public void deleteStudent(@PathParam("studentID") String id){
		sd.deleteStudent(id);
	}
	
	
	
	
}
