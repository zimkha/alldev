package com.stuff.dev.alldev.services;


import com.stuff.dev.alldev.entities.Messages;

import java.util.Collection;


public interface MessagesService {
    Messages create(Messages msg);
    Boolean updateStatus(Long id);
    Boolean delete(Long id);
    Messages getOne(Long id);
    //Collection<Messages> getMessageByUser(Long id);
}
