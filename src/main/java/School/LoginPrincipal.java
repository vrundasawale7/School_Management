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
	@WebServlet("/abcd")
	public class LoginPrincipal extends HttpServlet
	{
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String email=req.getParameter("email");
		  String password=req.getParameter("password");
		  
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("vrunda");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
		  Query q=em.createQuery("select p from Principal p where p.email=?1 and p.password=?2");
		  
		  q.setParameter(1, email);
		  q.setParameter(2, password);
		  
		  List<Principal> principal=q.getResultList();
		  
		  if(principal.size()>0)
		  {
			  RequestDispatcher rd=req.getRequestDispatcher("StudentTeacher.html");
			  rd.forward(req, resp);
		  }
		  else {
			  PrintWriter pd=resp.getWriter();
			  pd.write("Invalid credential");
			  
			  RequestDispatcher rd=req.getRequestDispatcher("login.html");
			  rd.include(req, resp);
			  resp.setContentType("text/html");
		  }
			  
	}
	

}
