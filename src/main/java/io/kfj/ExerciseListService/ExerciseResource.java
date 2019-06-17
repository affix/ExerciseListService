package io.kfj.ExerciseListService;

import io.kfj.ExerciseListService.Models.Exercise;
import io.kfj.ExerciseListService.Repositories.ExerciseRepository;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ExerciseResource {

    @Inject
    ExerciseRepository er;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercise> index() {
        return er.getAll();
    }
}