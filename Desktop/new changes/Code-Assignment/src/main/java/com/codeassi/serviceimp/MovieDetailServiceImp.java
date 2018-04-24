/**
 * 
 */
package com.codeassi.serviceimp;

import java.util.LinkedHashMap;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeassi.datainterface.IMovieDetailData;
import com.codeassi.model.MovieDetails;
import com.codeassi.serviceinterface.IMovieDetailService;

/**
 * @author kashraf
 *
 */

@Service
public class MovieDetailServiceImp implements IMovieDetailService {
	
      @Autowired
	   IMovieDetailData movieDetailData;
     
       
       
	@Override
	public MovieDetails createMovieDetail(MovieDetails movieDetails) {
		return movieDetailData.createMovieDetail(movieDetails);	
	}

	
	@Override
	public MovieDetails getMovieDetailsById(String Id){
		return movieDetailData.getMovieDetailsById(Id);
	}

	
	@Override
	public MovieDetails updateMovieDetail(MovieDetails movieDetails) {
		return movieDetailData.updateMovieDetail(movieDetails);
	}

	
	@Override
	public Boolean deleteMovieDetailById(String Id) {
		return movieDetailData.deleteMovieDetailById(Id);
	}

	@Override
	public void addMovieDetailsData() {
		 movieDetailData.addMovieDetailsData();	
	}
	
	@Override
	public TreeMap<String, MovieDetails> getAllMovieDetails()
	{
		return movieDetailData.getAllMovieDetails();
	}


	@Override
	public LinkedHashMap<String, MovieDetails> sortObject(String sortColumn,
			String sortType) {
		return movieDetailData.sortObject(sortColumn, sortType);
	}
}
