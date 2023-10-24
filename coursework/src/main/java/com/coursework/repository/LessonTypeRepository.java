package com.coursework.repository;

import com.coursework.entity.LessonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonTypeRepository extends JpaRepository<LessonType, Long> {
    List<LessonType> findAllByNameContainingIgnoreCase(String name);
}
