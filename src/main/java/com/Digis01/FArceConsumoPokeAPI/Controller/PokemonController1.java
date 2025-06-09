package com.Digis01.FArceProgramacionConsumoPokeAPI.Controller;

import com.Digis01.FArceProgramacionConsumoPokeAPI.DAO.PokemonService;
import com.Digis01.FArceProgramacionConsumoPokeAPI.ML.Pokemon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pokedex")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Pokemon> pokemons = pokemonService.getAllPokemon();
        String title = "Pokédex – Primera Generación";
        model.addAttribute("tituloGeneracion", title);
        model.addAttribute("pokemons", pokemons);
        return "index";
    }

    @GetMapping({"", "/", "/generation/{gen}"})
    public String pokedex(
            @PathVariable(required = false) Integer gen,
            Model model
    ) {
        int generation = (gen == null) ? 1 : gen;
        List<Pokemon> pokemons = pokemonService.getPokemonsByGeneration(generation);

        String title;
        switch (generation) {
            case 2 ->
                title = "Pokédex – Segunda Generación";
            case 3 ->
                title = "Pokédex – Tercera Generación";
            case 4 ->
                title = "Pokédex – Cuarta Generación";
            case 5 ->
                title = "Pokédex – Quinta Generación";
            case 6 ->
                title = "Pokédex – Sexta Generación";
            case 7 ->
                title = "Pokédex – Séptima Generación";
            case 8 ->
                title = "Pokédex – Octava Generación";
            case 9 ->
                title = "Pokédex – Novena Generación";
            default ->
                title = "Pokédex – Primera Generación";
        }

        model.addAttribute("pokemons", pokemons);
        model.addAttribute("activeGen", generation);
        model.addAttribute("tituloGeneracion", title);
        return "index";
    }

    @PostMapping("/buscar")
    public String buscarPokemon(@RequestParam("nombre") String nombre, Model model) {
        Pokemon pokemon = pokemonService.getPokemon(nombre);
        pokemon.getSprites().getFrontDefault();
        pokemon.getTypes().get(0).getType().getName();
        model.addAttribute("pokemon", pokemon);
        return "index";
    }
}
