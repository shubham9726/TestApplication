/*
package com.java.repository.impl;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.java.annotations.CollectionName;
import com.java.api.BaseModel;
import com.java.db.MongoDb;
import com.java.repository.BaseRepository;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.jongo.MongoCollection;

import java.util.List;

public class BaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T> {
  final MongoDb mongoManager;
  protected final MongoCollection collection;
  protected final Class<T> entityClass;
  protected CollectionName collectionName;

  @Inject
  public BaseRepositoryImpl(MongoDb mongoManager, Class<T> clazz) throws Exception {
    this.mongoManager = mongoManager;
    collectionName = clazz.getAnnotation(CollectionName.class);
    collection = mongoManager.getMongoCollection(collectionName.name());
    entityClass = clazz;
  }

  @Override
  public T save(T model) {
    if (model == null) {
      throw new RuntimeException("No data Found");
    }
    Object id = collection.save(model).getUpsertedId();
    if (id != null && id instanceof ObjectId) {
      model.setId(((ObjectId) id).toStringMongod());
    }
    return model;
  }

  @Override
  public List<T> getAll() {
    Iterable items = collection.find().as(entityClass);
    return Lists.newArrayList(items);

  }

  @Override
  public T getById(String id) {
    if (id == null || !ObjectId.isValid(id)) {
      return null;
    }
    return collection.findOne(new ObjectId(id)).as(entityClass);

  }

  @Override
  public void deleteById(String id) {
    if (id != null && ObjectId.isValid(id)) {

      collection.update(new ObjectId(id)).with("{$set: {deleted:true,modified:#}}", DateTime.now().getMillis());
    }
  }

  @Override
  public T updateById(String id, T model) {
    if (id == null || !ObjectId.isValid(id) || model == null) {
      throw new RuntimeException("Entity  should not be null.");
    }
    model.setModified(DateTime.now().getMillis());
    collection.update(new ObjectId(id)).with(model);
    return model;
  }
}
*/
