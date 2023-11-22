# FUNCIONS CRIPTOGRAFIA ASIMÈTRICA

---
## Com s'han creat les funcions?

Consta principalment d'una classe anomenada `Claus` amb diverses 
funcions relacionades amb el menu anterior del `main()`.

### Creació de variables generals de la classe `Claus`

### Funció "generaClaus"

Aquesta funció inicialitza el motor d'encriptació i genera un parell de claus
(clau pública i clau privada) utilitzant l'algoritme RSA amb una longitud de
2048 bits. Si ja s'ha generat un parell de claus, es mostrarà un missatge d'avís.

```java
public static void generaClaus() {
        System.out.println("Inicialitzant el motor d'encriptació...");
        if (keyPair == null) {
            System.out.println("INFO: Encara no s'ha generat cap parell de claus. Creant un de nou...");
            keyPair = generateKeyPair();
            guardaClaus();
        } else {
            System.out.println("WARN: Ja s'han generat un parells de claus. No es pot crear de nou...");
        }
    }
```

```java
// Clau privada per generar i inicialitzar el KeyPair
private static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
```

### Funció "guardaClaus"

Aquesta funció guarda el parell de claus generat en les variables "publicKey"
i "privateKey" en format Base64. Si no s'ha generat cap parell de claus, es
mostrarà un missatge d'error.

```java
private static void guardaClaus() {
        if (keyPair != null) {
            PublicKey publicKeyObj = keyPair.getPublic();
            PrivateKey privateKeyObj = keyPair.getPrivate();
            ;

            publicKey = Base64.getEncoder().encodeToString(publicKeyObj.getEncoded());
            privateKey = Base64.getEncoder().encodeToString(privateKeyObj.getEncoded());
        } else {
            System.out.println("ERROR: No s'ha generat cap parell de claus.");
        }
    }
```

### Funció "signaDocument"

Aquesta funció permet signar un document utilitzant la clau privada. 
Primer, es demana a l'usuari que introdueixi la ruta del document a signar. 
A continuació, es llegeix el contingut del document i es calcula la 
signatura utilitzant l'algoritme SHA256 amb RSA. La signatura es 
guarda en un fitxer amb extensió ".sig" i es mostra per pantalla
en format Base64.

```java
public static void signaDocument() throws Exception {
        String ruta = "";
        try {
            if (keyPair != null) {
                System.out.println("Introdueix la ruta del document a signar: ");
                ruta = scan.nextLine();
                while (!Paths.get(ruta).toFile().exists()) {
                    System.out.println("Introdueix una ruta del document a signar vàlida: ");
                    ruta = scan.nextLine();
                }
                if (Files.exists(Paths.get(ruta))) {
                    byte[] bytes = Files.readAllBytes(Paths.get(ruta));
                    Signature signature = Signature.getInstance("SHA256withRSA");
                    signature.initSign(keyPair.getPrivate());
                    signature.update(bytes);
                    byte[] signat = signature.sign();
                    System.out.println("Document signat amb èxit. Signatura (en format base64):");
                    System.out.println("Signatura: " + Base64.getEncoder().encodeToString(signat));
                    Files.write(Paths.get(ruta + ".sig"), signat).toFile();
                    System.out.println("Generat fitxer: " + ruta + ".sig");
                }
            } else {
                System.out.println("ERROR: No s'ha generat cap parell de claus.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

### Funció "verificaSignatura"
Aquesta funció permet verificar la signatura d'un document utilitzant
la clau pública. Primer, es demana a l'usuari que introdueixi
la ruta del document original i la ruta del document amb la signatura.
A continuació, es llegeixen els continguts d'ambdós documents i es verifica
la signatura utilitzant l'algoritme SHA256 amb RSA. Es mostra un missatge
indicant si la signatura és vàlida o no.

```java
public static void verificaSignatura() throws Exception {
        try {
            if (keyPair != null) {
                System.out.println("Introdueix la ruta del document original: ");
                String rutaOG = scan.nextLine();
                while (!Paths.get(rutaOG).toFile().exists()) {
                    System.out.println("Introdueix una ruta del document original vàlida: ");
                    rutaOG = scan.nextLine();
                }
                System.out.println("Introdueix la ruta del document amb la signatura: ");
                String ruta = scan.nextLine();
                while (!Files.exists(Paths.get(ruta))) {
                    System.out.println("Introdueix una ruta del document amb la signatura vàlida: ");
                    ruta = scan.nextLine();
                }
                if (Files.exists(Paths.get(ruta))) {
                    byte[] bytesOG = Files.readAllBytes(Paths.get(rutaOG));
                    byte[] bytes = Files.readAllBytes(Paths.get(ruta));
                    Signature signature = Signature.getInstance("SHA256withRSA");
                    signature.initVerify(keyPair.getPublic());
                    signature.update(bytesOG);
                    boolean verify = signature.verify(bytes);
                    if (verify)
                        System.out.println("Document verificat amb èxit.");
                    else
                        System.out.println("No s'ha pogut verificar correctament, el document Original ha sigut modificat.");
                } else {
                    System.out.println("No s'ha trobat el document.");
                }
            } else {
                System.out.println("ERROR: No s'ha generat cap parell de claus.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

#### Accedir a el repositori del programa:
- [Repositori principal](../../../../../../)

---

## Informació tècnica utilitzada
**IDE:** 
- IntelliJ Professional

**Llenguatge:** 
- Java (SDK Coretto-11)

**Imports:** 
- java.util
- java.security
- java.nio.file

## Autor
- [@danikeinox](https://www.github.com/danikeinox)