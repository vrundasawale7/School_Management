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
	import javax.servlet.http.HttpSession;

	@WebServlet("/updateeeee")
	public class UpdateTeacher extends HttpServlet
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
		    HttpSession hs=req.getSession();
		    hs.setAttribute("updateteacherdata", t);
		    
		    
			RequestDispatcher rd=req.getRequestDispatcher("UpdateTeach.jsp");
			rd.forward(req, resp);
		    }
		    else
		    {
		    	PrintWriter pw=resp.getWriter();
				pw.write("Invalid credential...!");
				
		    	RequestDispatcher rd=req.getRequestDispatcher("UpdateTeacherfirst.html");
				rd.include(req, resp);
				resp.setContentType("text/html");
		    }
	}
	

}
