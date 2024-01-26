package web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.CreditMetierImpl;
import metier.ICreditMetier;

@WebServlet(name="cs",urlPatterns={"/controleur","*.php"})

public class ControleurServlet extends HttpServlet {
	private ICreditMetier metier;
		@Override
	public void init() throws ServletException {
			metier= new CreditMetierImpl();
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("creditModel", new CreditModel());
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double montant=Double.parseDouble(req.getParameter("montant"));
		double taux=Double.parseDouble(req.getParameter("taux"));
		int duree=Integer.parseInt(req.getParameter("duree"));

        CreditModel model = new CreditModel();
        model.setMontant(montant);
        model.setDuree(duree);
        model.setTaux(taux);
        double res=metier.calculerMensualiteCredite(montant, taux, duree);
        model.setMensualite(res);
         
       req.setAttribute("creditModel",model);
        
        req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
		
		super.doPost(req, resp);
	}
}
