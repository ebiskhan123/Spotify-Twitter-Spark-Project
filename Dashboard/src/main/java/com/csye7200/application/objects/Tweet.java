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
@Table(name = "Tweet")
@NamedQueries({
        @NamedQuery(name = "Tweet.findAll", query = "select i from Tweet i")
})
public class Tweet {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid"
    )
    private String id;

    private String title;
    private String tweets;
    private Integer sentiment;
    private String tf_vector;
    private String idf_vector;
    private String processed;

}