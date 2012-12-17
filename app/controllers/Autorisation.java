package controllers;

import models.Groupe;
import models.Message;
import models.Utilisateur;
import play.Logger;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;

public class Autorisation extends Security.Authenticator {

	@Override
	public String getUsername(Context ctx) {
		return ctx.session().get("mail");
	}

	@Override
	public Result onUnauthorized(Context ctx) {
		return redirect(routes.ApplicationAuthentification.login());
	}

	public static boolean isAdmin() {
		Logger.info("user email: " + Context.current().session().get("mail"));
		if (Context.current().session().get("mail")
				.equals("guillaume@sample.com")) {
			Logger.info("hello admin!!!");
			return true;
		}
		Logger.info("Sorry! u r not the admin!!!");
		return false;
	}

	public static boolean isOwnerMessge(Long idMsg) {
		Logger.info("user email: " + Context.current().session().get("mail"));
		String mail = Context.current().session().get("mail");
		Message msg = Message.findMsgById(idMsg);
		Logger.info("owner message email: " + msg.getUser().getMail());
		if (msg.getUser().getMail().equals(mail)) {
			Logger.info("Ok u can delete your message!!!");
			return true;
		}
		Logger.info("Sorry u can't delete the message!!!");
		return false;
	}

	public static boolean isOwnerCompte(Long idCompte) {
		Logger.info("user email: " + Context.current().session().get("mail"));
		String mail = Context.current().session().get("mail");
		Utilisateur util = Utilisateur.findUserById(idCompte);
		Logger.info("owner compte email: " + util.getMail());
		if (util.getMail().equals(mail)) {
			Logger.info("Ok u can delete your compte!!!");
			return true;
		}
		Logger.info("Sorry u can't delete the compte!!!");
		return false;
	}

	public static boolean isOwnerGroupe(Long idGroupe) {
		Logger.info("user email: " + Context.current().session().get("mail"));
		String mail = Context.current().session().get("mail");
		Groupe grp = Groupe.findGroupeById(idGroupe);
		Logger.info("owner groupe email: " + grp.getUserAdmin().getMail());
		if (grp.getUserAdmin().getMail().equals(mail)) {
			Logger.info("Ok u can delete your groupe!!!");
			return true;
		}
		Logger.info("Sorry u can't delete the groupe!!!");
		return false;
	}

}