package com.bookstoredb.storelibrary.Controller;

import com.bookstoredb.storelibrary.Model.TaskLibrary;
import com.bookstoredb.storelibrary.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TaskController {
  @Autowired
  private TaskRepository taskrepository;

  @GetMapping(value = "/books")
  public List<TaskLibrary> getLibraryStore() {
    return this.taskrepository.findAll();
  }

  @GetMapping(value = "books/{title}")
  public List<TaskLibrary> getLibraryTitle(@PathVariable String title) {
    return taskrepository.findByTitleContaining(title);
  }


  @GetMapping(value = "books/{author}")
  public List<TaskLibrary> getLibraryAuthor(@PathVariable String author) {
    return this.taskrepository.findByAuthorContaining(author);
  }
  @PostMapping(value = "/books")
  public String saveLibraryStore(@RequestBody TaskLibrary library) {
   taskrepository.save(library);
   return "Save books";
  }


   @PutMapping(value = "books/{id}")
  public TaskLibrary updateLibrary(@PathVariable long id, @RequestBody TaskLibrary library){
    TaskLibrary updatedLibrary = taskrepository.findById(id).get();
    updatedLibrary.setTitle(library.getTitle());
    updatedLibrary.setAuthor(library.getAuthor());
    updatedLibrary.setDescription(library.getDescription());
    updatedLibrary.setGenre(library.getGenre());
    return this.taskrepository.save(updatedLibrary);

  }

  @DeleteMapping(value = "books/{id}")

  public String deleteLibrary(@PathVariable long id){
    TaskLibrary deletedLibrary = taskrepository.findById(id).get();
    taskrepository.delete(deletedLibrary);
    return "Delete TaskLibrary";
  }



}
