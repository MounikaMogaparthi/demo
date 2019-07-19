package co.za.ned.model;

import javax.persistence.*;

@Entity
@Table(name="Customer_Table")
public class Customer {
@Id
@GeneratedValue
@Column(name="Customer_Id")
  private Integer cid;
@Column(name="Customer_Name")
    private String cname;

    public Customer() {
    }

    public Customer(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Integer getCid()
    {
        return cid;
    }

    public void setCid(Integer cid) {

        this.cid = cid;
    }

    public String getCname() {

        return cname;
    }

    public void setCname(String cname) {

        this.cname = cname;
    }
}
