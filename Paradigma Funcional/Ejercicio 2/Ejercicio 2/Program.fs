(*
Ejercicio 2: Haciendo uso de la función filter, implemente una función que, a partir de una lista de cadenas
de parámetro, filtre aquellas que contengan una subcadena que el usuario indique en otro argumento.
Ejemplo:
Lista:  [“la casa, “el perro”, “pintando la cerca”]
sub_cadenas “la”
Resultado filtrado: [“la casa, “pintando la cerca”]
*)

open System

printf "Ingrese la sub-Cadena a filtrar: "
let subCadena = Console.ReadLine()

let listaCadena = ["la casa"; "el perro"; "pintando la casa"; "el dinosaurio";"el cangrejo"]

let filtrarPalabras (pal:string) (lista:string list) =
    lista
    |> List.map(fun (x:string) -> x.Split [|' '|])//Divide en subcadenas la cadena
    |> List.filter (fun subCadena -> subCadena |> Array.exists(fun str -> str.Contains(pal)))//Verifica que la subcadena ingresada sea igual a las subcadenas divididas
    |> List.map(fun subCadena -> String.concat " " subCadena) //Une las palabras que pasan el filtro

printfn "%A" (filtrarPalabras subCadena listaCadena)