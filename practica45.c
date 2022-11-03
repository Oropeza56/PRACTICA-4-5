#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "array45.c"
#define TAM 2048

void procesoNuevo( char memoria[]){
	
	int espacio;
	char nombreproceso[30];
	printf("Asigne un nombre al nuevo proceso: ");
	scanf("%s", nombreproceso);

	espacio = pow(2, rand()%4+6);
	int espaciDisp = espacioVacio(memoria);

	if( espacio <= espaciDisp ){ //verifica si tiene espacio suficiente la memoria
		int numproc = rand()%51+50; // este es el ID, falta que sea un numero unico
		int instr= rand()%21+10; //numero de instrucciones del 10 al 30
		insertarProceso(nombreproceso, numproc, instr, memoria, espacio);
    }
    else{
    	 printf("No se puede crear este proceso, es necesario ejecutar o matar otros procesos");
    }

}

void verProcesos(char procPrepa[], char procFinal[], char procElim[]){
		printf("PROCESOS LISTOS (EN COLA)")
		for (int i = 0; i < TAM; ++i){
			printf(procPrepa[i] "\n");
	}

	printf("\n ");
}



int main(){

char procPrepa[TAM];
char procFinal[TAM];
char procElim[TAM];

 printf("MENU: \n1. Crear proceso nuevo \n2. Ver estado de los procesos \n3. Ver estado de la memoria \n4. Imprimir cola de procesos  \n5. Ver procesos actual \n6. Ejecutar proceso actual \n7. Pasar al proceso siguiente \n8. Matar proceso actual\n9. Desfragmentar memoria\n10. Salir del programa\n " );	

 int val;
 printf("\nElige una opcion:  ");
 scanf ("%d", &val);


	switch (val){
		case 1:
		procesoNuevo(procPrepa);
		break;

		case 2:
		verProcesos(procPrep, procFin, procElim);
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