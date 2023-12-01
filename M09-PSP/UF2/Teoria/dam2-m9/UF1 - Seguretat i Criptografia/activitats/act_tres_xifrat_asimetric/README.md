# Activitat 3: _e·ni-gm·a evolved_

## Objectiu

L'objectiu d'aquesta activitat és desenvolupar un sistema segur de gestió de claus i signatura de documents utilitzant criptografia asimètrica. El sistema permetrà als usuaris generar parells de claus, signar documents i verificar signatures.

## Descripció

El vostre repte és crear una aplicació de consola en Java que integri diverses tasques relacionades amb la criptografia asimètrica. La vostra aplicació ha de ser capaç de:

1. **Generar un nou parell de claus**: L'usuari podrà generar un nou parell de claus.
2. **Visualitzar les claus**: El sistema mostrarà una representació de les claus.
4. **Signar un document**: L'usuari podrà crear una signatura digital per un document i emmagatzemar-la en un fitxer (aquest potser en format text o binari)
5. **Verificar la signatura d'un document**: El sistema permetrà verificar la signatura d'un document.

La vostra tasca és implementar aquestes funcionalitats de manera eficient i segura, tenint en compte la millor gestió d'errors i l'experiència d'usuari.

## Requisits

1. **Menú interactiu**: La vostra aplicació hauria de començar amb un menú en format tabular que permeti a l'usuari seleccionar diferents operacions.

2. **Generació de claus**: Implementeu la generació de claus asimètriques utilitzant almenys una longitud de clau, per defecte, de 2048 bits.

3. **Visualització de les claus**: Proporcioneu una manera de visualitzar el parell de claus.

4. **Signatura i verificació**: Deixeu que l'usuari signi documents (pot ser un text simple o un fitxer) i verifiqueu les signatures respectives.

5. **Gestió d'errors**: El vostre codi ha de controlar els errors de manera efectiva, evitant problemes de l'aplicació i proporcionant missatges d'error clars a l'usuari.

6. **Codificació i decodificació**: Implementeu funcionalitats per codificar i decodificar les claus i les signatures en formats com Base64 per facilitar el seu emmagatzematge i transmissió.


## Exemple de sortida

```
+-----------------------------------------+
|            e·ni-gm·a system             |
+----------------------------------------+|
| 1. Generar un nou parell de claus       |
| 2. Mostra la clau pública               |
| 3. Mostra la clau privada               |
| 4. Signar un document                   |
| 5. Verificar la signatura d'un document |
| 6. Sortir                               |
+-----------------------------------------+
Selecciona una opció: 1
Inicialitzant el motor d'encriptació...
INFO: Encara no s'ha generat cap parell de claus. Creant un de nou...
Parell de claus generada amb èxit!

Selecciona una opció: 2
Clau pública: ulAvuYd+QeK3vf+9wyt63PdGM+OpiQ/wHiMfZUoalGk=

Selecciona una opció: 3
Clau privada: bqDM4K/IZB3WmoJqjnllJx9yX3tSaJ9KgwxTf0CG9fM=

Selecciona una opció: 4
Introdueix la ruta del document a signar: document.txt
Document signat amb èxit. Signatura (en format base64):
Signatura: FZ+6mlNykHBCQdIU0mkxCAq/gwcsjnDJsteTEWU3NIwjXFyLyaQxyEqnF9oFJXNPV4aif1NIl83DVkSw+UAl7OSNh/3L400s765jETG51abCfkcmVSPYd6W17EQrA+072j7aOP7twaXHn6tzJm6Lct+ug+QxNLIc5jqtui3Of9ztfKS1RysqomCjTYpRxvOdIyVhZk3KuGw/eXrQNEnhBjrxfRRw5OmDJy2AEgqFY4EUXT/Ylgvp1z4/7MMzA+xxFVgAFsAzWl5IzIQKAS9GoW2zXKtJ8BI7oOKnzdYrcHsTLLbjjfm6YfPH2WSUpkk5az4GSpGcOWlDwD1qzCccLA==

Selecciona una opció: 5
Introdueix la ruta del document original: document.txt
Introdueix la ruta del document amb la signatura: document.txt.sig
Document verificat amb èxit.

Selecciona una opció: 6
Sortint de l'aplicació...
```

## Recursos
**JDK 8**
- [Documentació oficial de Java](https://docs.oracle.com/javase/8/docs/api/)
- [Criptografia en Java](https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html)
- [Base64](https://docs.oracle.com/javase/8/docs/api/java/util/Base64.html)

**Java JDK 11**
- [Documentació oficial de Java](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)
- [Criptografia en Java](https://docs.oracle.com/en/java/javase/11/security/java-cryptography-architecture-jca-reference​-guide.html)
- [Base64](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Base64.html)

##  CODI D’HONOR
L'ús de la IA ha de ser una eina d'aprenentatge i millora personal, no una forma de
trampa que minvi el teu progrés, comprensió dels conceptes i capacitat d'assolir reptes
més complexos.
1. Autenticitat en l'aprenentatge: Utilitza la intel·ligència artificial per entendre els problemes
i desenvolupar les teves habilitats, no per evadir els reptes d'aprenentatge.
2. Col·laboració ètica: Col·labora amb altres estudiants de manera ètica i transparent. Ajuda'ls
a comprendre i superar els obstacles, però no els donis solucions completes si això
compromet la seva pròpia comprensió.
3. Reconeixement dels recursos: Si utilitzes codi, solucions o materials d'altres fonts,
assegura't de reconèixer i citar adequadament aquests recursos. L’honestedat intel·lectual
és fonamental.
4. Responsabilitat personal: La responsabilitat del teu aprenentatge i èxit recau en tu mateix.
Utilitza les eines d'intel·ligència artificial com a suport, no com a substitut de l'esforç.