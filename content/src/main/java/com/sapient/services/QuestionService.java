package com.sapient.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.sapient.contracts.IQuestionDAO;
import com.sapient.entity.Question;
import com.sapient.util.GetConnection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class QuestionService implements IQuestionDAO {

    MongoClient mc;
    MongoDatabase qaDB;
    MongoCollection<Question> questionCollection;

    public QuestionService() {
        questionCollection = GetConnection.getCollectionFromDatabase("aarshdbs", "questions", Question.class);

    }


    @Override
    public boolean addQuestion(Question question) {

        try {
            questionCollection.insertOne(question);

            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Question> getQuestionByUserId(String uId) {
        return questionCollection.find(eq("uId", uId)).into(new ArrayList<Question>());
    }

    @Override
    public MongoCursor getAllQuestions() {
        return questionCollection.find().iterator();
    }

    @Override
    public Question getQuestionById(String id) {

        return  (Question) questionCollection.find(eq("_id", new ObjectId(id))).first();

    }


    @Override
    public boolean updateQuestionById(Question question, String id) {
        Bson filter= eq("_id",new ObjectId(id));
        Bson updateOperation= and(Updates.set("content",question.getContent()),
                Updates.set("votes",question.getVotes()),
                Updates.set("status", question.getStatus()),
                Updates.set("uId", question.getUId()),
                Updates.set("answers", question.getAnswers())
        );

        UpdateResult updateResult = questionCollection.updateOne(filter, updateOperation);

        return updateResult.getModifiedCount()>0;
    }

    @Override
    public boolean removeQuestionById(String id) {
        return questionCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount()>0;
    }

    @Override
    public boolean voteQuestionById(String method, String id) {
        // TODO Auto-generated method stub
        return false;
    }

}