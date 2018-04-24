/**
 * 
 */
package com.codeassi;


import java.util.LinkedHashMap;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.codeassi.model.MovieDetails;
import com.codeassi.serviceinterface.IMovieDetailService;



/**
 * @author kashraf
 *
 */


@Controller
@RestController
@RequestMapping("/movies")
public class MovieDetailController {
	
   @Autowired
   IMovieDetailService movieDetailService;
   
   
   @PostMapping(value="/createMovie")
	public @ResponseBody  MovieDetails createMovieDetail(@RequestBody MovieDetails movieDetails) {
				
			return movieDetailService.createMovieDetail(movieDetails);

	}

	
   @GetMapping(value="/{id}")
	public @ResponseBody MovieDetails getMovieDetailsById(@PathVariable("id") String Id){
		return (movieDetailService.getMovieDetailsById(Id) != null) ? movieDetailService.getMovieDetailsById(Id): null;

	}
   

   @PutMapping(value="/updateMovie")
  	public @ResponseBody MovieDetails updateMovieDetail(@RequestBody MovieDetails movieDetails){ 
	   return movieDetailService.updateMovieDetail(movieDetails);
  	}

	
   @DeleteMapping(value="/deleteMovie/{id}")
	public @ResponseBody Boolean deleteMovieDetailById(@PathVariable("id") String Id) {
		return movieDetailService.deleteMovieDetailById(Id);
	}
	
	
   	@GetMapping(value="/all")
	public @ResponseBody TreeMap<String, MovieDetails> getAllMovieDetails()
	{
		return movieDetailService.getAllMovieDetails();
	}
   	
   	@GetMapping
	public @ResponseBody LinkedHashMap<String, MovieDetails> sortObject(@RequestParam("sortColumn") String sortColumn, @RequestParam("sortType") String sortType){
		return movieDetailService.sortObject(sortColumn, sortType);

	}
   	
   	
}
