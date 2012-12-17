package controllers;

import com.avaje.ebeaninternal.server.type.LongToTimestampConverter;

import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ApplicationAuthentification extends Controller {

	static Form<Login> loginForm = form(Login.class);

	public static Result index() {
		return ok(views.html.login.render("Veuillez vous identifier svp!!!",
				loginForm));
		// return ok("boooooooooooooom");
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
			return badRequest(views.html.login.render(
					"Erreur d'authentification, réessayez svp!!!", loginForm));
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
		flash("success", "Vous etes déconnecté!!!");
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
