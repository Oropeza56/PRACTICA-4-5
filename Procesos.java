
public class Procesos{

  private String nombreP;

  private int idP;

  private int instT;

  private int instE;

  private int tamanoTotal;

  int[] paginas;


  public Procesos(String nombre, int id, int instruccionesTotales, int tamanoTotal, int paginas[]){
    this.nombreP = nombre;
    this.idP = id;
    this.instT = instruccionesTotales;
    this.tamanoTotal = tamanoTotal;
    this.instE = 0;
    this.paginas = paginas;
  }


  public String getNombre() {
    return this.nombreP;
  }

  public void setNombre(String nombre) {
    this.nombreP = nombre;
  }


  public int getID() {
    return this.idP;
  }

  public void setID(int id) {
    this.idP = id;
  }


  public int getInsTotal() {
    return this.instT;
  }

  public void setInsTotal(int insTotal) {
    this.instT = insTotal;
  }


  public int getInsEjec() {
    return this.instE;
  }


  public void setInsEjec(int insEjec) {
    this.instE = insEjec;
  }

  public int getTamanoTotal() {
    return this.tamanoTotal;
  }
}