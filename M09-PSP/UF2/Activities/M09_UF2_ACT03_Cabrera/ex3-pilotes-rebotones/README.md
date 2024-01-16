# Activitat 3: *Bouncing balls*

#### Objectiu
Desenvolupar una aplicació JavaFX que permeti reforçar la gestió d'execució i aturada selectiva de fils. L'aplicació simularà pilotes que reboten dins d'un rectangle, amb controls per pausar i reprendre el moviment de cada pilota, així com modificar la velocitat de totes elles.
S'ha de contemplar el disseny _Thread-Safe_ per garantir la seguretat.

#### Descripció

**Funcionalitats de l'aplicació:**

1. **Interfície d'usuari amb JavaFX (FXML):** La interfície inclourà un rectangle on les pilotes rebotaran, botons per controlar les pilotes i un botó de sortida.

2. **Controls de l'usuari:**
   - Quatre botons, cadascun corresponent a una pilota, per iniciar o aturar el seu moviment (boto 1 vermell, boto 2 verd, boto 3 blau, boto 4 morat, per exemple).
   - Un control [slider](https://www.geeksforgeeks.org/javafx-slider-class/) que permetrà augmentar la velocitat de totes les pilotes alhora.
   - Un botó "Sortir" que permeti tancar l'aplicació de manera segura.

3. **Pilotes animades:**
   - Un màxim de **4** pilotes, cadascuna controlada per un **fil separat**.
   - Cada pilota començarà amb un color assignat (vermell, verd, blau, morat, per exemple). El color coincidirà amb els botons per identificar fàcilment quin botó controla una pilota.

4. **Velocitat de les pilotes:**
   - El control slider permetrà ajustar la velocitat de totes les pilotes.

5. **Estil CSS:**
   - Aplicació d'estils CSS per a una interfície d'usuari atractiva.

#### Requisits tècnics

- L'aplicació ha de ser desenvolupada utilitzant JavaFX amb JDK >= 11.
- El disseny de la interfície d'usuari s'ha de realitzar amb un fitxer FXML.
- L'estil de la interfície d'usuari s'ha de definir amb un fitxer CSS.
- La gestió de fils ha de ser precisa per evitar condicions de cursa i assegurar una sortida neta de l'aplicació.

#### Objectius d'aprenentatge

- Entendre i aplicar la creació i gestió de fils en Java.
- Integrar JavaFX amb la programació multithread per crear animacions interactives.
- Practicar la utilització de FXML i CSS per a dissenyar interfícies d'usuari en JavaFX.
- Comprendre la importància de la gestió segura de fils en el tancament d'aplicacions.

## Plantilla a refactoritzar

Disposes d'una plantilla bàsica que pots o no utilitzar per desenvolupar la teva proposta. Aquesta conté **errors** i **no** segueix les directrius d'un disseny _**Thread-Safe**_.
Utilitza-la, si vols, per tenir una base i poder-te centrar en la gestió del fils, que és l'objectiu de l'activitat.

Si l'executes obtindràs aquesta 'sortida':

![ScreeShoot](act_3_bouncing_balls_template.png){width=42%}


## Exemple d'aplicació final

Un exemple d'aplicació podria ser:

![ScreeShoot](act_3_bouncing_balls.png){width=42%}

En funcionament ...

![Bouncing balls demo](act_3_bouncing_balls_demo.mov)

## CODI D’HONOR

_L'ús de la IA ha de ser una eina d'aprenentatge i millora personal, no una forma de
trampa que minvi el teu progrés, comprensió dels conceptes i capacitat d'assolir reptes
més complexos._

* **Autenticitat en l'aprenentatge**. _Utilitza la intel·ligència artificial per entendre els problemes
i desenvolupar les teves habilitats, no per evadir els reptes d'aprenentatge._
* **Col·laboració ètica**. _Col·labora amb altres estudiants de manera ètica i transparent. Ajuda'ls
a comprendre i superar els obstacles, però no els donis solucions completes si això
compromet la seva pròpia comprensió._
* **Reconeixement dels recursos**. _Si utilitzes codi, solucions o materials d'altres fonts,
assegura't de reconèixer i citar adequadament aquests recursos. L’honestedat intel·lectual
és fonamental._
* **Responsabilitat personal**. _La responsabilitat del teu aprenentatge i èxit recau en tu mateix.
Utilitza les eines d'intel·ligència artificial com a suport, no com a substitut de l'esforç._