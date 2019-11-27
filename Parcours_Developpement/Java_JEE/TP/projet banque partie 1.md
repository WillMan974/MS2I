# TP projet banque:

objectifs, mise en oeuvre :

* formulaires vides (création) et existant (modification)

* lien avec bdd

* spring-security pour la partie admin

* url spécifiques : /admin/ et /client/

* AOP pour la gestion de comptes, virements, clients, 

* views (liste des comptes, liste des clients, données d'un compte, données d'un client)

```
existant :
* Banque-bdd
* Classes de test afin de tester toutes les méthodes
 Client
 ajouterClient
 rechercherClient
 rechercherTousLesclient
Compte
ajouterCompte
rechercheCompteParNumero
rechercherComptesClient
modifierCompte

* Banque-métier
* Classes de test afin de tester toutes les méthodes
banqueService 
authentifier
mesComptes
virement
* Banque-www
à faire : rajouter les dépendances aux deux projets précédents
```

## 

```
* création du menu principal du projet
	* opérations clients
		* liste des clients (admin)
		* création (admin)
	* opérations comptes
		* liste des comptes (user, admin)
		* création (admin)
* client
	* formulaire de création de client (admin)
* compte
	* formulaire de création de compte (admin)
		* association du compte créé à un client (admin)
```

## projet banque (suite)

```
* virements entre comptes (user, admin)
	* vérifications à rajouter
 vérification : solde suffisant pour le compte source
(gestion du découvert  si tout a été fait)

* url
/admin/creerCompte
/admin/modifierCompte (associer à un client) + option effacerCompte (vérif solde=0)
/admin/creerClient
/admin/modifierClient
/admin/associerClientCompte
/admin/connexion (verifier qu'un client ne peut pas se connecter pour faire ces opérations)

/client/consulterComptes
/client/virement
/client/authentification (?)

```