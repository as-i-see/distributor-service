/*
 * Created on 2019-05-04 ( Date ISO 2019-05-04 - Time 23:47:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence;

import org.demo.data.record.UserRecord;

import java.util.List;

/** Persistence Interface for UserRecord. */
public interface UserPersistence {

  /**
   * Tries to find an entity using its Id / Primary Key
   *
   * @param id
   * @return entity
   */
  UserRecord findById(Integer id);

  UserRecord findByEmail(String email);

  /**
   * Finds all entities.
   *
   * @return all entities
   */
  List<UserRecord> findAll();

  /**
   * Counts all the records present in the database
   *
   * @return
   */
  long countAll();

  /**
   * Saves the given entity in the database (create or update)
   *
   * @param entity
   * @return entity
   */
  UserRecord save(UserRecord entity);

  /**
   * Updates the given entity in the database
   *
   * @param entity
   * @return true if the entity has been updated, false if not found and not updated
   */
  boolean update(UserRecord entity);

  /**
   * Creates the given entity in the database
   *
   * @param entity
   * @return
   */
  UserRecord create(UserRecord entity);

  /**
   * Deletes an entity using its Id / Primary Key
   *
   * @param id
   * @return true if the entity has been deleted, false if not found and not deleted
   */
  boolean deleteById(Integer id);

  /**
   * Deletes an entity using the Id / Primary Key stored in the given object
   *
   * @param the entity to be deleted (supposed to have a valid Id/PK )
   * @return true if the entity has been deleted, false if not found and not deleted
   */
  boolean delete(UserRecord entity);

  /**
   * Returns true if an entity exists with the given Id / Primary Key
   *
   * @param id
   * @return
   */
  boolean exists(Integer id);

  /**
   * Returns true if the given entity exists
   *
   * @param entity
   * @return
   */
  boolean exists(UserRecord entity);
}
