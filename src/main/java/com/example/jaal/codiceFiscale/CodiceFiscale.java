package com.example.jaal.codiceFiscale;

public class CodiceFiscale {
	public static void main(String[] args) {
		String cognome = "Scognamiglio";
		String nome = "Vincenzo";
		String giornoNascita = "02";
		String meseNascita = "07";
		String annoNascita = "1995";
		String comuneNascita = "Pompei";
		char sex = 'M';
		String vc = CfGeneratore.codiceFiscale(cognome, nome, meseNascita, annoNascita, sex, giornoNascita, comuneNascita);
//		String vc = CfGeneratore.cfCognome(cognome) + CfGeneratore.cfNome(nome) + CfGeneratore.cfAnno(annoNascita) + CfGeneratore.cfMese(meseNascita) + CfGeneratore.cfGiorno(giornoNascita, sex) + CfGeneratore.cfComuneNascita(comuneNascita);
		String consonantiVocaliCognome = CfGeneratore.cfCognome(cognome);
		System.out.println(vc);

	}
}
