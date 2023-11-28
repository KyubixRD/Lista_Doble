public class Main
{

    public static void main(String[] args)
    {
        Lista_Doble obj = new Lista_Doble();

        obj.insertaPrimerNodo("Dani");
        obj.insertaAlFinal("Juan");
        obj.insertaAntesPrimerNodo("Pedro");
        obj.insertaAlFinal("Taylor");
        obj.insertaEntreNodos("Denis", "Emi");

        obj.buscarNodo("Pedro");
        obj.buscarNodoeInsertar("Pedro","Hola Profe");
        obj.IntercambiarNodo("Dani","Remplazo");

        obj.imprimir();
        System.out.println(obj);
    }
}