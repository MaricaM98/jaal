package com.example.jaal.codiceFiscale;

import java.util.ArrayList;
import java.util.Arrays;

public class CfGeneratore {

	public static String cfCognome(String cognome) {
		String cognomeUp = cognome.toUpperCase();
		String vocali = "AEIOU";
		StringBuilder vocaliC = new StringBuilder();
		StringBuilder consonantiC = new StringBuilder();
		int i = 0;
		int j = 0;
		while (j < vocali.length() && i < cognomeUp.length()) {
			if (cognomeUp.charAt(i) != vocali.charAt(j)) {
				j++;
			} else if (cognomeUp.charAt(i) != vocali.charAt(j)) {
				consonantiC.append(cognomeUp.charAt(i));
				i++;
			} else {
				vocaliC.append(cognomeUp.charAt(i));
				i++;
				j = 0;
			}
			while (j == vocali.length() - 1 && i < cognomeUp.length() - 1) {
				if (cognomeUp.charAt(i) != vocali.charAt(vocali.length() - 1)) {
					consonantiC.append(cognomeUp.charAt(i));
					i++;
					j = 0;
				} else {
					vocaliC.append(cognomeUp.charAt(i));
					i++;
					j = 0;
				}

			}
		}
		// SB solo con le lettere del cognome necessarie
		if (consonantiC.length() < 3) {
			do {
				consonantiC.append(vocaliC.charAt(i));
			} while (consonantiC.length() < 3);
		} else if (consonantiC.length() > 3) {
			consonantiC.delete(3, consonantiC.length());
		}

		return consonantiC.toString();
	}

	public static String cfNome(String nome) {
		String nomeUp = nome.toUpperCase();
		String vocali = "AEIOU";
		StringBuilder vocaliN = new StringBuilder();
		StringBuilder consonantiN = new StringBuilder();
		int i = 0;
		int j = 0;
		while (j < vocali.length() && i < nomeUp.length()) {
			if (nomeUp.charAt(i) != vocali.charAt(j)) {
				j++;
			} else if (nomeUp.charAt(i) != vocali.charAt(j)) {
				consonantiN.append(nomeUp.charAt(i));
				i++;
			} else {
				vocaliN.append(nomeUp.charAt(i));
				i++;
				j = 0;
			}
			while (j == vocali.length() - 1 && i < nomeUp.length() - 1) {
				if (nomeUp.charAt(i) != vocali.charAt(vocali.length() - 1)) {
					consonantiN.append(nomeUp.charAt(i));
					i++;
					j = 0;
				} else {
					vocaliN.append(nomeUp.charAt(i));
					i++;
					j = 0;
				}

			}
		}
		// SB solo con le lettere del nome necessarie
		if (consonantiN.length() < 3) {
			do {
				consonantiN.append(vocaliN.charAt(i));
			} while (consonantiN.length() < 3);

		} else if (consonantiN.length() > 3) {
			consonantiN.delete(4, consonantiN.length());
			consonantiN.deleteCharAt(1);
		}

		return consonantiN.toString();
	}

	public static String cfAnno(String anno) {
		String annoNascita = anno.substring(anno.length() - 2, anno.length());
		return annoNascita;
	}

	public static String cfMese(String mese) {
		String[] mesiNum = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] mesiLettere = { "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto",
				"Settembre", "Ottobre", "Novembre", "Dicembre" };
		String[] codiciMesi = { "A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S", "T" };
		StringBuilder cM = new StringBuilder();
		for (int i = 0; i < 12; i++) {
			if (mese == mesiNum[i] || mese == mesiLettere[i]) {
				cM.append(codiciMesi[i]);
			}

		}

		String result = cM.toString();
		return result;
	}

	public static String cfGiorno(String giorno, char sex) {
		StringBuilder gg = new StringBuilder();
		int numGiorno = Integer.parseInt(giorno);
		if (sex == 'F') {
			numGiorno += 40;
			gg.append(numGiorno);
		} else if (sex == 'M' && numGiorno < 10) {
			gg.append("0" + numGiorno);
		} else {
			gg.append(numGiorno);
		}
		return gg.toString();
	}

	public static String cfComuneNascita(String comune) {
		String[] comuni = { "Gioia del colle", "Santeramo in colle", "Pompei" };
		String[] codiciCatastali = { "E038", "I330", "G813" };
		StringBuilder codiceComune = new StringBuilder();
		for (int i = 0; i < comuni.length; i++) {
			if (comune.equalsIgnoreCase(comuni[i])) {
				codiceComune.append(codiciCatastali[i]);
			}
		}
		return codiceComune.toString();
	}

	public static String codiceFiscale(String cognome, String nome, String mese, String anno, char sex, String giorno,
			String comuneNascita) {
		StringBuilder cf = new StringBuilder();
		cfNome(nome);
		cfCognome(cognome);

		for (int i = 0; i < cfCognome(cognome).length(); i++) {
			cf.append(cfCognome(cognome).charAt(i));
		}
		cf.toString();

		for (int i = 0; i < cfNome(nome).length(); i++) {
			cf.append(cfNome(nome).charAt(i));
		}
		cf.append(cfAnno(anno) + cfMese(mese) + cfGiorno(giorno, sex) + cfComuneNascita(comuneNascita));
		String codiceFiscale = cf.toString() + codiceControllo(cf.toString());
		return codiceFiscale;
	}

	public static String codiceControllo(String codiceFiscale) {
		char[] lettere = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int[] numDispari = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24,
				23 };
		int[] numeri = new int[26];
		int sum = 0;
		int i = 0;
		int j = 0;
		StringBuilder parteNumericaPari = new StringBuilder();
		StringBuilder parteNumericaDispari = new StringBuilder();
		for (i = 0; i < numeri.length; i++) {
			numeri[i] = i;
		}
		StringBuilder pari = new StringBuilder();
		StringBuilder dispari = new StringBuilder();
		for (i = 0; i < codiceFiscale.length(); i++) {
			if ((i + 1) % 2 == 0) {
				pari.append(codiceFiscale.charAt(i));
			} else {
				dispari.append(codiceFiscale.charAt(i));
			}
		}

		for (i = 0; i < pari.length(); i++) {
			if (Character.isDigit(pari.toString().charAt(i))) {
				parteNumericaPari.append(pari.toString().charAt(i));
			}
		}
		String parteNumPari = parteNumericaPari.toString();
		int[] numP = new int[parteNumPari.length()];
		for (i = 0; i < parteNumPari.length(); i++) {
			numP[i] = Integer.parseInt(String.valueOf(parteNumPari.charAt(i)));
		}
		i = 0;
		while (j < numP.length && i < numeri.length) {
			if (numP[j] != numeri[i]) {
				i++;
			} else {
				sum += numP[j];
				j++;
				i = 0;
			}
		}

		i = 0;
		j = 0;
		while (j < pari.toString().length() && i < lettere.length) {
			if (pari.toString().charAt(j) != lettere[i]) {
				i++;
			} else {
				sum += numeri[i];
				j++;
				i = 0;
			}

			while (j < pari.toString().length() - 1 && i == lettere.length - 1) {
				if (pari.toString().charAt(j) != lettere[i]) {
					j++;
					i = 0;
				} else {
					sum += numeri[i];
					j++;
					i = 0;
				}

			}
		}
		i = 0;
		j = 0;
		while (j < dispari.length() && i < lettere.length) {
			if (dispari.toString().charAt(j) != lettere[i]) {
				i++;
			} else {
				sum += numDispari[i];
				j++;
				i = 0;
			}
			while (j < dispari.length() - 1 && i == lettere.length - 1) {
				if (dispari.toString().charAt(j) != lettere[i]) {
					j++;
					i = 0;
				} else {
					sum += numDispari[i];
					j++;
					i = 0;
				}

			}

		}

		for (i = 0; i < dispari.length(); i++) {
			if (Character.isDigit(dispari.toString().charAt(i))) {
				parteNumericaDispari.append(dispari.toString().charAt(i));
			}
		}
		String pn = parteNumericaDispari.toString();
		int[] numD = new int[pn.length()];
		for (i = 0; i < pn.length(); i++) {
			numD[i] = Integer.parseInt(String.valueOf(pn.charAt(i)));
		}

		i = 0;
		j = 0;
		while (j < numD.length && i < numeri.length) {
			if (numD[j] != numeri[i]) {
				i++;
			} else {
				sum += numDispari[i];
				j++;
				i = 0;
			}
		}
		int codice = sum % 26;
		String cc = Integer.toString(codice);
		for (i = 0; i < numeri.length; i++) {
			if (codice == numeri[i]) {
				cc = Character.toString(lettere[i]);
			}
		}

		return cc;
	}

}
