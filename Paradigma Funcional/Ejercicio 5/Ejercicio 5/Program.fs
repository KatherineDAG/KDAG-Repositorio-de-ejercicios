(*
Ejercicio 5: 5)	Construya un programa que resuelva el problema de encontrar la o las rutas de un laberinto 
con datos quemados. Dicho problema se puede resolver exactamente igual que un problema de grafos, 
entendiendo que cada casilla del laberinto puede verse como un “vecino” adjunto de otra, siempre que no
haya pared.
-Represente el laberinto del gráfico como un grafo y corra la búsqueda en profundidad para encontrar
todos los caminos que lo resuelven. Elimine paredes y represente ese nuevo conocimiento de caminos posibles
en el grafo y vuelva a probar.
-Escriba una función que encuentre la ruta más corta para resolver el laberinto
*)

//Representación del laberinto 
let grafo = [
    (2, [3; 8]);
    (3, [2; 9; 4]);
    (4, [3; 10; 16; 22; 21; 15; 14]);
    (14, [13; 20]);
    (13, [7; 1]);
    (20, [26; 27; 28]);
    (28, [34]);
    (34, [33; 32; 31; 25; 19]);
    (34, [35; 36; 30; 24; 18; 12]);
    (28, [29; 23; 17; 11; 5])
]

//Busqueda en profundidad para rutas que resuelven el laberinto
let rec buscarEnProfundidad grafo inicio objetivo visitados =
    if inicio = objetivo then
        [inicio]
    else
        let vecinos =
            match List.tryFind (fun (n, _) -> n = inicio) grafo with
            | Some (_, vecs) -> vecs
            | None -> []
        
        let nuevosVecinos = List.filter (fun v -> not (List.contains v visitados)) vecinos
        match nuevosVecinos with
        | [] -> []
        | _ ->
            let resultado = ref []
            for v in nuevosVecinos do
                let ruta = buscarEnProfundidad grafo v objetivo (inicio::visitados)
                if List.length ruta > 0 then
                    resultado := inicio::ruta
            !resultado

//Prueba
let profundidad = buscarEnProfundidad grafo 2 32 []
printfn "Busqueda en Profundidad: %A" profundidad


//Nuevos caminos posibles, eliminando rutas
let romperPared grafo nodo1 nodo2 =
    let rec agregarConexion nodo conexion =
        match conexion with
        | (n, vecinos) :: resto ->
            if n = nodo1 then
                (n, nodo2::vecinos) :: agregarConexion nodo resto
            elif n = nodo2 then
                (n, nodo1::vecinos) :: agregarConexion nodo resto
            else
                (n, vecinos) :: agregarConexion nodo resto
        | [] -> [(nodo1, [nodo2]); (nodo2, [nodo1])]

    let grafoActualizado = agregarConexion nodo1 grafo |> agregarConexion nodo2

    grafoActualizado

//Prueba
let grafoConNuevasRutas = romperPared grafo 2 32
printfn "Nuevas Rutas: %A" grafoConNuevasRutas 


//Encontrar ruta más corta 
let encontrarRutaMasCorta grafo inicio objetivo =
    let rec bfs cola visitados =
        match cola with
        | [] -> None // No se encontró una ruta
        | (nodo, camino) :: resto ->
            if nodo = objetivo then
                Some (List.rev (nodo::camino))
            else
                let vecinos =
                    grafo
                    |> List.tryFind (fun (n, _) -> n = nodo)
                    |> Option.map snd
                    |> Option.defaultValue []
                let nuevosVecinos =
                    vecinos
                    |> List.filter (fun v -> not (List.contains v visitados))
                    |> List.map (fun v -> (v, nodo::camino))
                let nuevosVisitados = List.append visitados [nodo]
                bfs (resto @ nuevosVecinos) nuevosVisitados

    bfs [(inicio, [])] []
    
//Prueba    
let rutaMasCorta = encontrarRutaMasCorta grafo 2 32
printfn "Ruta más corta: %A" rutaMasCorta


