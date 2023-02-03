package School;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteeeeee")
public class DeleteTeacher extends HttpServlet
	{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vrunda");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t=em.find(Teacher.class, id1);	
		if(t!=null)
		{
			et.begin();
			em.remove(t);
			et.commit();
			
			PrintWriter pd=resp.getWriter();
			pd.write("Teacher is deleted....!");
			
			RequestDispatcher rd=req.getRequestDispatcher("crudTeacher.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		else
		{
			PrintWriter pd=resp.getWriter();
			pd.write("Invalid credential");
			
			RequestDispatcher rd=req.getRequestDispatcher("DeleteTeacher.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}


}
