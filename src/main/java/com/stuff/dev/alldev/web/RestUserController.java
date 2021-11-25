package com.stuff.dev.alldev.web;


import com.stuff.dev.alldev.entities.RequestBodyAdd;
import com.stuff.dev.alldev.entities.Response;
import com.stuff.dev.alldev.entities.Technology;
import com.stuff.dev.alldev.entities.User;
import com.stuff.dev.alldev.repositories.TechnologyRepository;
import com.stuff.dev.alldev.repositories.UserRepository;
import com.stuff.dev.alldev.services.TechnologyService;
import com.stuff.dev.alldev.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class RestUserController {
    private final UserService userService;
    private  final TechnologyService technologyService;
    private  final UserRepository userRepository;

   @GetMapping("/list")
    public ResponseEntity<Response> list() throws IOException {
     return  ResponseEntity.ok(
        Response.builder()
                .timeStamp(now())
                .message("Users retrieved")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(Map.of("users", userService.list(10) ))
                .build()
     );
    }

    @PostMapping("/save")
    public  ResponseEntity<Response> save(@RequestBody User user) throws  IOException {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message("Users retrieved")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .developerMessage("User is creaed")
                        .data(Map.of("user", userService.created(user)))
                        .build()
        );
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Response> getOneUser(@PathVariable Long id) throws IOException {
       return  ResponseEntity.ok(
               Response.builder()
                       .timeStamp(now())
                       .message("User found")
                       .status(HttpStatus.OK)
                       .developerMessage("User is founded")
                       .statusCode(HttpStatus.OK.value())
                       .data(Map.of("user", userService.get(id) ))
                       .build()
       );
    }

    @DeleteMapping(path = "/user/{id}")

    public ResponseEntity<Response> deleteOne(@PathVariable Long id) throws  IOException {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message("User found")
                        .status(HttpStatus.OK)
                        .developerMessage("User is founded")
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("user", userService.deleted(id) ))
                        .build()
       );
    }

    @PostMapping("/add-technology")
    public  ResponseEntity<Response> addTechnos(@RequestBody RequestBodyAdd el) throws  IOException {
        User user = userService.get(el.getIdUser());
       for(Technology t: el.getTechnologies()) {
          Technology newT = technologyService.getOne(t.getId());
          user.getTechnologies().add(newT);
          
       }


        System.out.println("Une technology => " + user.getTechnologies());
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message("Technologies add")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .developerMessage("Update is Done")
                        .data(Map.of("user", userRepository.save(user)))
                        .build()
        );
    }

    @GetMapping("/messages-user/{id}")
    public ResponseEntity<Response> listMessages(@PathVariable Long id) throws IOException{
       return  ResponseEntity.ok(
               Response.builder()
                       .timeStamp(now())
                       .message("List messages by user")
                       .status(HttpStatus.CREATED)
                       .statusCode(HttpStatus.CREATED.value())
                       .developerMessage("List messages by one user")
                       .data(Map.of("user", userService.listMessageByUser(id)))
                       .build()
       );
    }
}
