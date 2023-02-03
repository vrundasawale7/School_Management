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

	@WebServlet("/updatedatateacher")
	public class UpdateTeacherLast extends HttpServlet
	{
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		    String id=req.getParameter("id");
			String name=req.getParameter("name");
			String sub=req.getParameter("sub");
			String sal=req.getParameter("sal");
			
			int id1=Integer.parseInt(id);
			double sal1=Double.parseDouble(sal);
			
			Teacher t=new Teacher();
			t.setId(id1);
			t.setName(name);
			t.setSub(sub);
			t.setSal(sal1);
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("vrunda");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.merge(t);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("Student is updated...!");
			
			RequestDispatcher rd=req.getRequestDispatcher("crudTeacher.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
	}


}
