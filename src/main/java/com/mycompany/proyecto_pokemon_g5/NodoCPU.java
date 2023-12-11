/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_pokemon_g5;


public class NodoCPU {
    NodoCPU next;
    private PokemonCPU pokemonCPU;
    
    public NodoCPU(PokemonCPU pokemonCPU) 
    {
        this.pokemonCPU = pokemonCPU;
        this.next = null;
    }

    public PokemonCPU getPokemon() {
        return pokemonCPU;
    }

    public NodoCPU getSiguiente() 
    {
        return next;
    }

    public void setSiguiente(NodoCPU siguiente) 
    {
        this.next = siguiente;
    }
}
