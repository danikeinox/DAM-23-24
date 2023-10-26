# Mini Projecte: El Joc del Penjat 🎩🪓

Us imagineu un penjat feliç? 🤔 El nostre penjat està decidit a no penjar-se i necessita la teva ajuda per endevinar les
paraules i evitar un final tràgic.

### Benvinguts a **Hangman** el clàssic joc del Penjat!

En aquest divertit mini projecte, crearàs una aplicació que permet als jugadors jugar al penjat de forma interactiva i
emocionant. Aquí tens el que hauràs de fer:

**1. Inici Interactiu 🎮**

- L'aplicació ha d'iniciar-se amb un *menú interactiu* que captura l'atenció del jugador. Utilitza *[ASCII art](https://patorjk.com/software/taag/#p=display&f=Banner3&t=Com%20%20estas%20%3F)* per crear
  un títol cridaner.

**2. Registra el Jugador 📝**

- Abans de començar a endevinar, l'aplicació ha de permetre als jugadors registrar-se. Demana als jugadors que
  introdueixin el seu *nickname* perquè es pugui registrar la seva puntuació.

**3. Endevina la Paraula 🔤**

- Utilitza una *base de dades de paraules* en català (pots incloure'n 100) emmagatzemades en un fitxer de text que
  l'aplicació gestionarà com la base de dades de paraules per al joc.
- Pots trobar una llista de 100 paraules al [repositori](hangman/paraules.txt). Intenta def-ho directament des del web, és a dir, sense carregar del disc el fitxer. Encara que així també seria correcte 😉.
- L'aplicació triarà una paraula aleatòria de la base de dades per a cada partida.
- Mostra el *progrés del joc* a mesura que el jugador introdueix lletres. Al principi, mostra la paraula com "_ _ _ _ _"
  i a mesura que es van encertant lletres, mostra-les correctament.

**4. Evita Penjar-te! 🙈**

- El jugador intentarà endevinar la paraula introduint una lletra a la vegada.
- L'aplicació ha d'assegurar-se que el jugador introdueixi una sola lletra vàlida i que no repeteixi lletres ja
  endevinades o incorrectes.
- Si el jugador introdueix una lletra correcta, mostra-la a la seva posició corresponent en la paraula. Si introdueix
  una lletra incorrecta, mostra un missatge d'error.
- Compta el nombre d'intents que necessita per endevinar la paraula correcta.

**5. Guanya el Joc! 🏆**

- El joc es guanya quan el jugador aconsegueix endevinar totes les lletres de la paraula abans de superar un nombre
  màxim d'intents (p. ex., 6 intents).
- Quan el jugador guanya, mostra un missatge de felicitació i la paraula correcta.
- Registra la *puntuació* del jugador (data, nickname, paraula endevinada i recompte d'intents) en un fitxer de text com
  el "Hall of Fame."

**6. Visualitza el Hall of Fame 🌟**

- Implementa una opció en el menú principal per que els jugadors puguin *visualitzar el Hall of Fame*. El Hall of Fame
  hauria de mostrar la data, el nickname, la paraula endevinada i el nombre d'intents dels millors jugadors en un format
  de taula tabular.

**7. Distribució Fàcil 📦**

- Assegura't que l'aplicació es pugui *instal·lar fàcilment* com un paquet distribuïble binari. Proporciona instruccions
  per a la generació del paquet utilitzant arxius com `Makefile`, `setup.py`, i `requirements.txt` si és necessari.

**Exemple de Sortida:**

```
Benvingut a Hangman!
  _   _    _    _   _  ____ __  __    _    _   _ 
 | | | |  / \  | \ | |/ ___|  \/  |  / \  | \ | |
 | |_| | / _ \ |  \| | |  _| |\/| | / _ \ |  \| |
 |  _  |/ ___ \| |\  | |_| | |  | |/ ___ \| |\  |
 |_| |_/_/   \_\_| \_|\____|_|  |_/_/   \_\_| \_|
                                                 
1. Jugar Hangman
2. Visualitzar Hall of Fame
3. Sortir

Selecciona una opció: 1

Introdueix el teu nickname: jugador1

Paraula a endevinar: _ _ _ [1/4]
Introdueix una lletra: a
Encertat!

Paraula a endevinar: _ a _ [2/4]
Introdueix una lletra: g
Encertat!

Paraula a endevinar: g a _ [3/4]
Introdueix una lletra: s
Lletra incorrecta.

Paraula a endevinar: g a _ [4/4]
Introdueix una lletra: t
Encertat!
Has guanyat! La paraula era 'gat'.
```

Posa't mans a la feina, crea el teu codi i recorda respectar el **Codi d'Honor**:

### Principis del Codi d'Honor

*L'ús de la IA ha de ser una eina d'aprenentatge i millora personal, no una forma de trampa que minvi el teu progrés,
comprensió dels conceptes i capacitat d'assolir reptes més complexos*

1. **Autenticitat en l'Aprenentatge**: Utilitza l'intel·ligència artificial per entendre els problemes i desenvolupar
   les teves habilitats, no per evadir els reptes d'aprenentatge.

2. **Col·laboració Ètica**: Col·labora amb altres estudiants de manera ètica i transparent. Ajuda'ls a comprendre i
   superar els obstacles, però no els donis solucions completes si això compromet la seva pròpia comprensió.

3. **Reconeixement dels Recursos**: Si utilitzes codi, solucions o materials d'altres fonts, assegura't de reconèixer i
   citar adequadament aquests recursos. La honestitat intel·lectual és fonamental.

4. **Responsabilitat Personal**: La responsabilitat pel teu aprenentatge i èxit recau en tu mateix. Utilitza les eines
   d'intel·ligència artificial com a suport, no com a substitut de l'esforç.
