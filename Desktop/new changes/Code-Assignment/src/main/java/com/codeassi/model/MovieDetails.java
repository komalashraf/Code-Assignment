/**
 * 
 */
package com.codeassi.model;



import java.util.Comparator;

import org.apache.commons.lang.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author kashraf
 *
 */

public class MovieDetails  {
	
	private String movieId;
	private String name;
	private String movieType;
	
	public MovieDetails(@JsonProperty("movieId")String movieId, @JsonProperty("name")String name, @JsonProperty("movieType")String movieType) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.movieType = movieType;
	}	
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	
	 public boolean equals(MovieDetails object) {
	        if( StringUtils.equalsIgnoreCase(this.movieId, object.movieId) && StringUtils.equalsIgnoreCase(this.name, object.name) && StringUtils.equalsIgnoreCase(this.movieType, object.movieType)) { 
	            return true;
	        }
	        else return false;
	    }
	 
	 
	 public static Comparator<MovieDetails> movieNameComparatorAscOrder = new Comparator<MovieDetails>() {
		    public int compare(MovieDetails object1, MovieDetails object2) {
		      String movieName = ((MovieDetails) object1).getName();
		      String movieName1 = ((MovieDetails) object2).getName();
	
		      return movieName.compareTo(movieName1);
		    }
		  };
		  
		 
		  public static Comparator<MovieDetails> movieNameComparatorDesOrder = new Comparator<MovieDetails>() {
			    public int compare(MovieDetails object1, MovieDetails object2) {
			      String movieName = ((MovieDetails) object1).getName();
			      String movieName1 = ((MovieDetails) object2).getName();
		
			      return movieName1.compareTo(movieName);
			    }
			  };


		  		  
}
