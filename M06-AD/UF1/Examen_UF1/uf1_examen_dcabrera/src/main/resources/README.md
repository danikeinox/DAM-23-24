Lliurament Examen UF1
Estem desenvolupament un projecte on tenim un fitxer d'access aleatori que emmagatzema dades de satel·lit. Les dades que sestiona són:

- CODI SATEL·LIT: 5 CARACTERS

- PAIS: FINS A 25 CARACTERS

- POSICIÓ X: FLOAT

- POSICIÓ Y: FLOAT

-  POSICIO Z: FLOAT

Com a part del desenvolupament ens diuen que creem una funció que donada un x1,y1,z1 i un marge d'error Er expressat com a float cerqui al sistema els satèl·lits tals que les seveis x,y,z estiguin dins aquest marge, es a dir

x1-Er <= X <=x1+Er

A més ens donaran un integer que representarà la posició des d'on haurem de començar a contar.

La capçalera de la funció serà:

bool trobaSatelits(String fitxerRAF,float x1,float y1,float z1,float margeError,int posicióInicial)

Els satel·lits que compleixin la condició s'hauran d'anar imprimint, de l'estil:

codi, pais, x,y,x

Si es produeix un error, s'ha de retornar false, si va bé, true.