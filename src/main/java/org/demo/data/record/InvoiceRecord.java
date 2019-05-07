/*
 * Created on 2019-05-04 ( Date ISO 2019-05-04 - Time 23:47:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;

import java.io.Serializable;

/**
 * Java bean for entity "invoice" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 * @author Telosys Tools Generator
 */
public class InvoiceRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id; // Integer // Id or Primary Key

  private Integer user; // Integer
  private Long payment; // Long
  private Byte paid; // Byte

  /** Default constructor */
  public InvoiceRecord() {
    super();
  }

  // ----------------------------------------------------------------------
  // GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
  // ----------------------------------------------------------------------

  /**
   * Get the "id" field value This field is mapped on the database column "id" ( type "INT
   * UNSIGNED", NotNull : true )
   *
   * @return the field value
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Set the "id" field value This field is mapped on the database column "id" ( type "INT
   * UNSIGNED", NotNull : true )
   *
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  // ----------------------------------------------------------------------
  // GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
  // ----------------------------------------------------------------------

  /**
   * Get the "user" field value This field is mapped on the database column "user" ( type "INT
   * UNSIGNED", NotNull : true )
   *
   * @return the field value
   */
  public Integer getUser() {
    return this.user;
  }

  /**
   * Set the "user" field value This field is mapped on the database column "user" ( type "INT
   * UNSIGNED", NotNull : true )
   *
   * @param user
   */
  public void setUser(Integer user) {
    this.user = user;
  }

  /**
   * Get the "payment" field value This field is mapped on the database column "payment" ( type
   * "BIGINT UNSIGNED", NotNull : true )
   *
   * @return the field value
   */
  public Long getPayment() {
    return this.payment;
  }

  /**
   * Set the "payment" field value This field is mapped on the database column "payment" ( type
   * "BIGINT UNSIGNED", NotNull : true )
   *
   * @param payment
   */
  public void setPayment(Long payment) {
    this.payment = payment;
  }

  /**
   * Get the "paid" field value This field is mapped on the database column "paid" ( type "TINYINT",
   * NotNull : true )
   *
   * @return the field value
   */
  public Byte getPaid() {
    return this.paid;
  }

  /**
   * Set the "paid" field value This field is mapped on the database column "paid" ( type "TINYINT",
   * NotNull : true )
   *
   * @param paid
   */
  public void setPaid(Byte paid) {
    this.paid = paid;
  }

  // ----------------------------------------------------------------------
  // toString METHOD
  // ----------------------------------------------------------------------
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append(id);
    sb.append("|");
    sb.append(user);
    sb.append("|");
    sb.append(payment);
    sb.append("|");
    sb.append(paid);
    return sb.toString();
  }
}
