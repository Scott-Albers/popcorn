package com.allstate.repositories;

import com.allstate.entities.Actor;
import com.allstate.entities.Movie;
import com.allstate.entities.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by localadmin on 8/24/16.
 */
public interface  IActorRepository extends PagingAndSortingRepository<Actor, Integer> {

    @Query("select m from Movie m join m.actors a where a.id = :id")
    public Page<Movie> findAllMoviesByActorId(@Param("id") int id, Pageable pageable);


    @Query("select distinct s from Movie m join m.studio s join m.actors a where a.id = :id")
    public Page<Studio> findAllStudiosByActorId(@Param("id") int id, Pageable pageable);


}
