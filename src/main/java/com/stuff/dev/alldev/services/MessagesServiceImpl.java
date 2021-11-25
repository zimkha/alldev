package com.stuff.dev.alldev.services;

import com.stuff.dev.alldev.entities.Messages;
import com.stuff.dev.alldev.repositories.MessageRepository;
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
    @Override
    public Messages create(Messages msg) {
        return messageRepository.save(msg);
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
