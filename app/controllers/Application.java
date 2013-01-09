package controllers;

import java.io.Console;
import java.util.List;

import models.Message;
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
			Utilisateur.findUserByEmail("mail");
			
			Utilisateur user = filledForm.get();

			Utilisateur verif_mail = Utilisateur.findUserByEmail(user.getMail());
			Utilisateur verif_pseudo = Utilisateur.findByPseudo(user.getPseudo());
			
			if (verif_mail == null && verif_pseudo == null) {
				Logger.info("Identifiants dispo");
				Utilisateur.createUser(user);
				return redirect(routes.ApplicationAuthentification.index());
			} else {
				flash("error", "Ces identifiants sont déjà utilisés.");
				return redirect(routes.ApplicationAuthentification.index2());	
			}
				
		}
	}
  
}