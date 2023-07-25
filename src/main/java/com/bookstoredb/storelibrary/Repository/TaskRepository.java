package com.bookstoredb.storelibrary.Repository;

import com.bookstoredb.storelibrary.Model.TaskLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskLibrary, Long>  {
  List<TaskLibrary> findByTitleContaining(String title);
  List<TaskLibrary> findByAuthorContaining(String author);
}
