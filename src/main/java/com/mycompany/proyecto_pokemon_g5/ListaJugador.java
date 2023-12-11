/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_pokemon_g5;


public class ListaJugador {
    
    NodoJugador cabeza; 
    
        public ListaJugador() {
        this.cabeza = null;
    }
    
    public void insertarListaJugador(Pokemon pokemon){
        NodoJugador nuevoNodo = new NodoJugador(pokemon);
        if(cabeza==null){
            cabeza= nuevoNodo;
            System.out.println("agregado exitoso");
        }else{
            NodoJugador aux = cabeza;
            while (aux.getSiguiente()!=null){
                aux = aux.getSiguiente();//pare hasta que el siguiente sea null
                }
            System.out.println("agregado exitoso");
            aux.setSiguiente(nuevoNodo);
        }//aqui ya insertamos en la lista         
    }
    
    public void mostrar(){
        NodoJugador aux = cabeza;
        int contador = 0;
        while (aux != null) {
            System.out.println(contador + ". " + aux.getPokemon().getNombreP());
            aux = aux.getSiguiente();
            contador++;
        }
    }
    public String obtenerStringEnPosicion(int posicion) {
        int contador = 0;
        NodoJugador nodoActual = cabeza;
        while (nodoActual != null) {
            if (contador == posicion) {
                return nodoActual.getPokemon().getNombreP();
            }
            contador++;
            nodoActual = nodoActual.getSiguiente();
        }
        return null; // Si la posición no existe en la lista
    }
    
    
}
