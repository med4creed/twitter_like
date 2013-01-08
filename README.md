twitter_like
============

Notice d'utilisation & Cas d'utilisation :

Notice d'utilisation�:
====

Pour acc�der au service du site, il faut se connecter en tant que membre ou administrateu. 
Des identifiants pour ces deux statuts sont cr��s � la g�n�ration du site gr�ce au fichier initial-data.yml.

L�administrateur du site est le membre ayant pour email : guillaume@sample.com
Les identifiants de connexion sont donc :
- Email : guillaume@sample.com
- Pass : 1234

Trois autres membres sont cr��s par d�faut, ils poss�dent tous le m�me mot de passe : 1234
Leurs emails de connexion sont : 
- maxime@sample.com
- sadek@sample.com
- erwan@sample.com



US�:
====
User Stories


En tant qu�utilisateur, je cr�e un compte afin de pouvoir m�identifier :
- se rendre sur le site
- si l�utilisateur n�est pas connect�, le renvoyer sur la page de connexion 
- cliquer sur s�inscrire
- attendre le chargement du formulaire d�inscription
- saisir un pseudo, email, nom, pr�nom et son mot de passe
- attendre que le syst�me valide l�unicit� du pseudo et de l�adresse mail
- redirection sur la page de connexion


En tant qu�utilisateur, je me connecte au site afin d�acc�der � ses fonctionnalit�s :
- se rendre sur le page de connexion du site
- rentrer son identifiant (email) et son mot de passe
- cliquer sur le bouton se connecter
- attendre la v�rification syst�me de la pr�sence de l'identifiant dans la BDD
- attendre la v�rification syst�me que le mot de passe saisit corresponde � celui dans la BDD
- connexion valid�e, session cr��e
- redirection sur la page d�affichage de tous les messages


En tant qu�utilisateur, je me d�connecte afin de fermer ma session
- cliquer sur le lien �D�connexion� pr�sent dans le menu en haut � gauche
- attendre que le syst�me supprime mes identifiants de session et me redirige vers la page de d�connexion
- un message confirme la d�connexion


En tant qu�utilisateur, je peux consulter mon compte afin de v�rifier mes informations de compte :
- cliquer sur le lien �afficher� dans le menu de gauche
- attendre le chargement de la page et consulter mes informations de compte


En tant qu�utilisateur, je peux modifier mon compte afin de mettre � jour mon profil :
- cliquer sur le lien �afficher� dans le menu de gauche
- attendre le chargement de la page et consulter mes informations de compte
- modifier le formulaire en dessous des informations en remplissant les champs choisit (nom, pr�nom, pseudo)
- attendre que le syst�me valide le formulaire et recharge la page
- consulter les modifications effectu�es


En tant qu�utilisateur, je supprime mon compte afin de ne plus appara�tre sur le site :
- cliquer sur le lien �mon profil� dans le menu secondaire
- cliquer sur le bouton �supprimer mon compte� en bas de mon profil
- attendre que le syst�me supprime mon compte et mes identifiants de session
- je suis redirig� sur la page de connexion avec un message de validation


En tant qu�utilisateur, je poste un message afin de le partager avec les autres utilisateurs :
- cliquer sur le lien �poster un message� dans le menu secondaire
- attendre l�affichage du formulaire de cr�ation de message
- saisir son message
- cliquer sur le bouton �poster�
- attendre que le syst�me v�rifie la validit� du message
- le message est �dit�


En tant qu�utilisateur, je souhaite consulter mes messages :
- cliquer sur les liens �Tous mes messages� dans le menu de gauche
- attendre le chargement de la page
- consulter les messages affich�s


En tant qu�utilisateur, je supprime un message afin qu�il n�apparaisse plus sur le site :
- consulter un de ses messages en naviguant sur le site ou sur le lien �Tous mes messages�
- cliquer sur le bouton supprimer pr�sent juste en dessous du texte du message
- attendre que le syst�me v�rifie que l�on est bien le propri�taire du message
- le message est supprim�


En tant qu�utilisateur, je peux consulter le profil d�un membre afin d�obtenir plus d�informations sur lui :
- cliquer sur le lien �afficher profil� en bas du message d�un utilisateur
- attendre que le syst�me me redirige vers la page de l�utilisateur souhait�
- consulter son profil


En tant qu�utilisateur, je veux cr�er un groupe afin de partager des messages sur un th�me pr�cis :
- cliquer sur le lien �cr�er un groupe� du menu gauche
- attendre le chargement du formulaire de cr�ation d�un groupe
- remplir le nom du groupe souhait�
- attendre que le syst�me v�rifie le formulaire
-  attendre le rechargement de la page et consulter son groupe dans la liste de groupe

En tant qu�utilisateur, je veux consulter mes groupes afin de lister tous les groupes que j�ai cr��s :
- cliquer sur le lien �Mes groupes� dans le menu de gauche
- attendre le chargement de la page et l�affichage de ma liste de groupe
- consulter mes groupes

En tant qu�utilisateur, je peux consulter mon groupe afin de voir tous les messages post�s sur celui-ci :
- cliquer sur �Mes groupes� dans le menu de gauche
- attendre le chargement de tous mes groupes
- cliquer sur le bouton �Consulter� en bas du groupe choisi
- consulter les messages de mon groupe

En tant qu�utilisateur, je souhaite supprimer mon groupe afin d�effacer tous ses messages :
- cliquer sur �Mes groupes� dans le menu de gauche
- attendre le chargement de tous mes groupes
- cliquer sur le bouton �Consulter� en bas du groupe choisi
- attendre la suppression du groupe par le syst�me


En tant qu�utilisateur, je consulte la liste des utilisateurs afin de conna�tre les membres inscrits sur le site :
-  cliquer sur le lien �lister� dans le menu secondaire 
- attendre le chargement de la liste de tous les utilisateurs
- consulter les informations de tous les membres


En tant qu�utilisateur, je consulte le profil d�un membre afin d�avoir plus d�information sur celui-ci :
- cliquer sur le lien �lister� dans le menu secondaire pour consulter la liste des membres inscrits sur le site
- s�lectionner un utilisateur en cliquant sur le bouton profil de celui-ci
- lire sa description sur la page de son profil


En tant qu�utilisateur, je peux consulter les messages de tous les utilisateurs :
- cliquer sur le lien �Tous les messages� dans le menu de gauche
- attendre le chargement de la page
- consulter tous les messages


En tant qu�utilisateur, je veux consulter les messages d�un utilisateur :
- cliquer sur le lien �Utilisateur� du menu de gauche
- attendre le chargement de la page de tous les utilisateurs
- cliquer sur le bouton �Lire ses messages� de l�utilisateur choisi
- attendre le chargement de sa liste de messages
- consulter ses messages s�il en a d�j� post�


En tant qu�utilisateur, je peux consulter les autres groupes afin de les d�couvrir :
- cliquer sur le lien �Tous les groupes� du menu de gauche
- cliquer sur le bouton �Consulter� sur le groupe choisi
- attendre le chargement de la page du groupe
- consulter les messages


En tant qu�utilisateur, je peux rejoindre un groupe afin d�y participer :
- cliquer sur le lien �Tous les groupes� du menu de gauche
- cliquer sur le bouton �Rejoindre� sur le groupe choisi
- attendre la validation sur syst�me
- je peux afficher ce groupe sur la page �Mes groupes�


En tant qu�utilisateur, je peux poster un message dans un groupe pour partager avec les membres de ce groupe :
- cliquer sur le lien �Tous les groupes� du menu de gauche
- cliquer sur le bouton �Consulter� du groupe choisi
- attendre l�affichage du formulaire
- remplir le formulaire
- attendre la validation du formulaire par le syst�me
- consulter mon message apr�s le rechargement de la page par le syst�me


En tant qu�administrateur, je peux supprimer un compte :
- afficher la liste des utilisateurs gr�ce au lien �Utilisateur� du menu de gauche
- cliquer sur le bouton �Supprimer� en bas de son profil
- attendre la suppression du compte par le syst�me puis le rechargement de la page


En tant qu�administrateur, je souhaite supprimer un message afin de faire respecter la charte du site :
- cliquer sur le bouton �Supprimer� en bas des messages d�un utilisateur
- attendre la suppression du message par le syst�me puis le rechargement de la page


En tant qu�administrateur, je souhaite supprimer un groupe afin de faire respecter la charte du site :
- cliquer sur le lien �Tous les groupes� du menu gauche
- attendre le chargement de la liste des groupes
- consulter les groupes
- cliquer sur le bouton �Supprimer� en bas du groupe choisi
- attendre la suppression du groupe par le syst�me
