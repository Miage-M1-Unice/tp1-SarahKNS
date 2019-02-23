package LaClasse;

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse2 {

	public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
		// Récupération d'un objet de type Class correspondant au nom passé en paramètres
		Class cl = Class.forName(nomClasse);


			afficheEnTeteClasse(cl);

			System.out.println();
			afficheAttributs(cl);

			System.out.println();
			afficheConstructeurs(cl);

			System.out.println();
			afficheMethodes(cl);

			// L'accolade fermante de fin de classe !
			System.out.println("}");
		}
	


	/** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
	public static void afficheEnTeteClasse(Class cl) {
		//  Affichage du modifier et du nom de la classe
		// CODE A ECRIRE
		int N = cl.getModifiers();
		Class clname =cl.getDeclaringClass();
		System.out.println(N + " "  + clname + " ");

		// Récupération de la superclasse si elle existe (null si cl est le type Object)
		Class supercl =  cl.getSuperclass();
		Class cl2 = Object.class;


		// On ecrit le "extends " que si la superclasse est non nulle et
		// différente de Object
		if(supercl != null && supercl != cl2 ) {
			System.out.print(" extends "  + supercl);
		}

		// Affichage des interfaces que la classe implemente
		Class[] clint = cl2.getInterfaces();
		for (Class aninterface : clint){
			System.out.print("\t" + aninterface );
		}

		// Enfin, l'accolade ouvrante !
		System.out.print(" {\n");
	}

	public static void afficheAttributs(Class cl) {
		System.out.println("Affiche attributs classe :  " );
		Field[] attr = cl.getFields();
		System.out.println("\t" +  attr);
	}

	public static void afficheConstructeurs(Class cl) {
		Constructor[] constr = cl.getConstructors();
		System.out.println("Les constructeurs : " );
		for(Constructor C : constr) {
			System.out.println("\t" + constr);
		}
	}

	public static void afficheMethodes(Class cl) {
		Method[] meth = cl.getMethods();
		System.out.println("Les methodes : ");
		for(Method M:meth) {
			System.out.println("\t" +  M);
		}
	}

	public static String litChaineAuClavier() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) {
		boolean ok = false;

		while(!ok) {
			try {
				System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
				String nomClasse = litChaineAuClavier();
				System.out.println(nomClasse);
				analyseClasse(nomClasse);
				ok = true;
			} catch(ClassNotFoundException e) {
				System.out.println("Classe non trouvée.");
			}catch(IOException e) {
				System.out.println("Erreur d'E/S!");
			}
		}
	}
}
