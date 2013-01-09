package controllers;

import com.avaje.ebeaninternal.server.type.LongToTimestampConverter;

import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ApplicationAuthentification extends Controller {

	static Form<Login> loginForm = form(Login.class);
	static Form<Utilisateur> userForm = form(Utilisateur.class);

	public static Result index() {
		return ok(views.html.login.render("Veuillez vous identifier !",
				loginForm));
	}
	
	
	public static Result index2() {
		return ok(views.html.signup.render("Veuillez vous identifier !", userForm));

	}

	public static boolean validationLogin(String email, String mdp) {
		if (Utilisateur.findByLogin(email, mdp) != null) {
			return true;
		}
		return false;
	}

	// login
	public static Result login() {
		Form<Login> filledForm = loginForm.bindFromRequest();
		
		Login login = filledForm.get();
		Utilisateur currentUser = null;
		if (!validationLogin(login.getMail(), login.getMdp())) {
			flash("error", "Mauvais identidiants");
			return redirect(routes.ApplicationAuthentification.index());
			
		} else {
			currentUser = Utilisateur.findByLogin(login.getMail(),
					login.getMdp());
			flash("success", "Vous êtes connecté!!!");
			session().put("mail", currentUser.getMail());
			session().put("id", Long.toString(currentUser.getId()));
		}
		return redirect(routes.ApplicationMessages.getAllMessages());
	}

	// logout
	public static Result logout() {
		session().clear();
		flash("success", "Vous etes déconnecté.");
		return redirect(routes.ApplicationAuthentification.login());
	}

	// classe d'Login
	public static class Login {
		private String mail;
		private String mdp;

		public Login() {
		}

		public Login(String mail, String mdp) {
			this.mail = mail;
			this.mdp = mdp;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getMdp() {
			return mdp;
		}

		public void setMdp(String mdp) {
			this.mdp = mdp;
		}

		@Override
		public String toString() {
			return "Login [mail=" + mail + ", mdp= ****** ]";
		}

	}

}

