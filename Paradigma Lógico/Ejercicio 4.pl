%Defina un predicado llamado partir(Lista, Umbral, Menores, Mayores) para dividir una lista respecto un umbral dado,
% dejando los valores menores a la izquierda y los mayores a la derecha. Por ejemplo, el resultado de partir la lista [2,7,4,8,9,1]
% respecto al umbral 6 serían las listas [2,4,1] y [7,8,9].

partir([],_,[],[]).
partir([H|T],Umbral,[H|Menores],Mayores):-
    H =< Umbral,
    partir(T,Umbral, Menores,Mayores).

partir([H|T],Umbral,Menores,[H|Mayores]):-
    H > Umbral,
    partir(T,Umbral,Menores,Mayores).


% Se agrega el = a la primera condición, ya que si el umbral es igual a
% un valor dentro de la lista, este siga siendo parte del menor y que
% los mayores esten a parte


%Pruebas para ejecutar
%?- partir([2,7,4,8,9,1],6,Menores,Mayores).
%Resultado
%Menores = [2, 4, 1],
%Mayores = [7, 8, 9] ;

%?- partir([2,7,4,8,9,1],4,Menores,Mayores).
%Resultado
%Menores = [2, 4, 1],
%Mayores = [7, 8, 9] ;

%?- partir([2,7,4,8,9,1],7,Menores,Mayores).
%Resultado
%Menores = [2, 7, 4, 1],
%Mayores = [8, 9] ;
