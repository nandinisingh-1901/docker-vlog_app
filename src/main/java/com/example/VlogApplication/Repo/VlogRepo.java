package com.example.VlogApplication.Repo;

import com.example.VlogApplication.Model.Vlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VlogRepo extends JpaRepository<Vlog, Integer> {
//    @Query(
//            value = "SELECT * FROM vlog WHERE title LIKE %:title%",
//            nativeQuery = true
//    )
    List<Vlog> findByTitleContaining(String title);
}
