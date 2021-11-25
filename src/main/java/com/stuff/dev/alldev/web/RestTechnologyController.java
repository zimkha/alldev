package com.stuff.dev.alldev.web;


import com.stuff.dev.alldev.entities.Response;
import com.stuff.dev.alldev.entities.Technology;
import com.stuff.dev.alldev.services.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/tecnhologies")
public class RestTechnologyController {
    private  final TechnologyService technologyService;

    @GetMapping("/list")
    public ResponseEntity<Response> list() throws IOException{
        return ResponseEntity.ok(
                Response.builder()
                .timeStamp(now())
                .message("Technologies retrieved")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(Map.of("Technologies", technologyService.list(10) ))
                .build()
        );
    }
    @PostMapping("/save")
    public  ResponseEntity<Response> created(@RequestBody Technology technology) throws IOException{
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message("Technologies retrieved")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of("Technologies", technologyService.created(technology)))
                        .build()
        );
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Response> getOne(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message("Technologies retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("Technologies", technologyService.getOne(id) ))
                        .build()
        );
    }
}
