# Mini Projecte: Guess Game - Joc d'Endevinar el Nombre 🎮

Benvinguts al fascinant món dels jocs d'ordinador! En aquest mini projecte, crearem una aplicació divertida anomenada "Guess Game" on els jugadors hauran de posar a prova les seves habilitats d'endevinar nombres aleatoris. 🤔💡

## Tasques a Desenvolupar 🚀
Les vostres tasques consistiran en:

1. **Classe Jugador: Representant a les Mestres de les Endevinalles** 🕵️‍♂️ 
  
   a) Crea una classe anomenada **`Jugador`** que tindrà dos atributs: **`nickname`** i **`encerts`**.
  
   b) Implementa un mètode **`incrementar_encerts`** que augmentarà el comptador d'encerts cada vegada que el jugador encerti un nombre.



2. **Classe Game: On els Nombres Esdevenen Secrets** 🤫

    a) Crea una classe anomenada **`Game`** que gestionarà el joc.
     
    b) Implementa un mètode **`generar_nombre_aleatori`** per generar un nombre aleatori entre 1 i 100, per exemple.
     
    c) Implementa un mètode **`jugar`** que permeti als jugadors intentar endevinar el nombre aleatori generat. Utilitza la instància de la classe **`Jugador`** per gestionar les dades del jugador durant el joc.

    d) Implementa un mètode **`registrar_encert`** que enregistri el nickname, la data i els encerts del jugador en un fitxer de text (*Hall of Fame*).


3. **Classe MenuInteractiu: Per als Mestres del Teclat** ⌨️

    a) Crea una classe anomenada **`MenuInteractiu`** que mostrarà el menú principal i les puntuacions.

    b) Implementa un mètode **`mostrar_menu`** que visualitzarà les opcions disponibles (Jugar, Veure Puntuacions, Sortir).

    c) Implementa un mètode **`veure_puntuacions`** que mostrarà les puntuacions del Hall of Fame ordenades de major a menor nombre d'encerts.

## Exemple de Sortida de l'Aplicació 📋
```text
Benvingut a Guess Game - Joc d'Endevinar el Nombre!

1. Jugar
2. Veure Puntuacions
3. Sortir

Selecciona una opció: 1

Introdueix el teu nickname: Sherlock

Endevina el nombre (entre 1 i 100): 42
Massa gran. Torna a intentar-ho.
Endevina el nombre (entre 1 i 100): 20
Massa petit. Torna a intentar-ho.
Endevina el nombre (entre 1 i 100): 30
Encertat! Has endevinat el nombre en 3 intents.

1. Jugar
2. Veure Puntuacions
3. Sortir

Selecciona una opció: 2

Hall of Fame:
03/10/2023 Sherlock ha trigat en encertar: 3
...

1. Jugar
2. Veure Puntuacions
3. Sortir

Selecciona una opció: 3
```

Posa't mans a la feina i programa el teu codi i recorda respectar el **Codi d'Honor**: 

### Principis del Codi d'Honor

*L'ús de la IA ha de ser una eina d'aprenentatge i millora personal, no una forma de trampa que minvi el teu progrés, comprensió dels conceptes i capacitat d'assolir reptes més complexos*

1. **Autenticitat en l'Aprenentatge**: Utilitza l'intel·ligència artificial per entendre els problemes i desenvolupar les teves habilitats, no per evadir els reptes d'aprenentatge.

2. **Col·laboració Ètica**: Col·labora amb altres estudiants de manera ètica i transparent. Ajuda'ls a comprendre i superar els obstacles, però no els donis solucions completes si això compromet la seva pròpia comprensió.

3. **Reconeixement dels Recursos**: Si utilitzes codi, solucions o materials d'altres fonts, assegura't de reconèixer i citar adequadament aquests recursos. La honestitat intel·lectual és fonamental.

4. **Responsabilitat Personal**: La responsabilitat pel teu aprenentatge i èxit recau en tu mateix. Utilitza les eines d'intel·ligència artificial com a suport, no com a substitut de l'esforç.


