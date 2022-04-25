package com.csye7200.application.objects;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Song")
@NamedQueries({
        @NamedQuery(name = "Song.findAll", query = "select i from Song i")
})
public class Song {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid"
    )
    private String id;

    private String title;
    private String lyrics;
    private Integer sentiment;
    private String tf_vector;
    private String idf_vector;
    private String processed;

}
