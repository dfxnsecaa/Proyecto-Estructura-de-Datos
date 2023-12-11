/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_pokemon_g5;



public class NodoJugador {
    NodoJugador next;
    private Pokemon pokemon;
    
    public NodoJugador(Pokemon pokemon) 
    {
        this.pokemon = pokemon;
        this.next = null;
    }

    public Pokemon getPokemon() 
    {
        return pokemon;
    }

    public NodoJugador getSiguiente() 
    {
        return next;
    }

    public void setSiguiente(NodoJugador siguiente) 
    {
        this.next = siguiente;
    }
}


