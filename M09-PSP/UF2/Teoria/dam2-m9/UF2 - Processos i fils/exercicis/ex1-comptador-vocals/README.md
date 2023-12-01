# Exercici: Efficient vocal counter

**Objectiu:**  
Desenvolupar un programa en Java que compti el nombre de cada vocal (a, e, i, o, u) present en un fitxer de text. L'exercici es realitzarà creant una classe `Thread` específica per a cada vocal, i el programa s'implementarà en dues versions: una amb execució **asíncrona** i l'altra amb execució **síncrona** dels fils.

**Descripció:**  
El programa haurà de llegir el contingut d'un fitxer de text i utilitzar cinc fils diferents per comptar les aparicions de cada vocal. Cada fil s'encarregarà d'una vocal específica. Es crearan les següents classes derivades de `Thread`:
- ACounter
- ECounter
- ICounter
- OCounter
- UCounter

Cada una d'aquestes classes comptarà el nombre d'aparicions de la seva vocal assignada dins del text.

**Tasques:**

1. **Implementació de classes de fil:**  
   Crear una classe per a cada vocal que estengui `Thread`. Cada classe haurà de sobreescriure el mètode `run()` per a comptar el nombre d'aparicions de la seva vocal en el text.

2. **Lectura del fitxer:**  
   Llegir el contingut del fitxer de text que serà analitzat.

3. **Execució asíncrona:**  
   En aquesta versió, tots els fils s'iniciaran simultàniament. El programa principal no esperarà que un fil acabi abans d'iniciar el següent.

4. **Execució síncrona:**  
   En aquesta versió, el programa principal esperarà a que un fil acabi abans d'iniciar el següent. Això garantirà que els fils s'executin de manera seqüencial.

5. **Resultats:**  
   Per a cada versió, el programa ha d'imprimir el recompte total de cada vocal.

## Preguntes
**Quin penses que serà més eficient?**

✅ Per a fer-ho calcula el temps d'execució de cada forma d'execució.

### Exemple de sortida
```text
Inici d'execució asíncron
	Recompte de a's: 1405
	Recompte de o's: 706
	Recompte de u's: 1484
	Recompte de i's: 1746
	Recompte de e's: 1837
Temps d'execució asíncron: XXX ms

Inici d'execució síncron
	Recompte de a's: 1405
	Recompte de e's: 1837
	Recompte de i's: 1746
	Recompte de o's: 706
	Recompte de u's: 1484
Temps d'execució síncron: XXX ms
```

On **XXX** representa en valor en milisegons de temps d'execució.
El resultat de la sortida pot variar en funció de l'ordinador on s'executi.