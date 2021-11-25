package com.stuff.dev.alldev.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Messages  implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String message;
    private Date dateSending;
    private Date dateReceive;
    private Boolean isReade;

    @ManyToOne
    private User user;


    @Override
    public  String toString() {
        return "id : " + id
                + " message " + message;
    }


}
