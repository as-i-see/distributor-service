/*
 * Created on 2019-05-04 ( Date ISO 2019-05-04 - Time 23:46:25 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;

import org.demo.data.record.PeriodicalRecord;
import org.demo.persistence.PeriodicalPersistence;
import org.demo.persistence.impl.jdbc.commons.GenericJdbcDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Periodical persistence implementation
 *
 * @author Telosys
 */

public class PeriodicalPersistenceJdbc extends GenericJdbcDAO<PeriodicalRecord>
    implements PeriodicalPersistence {

  private static final String SQL_SELECT_ALL = "select id, category, title, price from periodical";

  private static final String SQL_SELECT =
      "select id, category, title, price from periodical where id = ?";

  private static final String SQL_INSERT =
      "insert into periodical ( category, title, price ) values ( ?, ?, ? )";

  private static final String SQL_UPDATE =
      "update periodical set category = ?, title = ?, price = ? where id = ?";

  private static final String SQL_DELETE = "delete from periodical where id = ?";

  private static final String SQL_COUNT_ALL = "select count(*) from periodical";

  private static final String SQL_COUNT = "select count(*) from periodical where id = ?";

  // ----------------------------------------------------------------------
  /** DAO constructor */
  public PeriodicalPersistenceJdbc() {
    super();
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setAutoIncrementedKey(PeriodicalRecord record, long value) {
    record.setId((Integer)(int) value);
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setValuesForPrimaryKey(PreparedStatement ps, int i, PeriodicalRecord periodical)
      throws SQLException {
    // --- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
    setValue(ps, i++, periodical.getId()); // "id" : java.lang.Integer
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setValuesForInsert(PreparedStatement ps, int i, PeriodicalRecord periodical)
      throws SQLException {
    // --- Set PRIMARY KEY and DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
    // "id" is auto-incremented => no set in insert
    setValue(ps, i++, periodical.getCategory()); // "category" : java.lang.Integer
    setValue(ps, i++, periodical.getTitle()); // "title" : java.lang.String
    setValue(ps, i++, periodical.getPrice()); // "price" : java.lang.Integer
  }

  // ----------------------------------------------------------------------
  @Override
  protected void setValuesForUpdate(PreparedStatement ps, int i, PeriodicalRecord periodical)
      throws SQLException {
    // --- Set DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
    setValue(ps, i++, periodical.getCategory()); // "category" : java.lang.Integer
    setValue(ps, i++, periodical.getTitle()); // "title" : java.lang.String
    setValue(ps, i++, periodical.getPrice()); // "price" : java.lang.Integer
    // --- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
    setValue(ps, i++, periodical.getId()); // "id" : java.lang.Integer
  }

  // ----------------------------------------------------------------------
  /**
   * Creates a new instance of the bean and populates it with the given primary value(s)
   *
   * @param id;
   * @return the new instance
   */
  private PeriodicalRecord newInstanceWithPrimaryKey(Integer id) {
    PeriodicalRecord periodical = new PeriodicalRecord();
    periodical.setId(id);
    return periodical;
  }

  // ----------------------------------------------------------------------
  @Override
  protected PeriodicalRecord newInstance() {
    return new PeriodicalRecord();
  }

  // ----------------------------------------------------------------------
  @Override
  protected PeriodicalRecord populateBean(ResultSet rs, PeriodicalRecord periodical)
      throws SQLException {

    // --- Set data from ResultSet to Bean attributes
    periodical.setId(rs.getInt("id")); // java.lang.Integer
    if (rs.wasNull()) {
      periodical.setId(null);
    }
      // not primitive number => keep null value if any
    periodical.setCategory(rs.getInt("category")); // java.lang.Integer
    if (rs.wasNull()) {
      periodical.setCategory(null);
    }
      // not primitive number => keep null value if any
    periodical.setTitle(rs.getString("title")); // java.lang.String
    periodical.setPrice(rs.getInt("price")); // java.lang.Integer
    if (rs.wasNull()) {
      periodical.setPrice(null);
    }
      // not primitive number => keep null value if any
    return periodical;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public PeriodicalRecord findById(Integer id) {
    PeriodicalRecord periodical = newInstanceWithPrimaryKey(id);
    if (super.doSelect(periodical)) {
      return periodical;
    } else {
      return null; // Not found
    }
  }
  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public List<PeriodicalRecord> findAll() {
    return super.doSelectAll();
  }

  // ----------------------------------------------------------------------
  /**
   * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)
   * <br>
   * If found, the given instance is populated with the values retrieved from the database<br>
   * If not found, the given instance remains unchanged
   *
   * @param periodical
   * @return true if found, false if not found
   */
  // @Override
  public boolean load(PeriodicalRecord periodical) {
    return super.doSelect(periodical);
  }

  // ----------------------------------------------------------------------
  /**
   * Inserts the given bean in the database
   *
   * @param periodical
   */
  public long insert(PeriodicalRecord periodical) {
    Long key = super.doInsertAutoIncr(periodical);
    return key.longValue();
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public PeriodicalRecord create(PeriodicalRecord periodical) {
    insert(periodical);
    return periodical;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public boolean update(PeriodicalRecord periodical) {
    int r = super.doUpdate(periodical);
    return r > 0;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public PeriodicalRecord save(PeriodicalRecord periodical) {
    if (super.doExists(periodical)) {
      super.doUpdate(periodical);
    } else {
      super.doInsert(periodical);
    }
    return periodical;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public boolean deleteById(Integer id) {
    PeriodicalRecord periodical = newInstanceWithPrimaryKey(id);
    int r = super.doDelete(periodical);
    return r > 0;
  }

  // ----------------------------------------------------------------------
  /* (non-Javadoc)
   * @see interface
   */
  @Override
  public boolean delete(PeriodicalRecord periodical) {
    int r = super.doDelete(periodical);
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
    PeriodicalRecord periodical = newInstanceWithPrimaryKey(id);
    return super.doExists(periodical);
  }
  // ----------------------------------------------------------------------
  /**
   * Checks the existence of the given bean in the database
   *
   * @param periodical
   * @return
   */
  // @Override
  public boolean exists(PeriodicalRecord periodical) {
    return super.doExists(periodical);
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
