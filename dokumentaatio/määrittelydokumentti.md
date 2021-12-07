# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla kanien kasvattajat voivat helpommin hallinnoida kanilaansa. Sovelluksen avulla voidaan pitää kirjaa kaikista kasvattajan omistamista kaneista 
tietokannan avulla, tarkistaa, mitkä kanit voidaan astuttaa keskenään sekä kirjata ylös kaikki tehdyt astutukset. Sovellusta voi käyttää useampi 
rekisteröitynyt käyttäjä, joilla kaikilla on omat yksilölliset listat omista kaneista sekä astutuksista. 

## Käyttäjät

Sovelluksella on ainoastaan *normaaleja käyttäjiä* eli sovelluksella on vain yksi käyttäjärooli.

## Käyttöliittymäluonnos

Sovelluksessa on kuusi eri näkymää:

![Image](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/RabbitPlan.png)

Kun sovellus aukaa, näkyy ensimmäisenä kirjautumisnäkymä. Kirjautumisnäkymästä on mahdollista siirtyä näkymään, jossa voi luoda uuden käyttäjän tai palata 
takaisin kirjautumisnäkymään. Uuden käyttäjän luomisen jälkeen palataan takaisin kirjautumisnäkymään. Kun kirjautuminen onnistuu, siirrytään seuraavaan
näkymään, jossa voi valita, mitä haluaa tehdä tai voi kirjautua ulos. Jos haluaa nähdä, mitkä kanit ovat mahdollisia pareja astutukseen, valitaan `valitse kani`.
Tällöin siirrytään näkymään, missä voi valita kanin tai palata takaisin, minkä jälkeen tulostuu mahdolliset parit tai palataan edelliseen näkymään. Jos haluaa
nähdä onnistuuko kahden tietyn kanin astutus eli kanit eivät ole läheistä sukua, valitaan `valitse pari`. Tällöin siirrytään näkymään, jossa valitaan uros ja
naaras tai palataan takaisin, jolloin tulostuu onnistuuko astutus tai palataan edelliseen näkymään. Jos haluaa lisätä tai poistaa astutuksen, valitaan `lisää
astutus`, jolloin siirrytään näkymään, jossa voi lisätä tai poistaa astutuksen tai palata takaisin edelliseen näkymään.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

- Käyttäjä voi luoda uuden käyttäjätunnuksen.
  - Käyttäjätunnuksen tulee olla vähintään viisi merkkiä pitkä ja uniikki. Kasvattajanimi ja -numero eivät ole pakollisia.
- Käyttäjä voi kirjautua sisään.
  - Kun syötetään olemassaoleva käyttäjätunnus, kirjautuminen onnistuu.
  - Jos käyttäjätunnusta ei ole olemassa, sovellus ilmoittaa asiasta.
  
### Kirjautumisen jälkeen

- Käyttäjä näkee vaihtoehdot, jotka on mahdollista tehdä. 
- Käyttäjä voi tarkistaa mahdolliset astutusparit tietylle kanille valitsemalla `valitse kani`.
  - Käyttäjä näkee mahdolliset parit syöttämällä kanin nimen. 
  - Jos kyseistä kania ei ole tiedoissa, sovellus ilmoittaa tästä.
  - Käyttäjä voi palata valitsemaan toisen tehtävän.
- Käyttäjä voi tarkistaa, onnistuuko tiettyjen kanien astuttaminen valitsemalla `valitse pari`.
  - Käyttäjä syöttää naaraan ja uroksen nimet, jolloin tulostuu tieto, onnistuuko astutus.
  - Jos jompaa kumpaa kania ei löydy tiedoista, sovellus ilmoittaa asiasta.
  - Käyttäjä voi palata valitsemaan toisen tehtävän.
- Käyttäjä voi lisätä tai poistaa astutuksia valitsemalla `lisää astutus`.
  - Käyttäjä voi lisätä astutuksen.
  - Käyttäjä voi poistaa astutuksen, jolloin se häviää listalta.
- Käyttäjä voi kirjautua ulos.

## Jatkokehitysideoita

Perusversion jälkeen sovellukseen voidaan lisätä seuraavanlaisia toiminnallisuuksia:

- Omiin tietoihin voidaan lisätä tai muuttaa kasvattajanimi ja numero.
- Käyttäjä voi nähdä listan omista kaneista. Lista voidaan jakaa uroksiin ja naaraisiin.
- Sovelluksen kautta voidaan lisätä tai poistaa kaneja.
- Kanien tietoja voidaan muuttaa.
- Voidaan tulostaa syntyneiden poikasten sukupuu.
- Käyttäjätunnuksiin voidaan lisätä salasana, joka tarkastetaan kirjautumisen yhteydessä.
- Käyttäjätunnukset voidaan poistaa.
- Kaneille voidaan lisätä näyttelytulokset, jotka voi visualisoida kuvaajan avulla. 
- Voidaan lisätä poikueet, joiden tietoja voi hallinnoida.
