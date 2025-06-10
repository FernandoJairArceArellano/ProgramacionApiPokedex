package com.Digis01.FArceConsumoPokeAPI.Controller;

import com.Digis01.FArceConsumoPokeAPI.ML.PokemonDetail;
import com.Digis01.FArceConsumoPokeAPI.Servicie.pokemonsrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class controllerpoke {

    @Autowired
    private pokemonsrv pokemonService;

    @GetMapping("/")
    public String showPokemons(Model model) {
        var response = pokemonService.getFirst151Pokemons();
        model.addAttribute("pokemons", response.getResults());
        return "indexold";
    }

    @GetMapping("/pokemonesss/{id}")
    public String getPokemonDetail(@PathVariable String id, Model model) {
        PokemonDetail detail = pokemonService.getPokemonDetail(id);
        model.addAttribute("pokemon", detail);
        return "detalle";
    }

}
