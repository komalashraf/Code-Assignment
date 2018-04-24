package com.codeassi;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.codeassi.model.MovieDetails;
import com.codeassi.serviceinterface.IMovieDetailService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeAssignmentApplicationTests {

	@Autowired
	 IMovieDetailService movieDetailService;
	
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	@Test
	public void getMovieDetailsById() {
			
		try
		{
			assertTrue(new MovieDetails("1", "Test A", "action").equals(movieDetailService.getMovieDetailsById("1")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void createMovieDetailByURI() throws Exception {
		try
		{
		MovieDetails movieDetailObj = new MovieDetails("269", "Data 1", "thriller");
		ResponseEntity<MovieDetails> responseEntity = restTemplate.postForEntity("http://localhost:8080/movies/createMovie", movieDetailObj, MovieDetails.class);
	           
		MovieDetails movieDetails = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(true, movieDetails.equals(movieDetails));
		}
		catch(NullPointerException exp)
		{
			exp.printStackTrace();

		}
	    }
	
	}
	

