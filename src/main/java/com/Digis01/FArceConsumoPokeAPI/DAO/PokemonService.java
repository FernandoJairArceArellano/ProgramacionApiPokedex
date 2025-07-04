package com.Digis01.FArceConsumoPokeAPI.DAO;

import com.Digis01.FArceConsumoPokeAPI.ML.EvolutionChainResponse;
import com.Digis01.FArceConsumoPokeAPI.ML.MoveData;
import com.Digis01.FArceConsumoPokeAPI.ML.MoveSlot;
import com.Digis01.FArceConsumoPokeAPI.ML.PokemonListResponse;
import com.Digis01.FArceConsumoPokeAPI.ML.Pokemon;
import com.Digis01.FArceConsumoPokeAPI.ML.PokemonEvolucion;
import com.Digis01.FArceConsumoPokeAPI.ML.PokemonResponse;
import com.Digis01.FArceConsumoPokeAPI.ML.PokemonSpecies;
import com.Digis01.FArceConsumoPokeAPI.ML.TypeData;
import com.Digis01.FArceConsumoPokeAPI.ML.TypeSlot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    private final String baseUrl = "https://pokeapi.co/api/v2/pokemon/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Pokemon getPokemon(String name) {
        String url = baseUrl + name.toLowerCase();
        try {
            Pokemon pokemon = restTemplate.getForObject(url, Pokemon.class);
            if (pokemon != null) {
                agregarIconosTipos(pokemon);
            }
            return pokemon;
        } catch (HttpClientErrorException e) {
            // Puedes loguear el error si deseas
            System.out.println("No se encontró el Pokémon: " + name);
            return null;
        }
    }

    public List<Pokemon> getAllPokemon() {
        String url = baseUrl + "?limit=151";
        PokemonListResponse response = restTemplate.getForObject(url, PokemonListResponse.class);

        List<Pokemon> pokemons = new ArrayList<>();

        for (var result : response.getResults()) {
            Pokemon pokemon = restTemplate.getForObject(result.getUrl(), Pokemon.class);
            agregarIconosTipos(pokemon);
            pokemons.add(pokemon);
        }

        return pokemons;
    }

    public PokemonResponse getAllPokemons() {
        return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon?limit=1025", PokemonResponse.class);
    }

//    public List<PokemonSpecies> getPokemonsByGen(int genId) {
//        String url = "https://pokeapi.co/api/v2/generation/" + genId;
//        GenerationResponse response = restTemplate.getForObject(url, GenerationResponse.class);
//
//        // Ordenamiento por ID ascendente
//        return response.getPokemon_species().stream()
//                .sorted(Comparator.comparingInt(species -> {
//                    String[] parts = species.getUrl().split("/");
//                    return Integer.parseInt(parts[parts.length - 1]);
//                }))
//                .collect(Collectors.toList());
//
//    }
    public List<Pokemon> getPokemonsByGeneration(int gen) {
        int start = 1, end = 151;

        switch (gen) {
            case 2 -> {
                start = 152;
                end = 251;
            }
            case 3 -> {
                start = 252;
                end = 386;
            }
            case 4 -> {
                start = 387;
                end = 493;
            }
            case 5 -> {
                start = 494;
                end = 649;
            }
            case 6 -> {
                start = 650;
                end = 721;
            }
            case 7 -> {
                start = 722;
                end = 809;
            }
            case 8 -> {
                start = 810;
                end = 905;
            }
            case 9 -> {
                start = 906;
                end = 1025;
            }
        }

        List<Pokemon> pokemons = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            Pokemon pokemon = restTemplate.getForObject(baseUrl + i, Pokemon.class);
            agregarIconosTipos(pokemon);
            pokemons.add(pokemon);
        }

        return pokemons;
    }

    public PokemonSpecies getColors(String typeColor) {
//        Sring url = ""
        return null;
    }

    public TypeData getPokemonType(String typeName) {
        String url = "https://pokeapi.co/api/v2/type/" + typeName.toLowerCase();
        return restTemplate.getForObject(url, TypeData.class);
    }

    private void agregarIconosTipos(Pokemon pokemon) {
        if (pokemon.getTypes() != null) {
            for (TypeSlot typeSlot : pokemon.getTypes()) {
                try {
                    TypeData typeData = getPokemonType(typeSlot.getType().getName());
                    String iconUrl = typeData
                            .getSprites()
                            .getGenerationIX()
                            .getScarletViolet()
                            .getNameIcon();
                    typeSlot.setTypeIconUrl(iconUrl);
                } catch (Exception e) {
                    typeSlot.setTypeIconUrl(null);
                }
            }
        }
    }

    public MoveData getMoveData(String moveName) {
        String url = "https://pokeapi.co/api/v2/move/" + moveName.toLowerCase();
        return restTemplate.getForObject(url, MoveData.class);
    }

    private void agregarDetallesMovimientos(Pokemon pokemon) {
        if (pokemon.getMoves() != null) {
            for (MoveSlot moveSlot : pokemon.getMoves()) {
                try {
                    MoveData moveData = getMoveData(moveSlot.getMove().getName());
                    moveSlot.setMoveData(moveData);
                } catch (Exception ex) {
                    // Si falla, no agregamos nada
                }
            }
        }
    }

    public PokemonSpecies getPokemonSpecies(String idOrName) {
        String url = "https://pokeapi.co/api/v2/pokemon-species/" + idOrName;
        return restTemplate.getForObject(url, PokemonSpecies.class);
    }

    public Pokemon getPokemonDetail(String idOrName) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + idOrName;
        Pokemon pokemonDetail = restTemplate.getForObject(url, Pokemon.class);

        agregarIconosTipos(pokemonDetail);
        agregarDetallesMovimientos(pokemonDetail);
        return pokemonDetail;
    }

    public List<PokemonEvolucion> getEvoluciones(String idOrName) {
        String speciesUrl = "https://pokeapi.co/api/v2/pokemon-species/" + idOrName.toLowerCase();
        PokemonSpecies species = restTemplate.getForObject(speciesUrl, PokemonSpecies.class);

        if (species == null || species.getEvolution_chain() == null) {
            return Collections.emptyList();
        }

        String evoChainUrl = species.getEvolution_chain().getUrl();
        EvolutionChainResponse chainResponse = restTemplate.getForObject(evoChainUrl, EvolutionChainResponse.class);
        List<PokemonEvolucion> evoluciones = new ArrayList<>();
        agregarNodoYEvoluciones(chainResponse.getChain(), evoluciones);

        return evoluciones;
    }

    private boolean buscarEvolucionesDesde(EvolutionChainResponse.Chain node, String targetName, List<PokemonEvolucion> result) {
        String name = node.getSpecies().getName();

        if (name.equalsIgnoreCase(targetName)) {
            agregarNodoYEvoluciones(node, result);
            return true;
        }

        for (EvolutionChainResponse.Chain next : node.getEvolves_to()) {
            if (buscarEvolucionesDesde(next, targetName, result)) {
                return true;
            }
        }
        return false;
    }

    private void agregarNodoYEvoluciones(EvolutionChainResponse.Chain node, List<PokemonEvolucion> result) {
        String nombre = node.getSpecies().getName();
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombre;
        Pokemon p = restTemplate.getForObject(url, Pokemon.class);
        result.add(new PokemonEvolucion(nombre, p.getSprites().getFrontDefault()));

        for (EvolutionChainResponse.Chain next : node.getEvolves_to()) {
            agregarNodoYEvoluciones(next, result);
        }
    }
}
