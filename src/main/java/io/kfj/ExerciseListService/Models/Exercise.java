package io.kfj.ExerciseListService.Models;

import javax.persistence.*;

@Entity
public class Exercise {

  @Id  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;

  @OneToOne
  private ExerciseCategory category;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ExerciseCategory getCategory() {
    return this.category;
  }

  public void setCategory(ExerciseCategory category) {
    this.category = category;
  }
}