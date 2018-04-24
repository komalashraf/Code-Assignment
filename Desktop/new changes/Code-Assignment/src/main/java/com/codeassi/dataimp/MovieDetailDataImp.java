/**
 * 
 */
package com.codeassi.dataimp;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.codeassi.datainterface.IMovieDetailData;
import com.codeassi.model.MovieDetails;

/**
 * @author kashraf
 *
 */

@Repository
public class MovieDetailDataImp implements IMovieDetailData {

	TreeMap<String, MovieDetails> movieDetailsMap = new TreeMap<String, MovieDetails>();
	
	MovieDetailDataImp()
	{
		
		
		if(movieDetailsMap.isEmpty())
		{
			addMovieDetailsData();
		}
	}

	@Override
	public MovieDetails createMovieDetail(MovieDetails movieDetails) {
	
		if (!ListIsEmpty(movieDetailsMap) && recordExist(movieDetailsMap, movieDetails.getMovieId())) 
		{
			System.out.println("Record with Id " + movieDetails.getMovieId() + " already exist. Cannot create this record");
			return null;
		}

		else 
		{
			movieDetailsMap.put(movieDetails.getMovieId(), movieDetails);
			System.out.println("Record with Id " + movieDetails.getMovieId() + " is created.");
			return movieDetailsMap.get(movieDetails.getMovieId());
		}
	}

	@Override
	public MovieDetails getMovieDetailsById(String Id) {
		if(movieDetailsMap.containsKey(Id))
			return movieDetailsMap.get(Id);
		
		return null;

	}

	@Override
	public MovieDetails updateMovieDetail(MovieDetails movieDetails) {

		if (recordExist(movieDetailsMap, movieDetails.getMovieId())) {
			movieDetailsMap.put(movieDetails.getMovieId(), movieDetails);
			System.out.println("Record with Id " + movieDetails.getMovieId()
					+ " is updated.");
			return movieDetailsMap.get(movieDetails.getMovieId());
		}

		else {
			System.out.println("Record with Id " + movieDetails.getMovieId()
					+ " doesnot exist. Cannot update this record");
			return null;
		}
	}

	@Override
	public Boolean deleteMovieDetailById(String Id) {
		if (recordExist(movieDetailsMap, Id)) {
			movieDetailsMap.remove(Id);
			System.out.println("Record with Id " + Id + " is deleted.");
			return true;
		}

		else {
			System.out.println("Record with Id " + Id + " doesnot exist. Cannot delete this record");
			return false;
		}
	}
	
	
	@Override
	public Boolean ListIsEmpty( TreeMap<String, MovieDetails> movieDetailsMapData) {
		if (movieDetailsMapData.isEmpty()) {
			return true;
		}

		return false;

	}
	
	
	@Override
	public Boolean recordExist( TreeMap<String, MovieDetails> movieDetailsMapData, String Id) {
		 if (!movieDetailsMap.isEmpty() && movieDetailsMap.containsKey(Id)) {
					return true;
				}
		
		return false;

	}

	@Override
	public void addMovieDetailsData() {
		
		movieDetailsMap.put("1", new MovieDetails("1", "Test A", "action"));
		movieDetailsMap.put("2", new MovieDetails("2", "Test B", "horror"));
		movieDetailsMap.put("3", new MovieDetails("3", "Test C", "action"));
		movieDetailsMap.put("4", new MovieDetails("4", "Test D", "horror"));
		movieDetailsMap.put("5", new MovieDetails("5", "Test E", "action"));
	}


	@Override
	public TreeMap<String, MovieDetails> getAllMovieDetails() {
		return movieDetailsMap;
	}

	
	@Override
	public LinkedHashMap<String, MovieDetails> sortObject(String sortColumn, String sortType) {
			
		if(!movieDetailsMap.isEmpty() || movieDetailsMap!=null)
		{
			if(StringUtils.equalsIgnoreCase(sortType, "asc") && StringUtils.equalsIgnoreCase(sortColumn, "movieName"))
			{
				
				LinkedHashMap<String, MovieDetails> sortedMap = movieDetailsMap.entrySet().stream().sorted(Map.Entry.<String, MovieDetails>comparingByValue(MovieDetails.movieNameComparatorAscOrder))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
	
			return sortedMap;
			}
				
			if(StringUtils.equalsIgnoreCase(sortType, "des") && StringUtils.equalsIgnoreCase(sortColumn, "movieName")){
					LinkedHashMap<String, MovieDetails> sortedMap = movieDetailsMap.entrySet().stream().sorted(Map.Entry.<String, MovieDetails>comparingByValue(MovieDetails.movieNameComparatorDesOrder))
	                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                                (e1, e2) -> e1, LinkedHashMap::new));
					
				return sortedMap;
				}
			
		}

		return null;
	}

	
}
