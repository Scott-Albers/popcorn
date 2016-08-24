package com.allstate.controllers;


import com.allstate.entities.Actor;
import com.allstate.entities.Movie;
import com.allstate.entities.Studio;
import com.allstate.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/actors")
public class ActorController {
    private ActorService service;

    @Autowired
    public void setService(ActorService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Actor> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}/movies"}, method = RequestMethod.GET)
    public Page<Movie> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAllMoviesByActorId(id, page);
    }

    @RequestMapping(path = {"/{id}/studios"}, method = RequestMethod.GET)
    public Page<Studio> studios(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAllStudiosByActorId(id, page);
    }


    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Actor show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path= {"", "/"}, method = RequestMethod.POST)
    public Actor create(@RequestBody Actor  actor){
        return this.service.create(actor);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
//    public Movie update(@PathVariable int id, @RequestBody Movie movie) {
//        return this.service.update(id, movie);
//    }

}
