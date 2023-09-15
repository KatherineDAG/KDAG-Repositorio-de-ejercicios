(*
Ejercicio 1: Realizar ejercicio para desplazar (SHIFT) una lista de elementos n posiciones a la izquierda
o la derecha según se indique por argumento.
Ejemplo:
desplazar “izq” 3  [1,2,3,4,5]
[4,5,0,0,0]
desplazar “der” 2  [1,2,3,4,5]
[0,0,1,2,3]
desplazar “izq” 6  [1,2,3,4,5]
[0,0,0,0,0]
*)

open System

printf "Ingrese el número de veces que desea desplazar los elementos: "
let nPosicionesStr = Console.ReadLine()

printf "Ingrese 0 si quiere desplazar los elementos a la izquierda, 1 a la derecha: "
let posicionStr = Console.ReadLine()

let listaElementos = [1; 2; 3; 4; 5]

let desplazarElementos (nPos: int) (pos: int) (list: int list) =
    let tamano = List.length list
    if pos = 0 then
         let shiftAmount = min nPos tamano
         List.init tamano (fun i -> if i < tamano - shiftAmount then List.nth list (i + shiftAmount) else 0)
    elif pos = 1 then
        let shiftAmount = min nPos tamano
        List.init tamano (fun i -> if i < shiftAmount then 0 else List.nth list (i - shiftAmount))
    else failwith "La dirección debe ser 'izquierda' (0) o 'derecha' (1)"


//Concatenar elementos string que ingresan por consola, pasar a int
let nPosiciones = int nPosicionesStr
let posicion = int posicionStr

let resultado = desplazarElementos nPosiciones posicion listaElementos
printfn "%A" resultado
