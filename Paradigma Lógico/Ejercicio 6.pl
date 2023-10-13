%A rutas, modificarlo para que maneje pesos, y se debe obtener la ruta
% más corta (que sea la menor(utilizar findall))

% Definición de las conexiones entre nodos con sus respectivos pesos
conectado(i, a, 2).
conectado(i, b, 5).
conectado(a, b, 1).
conectado(a, c, 3).
conectado(b, f, 2).
conectado(b, c, 2).
conectado(c, f, 4).

% Predicado para buscar una ruta en profundidad con pesos
buscar_ruta_profundidad_con_pesos(Inicio, Fin, Visitados, Ruta, Peso) :-
    conectado(Inicio, Siguiente, PesoArista),
    \+ member(Siguiente, Visitados), % No se ha visitado el siguiente nodo
    buscar_ruta_profundidad_con_pesos(Siguiente, Fin, [Siguiente|Visitados], RutaParcial, PesoParcial),
    Ruta = [Inicio | RutaParcial],
    Peso is PesoArista + PesoParcial.
buscar_ruta_profundidad_con_pesos(Fin, Fin, _, [Fin], 0). % Llegamos al final

% Predicado para encontrar la ruta más corta de inicio a fin
buscar_ruta_mas_corta(Inicio, Fin, Ruta, Peso) :-
    findall((R, P), buscar_ruta_profundidad_con_pesos(Inicio, Fin, [Inicio], R, P), RutasConPesos),
    minimo_ruta(RutasConPesos, Ruta, Peso).

% Predicado para encontrar la ruta con el peso mínimo en una lista de rutas con pesos
minimo_ruta([(R, P)], R, P).
minimo_ruta([(R1, P1) | Resto], RMin, PMin) :-
    minimo_ruta(Resto, R2, P2),
    (P1 < P2 -> (RMin = R1, PMin = P1); (RMin = R2, PMin = P2)).

%Casos de Prueba

%?- buscar_ruta_mas_corta(i, f, Ruta, Peso).
%Ruta = [i, a, b, f],
%Peso = 5 ;

%?- buscar_ruta_mas_corta(i,a, Ruta, Peso).
%Ruta = [i, a],
%Peso = 2 ;
