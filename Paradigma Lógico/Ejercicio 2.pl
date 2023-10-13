%Defina la relación subconj(S, S1), donde S y S1 son listas
%representando conjuntos, que es verdadera si S1 es subconjunto de S


subconj([],_).
subconj([S|ST],S1):-
    member(S,S1),
    subconj(ST,S1).

%?- subconj([5,4],[4,3]).
%false.

%?- subconj([4,3],[4,3]).
%true

