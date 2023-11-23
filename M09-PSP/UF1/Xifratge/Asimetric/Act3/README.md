# CRIPTOGRAFIA ASIMÈTRICA

---
## Com s'ha creat el programa?
### Inicialitzem el programa:
- Obrim el Main.java en aquest cas:
  - Iniciem amb un `while(true)` perquè el programa entri en un bucle,
  on situarem el menu principal.
  - Afegim la funció **privada** `menu()` perquè mostri per pantalla el menu de
  forma visual i quedi més estètic, seguit preguntem amb la funció 
  `scanner` el número emmagatzemat a la variable `option` com input 
  que escollirà l'usuari.
    -  ```java
       // Classe Main + inicialització Scanner (static)
       public class Main {
       static Scanner scan = new Scanner(System.in);
       
       public static void main(String[] args) {
       
       }
       ```
     
    -  ```java
       // Funcio menu()
       private static void menu() {
        System.out.println("" +
                "+-----------------------------------------+\n" +
                "|            e·ni-gm·a system             |\n" +
                "+----------------------------------------+|\n" +
                "| 1. Generar un nou parell de claus       |\n" +
                "| 2. Mostra la clau pública               |\n" +
                "| 3. Mostra la clau privada               |\n" +
                "| 4. Signar un document                   |\n" +
                "| 5. Verificar la signatura d'un document |\n" +
                "| 6. Sortir                               |\n" +
                "+-----------------------------------------+\n");
       }
  - Realitzem un `switch(option)` on a cada `case` asignem el número
  corresponent del menu, seguit amb la incialització de la funció
  pertinent a cada punt tot dins de la funció main.
    -  ```java
       public static void main(String[] args) throws NoSuchAlgorithmException {
          while (true) {
              menu();
              System.out.print("Selecciona una opció: ");
              int option = scan.nextInt();
              switch (option) {
                  case 1:
                      generaClaus();
                      break;
                  case 2:
                      System.out.println("La clau pública es: " + publicKey);
                      break;
                  case 3:
                      System.out.println("La clau privada es: " + privateKey);
                      break;
                  case 4:
                      signaDocument();
                      break;
                  case 5:
                      verificaSignature();
                      break;
                  case 6:
                      System.out.println("Sortint de l'aplicació...");
                      System.exit(0);
                      break;
                  default:
                      System.out.println("Opció no válida.");
              }
          }
       }
       ```
---
### Afegim les classes assignades en el `main()`: 
- Seguit creem un nou directori o `package` en aquest cas anomenat
`"classes"` on crearem una única classe on afegirem totes les funcions
afegides anteriorment en el `main()`, es podria fer una classe per cada
funció per tenir el códi més organitzat i visualment correcte, però en
aquest càs únicament utilitzarem 5, per tant, no sería molt difícil llegir
el códi.

#### Accedir a el README.md del directori classes:
- [README de les Funcions Asimètriques](./src/main/java/daniel/Cabrera/classes/)

---


## Informació tècnica utilizada

**IDE:** 
- IntelliJ Professional

**Llenguatge**
- Java (SDK Coretto-11)

**Imports:** 
- java.util
- java.security
- daniel.Cabrera.classes.Claus.* 


## Autor

- [@danikeinox](https://www.github.com/danikeinox)

