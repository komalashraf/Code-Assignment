package com.codeassi.serviceinterface;

import java.util.LinkedHashMap;
import java.util.TreeMap;
import org.springframework.stereotype.Service;
import com.codeassi.model.MovieDetails;

/**
 * 
 */

/**
 * @author kashraf
 *
 */
@Service
public interface IMovieDetailService {

	public MovieDetails createMovieDetail(MovieDetails movieDetails);
	public MovieDetails getMovieDetailsById(String Id);
	public MovieDetails updateMovieDetail(MovieDetails movieDetails);
	public Boolean deleteMovieDetailById(String Id);
	public void addMovieDetailsData();
	public TreeMap<String, MovieDetails> getAllMovieDetails();
	public LinkedHashMap<String, MovieDetails> sortObject(String sortColumn, String sortType);
	
}
