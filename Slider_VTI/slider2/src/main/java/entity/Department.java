package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "depatment")
public class Department {
    @Id
//   @GeneratedValue(strategy = GenerationType.SEQUENCE,
//                     generator = "department_seQuence") // tạo tên trong data SQL
//
//    @SequenceGenerator(
//            name = "department_seQuence",  // liên kết với generator
//            sequenceName = "Department", // tên trong sql
//            initialValue = 2,  // bắt đầu
//            allocationSize = 10 // nới
//    )

// copy
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_generator"
//    )
//    @GenericGenerator(
//            name = "student_generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @Parameter(name = "sequence_name", value = "student_sequence"),
//                    @Parameter(name = "initial_value", value = "10"),// bắt đầu
//                    @Parameter(name = "increment_size", value = "1"),// step
//                    @Parameter(name = "optimizer", value = "pooled-lo")
//            }
//    )
    @Column(name = "code", length = 10)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @org.hibernate.annotations.Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue(generator = "code_generator")
    @GenericGenerator(
            name = "code_generator",
            strategy = "entity.DepartmentCodeGenerator")
    private String code;


    @Column(name = "name", nullable = false, length = 50, unique = true, updatable = true, insertable = true)
    private String name;
    @Column(name = "type   ")
    @Convert(converter = TypeDepartmentConverter.class)
    private Type type;

    public Department() {
    }

    public Department(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Department(String code, String name, Type type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getStatus() {
        return type;
    }

    public void setStatus(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Department" +
                "{" +
                "id=" + code +
                ", name='" + name + '\'' +
                ", status=" + type +
                '}';
    }

    public enum Type {
        DEVELOPER('D'), TESTER('T'), SCRUM('S'), PROJECT('P');
        private char code;

        Type(char code) {
            this.code = code;
        }

        //         lấy chữ cái đầu từ Departmet- Type
//        chuyển từ type sang char
        public char getCode() {
            return code;
        }

        //        chuyển từ char sang type
        public static Type toType(char code) {
            if (code == 'D' || code == 'd') {
                return DEVELOPER;
            }
            if (code == 'T' || code == 't') {
                return TESTER;
            }
            if (code == 'S' || code == 's') {
                return SCRUM;
            }
            if (code == 'P' || code == 'p') {
                return PROJECT;
            }
            throw new UnsupportedOperationException("This" + code + "is unsupported");
        }
    }
}
