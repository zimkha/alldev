package com.stuff.dev.alldev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
public class Technology  implements Serializable {

     @Id
     @GeneratedValue(strategy =  GenerationType.IDENTITY)
     private Long id;
     @Column(unique = true, nullable = false)
     private String name;
     private String description;
     @ManyToMany(
             fetch = FetchType.LAZY,
             cascade = CascadeType.PERSIST,
             mappedBy = "technologies"
     )
     @JsonIgnore
     private Collection<User> users = new ArrayList<>();

     @Override
     public  String toString() {
          return "id : " + id
                  + "name " + name;
     }


}
