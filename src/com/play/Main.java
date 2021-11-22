package com.play;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static String[] posts = { "POSTE 1:Xbox", "POSTE 2:Xbox", "POSTE 3:Xbox", "POSTE 4:PS5", "POSTE 5:PS5",
			"POSTE 6:Nintendo", "POSTE 7:Nintendo" };

	static Boolean[] postsAvailibility = { true, true, true, true, true, true, true };

	static String[] gamesByPost = { "FIFA:PES 2020", "Tarazan:PES 2020:Counter-Strike", "FIFA", "FIFA:Counter-Strike",
			"PES 2020:Counter-Strike", "FIFA:Counter-Strike", "PES 2020:Counter-Strike" };

	static int postsAvailable[] = new int[7];
	static int cmp ;

	public static ArrayList<String> newValue;
	static ArrayList<ArrayList<String>> personList = new ArrayList<ArrayList<String>>();

	public static int[] getindexPost(String nameGame) {
		cmp = 0;
		for (int index = 0; index < gamesByPost.length; index++) {
			if (gamesByPost[index].contains(nameGame)) {
				postsAvailable[cmp] = index;
				cmp++;
				//System.out.println("Found at " + posts[index]);
			}
		}
		return postsAvailable;
	}

	public static int postDispo(int postsAvailable[]) {
		int postDispo = 0;
		for (int index = 0; index < postsAvailable.length; index++) {
			if (postsAvailibility[postsAvailable[index]] == true) {
				postDispo = postsAvailable[index];
				//System.out.println(postsAvailibility[postsAvailable[index]]);
				postsAvailibility[postsAvailable[index]] = false;
				//postsAvailable = new int[7];
				//System.out.pr
				//System.out.print(postDispo);
				return postDispo;

			}else {
				System.out.println(posts[postsAvailable[index]] + " ce post est n'est pas disponible");
			}
			
			
		}
		return postDispo;
		

	}

//update
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// menu();

		System.out.println("");

		for (int index = 0; index < cmp; index++) {
			System.out.println("Found at " + postsAvailable[index]);

		}

		addNewGamer();
	}

	static String valider = "";
	static int choix;
	static int pay;
	static int choixJeuFinal;
	static int choixDureeFinal;
	static int comp = 56670;

	public static String choixJeu(int choix) {
		String nomJeux = "";
		switch (choix) {
		case 1:
			nomJeux = "FIFA";
			break;
		case 2:
			nomJeux = "PES";
			break;
		case 3:
			nomJeux = "Counter-Strike";
			break;
		case 4:
			nomJeux = "Assassin's Creed";
			break;
		default:
			break;
		}
		return nomJeux;
	}

	public static String choixDuree(int choix) {
		String duree = "";
		switch (choix) {
		case 1:
			duree = "30 min";
			break;
		case 2:
			duree = "1 heure";
			break;
		case 3:
			duree = "2 heures";
			break;
		case 4:
			duree = "5 heures";
			break;
		case 5:
			duree = "joueur de luxe";
			break;
		default:
			break;
		}
		return duree;
	}

	public static void addNewGamer() {
		String reponse;
		int reponse1;
		do {
			Scanner sc = new Scanner(System.in);
			//System.out.println(personList);
			newValue = new ArrayList<String>();
			//System.out.println(personList);

			System.out.println("***** ajouter au nouveux joueur *****");

			System.out.println("1 - Prénom : ");
			String prenom = sc.nextLine();
			newValue.add(prenom);

			System.out.println("2 - Nom : ");
			String nom = sc.nextLine();
			newValue.add(nom);

			//System.out.println("3 - N° de poste libre : ");
			//int choix = valideChoix();
			// int nPostL = Integer.parseInt(choix);
			

			System.out.println("4 - Heure de début (ex:09:40 ...) : ");
			String heureD = sc.nextLine();
			newValue.add(heureD);

			System.out.println("5 - Période horaire : ");
			int choixDuree = menulistDuree();
			String PeriodeHoraire = choixDuree(choixDuree);
			newValue.add(PeriodeHoraire);

			System.out.println("6 - le jeu choisi : ");
			String jeuChoisi = choixJeu(menuDesJeux());

			int array[] = getindexPost(jeuChoisi);
			int indexPostD = postDispo(array);
			newValue.add(posts[indexPostD]);
			System.out.println(posts[indexPostD] + " effectuee par le joueur" + prenom);
			
			newValue.add(jeuChoisi);
			comp++;
			String codeJoueur = nom + comp;
			// System.out.println(nom.charAt(0));

			newValue.add(String.valueOf(codeJoueur));

			personList.add(newValue);
			System.out.println(personList);
			payMontant(choixDuree);
			String autreJoueur;
			System.out.println("tu veux ajouter nouveau joueur ==> repondre par oui ou non");

			reponse = sc.next();
			reponse1 = Integer.parseInt(reponse);

			System.out.println(reponse1);
			System.out.println(reponse1 == 1);

		} while (reponse1 == 1);
		System.out.println("ok");
	}

//menu des jeux disponibles
	public static int menuDesJeux() {
		System.out.println("Voila la liste des jeux disponibles :");
		System.out.println("Football : \n 1 - FIFA \n 2 - PES ");
		System.out.println("Guerre : \n 3 - Counter-Strike \n 4 - Assassin's Creed");
		int choix = valideChoix();
		return valideChoixDesJeux(choix);
	}

	public static int menulistDuree() {
		System.out.println("Tu peux choisie la Durée :");
		System.out.println("1 - 30 min ==========> 5DH");
		System.out.println("2 - 1h ==========> 10DH");
		System.out.println("3 - 2h ==========> 18DH");
		System.out.println("4 - 5h ==========> 40DH");
		System.out.println("5 - Joueur de luxe ==========> 65DH");
		int choix = valideChoix();
		return valideDuree(choix);
	}

	// fonction pour verifier lorsque le nombre choisie trouver dans la liste des
	// jeux ou non
	public static int valideChoixDesJeux(int nombre) {
		if (nombre <= 0 || nombre > 4) {
			System.out.println("ce choix n'est pas disponible dans la liste des jeux");
			menuDesJeux();
		}
		return nombre;
	}

	public static int valideDuree(int nombre) {
		if (nombre <= 0 || nombre > 5) {
			System.out.println("Cette durée n'est pas disponible");
			menulistDuree();
		}
		return nombre;
	}

	// function pour verifier le type de choix du joueur int ou string
	public static int valideChoix() {
		System.out.println("Entrer Votre Choix : ");
		Scanner sc = new Scanner(System.in);
		String choixTemp = "";
		do {
			valider = "";
			try {

				choixTemp = sc.nextLine();
				choix = Integer.parseInt(choixTemp);

			} catch (Exception e) {
				System.out.println("Choisit un nombre");
				valider = "null";

			}
		} while (valider == "null");
		return choix;
	}

	public static void nvJoueur(String typejeux, int duree) {

	}

	public static int payMontant(int nombre) {
		switch (nombre) {
		case 1:
			System.out.println("Veuiller paye le montant nécessaire ==> 5DH");
			break;
		case 2:
			System.out.println("Veuiller paye le montant nécessaire ==> 10DH");
			break;
		case 3:
			System.out.println("Veuiller paye le montant nécessaire ==> 18DH");
			break;
		case 4:
			System.out.println("Veuiller paye le montant nécessaire ==> 40DH");
			break;
		case 5:
			System.out.println("Veuiller paye le montant nécessaire ==> 65DH");
			break;
		}
		return choix;

	}

}
