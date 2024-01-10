Vente de voiture d'occasion

Admin: 
	-IdPersonne
	-Nom 
	-Prenom
	-Mail
	-Contact
	-motdepass : crypté
	-vola

Personne:
	-IdPersonne
	-Nom 
	-Prenom
	-sexe
	-dateNaissance
	-Mail
	-Contact
	-motdepass : crypté
	-CIN
	-type de compte : Vendeur / client  

Catégorie:
	-IdCatégorie
	-designation (4x4 , SUV , .... )

Marque:
	-IdMarque
	-designation

Model:
	-IdModel
	-IdMarque
	-IdCategorie
	-designation

Voiture:
	-idVoiture
	-idPersonne(Proprietaire)
	-idModel
	-couleur
	-plaque d'immatriculation
	-Etat: /10
	-prix
	

DetailVoiture:
	-idVoiture
	-date: 
	-Desciption : (Text)
	
Statut Voiture:
	-idSatut
	-idVoiture
	-Date
	-Statut : (10-19 Vendu ,  20 -29 En atente de validation, ) 
			10 vendu fa mbola tsy livré
			11 vendu sady livré
			......
			(Annonce)

Transaction:
	-idTransaction
	-idVoiture
	-idPersonne (Mivarotra)
	-idPersonne (Mividy)
	-prix
	-date

OptionVoiture:
	-idVoiture
	-designation(

Caisse: 
	-idTransaction
	-dateTransaction
	-montant
	-Type (Debiteur, 

Favoris:
	-idAnonce
	-idPersonne
	-dateAjout

Back office:
	CRUD categorie,Model, voiture---
	login Admin
	Validation annonce

Front office :
	Filtre par catégorie + model + couleur 
	Liste des annonces récentes (Date -1mois)
	List des annonces Favoris(mila login)

Caractéristique voiture:

Voiture:
Marque,Model,

voiture:
	modele: sportage
		marque=KIA
		categorie=VOITURE de plaisir,...

	modele:starex
		marque:hyundai
		categorie:voiture familiale 

------------------------------Partie Dylan---------------------------------------
->Back office
	Annonce + vente
->Front office
	Annonce + vente

 -----------------------------Partie Prisca------------------------------------
 ->Back office from

------------------------------Message mongoDB
-Notification FIREBASE
