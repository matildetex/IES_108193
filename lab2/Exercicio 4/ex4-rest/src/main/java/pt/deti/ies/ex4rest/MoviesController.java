package pt.deti.ies.ex4rest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
	private List<String> quotes;
	MovieList movieList = new MovieList();

	@GetMapping("/api/quote")
	public String quote() {
		try {
			String quote = movieList.getRandomQuote();
			if (quote != null) {
				return "{\"quote\": \"" + quote + "\"}";
			} else {
				return "{\"error\": \"Nenhuma citação disponível.\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"error\": \"Ocorreu um erro ao buscar uma citação.\"}";
		}
	}
	

	@GetMapping("/api/shows")
	public List<Map<String, String>> show() {
		List<Map<String, String>> output = new ArrayList<>();
		for (Movie movie : movieList.getMovieList()) {
			Map<String, String> data = new LinkedHashMap<>();
			data.put("id", movie.getShowid());
			data.put("show", movie.getTitle());
			output.add(data);
		}
		return output;
	}


	@GetMapping("/api/quotes")
	public Map<String, Object> quote(@RequestParam(value = "show", defaultValue = "1001") String movieID) {
		int id = Integer.parseInt(movieID);

		ArrayList<String> quotes = movieList.getQuotesForMovie(movieID);
	
		String title = movieList.getTitleFromMovieId(movieID);
	
		if ("Movie Id Not Found".equals(title)) {
			return null; // Handle the case where the movie ID is not found.
		}
	
		Map<String, Object> output = new LinkedHashMap<>();
		output.put("id", movieID);
		output.put("show", title);
		output.put("quotes", quotes);
	
		return output;
	}
	
	}


