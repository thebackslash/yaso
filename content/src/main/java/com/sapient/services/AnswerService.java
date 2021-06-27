package com.sapient.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.sapient.contracts.IAnswerDAO;
import com.sapient.entity.Answer;
import com.sapient.util.GetConnection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class AnswerService implements IAnswerDAO {
    private MongoCollection collection;

    public AnswerService(){
  collection = GetConnection.getCollectionFromDatabase("aarshdbs", "answers", Answer.class);
    }

    @Override
    public boolean addAnswer(Answer answer) {
        collection.insertOne(answer);
          return true;
    }

    @Override
    public Answer getAnswerById(String id) {

        return (Answer) collection.find(Filters.eq("_id", new ObjectId(id))).first();
    }

    @Override
    public MongoCursor getByCondition(Bson condition, int limit) {
        return collection.find(condition).limit(limit).iterator();
    }

    @Override
    public boolean updateAnswerById(String id, Answer answer) {

       UpdateResult result = collection.updateOne(Filters.eq("_id", new ObjectId(id)), Updates.set("content", answer.getContent()));
        return result.getModifiedCount()>0;
    }


    @Override
    public boolean removeAnswerById(String id) {
        collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
        return true;
    }
}
