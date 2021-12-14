# RabbitPlan

Sovelluksen avulla kanien kasvattajat voivat helpommin hallinnoida kanilaansa. Sovelluksen avulla voidaan pitää kirjaa kaikista kasvattajan omistamista kaneista 
tiedoston avulla, tarkistaa, mitkä kanit voidaan astuttaa keskenään sekä kirjata ylös kaikki tehdyt astutukset. Sovellusta voi käyttää useampi 
rekisteröitynyt käyttäjä, joilla kaikilla on omat yksilölliset listat omista kaneista sekä astutuksista.

Sovellus toimii harjoitustyönä Helsingin yliopiston Tietojenkäsittelytieteen kurssilla Ohjelmistotekniikka. 

## Javan versio

Sovellus on tehty käyttäen Javan versiota 11. Sovelluksen käyttöliittymä käyttää JavaFX:ää. Sovellusta on testattu virtuaalisessatyöasemassa, joten se toimii ainakin laitoksen koneilla.

## Dokumentaatio

[Määrittelydokumentti](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/m%C3%A4%C3%A4rittelydokumentti.md)

[työaikakirjanpito](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)

[UserClass-info](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/UserClass-info.md)

[AppClass-info](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/AppClass-info.md)

[arkkitehtuuri](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Arkkitehtuurikuvaus](https://github.com/kirsihel/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuvaus.md)

## Releaset

[Viikko 5](https://github.com/kirsihel/ot-harjoitustyo/releases/tag/Viikko5)
[Viikko 6](https://github.com/kirsihel/ot-harjoitustyo/releases/tag/Viikko6)

## Komentorivi toiminnot

### Testaaminen

Testit voidaan suorittaa komennolla `mvn test`.

Testikattavuusraportti saadaan luotua komennolla `mvn jacoco:report`. Kattavuusraportin saa auki selaimella avaamalla tiedoston *target/site/jacoco/index.html*.

Halutessaan testit voi myös suorittaa käyttäen NetBeansia.

### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset voidaan suorittaa komennolla `mvn jxr:jxr checkstyle:checkstyle`. Mahdolliset virheilmoitukset voidaan tarkistaa selaimella avaamalla tiedosto *target/site/checkstyle.html*.

### suorittettavan jar-tiedoston generointi

Komennolla `mvn package` voidaan generoida jar-tiedosto *KanilanAstutusohjelma-1.0-SNAPSHOT* kansioon *target*

### JavaDoc

JavaDoc voidaan generoida komennolla `mvn javadoc:javadoc`.
