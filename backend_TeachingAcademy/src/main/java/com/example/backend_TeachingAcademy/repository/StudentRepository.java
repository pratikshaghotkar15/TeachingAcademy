package com.example.backend_TeachingAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.backend_TeachingAcademy.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
