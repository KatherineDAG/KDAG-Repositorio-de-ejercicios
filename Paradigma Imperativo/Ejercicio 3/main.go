/*
Ejercicio 3: Escriba una función que permita rotar una secuencia de elementos N posiciones a la izquierda
o a la derecha según sea el caso en función al parámetro que se reciba. Los parámetros deben ser un puntero a
un arreglo previamente creado, la cantidad de movimiento de rotación y la dirección (0 = izq y 1 = der).
*/

package main

import "fmt"

func main() {
	secElementos := []string{"a", "b", "c", "d", "e", "f", "g", "h"}
	var direccion int
	fmt.Print("Ingrese la dirección a la que quiere rotar\n " +
		"Ingrese 0 para izquierda \n Ingrese 1 para la derecha: ")
	fmt.Scan(&direccion)
	var CantMovRotar int
	fmt.Print("Ingrese el número de posiciones a rotar: ")
	fmt.Scan(&CantMovRotar)

	rotarSecuencia(&secElementos, CantMovRotar, direccion)
	fmt.Println(secElementos)
}

// Permite rotar la secuencia de N elementos según la cantidad y dirección de los parámetros dados
func rotarSecuencia(secElem *[]string, cant int, dic int) {
	posicion := len(*secElem) //Calcula longitud de la secuencia
	if dic == 0 {
		cant = cant % posicion
		//Une 2 slice, uno que contiene los elementos desde la posición cant hasta el final y la otra desde el princicio hasta el cant
		*secElem = append((*secElem)[cant%posicion:], (*secElem)[:cant%posicion]...)
	} else if dic == 1 {
		cant = cant % posicion
		//Es igual al anterior, pero contiene elementos desde la posicion posicion-cant%posicion
		*secElem = append((*secElem)[posicion-cant%posicion:], (*secElem)[:posicion-cant%posicion]...)
	}
}

/*
Prueba para validar (misma que da de ejemplo el profe)
Secuencia Original = [a, b, c, d, e, f, g, h,]
Cantidad de rotaciones = 3
Dirección = 0 (izq)
Secuencia final rotada = [d, e, f, g, h, a, b, c]
Nóte: que cada iteración, el elemento más a la izquierda del original
pasó a formar parte del final de la secuencia.

Si se hace a la derecha, sería lo contrario el elemento más a la derecha, formaria parte al
inicio de la secuencia.
Secuencia Original = [a, b, c, d, e, f, g, h]
Cantidad de rotaciones = 3
Dirección = 0 (izq)
Secuencia final rotada = [f, g ,h, a ,b ,c, d, e]
*/
