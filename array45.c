#include <stdio.h>
#include <stdlib.h>
#define MEMOTAM 2048
 
char memoriaTotal(int espacio){
    char memoria[espacio];
}

void insertarProceso(char nombreproc[], int id, int inst, char memoria[], int espacio){
       int cont =0;
       int comp=0;
       while (cont < espacio){
              if (memoria[comp] == NULL){
                char cadena[100];
                cadena = "-----\n" +"Nombre " + nombreproc +"\nID: "+ id + "\nInstrucciones Totales: " + inst + "\n------\n" ; // ESTO FALTA ARREGLAR
                memoria[i]= cadena;
                cont++;
                comp++;
             }
             else{
                comp++;
             }
        }

}

void imprimirMemoria(char memoria[]){
    for (int i = 0; i < MEMOTAM; ++i)
    {
       printf("%C \n", memoria[i] );
    }
}

void eliminarProceso(char memoria[], int local){

    memoria[local]= NULL;
}

int espacioVacio(char memoria[]){
    int espacdisp;
    for (int i = 0; i < MEMOTAM; ++i){
        if(memoria[i]= NULL){
            espacdisp++;
        }
    }
    return espacdisp;
}