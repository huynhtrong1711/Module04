package com.codegym.bai_tap_1.repository;

import com.codegym.bai_tap_1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
