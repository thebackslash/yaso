package com.sapient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.List;


/**
 * @Author: Aarsh Verdhan
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
public class Question {
    @BsonId
    private ObjectId id;
    private String uId;

   @Embedded
    private Votes votes;

    private String content;
    private String status;
    private List<ObjectId> answers;
    /*
    List<ObjectId> comments;
    List<ObjectId> tags;
*/

}
