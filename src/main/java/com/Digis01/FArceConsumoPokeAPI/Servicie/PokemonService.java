package com.Digis01.FArceConsumoPokeAPI.Servicie;

import com.Digis01.FArceConsumoPokeAPI.ML.PokemonDetail;
import com.Digis01.FArceConsumoPokeAPI.ML.PokemonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    // variable que representa un cliente HTTP reutilizable, que será asignado una sola vez
    private final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon?limit=151";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PokemonResponse getFirst151Pokemons() {
        return restTemplate.getForObject(POKEAPI_URL, PokemonResponse.class);
    }

    public PokemonDetail getPokemonDetail(String idOrName) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + idOrName;
        return restTemplate.getForObject(url, PokemonDetail.class);
    }
    
}
