package com.stuff.dev.alldev.repositories;

import com.stuff.dev.alldev.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface MessageRepository  extends JpaRepository<Messages, Long> {

    @Query("SELECT m FROM Messages m WHERE m.user = ?1")
    Collection<Messages> findByUser(Long id);
}
