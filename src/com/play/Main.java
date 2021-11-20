package com.play;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//update
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//menu();
		addNewGamer();
	}

	static ArrayList<String> newValue = new ArrayList<String>();
	static ArrayList<ArrayList<String>> PersonList = new ArrayList<ArrayList<String>>();

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
		Scanner sc = new Scanner(System.in);

		System.out.println("***** ajouter au nouveux joueur *****");

		System.out.println("1 - Prénom : ");
		String prenom = sc.nextLine();
		newValue.add(prenom);

		System.out.println("2 - Nom : ");
		String nom = sc.nextLine();
		newValue.add(nom);

		System.out.println("3 - N° de poste libre : ");
		String nPostLS = sc.nextLine();
		int nPostL = Integer.parseInt(nPostLS);
		newValue.add(String.valueOf(nPostL));

		System.out.println("4 - Heure de début (ex:09:40 ...) : ");
		String heureD = sc.nextLine();
		newValue.add(heureD);

		System.out.println("5 - Période horaire : ");
		
		String PeriodeHoraire = choixDuree(menulistDuree());
		newValue.add(PeriodeHoraire);

		System.out.println("6 - le jeu choisi : ");
		String jeuChoisi = choixJeu(menuDesJeux());

		newValue.add(jeuChoisi);
		comp++;
		int codeJoueur =  nom.charAt(0) + comp;

		newValue.add(String.valueOf(codeJoueur));
		PersonList.add(newValue);

		System.out.println(PersonList);
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
