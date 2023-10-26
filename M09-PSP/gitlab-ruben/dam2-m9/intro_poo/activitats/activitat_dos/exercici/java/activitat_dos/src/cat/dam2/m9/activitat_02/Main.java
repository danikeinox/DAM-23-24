package cat.dam2.m9.activitat_02;

import cat.dam2.m9.activitat_02.excepctions.EMailException;
import cat.dam2.m9.activitat_02.excepctions.NTelefonException;
import cat.dam2.m9.activitat_02.excepctions.NomException;
import cat.dam2.m9.activitat_02.utils.Utils;

public class Main {
    private static final int MAX_TEL = 9;
    private static final String DEFAULT_FILE = "resultat.txt";

    public static void main(String[] args) {
        String nom, tel, email;
        try {
            nom = readNom();
            tel = readTel();
            email = readEmail();
            System.out.println("Els valors introduïts són \n");
            System.out.printf("Nom: %s\n Telèfon: %s\n Correu: %s\n", nom, tel, email);

            Utils.saveToFile(DEFAULT_FILE, String.format("Nom: %s\n Telèfon: %s\n Correu: %s\n", nom, tel, email));

        } catch (NomException | NTelefonException | EMailException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readNom() throws NomException {
        String nom = Utils.inputString("Introdueix el teu nom: ");
        if (nom.isEmpty()) {
            throw new NomException("El valor introduït no és vàlid");
        }
        return nom;
    }

    private static String readTel() throws NTelefonException {
        String tel = Utils.inputString("Introdueix el teu nombre de telèfon: ");
        if (tel.length() < MAX_TEL) {
            throw new NTelefonException("Els nombre de telèfon han de ser de " + MAX_TEL + " caràcters");
        }
        return tel;
    }

    private static String readEmail() throws EMailException {
        String email = Utils.inputString("Introdueix el teu correu electrònic: ");
        if (!Utils.validateEmail(email)) {
            throw new EMailException("El format del correu electrònic no es correcte.");
        }
        return email;
    }
}