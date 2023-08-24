/*
Ejercicio 4: Escriba un programa que utilice una estructura y un
arreglo/slice para almacenar en memoria un inventario de una tienda
que vende zapatos.
*/

package main

import "fmt"

// Estructura para el inventario
type calzado struct {
	marca  string
	precio int32
	talla  int
	stock  int32 //Para llevar la cantidad de zapatos disponibles
}

type inventario []calzado

var listaCalzado inventario

// Función para verificar si el zapato existe en el inventario (por medio de la marca y la talla)
func buscar(l *inventario, mod string, tal int) int {
	for i, intv := range *l {
		if intv.marca == mod && intv.talla == tal {
			return i
		}
	}
	return -1
}

/*
Función para agregar los datos (se agrega el calzado, que no exista, es decir que no haya de la misma marca y talla
si hay de la misma marca y talla, se actualiza el precio y el stock)
*/
func (l *inventario) agregarCalzado(marca string, precio int32, talla int, stock int32) {
	index := buscar(l, marca, talla)
	if index == -1 {
		*l = append(*l, calzado{marca: marca, precio: precio, talla: talla, stock: stock})
		fmt.Printf("Agregado a inventario: %s talla %d\n", marca, talla)
	} else {
		(*l)[index].precio = precio
		(*l)[index].stock = stock
		fmt.Printf("Se cambio: %s, al precio: %d, y a la cantidad: %d\n", marca, precio, stock)
	}
}

// Función para la venta de zapatos (primero busca la marca y la talla que se quiere vender, depués elimina la cantidad vendida)
func (l *inventario) venderZapatos(marca string, talla int, cantidad int32) {
	index := buscar(l, marca, talla)
	if index == -1 {
		fmt.Println("No se encontraron zapatos con la marca y talla especificadas")
		return
	}

	if (*l)[index].stock >= cantidad {
		(*l)[index].stock -= cantidad
		fmt.Printf("Se vendieron %d pares de zapatos de la marca %s y talla %d. Nuevo stock: %d\n", cantidad, marca, talla, (*l)[index].stock)
	} else {
		fmt.Println("No se puede vender porque ya no hay suficiente stock")
	}
}

func main() {
	//Agregar datos del calzado
	listaCalzado.agregarCalzado("Nike", 50000, 42, 10)
	listaCalzado.agregarCalzado("Adidas", 60000, 39, 5)
	listaCalzado.agregarCalzado("Puma", 45000, 37, 3)
	listaCalzado.agregarCalzado("Reebok", 55000, 38, 7)
	listaCalzado.agregarCalzado("Vans", 40000, 41, 12)
	listaCalzado.agregarCalzado("Converse", 48000, 40, 8)
	listaCalzado.agregarCalzado("New Balance", 52000, 43, 6)
	listaCalzado.agregarCalzado("Nike", 42000, 39, 15)
	listaCalzado.agregarCalzado("Salomon", 65000, 42, 9)
	listaCalzado.agregarCalzado("Nike", 55000, 42, 20) //calzado con talla y marca iguales (cambia precio y stock para verificar que no se agreguen mismas tallas de la misma marca)

	//Lista del inventario del calzado al inicio
	fmt.Println("Calzado Inicial:", listaCalzado)

	//Vender calzado
	listaCalzado.venderZapatos("Nike", 42, 10)
	listaCalzado.venderZapatos("New Balance", 43, 6)
	listaCalzado.venderZapatos("New Balance", 43, 4) //Para verificar que no vende porque ya no hay en el stock
	fmt.Println("Calzado después de la venta:", listaCalzado)

}
