# Activitat/Prácica: JDBC

---
### A partir de la següent base de dades:


ARTIST (Code, Name) 

ALBUM (Code, Title, Artist, Year, Style) 

SONG (Code, Title, Album, Track) 

SALE (Song, Card, Sale_date) 

CLIENT (ClientID, Name, Surname1, Surname2, Region) 

CARD (Code, Card_number, Csv, Exp_date, Client)

Fer un programa que mostri el següent menú inicial:

1. Alta Artista (opc baixes)

2. Alta Album (opc baixes)

3. Alta Cançó (opc baixes)

4. Alta Client (amb una tarjeta) (opc baixes)

5. Fer venda (demanarà codi tarjeta i codi canço)

6. Llistar Vendes per Artista

7. Llistar Compres per client.

Es demana tenir una classe per entitat que encapsuli no només els Set i Get sino també la part de BBDD. Tenim mètodes com AltaCançoBBDD que a partir dels atributs de classe faci un insert a la taula de Cançons.

---
```
CREATE TABLE style (
code CHAR(5 char) CONSTRAINT PK_style PRIMARY KEY,
name VARCHAR2(20 char) CONSTRAINT NN_styleName NOT NULL
CONSTRAINT UN_style UNIQUE
);
CREATE TABLE artist (
code CHAR(5 char) CONSTRAINT PK_artist PRIMARY KEY,
name VARCHAR2(70 char) CONSTRAINT NN_artistName NOT NULL
CONSTRAINT UN_artist UNIQUE
);
CREATE TABLE album (
code CHAR(5 char) CONSTRAINT PK_album PRIMARY KEY,
title VARCHAR2(160 char) CONSTRAINT NN_albumTitle NOT NULL,
artist CONSTRAINT NN_albumArtist NOT NULL
CONSTRAINT FK1_album REFERENCES artist(code),
year CHAR(4 char) CONSTRAINT NN_albumYear NOT NULL,
style CONSTRAINT NN_albumStyle NOT NULL
CONSTRAINT FK2_album REFERENCES style(code),
CONSTRAINT UN_album UNIQUE(title, artist, year)
);
CREATE TABLE song (
code CHAR(7 char) CONSTRAINT PK_song PRIMARY KEY,
title VARCHAR2(200 char) CONSTRAINT NN_songTitle NOT NULL,
album CONSTRAINT NN_songAlbum NOT NULL
CONSTRAINT FK_song REFERENCES album(code),
track CHAR(2 char) CONSTRAINT NN_songtack NOT NULL,
CONSTRAINT UN1_song UNIQUE(title, album),
CONSTRAINT UN2_song UNIQUE(album, track)
);
CREATE TABLE client (
clientID NUMBER CONSTRAINT PK_client PRIMARY KEY,
name VARCHAR2(20 char) CONSTRAINT NN_clientName NOT NULL,
surname1 VARCHAR2(25 char) CONSTRAINT NN_clientSurname1 NOT
NULL,
surname2 VARCHAR2(25 char),
region CHAR(5 char) CONSTRAINT NN_clienRegion NOT NULL
);
CREATE TABLE card (
code CHAR(7 char) CONSTRAINT PK_card PRIMARY KEY,
card_number CHAR(16 char) CONSTRAINT NN_cardCard_number NOT
NULL
CONSTRAINT UN_Card UNIQUE,
csv CHAR(3 char) CONSTRAINT NN_cardCsv NOT NULL,
exp_date DATE CONSTRAINT NN_cardExp_date NOT NULL,
client CONSTRAINT NN_cardClient NOT NULL
CONSTRAINT FK_client REFERENCES client(clientID)
);
CREATE TABLE sale (
song CONSTRAINT FK1_sale REFERENCES song(code),
card CONSTRAINT FK2_sale REFERENCES card(code),
sale_date CHAR(10 char),
CONSTRAINT PK_SALE PRIMARY KEY (song,card, sale_date)
);
```