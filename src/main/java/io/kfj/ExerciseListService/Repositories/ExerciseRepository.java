package io.kfj.ExerciseListService.Repositories;

import io.kfj.ExerciseListService.Models.Exercise;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;

@ApplicationScoped
public class ExerciseRepository {

  @Inject
  EntityManager em;

  @Transactional

  public void createExercise(String exerciseName) {
    Exercise exercise = new Exercise();
    exercise.setName(exerciseName);
    em.persist(exercise);
  }

  @SuppressWarnings("unchecked")
  public List<Exercise> getAll() {
    try {
      return em.createQuery("from Exercise", Exercise.class).getResultList();
    } catch (NullPointerException e) {
      return new ArrayList<>();
    }
  }
}