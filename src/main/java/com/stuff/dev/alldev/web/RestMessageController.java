package com.stuff.dev.alldev.web;


import com.stuff.dev.alldev.entities.Messages;
import com.stuff.dev.alldev.entities.Response;
import com.stuff.dev.alldev.services.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping(path = "/messages")
@RequiredArgsConstructor
public class RestMessageController {

    private final MessagesService messagesService;

    @PostMapping("/message")
    public ResponseEntity<Response> create(@RequestBody Messages msg) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message("Messages Sending")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("users", messagesService.create(msg) ))
                        .build()
        );
    }
}
