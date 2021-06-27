package com.sapient.contracts;

import com.mongodb.client.MongoCursor;
import com.sapient.entity.Question;

import java.util.List;

/**
 * @Author: Aarsh Verdhan
 * @See: Interface for question Business Logic from MongoDB
 */

public interface IQuestionDAO {
    // to add questions
    boolean addQuestion(Question question);

    // get questions by userId
    List<Question> getQuestionByUserId(String uId);
    MongoCursor getAllQuestions();

    // get questions by questionId
    Question getQuestionById(String id);

    // update
    boolean updateQuestionById(Question question, String id);

    // remove
    boolean removeQuestionById(String id);

    // to upvote/downvote questions

    boolean voteQuestionById(String method, String id);


}
