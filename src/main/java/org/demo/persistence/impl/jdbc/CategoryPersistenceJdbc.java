/*
 * Created on 2019-05-04 ( Date ISO 2019-05-04 - Time 23:46:24 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;

import org.demo.data.record.CategoryRecord;
import org.demo.persistence.CategoryPersistence;
import org.demo.persistence.impl.jdbc.commons.GenericJdbcDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Category persistence implementation
 *
 * @author Telosys
 */

public class CategoryPersistenceJdbc extends GenericJdbcDAO<CategoryRecord>
    implements CategoryPersistence {

  private static final String SQL_SELECT_ALL = "select id, title from category";

  private static final String SQL_SELECT = "select id, title from category where id = ?";

  private static final String SQL_INSERT = "insert into category ( title ) values ( ? )";

  private static final String SQL_UPDATE = "update category set title = ? where id = ?";

  private static final String SQL_DELETE = "delete from category where id = ?";

  private static final String SQL_COUNT_ALL = "select count(*) from category";

  private static final String SQL_COUNT = "select count(*) from category where id = ?";

  // ----------------------------------------------------------------------
  /** DAO constructor */
  public CategoryPersistenceJdbc() {
    super();
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setAutoIncrementedKey(CategoryRecord record, long value) {
    record.setId((Integer)(int)value);
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setValuesForPrimaryKey(PreparedStatement ps, int i, CategoryRecord category)
      throws SQLException {
    // --- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
    setValue(ps, i++, category.getId()); // "id" : java.lang.Integer
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setValuesForInsert(PreparedStatement ps, int i, CategoryRecord category)
      throws SQLException {
    // --- Set PRIMARY KEY and DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
    // "id" is auto-incremented => no set in insert
    setValue(ps, i++, category.getTitle()); // "title" : java.lang.String
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setValuesForUpdate(PreparedStatement ps, int i, CategoryRecord category)
      throws SQLException {
    // --- Set DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
    setValue(ps, i++, category.getTitle()); // "title" : java.lang.String
    // --- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
    setValue(ps, i++, category.getId()); // "id" : java.lang.Integer
  }

  // ----------------------------------------------------------------------
  /**
   * Creates a new instance of the bean and populates it with the given primary value(s)
   *
   * @param id;
   * @return the new instance
   */
  private CategoryRecord newInstanceWithPrimaryKey(Integer id) {
    CategoryRecord category = new CategoryRecord();
    category.setId(id);
    return category;
  }

  // ----------------------------------------------------------------------
  @Override
  protected CategoryRecord newInstance() {
    return new CategoryRecord();
  }

  // ----------------------------------------------------------------------
  @Override
  protected CategoryRecord populateBean(ResultSet rs, CategoryRecord category) throws SQLException {

    // --- Set data from ResultSet to Bean attributes
    category.setId(rs.getInt("id")); // java.lang.Integer
    if (rs.wasNull()) {
      category.setId(null);
    }
      // not primitive number => keep null value if any
    category.setTitle(rs.getString("title")); // java.lang.String
    return category;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public CategoryRecord findById(Integer id) {
    CategoryRecord category = newInstanceWithPrimaryKey(id);
    if (super.doSelect(category)) {
      return category;
    } else {
      return null; // Not found
    }
  }
  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public List<CategoryRecord> findAll() {
    return super.doSelectAll();
  }

  // ----------------------------------------------------------------------
  /**
   * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)
   * <br>
   * If found, the given instance is populated with the values retrieved from the database<br>
   * If not found, the given instance remains unchanged
   *
   * @param category
   * @return true if found, false if not found
   */
  // @Override
  public boolean load(CategoryRecord category) {
    return super.doSelect(category);
  }

  // ----------------------------------------------------------------------
  /**
   * Inserts the given bean in the database
   *
   * @param category
   */
  public long insert(CategoryRecord category) {
    Long key = super.doInsertAutoIncr(category);
    return key.longValue();
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public CategoryRecord create(CategoryRecord category) {
    insert(category);
    return category;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public boolean update(CategoryRecord category) {
    int r = super.doUpdate(category);
    return r > 0;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public CategoryRecord save(CategoryRecord category) {
    if (super.doExists(category)) {
      super.doUpdate(category);
    } else {
      super.doInsert(category);
    }
    return category;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public boolean deleteById(Integer id) {
    CategoryRecord category = newInstanceWithPrimaryKey(id);
    int r = super.doDelete(category);
    return r > 0;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public boolean delete(CategoryRecord category) {
    int r = super.doDelete(category);
    return r > 0;
  }

  // ----------------------------------------------------------------------
  /**
   * Checks the existence of a record in the database using the given primary key value(s)
   *
   * @param id;
   * @return
   */
  // @Override
  public boolean exists(Integer id) {
    CategoryRecord category = newInstanceWithPrimaryKey(id);
    return super.doExists(category);
  }
  // ----------------------------------------------------------------------
  /**
   * Checks the existence of the given bean in the database
   *
   * @param category
   * @return
   */
  // @Override
  public boolean exists(CategoryRecord category) {
    return super.doExists(category);
  }

  // ----------------------------------------------------------------------
  /**
   * Counts all the records present in the database
   *
   * @return
   */
  @Override
  public long countAll() {
    return super.doCountAll();
  }

  // ----------------------------------------------------------------------
  @Override
  protected String getSqlSelect() {
    return SQL_SELECT;
  }
  // ----------------------------------------------------------------------
  @Override
  protected String getSqlSelectAll() {
    return SQL_SELECT_ALL;
  }
  // ----------------------------------------------------------------------
  @Override
  protected String getSqlInsert() {
    return SQL_INSERT;
  }
  // ----------------------------------------------------------------------
  @Override
  protected String getSqlUpdate() {
    return SQL_UPDATE;
  }
  // ----------------------------------------------------------------------
  @Override
  protected String getSqlDelete() {
    return SQL_DELETE;
  }
  // ----------------------------------------------------------------------
  @Override
  protected String getSqlCount() {
    return SQL_COUNT;
  }
  // ----------------------------------------------------------------------
  @Override
  protected String getSqlCountAll() {
    return SQL_COUNT_ALL;
  }
}