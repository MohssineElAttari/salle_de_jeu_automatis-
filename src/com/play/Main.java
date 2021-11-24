package com.play;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static String[] posts = { "POSTE 1:Xbox", "POSTE 2:Xbox", "POSTE 3:Xbox", "POSTE 4:PS5", "POSTE 5:PS5",
			"POSTE 6:Nintendo", "POSTE 7:Nintendo" };

	static Boolean[] postsAvailibility = { true, true, true, true, true, true, true };

	static String[] gamesByPost = { "FIFA:PES 2020", "Tarazan:PES 2020:Counter-Strike", "FIFA", "FIFA:Counter-Strike",
			"PES 2020:Counter-Strike", "FIFA:Counter-Strike", "PES 2020:Counter-Strike" };

	public static ArrayList<String> dureePost;

	static ArrayList<ArrayList<String>> listDureePost = new ArrayList<ArrayList<String>>();

	static int postsAvailable[] = new int[7];

	static int cmp;

	public static ArrayList<String> newValue;

	static ArrayList<ArrayList<String>> personList = new ArrayList<ArrayList<String>>();

	public static int[] getindexPost(String nameGame) {
		cmp = 0;
		for (int index = 0; index < gamesByPost.length; index++) {
			if (gamesByPost[index].contains(nameGame)) {
				postsAvailable[cmp] = index;
				cmp++;
				// System.out.println("Found at " + posts[index]);
			}
		}
		return postsAvailable;
	}

	public static int postDispo(int postsAvailable[]) {
		int postDispo = 0;
		for (int index = 0; index < postsAvailable.length; index++) {
			if (postsAvailibility[postsAvailable[index]] == true) {
				postDispo = postsAvailable[index];
				// System.out.println(postsAvailibility[postsAvailable[index]]);

				// postsAvailable = new int[7];
				// System.out.pr
				// System.out.print(postDispo);
				return postDispo;
			} else {
				System.out.println(posts[postsAvailable[index]] + " ce post est n'est pas disponible");
			}

		}
		return postDispo;

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

	public static int choixDuree(int choix) {
		int duree = 0;
		switch (choix) {
		case 1:
			duree = 30;
			break;
		case 2:
			duree = 1 * 60;
			break;
		case 3:
			duree = 2 * 60;
			break;
		case 4:
			duree = 5 * 60;
			break;
		case 5:
			duree = 24 * 60;
			break;
		default:
			break;
		}
		return duree;
	}

	public static void addPost(LocalTime heurD, LocalTime heurF, int indexPost) {
		dureePost = new ArrayList<String>();
		dureePost.add(heurD + "");
		dureePost.add(heurF + "");
		dureePost.add(indexPost + "");
		listDureePost.add(dureePost);
		System.out.println(listDureePost);
		postsAvailibility[indexPost] = false;

	}

	public static LocalTime heureFin(LocalTime heurD, int duree) {
		LocalTime hF = heurD.plusMinutes(duree);
		System.out.println(hF);
		return hF;

	}

	public static Boolean testHF(LocalTime hF) {
		LocalTime startA = LocalTime.of(9, 00);
		LocalTime stopA = LocalTime.of(12, 00);
		LocalTime startB = LocalTime.of(2, 00);
		LocalTime stopB = LocalTime.of(20, 00);
		
		Boolean containsNow = (((!hF.isBefore(startA)) && (hF.isBefore(stopA)))
				|| ((!hF.isBefore(startB)) && (hF.isBefore(stopB))));
		return containsNow;

	}

	public static void addNewGamer() {
		String reponse;
		int reponse1;
		do {
			Scanner sc = new Scanner(System.in);
			// System.out.println(personList);
			newValue = new ArrayList<String>();
			// System.out.println(personList);

			System.out.println("***** ajouter au nouveux joueur *****");
			System.out.println("1 - Entrer l'heure de d�but : ");
			int heureD = sc.nextInt();
			System.out.println("2 - Entrer les minutes de d�but : ");
			int minD = sc.nextInt();
			newValue.add(heureD + " : " + minD);
			LocalTime heurD = LocalTime.of(heureD, minD);
			System.out.println("3 - P�riode horaire : ");
			int choixDuree = menulistDuree();
			int PeriodeHoraire = choixDuree(choixDuree);
			newValue.add(PeriodeHoraire + "");
			System.out.println("6 - le jeu choisi : ");
			String jeuChoisi = choixJeu(menuDesJeux());
			newValue.add(jeuChoisi);
			int array[] = getindexPost(jeuChoisi);
			int indexPostD = postDispo(array);
			newValue.add(posts[indexPostD]);
			LocalTime hF = heureFin(heurD, PeriodeHoraire);
			boolean testHf = testHF(hF);
			System.out.println(testHf);
			if (testHf) {
				addPost(heurD, hF, indexPostD);
			} else {
				System.out.println("la salle des jeux n'est pas disponible dans cette periode");
			}
			System.out.println("7 - Pr�nom : ");
			String prenom = sc.next();
			newValue.add(prenom);
			System.out.println("8 - Nom : ");
			String nom = sc.next();
			newValue.add(nom);
			System.out.println(posts[indexPostD] + " effectuee par le joueur " + prenom);

			comp++;
			String codeJoueur = nom + comp;
			newValue.add(String.valueOf(codeJoueur));
			personList.add(newValue);
			System.out.println(personList);

			// payMontant(choixDuree);
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
		System.out.println("Tu peux choisie la Dur�e :");
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
			System.out.println("Cette dur�e n'est pas disponible");
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

	public static int payMontant(int nombre) {
		switch (nombre) {
		case 1:
			System.out.println("Veuiller paye le montant n�cessaire ==> 5DH");
			break;
		case 2:
			System.out.println("Veuiller paye le montant n�cessaire ==> 10DH");
			break;
		case 3:
			System.out.println("Veuiller paye le montant n�cessaire ==> 18DH");
			break;
		case 4:
			System.out.println("Veuiller paye le montant n�cessaire ==> 40DH");
			break;
		case 5:
			System.out.println("Veuiller paye le montant n�cessaire ==> 65DH");
			break;
		}
		return choix;

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

}
