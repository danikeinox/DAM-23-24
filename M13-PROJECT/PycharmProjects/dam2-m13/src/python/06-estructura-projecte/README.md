# Com estructurar un programa en Python - part 1

Organitzar el codi d'una manera eficient ens permetrà mantenir-lo mols més fàcilment.
A més a més, podem adaptar la nostra organització a la d'un repositori *git*, la qual cosa ens facilitarà la seva gestió.

## Ordres de construcció i instal·lació

Aquestes ordres s'executen al directori arrel del programa!

```shell
make 
```

En aquest cas aquest fitxer ens instal·la les dependències del nostre programari.

```shell
python ./setup.py sdist bdist
```
Instal·la el paquet. Utilitza el fitxer `setup.py` per crear el paquet.

* [sdist](https://docs.python.org/es/3/distutils/sourcedist.html): crea un paquet per la distribució del codi font.
* [bdist](https://docs.python.org/es/3/distutils/builtdist.html): crea un paquet per la distribució compilada del codi.


## Estructura bàsica (no tests, no docs)
```text
README.md
LICENSE
setup.py
requirements.txt
exemple/__init__.py
exemple/core.py
exemple/helpers.py
```

### README.md (`.srt`)
| Ubicació: | `./README.md`           |
|-----------|-------------------------|
| Propòsit: | Llicencia del proramari |

Conté la informació sobre el directori, els fitxers que conté i informació sobre el programari.

### LICENSE
| Ubicació: | `./LICENSE`               |
|-----------|---------------------------|
| Propòsit: | Llicencia del proramari   |

Hi ha molts tipus de [llicències](https://ca.wikipedia.org/wiki/Llic%C3%A8ncia_de_programari), tant de codi obert com privatiu. Heu de ser responsables en la seva selecció.

### setup.py
| Ubicació: | `./setup.py`                    |
|-----------|---------------------------------|
| Propòsit: | Gestió de paquets i distribució |

Si el paquet del mòdul principal es troba a l'arrel del teu repositori, òbviament també hauria d'estar a l'arrel.

### requirements.txt
| Ubicació: | `./requirements.txt`        |
|-----------|-----------------------------|
| Propòsit: | Dependències del programari |

S'ha de col·locar un fitxer de requisits `pip` a l'arrel del dipòsit. Ha d'especificar les dependències necessàries per contribuir al projecte: provar, construir i generar documentació.

Si el vostre projecte no té dependències de desenvolupament, o si preferiu configurar un entorn de desenvolupament mitjançant `setup.py`, aquest fitxer pot ser innecessari.

### exemple

Mòdul principal. El teu programa !