# Käyttöohje

Lataa tiedosto [KanilanAstutusohjelma-1.0-SNAPSHOT.jar](https://github.com/kirsihel/ot-harjoitustyo/releases/tag/Viikko5)

## Tiedostot

Sovellus käyttää tiedostoa `userfile.txt` käyttäjien tallentamiseen. Testiluokka UserDaoTest vastaavasti käyttää tiedostoa `userfiletest.txt` testaamisessa.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla `java -jar KanilanAstutusohjelma-1.0-SNAPSHOT.jar`. Ohjelman voi myös suorittaa NetBeansilla.

## Kirjautuminen

Sovellus aukeaa kirjautumisnäkymään:

![Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/kirjautuminen.png)

Kirjautuminen onnistuu, kun tiedostosta löytyy kirjoituskenttään syötetty käyttäjänimi ja painetaan *kirjaudu*.

## Uuden käyttäjän luominen

Kirjautumisnäkymästä voidaan siirtyä uuden käyttäjän luomiseen painamalla *luo uusi käyttäjä*. Tällöin avautuu uusi näkymä:

![Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/uusikayttaja.png)

Uusi käyttäjä luodaan syöttämällä tiedot kirjoituskenttiin. Käyttäjänimen tulee olla uniikki ja vähintään 5 merkkiä pitkä. Kun luonti on onnistunut, 
ylimpään kirjoitus kenttään ilmestyy teksti *uusi käyttäjä luotu*. Tällöin voidaan palata takaisin kirjautumisnäkymään ja kirjautua sisään.

## Päänäkymä

Kun kirjautuminen onnistuu siirrytään pää näkymään:

![Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/p%C3%A4%C3%A4.png)

## Kanin lisäys

Kun valitaan päänäkymästä `lisää kani`, päästään kaninlisäysnäkymään:

![Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/lis%C3%A4%C3%A4.png)

Kun syötetään uuden kanin tiedot ja painetaan `lisää`, niin sovellus ilmoittaa, jos kanin lisäys on onnistunut.

## Astutusten tarkastus.

Astutuksia voidaan tarkastaa valitsemalla yksi kani painamalla `valitse kani`, jolloin siirrytään näkymään:

![Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/valitse.png)

tai valitsemalla pari painamalla `valitse pari`, jolloin päästään näkymään:

![Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/pari.png)

## Päivämäärät

Kaikki kanien syntymäpäivät sekä muut päivämäärät tulee syöttää muodossa "vvvv-kk-pp".

## Astutusten kirjaaminen

Uudet astutukset tulee syöttää mudossa uros;naaras;päivämäärä.

