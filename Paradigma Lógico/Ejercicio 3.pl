/*Ejercicio 3: Implemente la funci�n aplanar. Esta funci�n recibe una lista con
m�ltiples listas anidadas como elementos y devuelve una lista con los mismos
elementos de manera lineal (sin listas). */

aplanar([], []).
aplanar([PE|EA], LF) :-
    is_list(PE),
    aplanar(PE, L1),
    aplanar(EA, L2),
    append(L1, L2, LF).
aplanar([PE|EA], [PE|LF]) :-
    not(is_list(PE)),
    aplanar(EA, LF).

/*Consultas:
?- aplanar([[], [1], [2,3], [], [4,5,6], []], X).
X = [1, 2, 3, 4, 5, 6] .

?- aplanar([1,2,[3,[4,5],[6,7]]],X).
X = [1, 2, 3, 4, 5, 6, 7] .

?- aplanar([[1,[[2,3]]]], X).
X = [1, 2, 3] */
