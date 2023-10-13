/*Ejercicio de cromosomas que se hizo en el laboratorio, aplicarlo en prolog. Obtener apartir de una muestra, cual es la persona mas parecida,recorrido averiguando para cada persona y ver que tanto se parece segun porcentaje. Pasar persona y muestra y consulta*/

% Definir cromosomas de personas
cromosoma_persona(luis, [1, 0, 1, 0, 1, 1, 0, 0, 0, 1]).
cromosoma_persona(maria, [0, 1, 1, 0, 1, 0, 0, 1, 0, 1]).

% Predicado para calcular el porcentaje de cromosomas parecidos
porcentaje_similitud(Nombre, Muestra, Porcentaje) :-
    cromosoma_persona(Nombre, Cromosoma),
    calcular_similitud(Muestra, Cromosoma, 0, 0, Porcentaje), !.

% Predicado auxiliar para calcular la similitud
calcular_similitud([], [], SimilitudActual, TotalElementos, Porcentaje) :-
    Porcentaje is (SimilitudActual / TotalElementos) * 100.
calcular_similitud([MuestraHead | MuestraResto], [CromosomaHead | CromosomaResto], SimilitudActual, TotalElementos, Porcentaje) :-
    MuestraHead =:= CromosomaHead,
    NuevaSimilitud is SimilitudActual + 1,
    NuevosElementos is TotalElementos + 1,
    calcular_similitud(MuestraResto, CromosomaResto, NuevaSimilitud, NuevosElementos, Porcentaje), !.
calcular_similitud([_ | MuestraResto], [_ | CromosomaResto], SimilitudActual, TotalElementos, Porcentaje) :-
    NuevosElementos is TotalElementos + 1,
    calcular_similitud(MuestraResto, CromosomaResto, SimilitudActual, NuevosElementos, Porcentaje), !.

/* Casos de Prueba y resultados
 ?- porcentaje_similitud(luis, [0, 1, 1, 0, 1, 1, 0, 0, 0, 1], Porcentaje).
Porcentaje = 80.0.

?- porcentaje_similitud(maria, [0, 1, 1, 0, 1, 0, 0, 1, 0, 1], Porcentaje).
Porcentaje = 100.

?- porcentaje_similitud(maria, [1, 0, 0, 1, 1, 1, 1,0, 1, 0], Porcentaje).
Porcentaje = 10.0.
*/
