package com.Digis01.FArceConsumoPokeAPI.Controller;

import com.Digis01.FArceConsumoPokeAPI.DAO.PokemonService;
import com.Digis01.FArceConsumoPokeAPI.ML.PokemonEvolucion;
import com.Digis01.FArceConsumoPokeAPI.ML.Pokemon;
import com.Digis01.FArceConsumoPokeAPI.ML.Result;
import java.util.ArrayList;
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
        /*
            Mala implementacion de las generaciones
         */
        List<Pokemon> pokemons = pokemonService.getAllPokemon();
        String title = "Pokédex – Primera Generación";
        model.addAttribute("tituloGeneracion", title);
        model.addAttribute("pokemons", pokemons);
        return "index";
    }

    @GetMapping({"", "/", "/generation/{gen}"})
    public String pokedex(@PathVariable(required = false) Integer gen, Model model) {
        /*
            Mala implementacion de las generaciones
         */
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
        /*
            Buscar un pokemon en especifico sin la busqueda de la informacion dinamica
         */
        Pokemon pokemon = pokemonService.getPokemon(nombre);
        if (pokemon != null) {
            pokemon.getSprites().getFrontDefault();
            pokemon.getTypes().get(0).getType().getName();
        } else {
            model.addAttribute("mensajeError", "No se encontró el Pokémon ingresado: " + nombre);
        }

        var response = pokemonService.getAllPokemons();
        model.addAttribute("pokemons", response.getResults());
        model.addAttribute("pokemon", pokemon);
        return "indexold";
    }

    @GetMapping("/todos")
    public String todosPokemones(Model model) {
        /*
            Todos los pokemones sin limitaciones de generacion
         */
        var response = pokemonService.getAllPokemons();
        model.addAttribute("pokemons", response.getResults());
//        List<PokemonWithColor> pokemonsWithColor = response.getResults().stream().map(summary -> {
//            String color = "";
//            try {
//                PokemonSpecies species = pokemonService.getPokemonSpecies(summary.getName());
//                color = species.getColor().getName();
//            } catch (Exception e) {
//                color = "unknown";  // Si hay error
//            }
//            return new PokemonWithColor(summary.getName(), summary.getUrl(), color);
//        }).collect(Collectors.toList());
        return "indexold";
    }

    @GetMapping("/pokedex/generation/{id}")
    public String getPokemonsByGeneration(@PathVariable int id, Model model) {
//        List<PokemonSpecies> pokemons = pokemonService.getPokemonsByGen(id);
//        model.addAttribute("pokemons", pokemons);
        return "fragments/pokemon-cards :: pokemonList";
    }

    @GetMapping("/pokemon/{id}")
    public String getPokemonDetail(@PathVariable String id, Model model) {
        Result result = new Result();

        try {
            Pokemon detail = pokemonService.getPokemonDetail(id);

            // Validaciones para evitar errores
            if (detail.getSprites() != null && detail.getSprites().getOther() != null) {
                if (detail.getSprites().getFrontDefault() != null) {
                    detail.getSprites().getFrontDefault();
                }
                if (detail.getSprites().getFrontShiny() != null) {
                    detail.getSprites().getFrontShiny();
                }
                if (detail.getSprites().getOther().getShowdown() != null) {
                    detail.getSprites().getOther().getShowdown().getFrontDefault();
                    detail.getSprites().getOther().getShowdown().getFrontShiny();
                }
            }

            if (detail.getTypes() != null && !detail.getTypes().isEmpty()) {
                detail.getTypes().get(0).getType().getName();
            }

            if (detail.getMoves() != null && !detail.getMoves().isEmpty()) {
                detail.getMoves().get(0);
            }

            model.addAttribute("pokemon", detail);

            String baseName = detail.getName().split("-")[0];

            if (detail.isIsDefault()) {
                List<PokemonEvolucion> evoluciones = pokemonService.getEvoluciones(baseName);
                model.addAttribute("evoluciones", evoluciones);
            } else {
                model.addAttribute("evoluciones", new ArrayList<>());
            }

            model.addAttribute("megas", new ArrayList<>());

            result.correct = true;
            result.object = detail;

        } catch (Exception ex) {
            result.correct = false;
            result.ex = ex;
            result.errorMessage = "Error al obtener detalles del Pokémon";
            model.addAttribute("error", result.errorMessage);
            model.addAttribute("exception", result.ex.getMessage());
            ex.printStackTrace();
            return "error";
        }

        return "detalle";
    }

}
