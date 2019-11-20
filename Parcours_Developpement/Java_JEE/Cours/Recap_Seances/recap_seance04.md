* débug des classes basses (bdd) et métiers

  * @proxy(lazy=false)

  * ou dans le fichier context.xml : <hibernate>

  * mentionné <import ressource=classpath:***projet-***context.xml>

* projet web MVC

  * 3 fichiers de configuration (qui viennent compléter le pom.xml (nécessaire  à MAVEN))

    * web.xml

      * fichier "minimum"

      * mapping d'url "/" pour démarrer l'application Spring

    * servlet-context.xml

      * viewresolver

        * construit le chemin d'accès aux JSP

    * root-context.xml

      * correspond au fichier de configuration des beans

  * utilisation des Controllers

    * @RequestMapping

      * avec ou sans paramètres @RequestParam (optionnel ou obligatoire)

      * return

        * new ModelAndView (classe originelle, assez lourd )

          * String nom de la JSP

          * préciser un "nom" associé au

          * Model contenant le dictionnaire (ou les données en général)

        * Model (remplace ModelAndView, plus simple à mettre en oeuvre)

          * passé en argument de la méthode du contrôleur

          * transmis de façon transparente à la JSP cible

        * String correspondant au nom de la JSP (utilisation de prefix et suffix pour localiser la JSP)