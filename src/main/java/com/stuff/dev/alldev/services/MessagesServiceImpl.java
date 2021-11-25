package com.stuff.dev.alldev.services;

import com.stuff.dev.alldev.entities.Messages;
import com.stuff.dev.alldev.entities.User;
import com.stuff.dev.alldev.repositories.MessageRepository;
import com.stuff.dev.alldev.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
@Slf4j
public class MessagesServiceImpl implements MessagesService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    @Override
    public Messages create(Messages msg) {
        if(msg.getUser().getId() != null) {
            User u =  userRepository.findById(msg.getUser().getId()).get();
            msg.setUser(u);
            return messageRepository.save(msg);
        }
        return null;

    }

    @Override
    public Boolean updateStatus(Long id) {

        boolean isok = false;
        Messages msg = messageRepository.findById(id).get();
        if(msg.getId() != null) {
          Boolean isUpdate = msg.getIsReade() == true ? false : true;
            msg.setIsReade(isUpdate);
            isok = true;
        }
        return isok;
    }

    @Override
    public Boolean delete(Long id) {
        messageRepository.deleteById(id);
        return true;
    }

    @Override
    public Messages getOne(Long id) {
        return messageRepository.getById(id);
    }

//    @Override
//    public Collection<Messages> getMessageByUser(Long id) {
//        return messageRepository.findByUser(id);
//    }
}
