package com.sapient.contracts;

import com.mongodb.client.MongoCursor;
import com.sapient.entity.Answer;
import org.bson.conversions.Bson;

/**
 * @Author: Aarsh Verdhan
 */

public interface IAnswerDAO {
    boolean addAnswer(Answer answer);

    Answer getAnswerById(String id);

    MongoCursor getByCondition(Bson condition , int limit);
    boolean updateAnswerById(String id, Answer answer);
    boolean removeAnswerById(String id);
}
