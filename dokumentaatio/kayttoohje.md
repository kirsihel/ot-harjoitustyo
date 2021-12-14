# Käyttöohje

Lataa tiedosto [KanilanAstutusohjelma-1.0-SNAPSHOT.jar](https://github.com/kirsihel/ot-harjoitustyo/releases/tag/Viikko5)

## Tiedostot

Sovellus käyttää tiedostoa `userfile.txt` käyttäjien tallentamiseen. Testiluokka UserDaoTest vastaavasti käyttää tiedostoa `userfiletest.txt` testaamisessa.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla `java -jar KanilanAstutusohjelma-1.0-SNAPSHOT.jar`. Ohjelman voi myös suorittaa NetBeansilla.

## Kirjautuminen

Sovellus aukeaa kirjautumisnäkymään:

[Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/kirjautuminen.png)

Kirjautuminen onnistuu, kun tiedostosta löytyy kirjoituskenttään syötetty käyttäjänimi ja painetaan *kirjaudu*.

## Uuden käyttäjän luominen

Kirjautumisnäkymästä voidaan siirtyä uuden käyttäjän luomiseen painamalla *luo uusi käyttäjä*. Tällöin avautuu uusi näkymä:



Uusi käyttäjä luodaan syöttämällä tiedot kirjoituskenttiin. Käyttäjänimen tulee olla uniikki ja vähintään 5 merkkiä pitkä. Kun luonti on onnistunut, 
ylimpään kirjoitus kenttään ilmestyy teksti *uusi käyttäjä luotu*. Tällöin voidaan palata takaisin kirjautumisnäkymään ja kirjautua sisään.

