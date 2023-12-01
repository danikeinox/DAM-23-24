
# Activitat 2: Xifratge simètric: operació _e·ni-gm·a_

## Enunciat:
Ets un enginyer/a altament qualificat/a en una missió crítica on has de desenvolupar un generador de fitxers per poder-los intercanviar amb seguretat. 

Hauràs de desenvolupar un programa en Java que faci el següent:

* Generar una clau secreta segura.
* Encriptar un missatge (fitxer de text) utilitzant la clau secreta.
* Desencriptar el missatge encriptat i obtenir el text original.
* Comprovar si un fitxer s'ha modificat o no.
* Generar un resum del missatge per verificar la seva integritat.

### Descripció i exemple de sortida

**1: Xifrar fitxers en text clar**
- Cerca informació sobre els algorismes criptogràfics simètrics suportats per Java [JDK >= 11](https://docs.oracle.com/en/java/javase/11/docs/specs/security/standard-names.html).
- Crea un generador de claus per obtenir una _clau secreta_ amb algorismes simètrics com per exemple [AES](https://ca.wikipedia.org/wiki/Advanced_Encryption_Standard).
- Genera un resum del fitxer en clar (_fitxer.digest_). Aquest resum garantirà a l'agent que el missatge no ha estat alterat.

**2: Desxifrar d'un fitxer xifrat**
- Si un agent rep un fitxer xifrat (_fitxer.encrypted_) l'aplicació haurà de poder generar un nou fitxer (_fitxer.decrypted_) en format text clar.
- Verifica el resultat i demostra si el missatge ha estat alterat o no.

**3: Generació de resums**
- Genera un resum (hash) per qualsevol missatge de text que un agent introdueixi.

**4: Verificació de resums**
- Si un agent rep un missatge necessita estar segur al 100% que aquest no ha estat manipulat.
- Crea un verificador de resums (hash).

## Exemple de sortida

```text
+------------------------------------+
|          e·ni-gm·a system          |
+------------------------------------+
| 1. Encriptar fitxer                |
| 2. Desencriptar fitxer             |
| 3. Generar un hash d'un missatge   |
| 4. Verificar el hash d'un missatge |
| 5. Sortir                          |
+------------------------------------+
Selecciona una opció: 1
Introdueix el camí del fitxer a encriptar: fitxer.txt

Introdueix la clau secreta: super secret !
Procés realitzat correctament: fitxer.encrypted
S'ha generat un fitxer de hash <fitxer.digest>: igCa6iI+AH0O81ayYHd9DAPAwnAIuQxJDve5GGdMUXw=

+------------------------------------+
|          e·ni-gm·a system          |
+------------------------------------+
| 1. Encriptar fitxer                |
| 2. Desencriptar fitxer             |
| 3. Generar un hash d'un missatge   |
| 4. Verificar el hash d'un missatge |
| 5. Sortir                          |
+------------------------------------+
Selecciona una opció: 2
Introdueix el camí del fitxer a desencriptar: fitxer.encrypted

Introdueix la clau secreta: super secret !
Procés realitzat correctament: fitxer.decrypted
Comprovant si el missatge ha estat alterat ...
Introdueix la ruta al fitxer de resum  _digest_: fitxer.digest
ALERTA. El missatge ha estat alterat.
```

###  CODI D’HONOR
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