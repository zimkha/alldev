package com.stuff.dev.alldev.services;

import com.stuff.dev.alldev.entities.Technology;
import com.stuff.dev.alldev.entities.User;

import java.util.Collection;

public interface TechnologyService {

    Technology created(Technology technology);
    Collection<Technology> list (int limit);
    Boolean deleted(Long id);
    Technology getOne(Long id);

}
