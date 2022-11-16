package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "group_student")
@IdClass(value = GroupStudentPK.class)
public class GroupStudent {
    @Id
    @Column(name = "group_id")
    private int groupId;
    @Id
    @Column(name = "student_id")
    private int studentId;
//    @EmbeddedId
//    private GroupStudentPK id;

    @Column(name = "joined_date", nullable = false)
    @CreationTimestamp
    private LocalDate joinedDate;

    public GroupStudent() {
    }

    public GroupStudent(int groupId, int studentID) {
        this.groupId = groupId;
        this.studentId = studentID;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    //    public GroupStudent(GroupStudentPK id) {
//        this.id = id;
//    }
//
//    public GroupStudentPK getId() {
//        return id;
//    }
//    public void setId(GroupStudentPK id) {
//        this.id = id;
//    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Override
    public String toString() {
        return "GroupStudent{" +
                "groupID=" + groupId +
                ", studentID=" + studentId +
                ", joinedDate=" + joinedDate +
                '}';
    }
}


