package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.StudentDAO;


/**
 * Servlet implementation class ValidateUserController
 */
@WebServlet("/ValidateUserController")
public class ValidateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private StudentDAO studentDAO;
    
    public ValidateUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	String username;
	String password;
	String result;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
			
			username = request.getParameter("uname");
			password = request.getParameter("pass");
			result = studentDAO.validateUser(username, password);
			request.setAttribute("uname", username);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.setAttribute("uname", username);
			
			if(result.equals("success")){
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
				dispatcher.forward(request, response);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
