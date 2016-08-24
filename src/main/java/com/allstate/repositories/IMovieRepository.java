package com.allstate.repositories;

import com.allstate.entities.Movie;
import com.allstate.enums.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by localadmin on 8/24/16.
 */
public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer> {
    public Movie findByName(String name);
    public List<Movie> findByRatingOrderByReleasedDesc(Rating rating);
}
