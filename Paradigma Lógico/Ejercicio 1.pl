%Defina sumlist(L,S) que es verdadero si S es la suma de los elementos de L

sumlist([],0).
sumlist([PE|SE],S):-
    sumlist(SE,AL),
    S is PE + AL.

%Ejemplos de ejecución
%?- sumlist([1,2],3).
%true.

%?- sumlist([1,4],3).
%false.
