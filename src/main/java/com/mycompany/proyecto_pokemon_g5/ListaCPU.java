/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_pokemon_g5;


public class ListaCPU {

    NodoCPU cabeza;

    public ListaCPU() {
        this.cabeza = null;
    }

    public void insertarListaCPU(PokemonCPU pokemonCPU) {
        
        NodoCPU nuevoNodo = new NodoCPU(pokemonCPU);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            System.out.println("agregado exitoso");// para ver si se esta creando o no
            
        } else {
            NodoCPU aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();//pare hasta que el siguiente sea null
            }
            System.out.println("agregado exitoso");
            aux.setSiguiente(nuevoNodo);
        }//aqui ya insertamos en la lista
    }

    public void eliminarRandom() {
        
        int largoLista = 8;
        int numeroRandom = (int) Math.round(Math.random() * largoLista);

        if (cabeza != null) {//si hay algo en cabeza, entre..
            if (cabeza.getPokemon().getIndice() == numeroRandom) {
                cabeza = cabeza.getSiguiente();//seteamos el siguiente de cabeza y lo borramos
                largoLista--;
            } else {
                NodoCPU aux = cabeza;//aux como cabeza mientras no acabe la lista de pokemon
                while (aux.getSiguiente() != null
                        && aux.getSiguiente().getPokemon().getIndice() < numeroRandom) {
                    aux = aux.getSiguiente();//avanza en la lista
                }
                //si es el de adelante, se borra
                if (aux.getSiguiente() != null
                        && aux.getSiguiente().getPokemon().getIndice() == numeroRandom) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    largoLista--;
                }
            }
        }
    }
    
    public void eliminarMuerto(){
        
        if (cabeza != null) {//si hay algo en cabeza, entre..
            if (cabeza.getPokemon().getIndice()== 0) {
                cabeza = cabeza.getSiguiente();//seteamos el siguiente de cabeza y lo borramos
                
            } else {
                NodoCPU aux = cabeza;//aux como cabeza mientras no acabe la lista de pokemon
                while (aux.getSiguiente() != null
                        && aux.getSiguiente().getPokemon().getIndice() < 0) {
                    aux = aux.getSiguiente();//avanza en la lista
                }
                //si es el de adelante, se borra
                if (aux.getSiguiente() != null
                        && aux.getSiguiente().getPokemon().getIndice() == 0) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
            }
        }
    }

    public void mostrar() {// verificamos si se puede o no crear la lista random para CPU
        NodoCPU aux = cabeza;
        int contador = 0;
        while (aux != null) {
            System.out.println(contador + ". " + aux.getPokemon().getNombreP());
            aux = aux.getSiguiente();
            contador++;
        }
    }

}
