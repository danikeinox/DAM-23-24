# FITXERS 5.0


## Contingut

La llibreria Fitxers 5.0 conté mètodes per guardar dades a fitxers de tipus text i binaris.
Conté una classe '_MeuObjecteOutputStream_' per poder evitar el problema del guardat d'objectes a continuació d'altres.
Aquesta classe és totalment transparent a l'usuari i sols s'utilitza dintre dels mètodes de guardat d'un objecte.

Hi han 2 subgrups grans de mètodes:

- [ ] Mètodes utilitzant java.io
- [ ] Mètodes utilitzant java.nio


## Pujada a repositori remot
La llibreria té per defecte e


## Utilització

Per utilitzar els mètodes d'aquesta classe construirem i utilitzarem així:

```java
Fitxers f=new Fitxers();
 
 
/*******************/
/* Fitxers de text */

// escriure text a un fitxer de text:
f.escriuTextFitxer("nomFitxer","textDelFitxer",true); // true afegirà al fitxer. // false crearà un fitxer nou amb el text
 
 
// recuperar text d'un fitxer de text en una llista. Cada ítem de la llista és una fila del text:
List<String> contingutFitxer=retornaFitxerTextEnLlista("nomFitxer");




/*******************/
/* Fitxers binaris: */

// escriure un objecte a un fitxer on ja hi han objectes guardats 
f.escriuObjecteFitxer(objecte, "nomFitxer.dat",true);


// recuperar una llista d'objectes: (per exemple de la classe Llibre)
List <Object> LObjectes=f.retornaFitxerObjecteEnLlista("nomFitxer.dat",Llibre.class);


```

El mateix amb la resta de mètodes que hi han a la llibreria


