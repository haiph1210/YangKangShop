package EnumConversterAndIDConverter.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

// auto tăng dễ quá ko làm
// làm auto tăng nhưng có thể mặc định tăng từ bao nhiêu
// enum tự sửa theo ý mình
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(generator = "Account_ID")
    @GenericGenerator(
            name = "Account_ID",
            strategy = "EnumConversterAndIDConverter.entity.AccountIDGenerator"

    )

    @Column(name = "id", length = 50,  nullable = false,unique = true)
    private String id;
    @Column(name = "name", unique = true,length = 50,insertable = true, updatable = true)
    private String name;
    @Enumerated(EnumType.ORDINAL)
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
//        HANOI("HN"),NINHBINH("NB"),NAMDINH("ND"),HOCHIMINH("HCM");
//        private String id;
//
//        Address(String id) {
//            this.id = id;
//        }
//
//
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public static Address toAddress(String id){
//            if (id == "HN"|| id == "hn"){
//                return HANOI;
//            }
//            if (id == "NB"|| id == "nb"){
//                return NINHBINH;
//            }
//            if (id == "ND"|| id == "nd"){
//                return NAMDINH;
//            }
//            if (id == "HCM"|| id == "hcm"){
//                return HOCHIMINH;
//            }
//            throw  new UnsupportedOperationException("This" + id + "is unsupported");
//        }

        HANOI('H'),NINHBINH('B'),NAMDINH('D'),HOCHIMINH('C');
        private char id;

        Address(char id) {
            this.id = id;
        }



        public char getId() {
            return id;
        }

        public void setId(char id) {
            this.id = id;
        }

        public static Address toAddress(char id){
            if (id == 'H'|| id == 'h'){
                return HANOI;
            }
            if (id == 'B'|| id == 'b'){
                return NINHBINH;
            }
            if (id == 'D'|| id == 'd'){
                return NAMDINH;
            }
            if (id == 'C'|| id == 'c'){
                return HOCHIMINH;
            }
            throw  new UnsupportedOperationException("This" + id + "is unsupported");
        }
    }
}

