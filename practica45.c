#include <stdio.h>
#include <stdlib.h>
#include "lista_en45.c"

#define TAM 30
#define MEMOTAM 2048

void procesoNuevo(){
	char nombre[TAM];
	printf("Asigne un nombre al nuevo proceso: ");
	scanf("%s", nombre);

}


int main(){

 printf("MENU: \n1. Crear proceso nuevo \n2. Ver estado de los procesos \n3. Ver estado de la memoria \n4. Imprimir cola de procesos  \n5. Ver procesos actual \n6. Ejecutar proceso actual \n7. Pasar al proceso siguiente \n8. Matar proceso actual\n9. Desfragmentar memoria\n10. Salir del programa\n " );	

 int val;
 printf("\nElige una opcion:  ");
 scanf ("%d", &val);


	switch (val){
		case 1:
		procesoNuevo();
		break;

		case 2:
		break;

		case 3:
		break;

		case 4:
		break;

		case 5:
		break;

		case 6:
		break;

		case 7:
		break;

		case 8:
		break;

		case 9:
		break;

		case 10:
		break;

	}
	return 0;

}