import java.util.*;

public class Menu{

public static void opcionM(){

    System.out.println("\nMenu:");
    System.out.println("1. Crear proceso nuevo");
    System.out.println("2. Ver estado de los procesos");
    System.out.println("3. Ver estado de la memoria");
    System.out.println("4. Imprimir cola de procesos");
    System.out.println("5. Ejecutar proceso actual");
    System.out.println("6. Ver proceso actual");
    System.out.println("7. Pasar al proceso siguiente");
    System.out.println("8. Matar proceso actual");
    System.out.println("9. Desfragmentar memoria");
    System.out.println("10. Salir del programa");
    System.out.print("Elige una opcion: ");

}


	public static void main(String args[]){
		 Gestion gestion = new Gestion();
		 System.out.print("\033[H\033[2J");
         System.out.flush();
         System.out.println("Bienvenid@");
         opcionM();

    Scanner scan = new Scanner(System.in);
    int opc = scan.nextInt();
    System.out.println(opc);

    do{
    	switch(opc){
    	case 1:
    	gestion.crearProceso();
    	break;

    	case 2:
    	gestion.verEstadoP();
    	break;

    	case 3:
    	gestion.verEstadoMem();
    	break;
    	
    	case 4:
    	gestion.imprimirCola();
    	break;
		
    	case 5:
    	gestion.ejecutarProcesoA();
    	break;

    	case 6:
    	gestion.verProcesoA();	
    	break;

        case 7:
        	gestion.pasarP();
    	break;
		
    	case 8:
    		gestion.matarP();
    	break;
		
    	case 9:
    		gestion.desfragmentarM();
    	break;
		
    	case 10:
    		gestion.salir();
    	break;

		default:
		System.out.println("Opcion invalida");	
    	}
    	opcionM();
    	opc = scan.nextInt();
		System.out.println(opc);

    }while(opc>=1 && opc<10);
    scan.close();
    System.out.println("Saliendo...");

	 }

}
