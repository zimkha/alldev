package com.stuff.dev.alldev.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class RequestBodyAdd {
    protected Long idUser;
    protected Collection<Technology> technologies;
}
