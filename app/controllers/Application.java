package controllers;

import models.Utilisateur;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
	static Form<Utilisateur> userForm = form(Utilisateur.class);
	
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
	public static Result newUtilisateur() {
		Form<Utilisateur> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			flash("error", "Merci de remplir correctement le formulaire.");
			return redirect(routes.ApplicationAuthentification.index2());	
		}

		else {
			Utilisateur user = filledForm.get();
			Utilisateur.createUser(user);
			return redirect(routes.ApplicationUtilisateurs.getAllUtilisateurs());
		}
	}
  
}