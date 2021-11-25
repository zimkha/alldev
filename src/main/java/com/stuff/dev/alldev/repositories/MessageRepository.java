package com.stuff.dev.alldev.repositories;

import com.stuff.dev.alldev.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface MessageRepository  extends JpaRepository<Messages, Long> {

    @Query("SELECT m FROM messages WHERE m.user_id = ?1")
    Collection<Messages> findByUser(Long id);
}
