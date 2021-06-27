package com.sapient.services;

import com.mongodb.client.model.Filters;
import com.sapient.contracts.IAnswerDAO;
import com.sapient.entity.Answer;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnswerTest {

    IAnswerDAO answerDAO;
    List<Answer> answers = null;
    static Answer answer;
    static ObjectId questionId;
    static ObjectId answerId;

    @BeforeAll
    public static void assignid(){
      AnswerTest.answerId = new ObjectId();
      AnswerTest.questionId = new ObjectId();
      AnswerTest.answer = new Answer();
    }
    @BeforeEach
    public void setup(){
        answerDAO = new AnswerService();
        answers = new ArrayList<>();
        answer.setId(answerId);
        answer.setContent("This is the answer");
        answer.setQuestionId(questionId);
        answer.setUId("101");
    }

    @Test
    @Order(1)
    public void addAnswerTest(){
         Assertions.assertTrue(answerDAO.addAnswer(answer));
    }


    @Test
    @Order(2)
    public void getAnswerBYIdTest(){
        Assertions.assertEquals(answer, answerDAO.getAnswerById(answer.getId().toHexString()));
    }

    @Test
    @Order(3)
    public void getAnswersByConditionTest(){
        Bson eq = Filters.eq("questionId", answer.getQuestionId() );
        Assertions.assertEquals(answer, answerDAO.getByCondition(eq, 0).next());

    }

    @Test
    @Order(4)
    public void updateAnswersByIdTest(){
       answer.setContent("Good Game well Played");
       answerDAO.updateAnswerById(answer.getId().toString(), answer);
       Assertions.assertEquals(answer, answerDAO.getAnswerById(answer.getId().toString()));
    }

    @Test
    @Order(5)
    public void removeAnswersByIdTest(){
          answerDAO.removeAnswerById(answer.getId().toString());
        Assertions.assertNull(answerDAO.getAnswerById(answer.getId().toString()));
    }


}
