# projet_backend_PFE
Web application for internal management of IT equipment at BMCI. Features include equipment tracking, user roles, affectation requests, technical interventions, and reporting. Built with React (frontend), Spring Boot (backend), and MySQL (database).

1.1 Objectif Principal
Développer une application web de gestion complète d'un parc informatique permettant l'inventaire, le suivi des interventions et la génération de rapports automatisés.
1.2 Objectifs Spécifiques
Centraliser l'inventaire de tous les équipements informatiques
Automatiser le processus de gestion des interventions techniques
Optimiser l'assignation des tâches aux techniciens
Générer des rapports et statistiques en temps réel
Sécuriser l'accès aux données avec un système d'authentification
Faciliter la prise de décision grâce aux indicateurs de performance

 
2.  OUTILS ET TECHNOLOGIES
2.1 Technologies Backend
Langage : Java
Framework : Spring Boot 3.x
Base de données : MySQL  
ORM : JPA/Hibernate
2.2 Technologies Frontend
Runtime : Node.js
Framework : React.js/Vue.js/Tailwind CSS/Lucide Icons /Recharts/Vite
Bibliothèques : Axios, Chart.js
2.3 Outils de Développement
IDE : IntelliJ IDEA (Backend) / VS Code (Frontend)
Serveur local : Embedded Tomcat (Spring Boot)
Contrôle de version : Git
Test API : Postman
2.4 Environnement de Déploiement
Serveur web : Apache/Nginx
Hébergement : Localhost (développement)

3. TYPES D'UTILISATEURS
3.1 Administrateur
Profil : Responsable informatique, Chef de service IT Permissions : Accès complet au système Responsabilités : Gestion globale, configuration, supervision
3.2 Technicien
Profil : Technicien informatique, Support technique Permissions : Accès limité aux interventions Responsabilités : Exécution des interventions, mise à jour des statuts

4.  FONCTIONNALITÉS PRINCIPALES
4.1 Pour l'Administrateur
 Authentification et Sécurité :
Connexion sécurisée avec email/mot de passe
Gestion des comptes utilisateurs
Définition des rôles et permissions
 Gestion des Équipements :
CRUD Équipements : Ajouter, modifier, supprimer, consulter
Catégorisation : Classement par type (PC, imprimante, serveur...)
Affectation : Attribution aux départements
Suivi d'état : En service, en panne, hors service, stocké
Historique : Traçabilité complète des modifications
Gestion Organisationnelle :
Départements : Création et gestion des services
Techniciens : Ajout et gestion des intervenants
Catégories : Types d'équipements et d'interventions
 Gestion des Interventions :
Création : Nouvelle demande d'intervention
Assignation : Attribution automatique ou manuelle aux techniciens
Suivi : Monitoring en temps réel des statuts
Validation : Approbation des solutions proposées
4.2 Pour le Technicien
 Dashboard Personnel(si j’ai le temps) :
Interventions assignées : Liste des tâches en cours
Calendrier : Planning des interventions
Priorités : Classement par urgence
 Gestion des Interventions
Consultation : Détails des interventions assignées
Mise à jour statut : En cours, terminée, reportée
Solutions : Saisie des actions réalisées
Historique : Accès aux interventions précédentes

5. STATISTIQUES ET RAPPORTS :
5.1 Tableaux de Bord
Dashboard  : Vue d'ensemble temps réel
Indicateurs  : Nombre d'équipements, interventions actives
Graphiques : Évolution des pannes, répartition par département
5.2 Rapports Automatisés
Rapports d'Inventaire
Liste complète des équipements par département
État du parc informatique (fonctionnel/défaillant)
Équipements par catégorie et localisation
Historique des acquisitions
 Rapports d'Interventions
Interventions par technicien et période
Temps de résolution moyen par type de panne
Taux de récurrence des problèmes
Performance des techniciens
Rapports Managériaux
Coût des interventions par département
Équipements nécessitant un remplacement
Charge de travail des techniciens
Tendances d'évolution du parc
5.3 Export de Données
Formats : PDF, Excel, CSV
Planification : Rapports automatiques périodiques
Personnalisation : Filtres par date, département, technicien

6 . CONCEPTION ET ARCHITECTURE
6.1 Architecture Technique
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   Frontend  	│◄──►│	Backend   	│◄──►│   Base de   	│
│   (Node.js) 	│	│  (Spring Boot)   │	│   Données   	│
│   React/Vue 	│	│    Java      	│	│   (MySQL)   	│
└─────────────────┘    └──────────────────┘    └─────────────────┘
6.2 Modèle de Base de Données
Tables principales :
utilisateurs : Comptes système
equipements : Inventaire du parc
interventions : Suivi des opérations
departements : Structure organisationnelle
techniciens : Ressources humaines
Relations :
Un équipement → Un département
Une intervention → Un équipement + Un technicien
Traçabilité complète avec historique
6.3 Interface Utilisateur
Design moderne : Interface épurée et intuitive
Responsive : Adaptation desktop
Navigation : Menu contextuel selon le rôle utilisateur

7. SÉCURITÉ ET CONTRAINTES
7.1 Sécurité
Authentification : Hash des mots de passe (bcrypt)
Autorisation : Contrôle d'accès basé sur les rôles
Sessions : Gestion sécurisée des connexions
Validation : Vérification des données côté serveur
7.2 Contraintes Techniques
Performance : Temps de réponse acceptable
Compatibilité : Navigateurs modernes
Architecture : Séparation frontend/backend
7.3 Contraintes Fonctionnelles
Intuitivité : Interface utilisable facilement
Fiabilité : Sauvegarde des données importantes

 
 
 
8. CONCLUSION
Ce projet de Système de Gestion de Parc Informatique répond à un besoin réel des organisations modernes. Il permettra de démontrer la maîtrise des technologies web modernes (Spring Boot, Node.js, MySQL) tout en résolvant une problématique concrète.
Objectif final : Livrer une application web complète, avec une API REST robuste et une interface utilisateur moderne, démontrant les compétences en développement full-stack.
