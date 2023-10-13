/*Ejercicio 1: Implemente un predicado que, a partir de una lista de cadenas
de parámetro, filtre aquellas que contengan una subcadena que el usuario
indique en otro argumento. */

auxSub(EnPal, Div) :-
    sub_atom(Div, _, _, _, EnPal).
subCadena(EnPal,ListPal,X) :-
    include(auxSub(EnPal),ListPal,X).

/*Consultas:
subCadena("el",["el puente","la casa","la universidad"],X).
X = ["el puente"].

subCadena("la",["el alimento ","vamos a la casa","la vida silvestre"],X).
X = ["vamos a la casa", "la vida silvestre"].
*/
