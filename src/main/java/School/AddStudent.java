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

	@WebServlet("/sstudent")
	public class AddStudent extends HttpServlet
	{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String fees=req.getParameter("fees");
		
		int id1=Integer.parseInt(id);
		double fees1=Double.parseDouble(fees);
				
		Student s=new Student();
		s.setId(id1);
		s.setName(name);
		s.setStream(stream);
		s.setFees(fees1);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vrunda");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		
		PrintWriter pd=resp.getWriter();
		pd.write("Student is added....!");
		
		RequestDispatcher rd=req.getRequestDispatcher("crudStudent.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
				
	}
	}

