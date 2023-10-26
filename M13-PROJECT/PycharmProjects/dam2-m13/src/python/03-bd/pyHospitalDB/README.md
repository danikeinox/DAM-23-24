# Exercici pyHospitalDB

Crear una app que permeti donar d'alta els doctors que treballen en un hospital.

La taula **doctor** emmagatzemarà els següents camps
* doctor_id: identificador del doctor (clau primària)
* nom: nom del doctor
* cognoms: cognoms del doctor
* sou: salari brut del doctor

La taula **hospital** emmagatzemarà els següents camps:
* hospital_id: identificador de l'hospital
* nom: nom de l'hospital


Es defineix una relació ***1 a n*** entre les taules **hospital** i **doctor**.

Es facilita un fitxer **docker-compose.yml** per facilitar les proves i practicar amb *docker*.

El fitxer conté aquesta informació:
```yaml
version: '3'

# Creen els serveis
services:
  mydb:                                 # Identifiquem el servei amb mydb
    image: postgres:13-bullseye         # Utiltizem la versió 13.X (last version) de potgres
    volumes:
      - postgresdb:/var/lib/postgresql  # Creem un volum per emmagatzemar les dades
    ports:                               
      - "5432:5432"                     # Habilitem el port 5432 per accedir a la DB
    environment:                        # Creem les variables d'usuari i contrasenya de la DB
      POSTGRES_USER: admin              #   que són necessaris per docker
      POSTGRES_PASSWORD: admin
      POSTGRES_DB: testdb

volumes:                                # asignem el volum
  postgresdb:
    driver: local
```

Recorda executar (on està el fitxer)
```shell
$ docker-compose up -d
```

Segui executa les següents ordres:

```shell
$ docker ps
```
Ens mostra per terminal els contenidors que estan en marxa, per tant si executem:

```shell
$ docker ps

CONTAINER ID   IMAGE                  COMMAND                  CREATED       STATUS       PORTS                                       NAMES
b99b6733f2ca   postgres:13-bullseye   "docker-entrypoint.s…"   2 hours ago   Up 2 hours   0.0.0.0:5432->5432/tcp, :::5432->5432/tcp   pyhospitaldb_mydb_1
```

Obtindrem que tenim en marxa el nostre recent contenidor.
Copia el valor del **CONTAINER ID** i executa:

```shell
$ docker exec -it b99b6733f2ca bash
```

Aquesta ordre ens permet executar una *shell bash* a la màquina virtual (al docker) i interactuar (***-it***) amb ella.
Obtindrem una interfície semblant a:
```shell
$ docker exec -it b99b6733f2ca bash
root@b99b6733f2ca:/# 
```

Una vegada dins de la shell podem accedir a la gestió del servei postgresql mitjançant:
```shell
root@b99b6733f2ca:/# psql -U admin -W -h localhost testdb
```

On:
* [psql](https://www.postgresql.org/docs/13/app-psql.html): programa de gestió del servidor Postgre
* -U: indica l'usuari que es connecta
* -W: indica sense contrasenya (--no-password) 
* -h: host
  * localhost: fa referpència al host local (127.0.0.1)
* testdb: nom de la base de dades

**ALERTA**: Recorda que els valors **admin** i **testdb** els hem definit al fitxer docker-compose.yml

Una vegada ja no necessitem el contenidor en marxa podem aturar-lo executant:

```shell
$ docker stop b99b6733f2ca
```

Dubtes? Agafa't la llibertat de preguntar ;-)