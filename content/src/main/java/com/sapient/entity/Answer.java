package com.sapient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import javax.persistence.Entity;

/**
 * @Author: Aarsh Verdhan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Answer {
   @BsonId
   private ObjectId id;
private String uId;
private String content;
private ObjectId questionId;

}
