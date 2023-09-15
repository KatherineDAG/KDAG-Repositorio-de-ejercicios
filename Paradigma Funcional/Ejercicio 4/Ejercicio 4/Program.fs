(*
Ejercicio 4: Modifique el ejercicio de búsqueda en profundidad visto en clase para ingresar pesos a 
los vértices (una recomendación es representarlos como [["i"],["a","b"],["3","6","5"]] para evitar 
tener que cambiar algo en el algoritmo actual). Implemente una función que encuentre el camino más 
corto en la búsqueda en profundidad basándose en la sumatoria de pesos. Implica cambiar la búsqueda 
en profundidad para que se lleven los pesos además de los vértices.
*)

open System

//Grafo con vertices y peso (se le atribuye el peso de una vez al vertice)
let grafo = [
    [('i', 0);('a', 1);('b', 2)];
    [('a', 1);('i', 0);('c', 3);('d', 2)];
    [('b', 2);('i', 0);('c', 1);('d', 4)];
    [('c', 3);('a', 1);('b', 1);('x', 2)];
    [('d', 2);('a', 4);('b', 1);('f', 3)];
    [('f', 3);('d', 2)];
    [('x', 2);('c', 3)]
]

let miembro e (lista: ('a * 'b) list) =
    lista
    |> List.map (fun (x,_) -> x = e)
    |> List.reduce (fun x y -> x || y)

let rec vecinos nodo grafo =
    match grafo with
    | [] -> []
    | ((head, peso)::adyacencias)::tail when nodo = head -> adyacencias
    | _::tail -> vecinos nodo tail 

let extender (ruta: _ list) grafo =
    (vecinos (fst ruta.Head) grafo)
    |> List.map (fun (x,peso) -> if (miembro x ruta) then [] else (x,peso)::ruta )
    |> List.filter (fun x -> x <> [])

//Función de busqueda en profundidad modificada para recibir el peso
let rec prof_aux fin (rutas: _ list list) grafo =
    if rutas = [] then
        []
    elif fin = (fst rutas.Head.Head) then
        List.append
            ([List.rev rutas.Head])
            (prof_aux fin rutas.Tail grafo)
    else
        prof_aux fin (List.append (extender rutas.Head grafo) rutas.Tail) grafo
        
let prof ini fin grafo =
    prof_aux fin [[(ini,0)]] grafo

//Función de rutaCorta solicitada    
let rec rutaCorta (rutas: _ list list) func =
    let rec rutaCortaAux rutas acumulador =
        match rutas with
        | [] -> None // No hay rutas
        | [ruta] -> Some (List.rev ruta) // Solo hay una ruta
        | ruta1::ruta2::tail ->
            let ruta1Longitud = List.length ruta1
            let ruta2Longitud = List.length ruta2
            let ruta1Peso = List.fold (fun acc (_, peso) -> acc + peso) 0 ruta1
            let ruta2Peso = List.fold (fun acc (_, peso) -> acc + peso) 0 ruta2
            if ruta1Peso <= ruta2Peso && ruta1Longitud <= acumulador then
                rutaCortaAux (ruta1::tail) ruta1Longitud
            elif ruta2Longitud <= acumulador then
                rutaCortaAux (ruta2::tail) ruta2Longitud
            else
                rutaCortaAux (ruta2::tail) acumulador

    rutaCortaAux rutas Int32.MaxValue

printf "Ruta corta: %A" (rutaCorta grafo prof)
