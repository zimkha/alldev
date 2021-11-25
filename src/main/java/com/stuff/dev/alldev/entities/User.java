package com.stuff.dev.alldev.entities;


import com.stuff.dev.alldev.enums.TypeMetier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            nullable = false

    )
    private String password;

    @Column(
            columnDefinition="TEXT",
            nullable = true
    )
    private String desciption;
    @ManyToMany(

            fetch = FetchType.LAZY
    )
    @JoinTable(name = "technologies_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Collection<Technology> technologies = new ArrayList<>();
    private TypeMetier typeMetier;

    @Column(nullable = true)
    private String googleId;
    @Column(nullable = true)
    private String githubId;
    @Column(nullable = true)
    private String token;
    @Column(nullable = true)
    @ElementCollection
    private Collection<String> links = new ArrayList<>();


    @Override
    public  String toString() {
        return "id : " + id
                + "firstname " + firstname;
    }

}
