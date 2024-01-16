# UF5 - 01 - Excepcions

## Exercici 1: 
### Demana a l'usuari un número sencer i posa una lletra. 

Ha de saltar la excepció i avisar a l'usuari que no es pot posar cap lletra sinò un número.

## Exercici 2: 
### Creeu una classe amb un mètode main() que generi un objecte de la classe Exception dins d'un bloc try. Proporcioni a l'constructor d'Exception dos números però Strings (exemple ExcepcioClasse ex=new ExcepcioClasse("3","4")).  

El mètode suma de la classe Exception convertirà aquests números "strings" a números integer i els sumarà retornant el resultat. Prova enviat aquests exemples: 
ExcepcioClasse ex=new ExcepcioClasse("3","4") --> hauria de fer la suma i no fallar 
ExcepcioClasse ex=new ExcepcioClasse("hola","4") --> fallarà i saltarà a la excepció avisant a l'usuari


## Exercici 3: 
### Escriu codi per generar i captura una excepció ArrayIndexOutOfBoundsException 

(O siga que ens hem passat de l'índex d'una matriu o vector. Avisa a l'usuari i que el programa no es tanque abruptament.


## Exercici 4: 
### Crea la teva pròpia classe d'excepció utilitzant la paraula clau Extends.

- Escriu un constructor per a aquesta classe que prengui un argument String i l'emmagatzema dins de l'objecte com una referència de tipus String. 
- Escriu un mètode que demani un número i que retorne l'arrel quadrada. 
- Si el número que li passem per paràmetre és negatiu, llançarà un throw de la excepció que acabem de crear - Crea una clàusula try-catch per provar la nova excepció.




## Exercici 5: 
### Crea una aplicació amb un menú que faci saltar algunes de les excepcions vistes a teoria. Per exemple el menú posat a continuació. 

Si vols pots experimentar en altres Excepcions no posades en aquest menú exemple: 
Escull el tipus d'Excepció:
```text
1) Excepció divisió/0 
2) Excepció array 
3) Excepció de classe no trobada 
4) Excepció de fitxer inexistent 
0) SORTIR
```
