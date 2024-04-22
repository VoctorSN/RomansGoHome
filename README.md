Romans Go Home
==============

### Kata Numerales Romanos

con nuestros simpáticos amigos los

**Enum Types**

y las alegres

**Expresiones Regulares**

en una nueva producción de Maven con **TDD** como estrella invitada.

## Enunciado
Los romanos trajeron muchas cosas...

https://www.youtube.com/watch?v=p-fRo5-p9hE 

pero admitamos que los números no eran su fuerte. Para qué los necesitaban si podían crucificar al que sabía contar.

Se trata de escribir una programa que transforme números en notación romana en notación indo-arábigo :

```
I  uno 1
II dos 2
III tres 3 
IV  cuatro 4 
V cinco 5
VI  seis 6
VII  siete 7
VIII  ocho 8
IX   nueve 9
XXXII  treinta y dos 32
XLV  cuarenta y cinco 45
```

**Has de utilizar expresiones regulares y tipos enumerados. 
Sin utilizar estos dos recursos, el kata no se da por superado puesto que desvirtúas su propósito.**

## Las reglas del sistema de numeración romano están descritas en el artículo de la Wikipedia:

https://es.wikipedia.org/wiki/Numeraci%C3%B3n_romana
editar

Hay que tener en cuenta que la numeración romana, al no ser un sistema posicional, no requiere del cero.

Para expresar en notación "moderna" los números romanos se utilizan las siguientes normas:

 - Los números se leen de izquierda a derecha empezando por los símbolos con mayor valor, o conjunto de símbolos de mayor valor.
 - Un símbolo seguido de otro de igual o inferior valor, suma (p.e. X·X·I = 10+10+1 = 21), mientras que si está seguido de otro de mayor valor, ambos símbolos forman un conjunto en el cual debe restarse el valor del primero al valor del segundo (p.e. X·IX = 10+[10-1] = 19).
 - La unidad (I) y los números con base 10 (X, C y M) pueden repetirse hasta 3 veces consecutivas como sumandos.
 - Los números con base 5 (V, L y D), no pueden repetirse seguidos, ya que la suma de esos dos símbolos tiene representación con alguno de los símbolos anteriores.
 - La unidad (I) y los símbolos de base 10 (X, C y M) también pueden aparecer restando antes de un símbolo de mayor valor, pero con las siguientes normas:
   - Eolo pueden aparecer restando sobre los símbolos con base 5 y 10 de valor inmediatamente superiores, pero no de otros con valores más altos(p.e. ‘IV’ y ‘IX’, pero no ‘IL’ ni ‘IC’).
   - En el caso de estar restando, no pueden repetirse.
Los símbolos con base 5 no pueden utilizarse para restar (p.e. 45 se escribe ‘XLV’ y no ‘VL’).

## Casos Test

Utilizad los que aparecen en el artículo de la Wikipedia, que explican cómo funcionan las normas.

*El código propuesto no existe si no incluye casos test para testear las expresiones regulares y la conversión de los números. 
Los casos test han de cubrir todas la posibilidades.*

Si quieres replicar mi arquitectura de clases, utiliza los casos test de mi código:

https://github.com/dfleta/romans-go-home/blob/enumOCP/src/test/java/org/foobarspam/KataRomanNumerals/Test/NumeroRomanoTest.java

## Lógica

Dado un número romano, p.e:

`String numeroRomano = "MDCCCLXXXVIII";`

de las citadas reglas puede deducirse que estas son las únicas combinaciones que se presentarán:

 1. M, C, X, I pueden aparecer de cero a tres veces (sumando).
 2. D, L, V pueden aparecer de cero a una vez sumando, ya que no pueden restar.
 3. Restando, sólo pueden aparecer las combinaciones:
    - IV e IX
    - XL y XC
    - CD y CM
 4. D, L, V no pueden aparecer restando.

Esto puede traducirse a expresiones regulares y a tipos enumerados:

 - Crea expresiones regulares para identificar en el string que representa el número romano los conjuntos anteriores, que no dejan de ser meros patrones.
 - Luego, utiliza los tipos enumerados para obtener el valor de los símbolos romanos (y las combinaciones permitidas, por ejemplo, aunque esto no es necesario).


## Expresiones regulares

Resuelve primero el ejercicio _Listing 14-2. Using Pattern and Matcher Classes_ pag. 527 del libro _Beginning Java 8 Fundamentals_. Es necesario leerse el capítulo del libro para entender cómo se usan las expresiones regulares en Java.

 - Será necesario utilizar herramientas online para testear expresiones regulares:

    http://www.freeformatter.com/java-regex-tester.html

 - Puedes resolver distintos casos test con esta herramienta, por ejemplo, el caso test:
pen pineapple apple pen

    https://www.youtube.com/watch?v=Ct6BUPvE2sM

Es recomendable profundizar un poco en el conocimiento de las expresiones regulares.

Por ejemplo, **Lookahead** y **Lookbehind** resultan muy útiles:

http://www.regular-expressions.info/lookaround.html

### SPOILER !!!

Las expresiones regulares que he utilizado están en este fichero, en el método `initRegexDicionario()`

https://github.com/dfleta/romans-go-home/blob/enumOCP/src/main/java/org/foobarspam/KataRomanNumerals/NumeroRomano.java

o en el script principal:

https://github.com/dfleta/romans-go-home/blob/enumOCP/src/main/java/org/foobarspam/KataRomanNumerals/RomansGoHome.java


## Gestión de dependencias con Maven

Configura las dependencias y plugins de tu proyecto como se explica aquí:

[Junit 5 y Maven Versions](./maven-versions.md)

## Proyecto
En tu GitHub desde ahora mismo, ¡y no olvides imputar en el panel!

## Solución
https://github.com/dfleta/romans-go-home

buscando mantener los principios de diseño SOLID, y utilizando HashMap para practicar esta estructura de datos en Java ;)  