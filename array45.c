#include <stdio.h>
#include <stdlib.h>
#define MEMOTAM 2048
 
void nuevoArray(int espacio){
    char memoria[espacio];

}

void insertarArray(char memoria[], int local, char proceso ){
        memoria[local] = proceso;
}

void imprimirArray(char memoria[]){
    for (int i = 0; i < MEMOTAM; ++i)
    {
       printf("%C \n", memoria[i] );
    }
}

void eliminarArray(char memoria[], int local){

    memoria[local]= NULL;
}