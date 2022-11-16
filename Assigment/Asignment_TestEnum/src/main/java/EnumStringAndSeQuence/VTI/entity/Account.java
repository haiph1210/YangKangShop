package EnumStringAndSeQuence.VTI.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.xml.ws.WebServiceRef;
import java.time.LocalDate;
import java.time.LocalDateTime;

// auto tăng dễ quá ko làm
// làm auto tăng nhưng có thể mặc định tăng từ bao nhiêu
// enum tự sửa theo ý mình
@Entity
@Table(name = "account")
public class Account {
    @Id
//    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Account_sequence")
    @GenericGenerator(
            name = "Account_sequence", // name phải đặt tên giống với gennerator
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "article_sequence"),
                    @Parameter(name = "initial_value", value = "10"), // bắt  đầu từ 10
                    @Parameter(name = "increment_size", value = "1"), // bước nhảy 1
//                    @Parameter(name = "optimizer", value = "pooled-lo")
            }
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "name", unique = true,length = 50,insertable = true, updatable = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "address")
    private Address address;
    @Column(name = "created_date",updatable = false,nullable = false)
    @CreationTimestamp
    private LocalDate createDate;
    @Column(name = "updated_at",updatable = false, nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;
//    private Group group;

    public Account() {
    }

    public Account(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createDate=" + createDate +
                ", updateAt=" + updateAt +
                '}';
    }

    public enum Address{
        HANOI,NINHBINH,NAMDINH,HOCHIMINH
    }
}

