package com.galli.poc.repository;

import com.galli.poc.model.TournamentEvent;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Esta clase busca la informacion de torneos que mockie en otra API: https://designer.mocky.io/
 * Para probar: https://www.baeldung.com/intro-to-feign
 *
 * Get url: https://run.mocky.io/v3/85ad46f6-2de9-4dad-9197-73783acf4159
 * La info que devuelve:
 * [
 *        {
 * 		"id": "123e4567-e89b-42d3-a456-556642440000",
 * 		"game": "Ajedrez",
 * 		"enrolled": 16,
 * 		"date": "11-11-2020 18:00",
 * 		"location": {
 * 			"address": "San Martin 598",
 * 			"locality": "CABA",
 * 			"province": "Buenos Aires",
 * 			"lat" : 37.4211274197085,
 *             "lng" : -122.0855988802915
 *        }
 *    },
 *    {
 * 		"id": "123e4567-e80a-42a3-8056-556642440000",
 * 		"game": "Super Mario",
 * 		"enrolled": 980,
 * 		"date": "12-11-2020 18:00",
 * 		"location": {
 * 			"address": "San Martin 598",
 * 			"locality": "CABA",
 * 			"province": "Buenos Aires",
 * 			"lat" : 37.4211274197085,
 *             "lng" : -122.0855988802915
 *        }
 *    },
 *    {
 * 		"id": "123e4567-e80a-42a3-8056-556642440000",
 * 		"game": "Mario kart",
 * 		"enrolled": 1501,
 * 		"date": "18-11-2020 14:00",
 * 		"location": {
 * 			"address": "Paseo colon 1532",
 * 			"locality": "CABA",
 * 			"province": "Buenos Aires",
 * 			"lat" : 37.4211274197084,
 *             "lng" : -122.0855988802920
 *        }
 *    }
 * ]
 *
 */
public class TournamentEventRepository {

    public static final String URL_GET_TOURNAMENT_EVENT = "https://run.mocky.io/v3/85ad46f6-2de9-4dad-9197-73783acf4159";

    final private RestTemplate restTemplate;

    public TournamentEventRepository() {
        this.restTemplate = new RestTemplate();
    }

    public List<TournamentEvent> getAlls() {
        return Optional.ofNullable(restTemplate.getForEntity(URL_GET_TOURNAMENT_EVENT,TournamentEvent[].class).getBody())
                .map(Arrays::asList).orElseGet(ArrayList::new);
    }

}
