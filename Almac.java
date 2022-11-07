import java.util.*;

public class Almac{

	private int tam = 2048;
	int memoria[] = new int[tam];
    //estion gestion = new Gestion();
    // Queue <Procesos> proceso = gestion.procesos;

	  List <Procesos> procesosFin = new ArrayList<Procesos>();
	  List <Procesos> procesosElim = new ArrayList<Procesos>();

    public Almac() {
        for (int i = 0; i < tam; i++){
            memoria[i] = -1;
        }
    }

    public void imprimirFin(){
    	for(Procesos p : procesosFin){
            System.out.println("-----------------------");
            System.out.println("Nombre: "+p.getNombre());
            System.out.println("-----------------------");
        }
    }

     public void imprimirElim(){
        for(Procesos p : procesosElim){
            System.out.println("-----------------------");
            System.out.println("Nombre: "+p.getNombre());
            System.out.println("-----------------------");
        }
    }

public Procesos insertarProceso(String nombre, int id, int insTotal, int defEsp){
        double espacioP = 0;        
        int noPaginas = 0;

        double pE = (double) defEsp;

        espacioP= Math.pow(2,pE);

        int espacio = (int) espacioP;
        
        noPaginas = espacio/16;
        int paginas[] = new int[noPaginas];
        int paginasFaltantes = noPaginas;
        int p = 0;
        int frame = 0;
        int huecos = 0;

        for(int i : memoria){
            if(i==-1){
                huecos++;
            }
            if(huecos>noPaginas) break;
        }
        if(huecos<noPaginas) return null;

        while(frame < tam && paginasFaltantes>0){
            if(memoria[frame]==-1){
                paginas[p] = frame;
                memoria[frame] = id;
                p++;
                paginasFaltantes--;                        
            }
            frame++;                      
        }
        
        Procesos p2 = new Procesos(nombre, id, insTotal, espacio, paginas);
        return p2;
    }

     public void eliminarProceso(Procesos p){       
        int id = p.getID();
        for(int i=0; i<tam; i++){
            if(memoria[i] == id) 
                memoria[i] = -1;
        }
    }

   /* public void nombreP (int id){
        (Procesos p)

        }*/


        public void imprimirLista(){
        System.out.println("Proceso ID/Hueco | Localidad | Tamaño");
        int longitud = 0;
        int empieza = 0;
        int i = 0;
        int temp= 0;

        while(i < tam){
            longitud = 0;
            if(memoria[i] != -1){
                int id = memoria[i];
                empieza = i;
                while(i < tam && id == memoria[i]){
                    longitud++;
                    i++;                    
                }

                temp = empieza + longitud;
                /*for (int f= empieza ; f <= temp ; f++ ) {
                    System.out.println( f + "       |        " + id);  
                }*/

    System.out.println("Proceso " +id+ "        |  " +empieza*16+ " - "+ temp*16 + "  | " + longitud*16  );
 
            } else {
                empieza = i;
                while(i < tam && memoria[i] == -1){
                    longitud++;
                    i++;                    
                }
                int temp2 =0;
                temp2 = empieza+ longitud;
                System.out.println("Hueco            |  "+empieza*16+ " - "+ temp2 + "  | "+longitud);
            }
        }
    }


        public void desfragmentar(){
        int localizacionMemoriaTemp = 0;
        int memoriaTemp[] = new int[tam];
        for (int i=0; i<tam; i++) {
            memoriaTemp[i]=-1;
        }
        for (int i=0; i<tam; i++) {
            if(memoria[i]!=-1){
                memoriaTemp[localizacionMemoriaTemp]=memoria[i];
                localizacionMemoriaTemp++;
            }
        }

        memoria=memoriaTemp;
        System.out.println("La memoría se desfragmentó.");
    }

}
