public class Lista_Doble {

    Node topForward;
    Node topBackward;

    //Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato){
        if (topForward == null) { //La lista está vacía
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;

            topBackward = topForward;

            return true;
        }
        else {
            return false;
        }
    }

    public void imprimir(){
        System.out.print("[X]");

        for (Node temp = this.topForward; temp != null; temp = temp.next){
            System.out.print(" <- [ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    public String toString(){
        String cadAux = "[X]";
        for (Node temp = this.topForward; temp != null; temp = temp.next){
            cadAux += " <- [ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n";

        return cadAux;
    }

    public void insertaAntesPrimerNodo(String nombre){
        Node temp;
        temp = new Node ();
        temp.name = nombre;
        temp.next = this.topForward;
        this.topForward.previous = temp;
        this.topForward = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre){
        Node temp = new Node ();
        temp.name = nombre;
        temp.next = null;

        temp.previous = this.topBackward;
        this.topBackward.next = temp;
        this.topBackward = temp;
        temp = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        //boolean NodoNoEncontrado = true;

        while ( (temp2 != null)
                && temp2.name.equals(buscado) == false ) {
            temp2 = temp2.next;
        }

        if (temp2 != null){  //Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;

            temp.previous = temp2;
            temp.next.previous = temp;

            temp = null;
            temp2 = null;

            return true;
        }
        else return false;
    }

    //Métodos de borrado
    public void borrarPrimerNodo(){
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }

    public void borrarUltimoNodo(){
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }


    //Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado){
        Node temp = this.topForward;

        while ( (temp != null)
                && temp.name.equals(buscado) == false ) {
            temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;

            return true;
        }
        else return false;
    }

    //Metodo para buscar un nodo c:
    public Node buscarNodo(String buscado)
    {
        Node temp = topForward;

        while (!temp.name.equalsIgnoreCase(buscado))
        {
            temp = temp.next;
        }

        return temp;
    }


    public void buscarNodoeInsertar(String buscado, String nuevoNombre) {
        Node encontrado = buscarNodo(buscado);

        if (encontrado != null) {

            // Creación del nuevo nodo
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoNombre;

            // Enlace del nuevo nodo
            nuevoNodo.next = encontrado.next;
            if (encontrado.next != null)
            {
                encontrado.next.previous = nuevoNodo;
            }
            encontrado.next = nuevoNodo;

            // Enlace de preview
            nuevoNodo.previous = encontrado;
        }
    }

    public void IntercambiarNodo(String buscado, String nuevo)
    {
        Node valorEncontrado = buscarNodo(buscado);

        if (valorEncontrado != null)
        {
            Node temp2 = topForward;

            while (temp2 != null && !temp2.name.equalsIgnoreCase(buscado))
            {
                temp2 = temp2.next;
            }

            temp2.name = nuevo;
            temp2 = null;
        }
    }

}


