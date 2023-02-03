package School;

import java.io.IOException;

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
@WebServlet("/addprincipal")
public class AddPrincipal  extends HttpServlet
	{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name= req.getParameter("name");
		String age= req.getParameter("age");
		String mobno=req.getParameter("mobno");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		int age1=Integer.parseInt(age);
		long mobno1=Long.parseLong(mobno);
		
		Principal p=new Principal();
		p.setName(name);
		p.setAge(age1);
		p.setMobno(mobno1);
		p.setEmail(email);
		p.setPassword(password);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vrunda");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
		
	}
	

}
