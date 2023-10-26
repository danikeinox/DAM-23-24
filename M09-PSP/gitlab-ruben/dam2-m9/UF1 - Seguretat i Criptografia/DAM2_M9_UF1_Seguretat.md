# Seguretat

[TOC]

## Introducció

La seguretat en el desenvolupament de programari engloba una sèrie de pràctiques, tècniques i processos dissenyats per protegir el codi, les dades i les operacions en un sistema o aplicació. Aquí tenim diversos aspectes clau de la seguretat:

1. Control d'accés.
2. Gestió d'errors.
3. Disseny segur d'aplicacions.

## Control d'accés

El control d'accés és el procés de garantir que els recursos del sistema estan accessibles només per a les persones o sistemes autoritzats, i inaccessibles per a aquells no autoritzats. Això es fa per protegir la informació i mantenir la integritat i confidencialitat dels sistemes.

1. **Tipus de Control d'Accés**:
    - **Autenticació**: Verifica la identitat d'un usuari.
    - **Autorització**: Determina quins recursos pot accedir un usuari autenticat.
    - **Auditoria**: Registra qui accedeix a què i quan.

2. **Mecanismes de Control d'Accés**:
    - **Control d'Accés Basat en Rols (_RBAC_)**: Aquest tipus de control d'accés és ampliament utilitzat i es basa en atorgar accés als usuaris segons els seus rols assignats. S'apliquen polítiques de seguretat per limitar els privilegis, ja sigui per accedir a dades o recursos del sistema. L'escalada de privilegis és una amenaça empresarial interna greu, amb conseqüències significatives, especialment econòmiques, i les empreses han de prestar-hi atenció.
    - **Control d'Accés Discrecional (_DAC_)**: Aquest tipus de control d'accés permet al propietari de les dades decidir qui pot accedir-hi i amb quins permisos, basat en les regles que especifica. S'utilitza en molts sistemes operatius i ofereix flexibilitat, ja que els propietaris poden controlar i canviar l'accés als seus recursos quan ho desitgin.
    - **Control d'Accés Mandatari (_MAC_)**: Aquest tipus de control d'accés és centralitzat i més arbitrari que altres models. L'autoritat central o una organització reguladora estableix les regulacions i etiquetes per als recursos. Els usuaris reben permisos basats en aquestes etiquetes, com "confidencial" o "alt secret", i l'administrador decideix els seus rols d'accés. Aquest sistema ofereix una capa addicional de seguretat mitjançant etiquetes i polítiques de control d'accés. Els usuaris no poden canviar els seus rols en aquest model d'accés obligatori.
    - **Control d'Accés basat en Atributs (_ABAC_)**: Aquest tipus de control d'accés es diferencia pel fet que assigna atributs als usuaris i recursos, com l'hora, la ubicació i altres dades, que es tenen en compte per a decidir quan concedir o limitar l'accés. És un mètode dinàmic que s'adapta a les circumstàncies i als usuaris per a determinar els permisos d'accés de manera flexible.


### Exemple: implementació de control d'accés basat en rols

```java
public class ControlAccesBasatRols {

    public static void main(String[] args) {
        Usuari user = new Usuari("Alice", "admin");
        executarTasca(user, "configuraSistema");
    }

    public static void executarTasca(Usuari user, String tasca) {
        if (user.getRol().equals("admin") && tasca.equals("configuraSistema")) {
            configuraSistema();
        } else {
            System.out.println("Accés denegat");
        }
    }

    public static void configuraSistema() {
        System.out.println("Sistema configurat correctament");
    }

    static class Usuari {
        private String nom;
        private String rol;

        public Usuari(String nom, String rol) {
            this.nom = nom;
            this.rol = rol;
        }

        public String getRol() {
            return rol;
        }
    }
}
```

## Gestió d'errors

La gestió d'errors consisteix en identificar, respondre i reportar errors que ocorren mentre un programa està en execució. Un bon maneig d'errors pot ajudar a prevenir la caiguda del sistema i proporcionar retroalimentació útil als usuaris i als desenvolupadors.

1. **Excepcions**:
    - En Java, les excepcions són la principal manera de gestionar errors. Una excepció és un objecte que representa un error o una condició inusual.

2. **Tipus d'Excepcions**:
    - **Excepcions Comprovades (Checked Exceptions)**: Són situacions que un programa hauria d'anticipar i capturar.
    - **Excepcions No Comprovades (Unchecked Exceptions)**: Són errors que ocorren durant l'execució que generalment no es poden anticipar.

3. **Captura i Llançament d'Excepcions**:
    - **try-catch**: Utilitzat per capturar i gestionar excepcions.
    - **throw**: Utilitzat per llançar una excepció manualment.
    - **finally**: Bloc que s'executa independentment de si es llança una excepció o no.

### Exemples:

#### Captura d'excepcions
```java
public class GestioErrorsExemple {
    public static void main(String[] args) {
        try {
            // Intentem executar un mètode que pot llançar una excepció
            int resultat = divideix(10, 0);
        } catch (ArithmeticException e) {
            // Capturamos l'excepció i imprimim un missatge d'error
            System.err.println("Error aritmètic: " + e.getMessage());
        }
    }

    /**
     * Realitza la divisió de dos números i llança una excepció si el divisor és zero.
     * @param num1 El dividend
     * @param num2 El divisor
     * @return El resultat de la divisió
     * @throws ArithmeticException si el divisor és zero
     */
    public static int divideix(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divisió per zero no permesa");
        }
        return num1 / num2;
    }
}
```

#### Bloc try-catch-finally
```java
public class TryCatchFinallyExemple {
    public static void main(String[] args) {
        try {
            // Intentem accedir a un índex fora de rang en un array
            int[] arr = new int[5];
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Capturamos l'excepció i imprimim un missatge d'error
            System.err.println("Índex fora de rang: " + e.getMessage());
        } finally {
            // Bloc que s'executa independentment de si es llança una excepció o no
            System.out.println("Execució del bloc finally");
        }
    }
}
```

#### Llançament d'excepcions personalitzades
```java
public class LlancamentExcepcionsExemple {
    public static void main(String[] args) {
        try {
            // Intentem executar un mètode que pot llançar una excepció
            verificaEdatPerVotar(16);
        } catch (ExcepcioEdat e) {
            // Capturamos l'excepció i imprimim el missatge associat
            System.err.println(e.getMessage());
        }
    }

    /**
     * Verifica si una persona pot votar basat en la seva edat.
     * @param edat L'edat de la persona
     * @throws ExcepcioEdat si la persona és menor d'edat per votar
     */
    public static void verificaEdatPerVotar(int edat) throws ExcepcioEdat {
        if (edat < 18) {
            throw new ExcepcioEdat("Has de tenir almenys 18 anys per votar. Edat proporcionada: " + edat);
        } else {
            System.out.println("Pots votar!");
        }
    }

    /**
     * Classe d'excepció personalitzada per gestionar errors d'edat.
     */
    static class ExcepcioEdat extends Exception {
        public ExcepcioEdat(String missatge) {
            super(missatge);
        }
    }
}
```

## Disseny segur d'aplicacions

El disseny segur és crucial per prevenir vulnerabilitats i assegurar que les aplicacions són robustes davant d'atacs malintencionats. A continuació, es presenten diversos criteris i pràctiques per a la creació de codi segur:

### Criteris de creació de codi segur:
1. **Minimització de l'atac surface**: Redueix les parts del sistema que estan exposades a possibles atacs limitant l'accés a recursos i funcionalitats.
2. **Principi de menor privilegi**: Assigna a cada mòdul o usuari només els privilegis necessaris per realitzar les seves tasques.
3. **Validació d'entrada**: Valida totes les entrades per assegurar que són correctes abans de processar-les.
4. **Gestió d'errors**: Gestiona els errors de manera que no revelin informació sensible.
5. **Xifratge**: Utilitza tècniques de xifratge per protegir les dades en repòs i en trànsit.
6. **Autenticació i autorització fortes**: Implementa mecanismes robusts d'autenticació i autorització.
7. **Auditoria i logging**: Mantén registres detallats de les accions del sistema i els accessos dels usuaris.

### Recomanacions pràctiques de disseny segur en Java:
1. **Utilitza APIs segures**: Prefereix APIs que promoguin la seguretat, com `java.security`.
2. **Gestiona les excepcions**: Captura i gestiona les excepcions de manera segura per evitar la divulgació d'informació sensible.
3. **Valida les entrades**: Utilitza expressions regulars i altres mètodes de validació per assegurar que les entrades són segures.
4. **Utilitza HTTPS**: Utilitza HTTPS per protegir les dades en trànsit entre el client i el servidor.
5. **Actualitza les llibreries**: Mantén les llibreries i frameworks actualitzats per beneficiar-te de les últimes millores de seguretat.
6. **Utilitza sempre _prepared statements_**: evitaràs els actacs [SQL injection](https://ca.wikipedia.org/wiki/Injecci%C3%B3_SQL).

### Eines i recursos d'anàlisi de codi:
1. **Tests unitaris**:
    - Són tests que verifiquen la correcta funcionalitat de petites unitats de codi.
    - Utilitza frameworks com JUnit per escriure i executar tests unitaris en Java.
2. **Anàlisi estàtic de codi**:
    - Examinen el codi sense executar-lo per identificar possibles problemes.
    - Eines com FindBugs o SonarQube poden ajudar a identificar vulnerabilitats i mala pràctica de codi.
3. **Anàlisi dinàmic de codi**:
    - Analitza el codi mentre s'executa per identificar comportaments inesperats.
    - Eines com OWASP ZAP proporcionen anàlisi dinàmica de codi.
    - Utitliza eines de _code coverage_ per ebrinar quin codi s'utilitza i quin no.
4. **Desenvolupament guiat per gests ([TDD](https://ca.wikipedia.org/wiki/Desenvolupament_guiat_per_proves))**:
    - És un mètode de desenvolupament que enfatitza la creació de tests abans del codi.
    - Promou la creació de codi ben estructurat i testejable, millorant la seguretat i la mantenibilitat.

### Top 10 proactive controls [OWASP 2018](https://owasp.org/www-project-proactive-controls/)

1. **Defineix Requisits de Seguretat (Define Security Requirements)**:
   - Aquest control suggereix que s'han de definir clarament els requisits de seguretat abans de desenvolupar una aplicació. Això inclou identificar i protegir les dades sensibles, així com definir com es gestionaran les autenticacions i les sessions.

2. **Aprofita els Marcos i Biblioteques de Seguretat (Leverage Security Frameworks and Libraries)**:
   - Aquest control promou l'ús de marcos i biblioteques de seguretat per evitar haver de reinventar la roda. Això pot incloure l'ús de biblioteques per a la validació d'entrada, l'escapament d'output, i altres funcions de seguretat crítiques.

3. **Accés Segur a la Base de Dades (Secure Database Access)**:
   - Aquest control suggereix l'ús de consultes parametritzades per evitar injeccions SQL, així com l'ús d'autenticació forta i xifrat per a l'accés a la base de dades.

4. **Codifica i Escapa Dades (Encode and Escape Data)**:
   - Aquest control enfatitza la importància de codificar i escapar dades per prevenir atacs com l'injecció de codi i l'injecció d'SQL.

5. **Valida Totes les Entrades (Validate All Inputs)**:
   - Aquest control recomana validar totes les entrades de l'usuari per assegurar-se que estan dins d'un rang acceptable abans d'utilitzar-les en l'aplicació.

6. **Implementa la Identitat Digital (Implement Digital Identity)**:
   - Aquest control descriu com gestionar la identitat digital dels usuaris, incloent la autenticació, la gestió de sessions, i la recuperació segura de contrasenyes. També descriu diferents nivells d'autenticació segons el risc associat amb l'aplicació.
7. **Aplicar Controls d'Accés (Enforce Access Controls)**
   - Aquest punt tracta sobre posar regles per a qui pot accedir a què dins l'aplicació. Per exemple, garantir que només puguis veure les teves pròpies fotos en una app, o que només els administradors puguin accedir a certes àrees.

8. **Protegir les Dades a Tot Arreu )Protect Data Everywhere)**
   - Això significa assegurar-se que les teves dades estiguin segures, no importa on es trobin: mentre viatgen per internet, mentre estan guardades o mentre les estàs utilitzant. Com a exemple, quan envies un missatge a un amic a través d'una app, les dades estarien "en trànsit" i haurien d'estar xifrades perquè ningú més pugui llegir-les.

9. **Implementar Registre i Monitorització de Seguretat (Implement Security Logging and Monitoring)**
   - Aquest punt parla de tenir un sistema que anoti (registri) i vigili activitats sospitoses. Això seria com tenir càmeres de seguretat que enregistressin tot el que passa, i algú que revisi les gravacions per captar activitats sospitoses.

10. **Gestionar Tots els Errors i Excepcions (Handle All Errors and Exceptions)**
    - Quan programem, a vegades les coses no van com esperàvem i es produeixen errors. Aquest punt es refereix a tenir plans sobre com gestionar aquests errors de manera que no causin problemes majors, com ara caigudes del sistema o, pitjor encara, accessos no autoritzats a parts sensibles de l'aplicació.

### Tecnologies  d'autenticació

En el món digital d'avui, garantir la seguretat i la privacitat de les dades és d'una importància crucial. Una de les maneres com es fa això és a través de l'autenticació, que és el procés de verificar la identitat d'un usuari o sistema. Les tecnologies d'autenticació han evolucionat ràpidament al llarg dels anys per abordar els desafiaments creixents i les amenaces de seguretat. En aquest apartat, explorarem tres tecnologies d'autenticació modernes: OAuth, JWT (JSON Web Tokens) i Biometria. Cada una d'aquestes tecnologies ofereix avantatges i desavantatges únics que les fan adequades per a diferents escenaris i requisits de seguretat. L'elecció de la tecnologia d'autenticació correcta pot ser crucial per garantir una experiència d'usuari segura i eficaç.

#### 1. [OAuth (Open Authorization)](https://ca.wikipedia.org/wiki/OAuth)

   OAuth és un estàndard per a l'autenticació i autorització basades en tokens a internet. En termes més senzills, permet a una aplicació accedir a informació específica d'una altra aplicació (com el teu compte de Facebook o Google) sense compartir les credencials.

   *  **Avantatges**
     - **Seguretat**: Utilitzant OAuth, les aplicacions poden accedir a les dades sense exposar les teves credencials, afegint una capa extra de protecció.
     - **Estandarditzat**: És un protocol estandarditzat, la qual cosa significa que segueix un conjunt específic de regles que molts serveis diferents accepten.
     - **Control**: Permet a l'usuari controlar quines aplicacions tenen accés a les seves dades sense compartir la seva contrasenya.

   * **Desavantatges**
     - **Complexitat**: Pot ser complex d'entendre i implementar.
     - **Dependència**: Depèn d'un servidor d'autorització, que podria ser un punt de fallada potencial.
     - **Ampliació de l'Abast**: Amb el temps, el protocol pot ampliar-se en excés, la qual cosa pot portar a implementacions no interoperables.


#### 2. [JWT (JSON Web Tokens)](https://ca.wikipedia.org/wiki/JSON_Web_Token)

   JWT és un mitjà compacte i segur per URL per representar reclamacions que han de ser transferides entre dues parts. Essencialment, JWT permet una manera per a les parts d'intercanviar reclamacions de seguretat de manera compacta i autònoma.

   * **Avantatges**
     - **Compacte**: Els JWT són petits i es poden transmetre fàcilment a través de l'URL, paràmetre POST o dins d'una capçalera HTTP.
     - **Autònom**: Conté tota la informació necessària sobre l'usuari, evitant la necessitat de consultar la base de dades més d'una vegada.
     - **Flexibilitat**: Es poden utilitzar amb OAuth per crear sistemes d'autenticació segurs i flexibles.

   * **Desavantatges**
     - **Emmagatzematge**: Poden requerir una manera d'emmagatzemar el token de manera segura al costat del client.
     - **Sense estat**: Són sense estat, així que si un token es veu compromès, es pot utilitzar en qualsevol lloc i en qualsevol moment fins que caduqui.


#### 3. [Biometria](https://ca.wikipedia.org/wiki/Identificaci%C3%B3_biom%C3%A8trica)

   L'autenticació biomètrica utilitza característiques físiques o de comportament úniques per verificar la identitat d'una persona.

   * **Avantatges**
     - **Alta seguretat**: És difícil falsificar o duplicar informació biomètrica com ara empremtes dactilars o escaneigs de retina.
     - **Facilitat d'ús**: Sovint és més ràpid i fàcil d'utilitzar que recordar una contrasenya.

   * **Desavantatges**
     - **Preocupacions per la privacitat**: Algunes persones poden trobar-ho invasiu.
     - **Taxes d'error**: Els sistemes biomètrics poden tenir falsos positius o negatius.


