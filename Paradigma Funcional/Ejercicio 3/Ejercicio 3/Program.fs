(*
Ejercicio 3: Realizar una función que obtenga el n-esimo elemento de una lista pero utilizando solamente
 map (sin recursión). Tip: Utilizar lista de índices como segunda lista de argumento para el map.
n_esimo 2 [1,2,3,4,5]
3
n_esimo 3 [1,2,3,4,5]
4
n_esimo 6 [1,2,3,4,5]
False
*)

open System

printf "Ingrese el elemento que desea: "
let nesimo = int (Console.ReadLine())
let lista = [1; 2; 3; 4; 5; 6]
             
let obtenerElemento (lista: int list)=
    let indices = [0..List.length lista - 1]  //segunda lista
    let elementos = List.map (fun i -> List.nth lista i) indices  //se pasa como argumento al map
    
    //Corrobora si existe el indice o el elemento en la lista
    match List.tryFind (fun (i, _) -> i = nesimo) (List.zip indices elementos) with
    | Some (_, elemento) -> elemento
    | None -> 0   //Se coloca 0 y no False ya que todas las ramas de un match deben devolver valores del mismo tipo

let resultado = obtenerElemento lista

printfn "El resultado es: %A" resultado




