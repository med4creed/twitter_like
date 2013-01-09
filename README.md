twitter_like
============

Notice d'utilisation & Cas d'utilisation :

Notice d'utilisation :
====

Pour accéder au service du site, il faut se connecter en tant que membre ou administrateu. 
Des identifiants pour ces deux statuts sont créés à la génération du site grâce au fichier initial-data.yml.

L’administrateur du site est le membre ayant pour email : guillaume@sample.com
Les identifiants de connexion sont donc :
- Email : guillaume@sample.com
- Pass : 1234

Trois autres membres sont créés par défaut, ils possèdent tous le même mot de passe : 1234
Leurs emails de connexion sont : 
- maxime@sample.com
- sadek@sample.com
- erwan@sample.com



US :
====
User Stories


En tant qu’utilisateur, je crée un compte afin de pouvoir m’identifier :
- se rendre sur le site
- si l’utilisateur n’est pas connecté, le renvoyer sur la page de connexion 
- cliquer sur s’inscrire
- attendre le chargement du formulaire d’inscription
- saisir un pseudo, email, nom, prénom et son mot de passe
- attendre que le système valide l’unicité du pseudo et de l’adresse mail
- redirection sur la page de connexion


En tant qu’utilisateur, je me connecte au site afin d’accéder à ses fonctionnalités :
- se rendre sur le page de connexion du site
- rentrer son identifiant (email) et son mot de passe
- cliquer sur le bouton se connecter
- attendre la vérification système de la présence de l'identifiant dans la BDD
- attendre la vérification système que le mot de passe saisit corresponde à celui dans la BDD
- connexion validée, session créée
- redirection sur la page d’affichage de tous les messages


En tant qu’utilisateur, je me déconnecte afin de fermer ma session
- cliquer sur le lien “Déconnexion” présent dans le menu en haut à gauche
- attendre que le système supprime mes identifiants de session et me redirige vers la page de déconnexion
- un message confirme la déconnexion


En tant qu’utilisateur, je peux consulter mon compte afin de vérifier mes informations de compte :
- cliquer sur le lien “afficher” dans le menu de gauche
- attendre le chargement de la page et consulter mes informations de compte


En tant qu’utilisateur, je peux modifier mon compte afin de mettre à jour mon profil :
- cliquer sur le lien “afficher” dans le menu de gauche
- attendre le chargement de la page et consulter mes informations de compte
- modifier le formulaire en dessous des informations en remplissant les champs choisit (nom, prénom, pseudo)
- attendre que le système valide le formulaire et recharge la page
- consulter les modifications effectuées


En tant qu’utilisateur, je supprime mon compte afin de ne plus apparaître sur le site :
- cliquer sur le lien “mon profil” dans le menu secondaire
- cliquer sur le bouton “supprimer mon compte” en bas de mon profil
- attendre que le système supprime mon compte et mes identifiants de session
- je suis redirigé sur la page de connexion avec un message de validation


En tant qu’utilisateur, je poste un message afin de le partager avec les autres utilisateurs :
- cliquer sur le lien “poster un message” dans le menu secondaire
- attendre l’affichage du formulaire de création de message
- saisir son message
- cliquer sur le bouton “poster”
- attendre que le système vérifie la validité du message
- le message est édité


En tant qu’utilisateur, je souhaite consulter mes messages :
- cliquer sur les liens “Tous mes messages” dans le menu de gauche
- attendre le chargement de la page
- consulter les messages affichés


En tant qu’utilisateur, je supprime un message afin qu’il n’apparaisse plus sur le site :
- consulter un de ses messages en naviguant sur le site ou sur le lien “Tous mes messages”
- cliquer sur le bouton supprimer présent juste en dessous du texte du message
- attendre que le système vérifie que l’on est bien le propriétaire du message
- le message est supprimé


En tant qu’utilisateur, je peux consulter le profil d’un membre afin d’obtenir plus d’informations sur lui :
- cliquer sur le lien “afficher profil” en bas du message d’un utilisateur
- attendre que le système me redirige vers la page de l’utilisateur souhaité
- consulter son profil


En tant qu’utilisateur, je veux créer un groupe afin de partager des messages sur un thème précis :
- cliquer sur le lien “créer un groupe” du menu gauche
- attendre le chargement du formulaire de création d’un groupe
- remplir le nom du groupe souhaité
- attendre que le système vérifie le formulaire
-  attendre le rechargement de la page et consulter son groupe dans la liste de groupe

En tant qu’utilisateur, je veux consulter mes groupes afin de lister tous les groupes que j’ai créés :
- cliquer sur le lien “Mes groupes” dans le menu de gauche
- attendre le chargement de la page et l’affichage de ma liste de groupe
- consulter mes groupes

En tant qu’utilisateur, je peux consulter mon groupe afin de voir tous les messages postés sur celui-ci :
- cliquer sur “Mes groupes” dans le menu de gauche
- attendre le chargement de tous mes groupes
- cliquer sur le bouton “Consulter” en bas du groupe choisi
- consulter les messages de mon groupe

En tant qu’utilisateur, je souhaite supprimer mon groupe afin d’effacer tous ses messages :
- cliquer sur “Mes groupes” dans le menu de gauche
- attendre le chargement de tous mes groupes
- cliquer sur le bouton “Consulter” en bas du groupe choisi
- attendre la suppression du groupe par le système


En tant qu’utilisateur, je consulte la liste des utilisateurs afin de connaître les membres inscrits sur le site :
-  cliquer sur le lien “lister” dans le menu secondaire 
- attendre le chargement de la liste de tous les utilisateurs
- consulter les informations de tous les membres


En tant qu’utilisateur, je consulte le profil d’un membre afin d’avoir plus d’information sur celui-ci :
- cliquer sur le lien “lister” dans le menu secondaire pour consulter la liste des membres inscrits sur le site
- sélectionner un utilisateur en cliquant sur le bouton profil de celui-ci
- lire sa description sur la page de son profil


En tant qu’utilisateur, je peux consulter les messages de tous les utilisateurs :
- cliquer sur le lien “Tous les messages” dans le menu de gauche
- attendre le chargement de la page
- consulter tous les messages


En tant qu’utilisateur, je veux consulter les messages d’un utilisateur :
- cliquer sur le lien “Utilisateur” du menu de gauche
- attendre le chargement de la page de tous les utilisateurs
- cliquer sur le bouton “Lire ses messages” de l’utilisateur choisi
- attendre le chargement de sa liste de messages
- consulter ses messages s’il en a déjà posté


En tant qu’utilisateur, je peux consulter les autres groupes afin de les découvrir :
- cliquer sur le lien “Tous les groupes” du menu de gauche
- cliquer sur le bouton “Consulter” sur le groupe choisi
- attendre le chargement de la page du groupe
- consulter les messages


En tant qu’utilisateur, je peux rejoindre un groupe afin d’y participer :
- cliquer sur le lien “Tous les groupes” du menu de gauche
- cliquer sur le bouton “Rejoindre” sur le groupe choisi
- attendre la validation sur système
- je peux afficher ce groupe sur la page “Mes groupes”


En tant qu’utilisateur, je peux poster un message dans un groupe pour partager avec les membres de ce groupe :
- cliquer sur le lien “Tous les groupes” du menu de gauche
- cliquer sur le bouton “Consulter” du groupe choisi
- attendre l’affichage du formulaire
- remplir le formulaire
- attendre la validation du formulaire par le système
- consulter mon message après le rechargement de la page par le système


En tant qu’administrateur, je peux supprimer un compte :
- afficher la liste des utilisateurs grâce au lien “Utilisateur” du menu de gauche
- cliquer sur le bouton “Supprimer” en bas de son profil
- attendre la suppression du compte par le système puis le rechargement de la page


En tant qu’administrateur, je souhaite supprimer un message afin de faire respecter la charte du site :
- cliquer sur le bouton “Supprimer” en bas des messages d’un utilisateur
- attendre la suppression du message par le système puis le rechargement de la page


En tant qu’administrateur, je souhaite supprimer un groupe afin de faire respecter la charte du site :
- cliquer sur le lien “Tous les groupes” du menu gauche
- attendre le chargement de la liste des groupes
- consulter les groupes
- cliquer sur le bouton “Supprimer” en bas du groupe choisi
- attendre la suppression du groupe par le système
