# Arkkitehtuurikuvaus

## Rakenne

Ohjelma on toteutettu viiden pakkauksen ja kahdeksan luokan avulla. Ohjelman pakkausrakenne on seuraavanlainen:



Ohjelmassa on kolme pääluokkaa: User, Rabbit ja Breeding, joiden luokkakaavio on seuraavanlainen:



Lisää luokista ja niiden toiminnallisuudesta voi lukea seuraavista linkeistä:


## Käyttöliittymä
Ohjelmassa on graafinen käyttöliittymä, joka sisältää seitsemän eri näkymää:

- kirjautumisnäkymä
- uuden käyttäjän luominen
- päänäkymä
- uuden astutuksen lisääminen
- uuden kanin lisääminen
- onnistuuko kahden kanin astuttaminen
- sopivan parin löytäminen

Jokainen näkymä on toteutettu omana Scene-oliona ja vain yksi näkymä näkyy kerralla. Käyttöliittymä sijaitsee luokassa kanilanastutusohjelma.App. 
Sovelluslogiikka on pyritty pitämään erillään käyttöliittymästä Service-luokan avulla.

## Tietojen tallennus

Ohjelma käyttää tiedostoja tietojen tallentamiseen. Tietojen tallentaminen tapahtuu käyttöliittymästä UserDao-, RabbitDao- ja BreedingDao-luokkien avulla.
Käyttäjät tallennetaan tiedostoon `userfile.txt` muodossa käyttäjänimi;kasvattajanimi;kasvattajanumero.

## Päätoiminnallisuudet

Yksi päätoiminnallisuuksista on sisään kirjautuminen. Kun käyttäjä haluaa kirjautua sisään painamalla nappulaa *kirjaudu*, niin App-luokka kutsuu luokan
Service metodia logIn(String username), joka taas kutsuu luokan UserDao metodia find(String username). Jos käyttäjänimi löytyy, niin metodi palauttaa
kyseisen käyttäjän, jolloin metodi logIn(String username) palauttaa true. Jos käyttäjää ei löytynyt, palauttaa metodi find(String username) null, jolloin 
metodi logIn(String username) palauttaa false.