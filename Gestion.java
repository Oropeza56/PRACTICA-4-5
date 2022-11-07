import java.util.*;

public class Gestion{

	  Queue <Procesos> procesos = new LinkedList<Procesos>();	
	  Almac almacenam = new Almac();

	  Scanner scan = new Scanner(System.in);

	  int proc =1;

	  public void crearProceso(){
		System.out.print("\033[H\033[2J");
	    System.out.flush();
	    System.out.println("Nombre del proceso: ");

	    String nombre = scan.nextLine(); 
	  
	    int id = proc;
	    int insTotal = (int) Math.floor(Math.random()*(30-10+1)+10); //numero aleatorio entre el 10-30
      int espacio = (int) Math.floor(Math.random()*(9-6+1)+6); //mumero aleatorio entre el 6 y 9 para definir el espacio

	    Procesos proceso = almacenam.insertarProceso(nombre,id,insTotal,espacio);
	     if(proceso == null){
	      System.out.println("La memoria no es suficiente, ejecuta o mata algun proceso");
	      return;
	    } 

	  System.out.println("PROCESO CREADO CORRECTAMENTE");
    System.out.println("----------------------");
    System.out.println("Nombre: " + nombre);
    System.out.println("ID: " + id);
    System.out.println("Tamaño: "+proceso.getTamanoTotal());
    System.out.println("No. de Instrucciones: "+proceso.getInsTotal());
    System.out.println("----------------------");

    procesos.add(proceso);
    proc++;

	}

	public void verEstadoP(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("Procesos en cola: " + procesos.size());
    System.out.println("Procesos finalizados exitosamente: ");
    almacenam.imprimirFin();
    System.out.println("Procesos finalizados antes de tiempo (eliminados): ");
    almacenam.imprimirElim();
  }

   public void verEstadoMem(){

    System.out.print("\033[H\033[2J");
    System.out.flush();

    almacenam.imprimirLista();
  }

    public void imprimirCola(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    if(procesos.size()==0){
      System.out.println("La cola esta vacia");
      return;
    }
    System.out.println("Cola de procesos: \n");
    for(Procesos p : procesos){
      System.out.println("Nombre: " + p.getNombre());
      System.out.println("ID: " + p.getID());
      System.out.println("Instrucciones por ejecutar: " + p.getInsTotal());
      System.out.println("------------------------------");
    }
  }


    public void ejecutarProcesoA(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    if(procesos.size()==0){
      System.out.println("La cola esta vacia");
      return;
    }
    Procesos p = procesos.remove();
    p.setInsTotal(p.getInsTotal()-5);
    p.setInsEjec(p.getInsEjec()+5);
    
    System.out.println("Se ejecuto el proceso: "+p.getNombre());
    System.out.println("Instrucciones por ejecutar: "+p.getInsTotal());

    if(p.getInsTotal()<=0) {
      almacenam.eliminarProceso(p);
      almacenam.procesosFin.add(p);
      System.out.println("El proceso ha terminado su ejecucion");
    } else {
      procesos.add(p);
    }
  }
  

    public void verProcesoA(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    if(procesos.size()==0){
      System.out.println("La cola esta vacia");
      return;
    }
    Procesos p = procesos.peek();
    System.out.println("Proceso Actual: ");
    System.out.println("Nombre: " + p.getNombre());
    System.out.println("ID: " + p.getID());
    System.out.println("Instrucciones por ejecutar: " + p.getInsTotal());
    System.out.println("Instrucciones ejecutadas: "+p.getInsEjec());
    System.out.println("Tamano: "+p.getTamanoTotal());
    //Ver tabla de páginas del proceso
    System.out.println("Tabla de páginas");
    System.out.println("Pagina | Frame");
    for (int i = 0; i < p.paginas.length; i++) {
      System.out.println(i+" | "+p.paginas[i]);
    }
  }


  public void pasarP(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    if(procesos.size()==0){
      System.out.println("La cola esta vacia");
      return;
    }
    Procesos p = procesos.remove();
    procesos.add(p);
    System.out.println("Se detuvo el proceso: "+p.getNombre());
    System.out.println("Instrucciones por ejecutar: "+p.getInsTotal());
  }


    public void matarP(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    if(procesos.size()==0){
      System.out.println("La cola esta vacia");
      return;
    }
    Procesos p = procesos.remove();
    almacenam.eliminarProceso(p);
    almacenam.procesosElim.add(p);
    System.out.println("Se elimino el proceso: "+p.getNombre());
    System.out.println("Instrucciones por ejecutar: "+p.getInsTotal());
  }

  public void desfragmentarM(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    almacenam.desfragmentar();
  }

    public void salir(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("Procesos Finalizados: ");
    almacenam.imprimirFin();
    System.out.println("Procesos Faltantes: ");
    if(procesos.size()==0){
      System.out.println("La cola esta vacia");
      return;
    }
    for(Procesos p : procesos){
      System.out.println("Nombre: " + p.getNombre());
      System.out.println("ID: " + p.getID());
      System.out.println("Instrucciones por ejecutar: " + p.getInsTotal());
      System.out.println("-----------------------------");
    }
  }

}