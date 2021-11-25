package com.stuff.dev.alldev.repositories;

import com.stuff.dev.alldev.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
