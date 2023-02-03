	package School;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.Query;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	@WebServlet("/xyzzz")
	public class UpdateStudentfirst extends HttpServlet
	{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String id=req.getParameter("id");
		
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vrunda");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
	     Student s=	em.find(Student.class, id1);
	     
	     if(s!=null)
	     {
	     HttpSession hs=req.getSession();
	     hs.setAttribute("updatedata", s);
	     
	     RequestDispatcher rd=req.getRequestDispatcher("UpdateSt.jsp");
	     rd.forward(req, resp);
	     }
	     else
	     {
	    	    PrintWriter pw=resp.getWriter();
				pw.write("Invalid credential...!");
				
		    	RequestDispatcher rd=req.getRequestDispatcher("updateStudentfirst.html");
				rd.include(req, resp);
				resp.setContentType("text/html");
	     }
	}
	

}
