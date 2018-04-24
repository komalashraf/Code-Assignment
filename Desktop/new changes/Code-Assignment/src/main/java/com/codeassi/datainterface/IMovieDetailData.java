/**
 * 
 */
package com.codeassi.datainterface;

import java.util.LinkedHashMap;
import java.util.TreeMap;
import org.springframework.stereotype.Repository;
import com.codeassi.model.MovieDetails;

/**
 * @author kashraf
 *
 */
@Repository
public interface IMovieDetailData {

	 public MovieDetails createMovieDetail(MovieDetails movieDetails);
	 public MovieDetails getMovieDetailsById(String Id);
	 public MovieDetails updateMovieDetail(MovieDetails movieDetails);
	 public Boolean deleteMovieDetailById(String Id);
	 public Boolean recordExist(TreeMap<String, MovieDetails> movieDetailsMapData, String Id);
	 public void addMovieDetailsData();
	 public TreeMap<String, MovieDetails> getAllMovieDetails(); 
	 public Boolean ListIsEmpty( TreeMap<String, MovieDetails> movieDetailsMapData);
	 public LinkedHashMap<String, MovieDetails> sortObject(String sortColumn, String sortType);
}
