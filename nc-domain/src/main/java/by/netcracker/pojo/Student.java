package by.netcracker.pojo;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by ilya on 4/8/15.
 */
@Entity
@Table(name = "T_STUDENT")
public class Student implements  Serializable{

    private static final Long serialVersionUID = 25463461234L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ID")
    private Integer id;

    @Size(min = 3, max = 70)
    @Column(name = "F_FIO")
    private String fio;

    @ManyToOne
    @JoinColumn(name = "F_GROUP_ID")
    private Group group;

    @NotEmpty
    @Column(name = "F_TYPE_STIPEND")
    private String typeStipend;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "F_JOIN_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joinDate;

    public Student() {
    }

    public Student(Integer id, String fio, Group group, String typeStipend, LocalDate joinDate) {
        this.id=id;
        this.fio=fio;
        this.group=group;
        this.typeStipend=typeStipend;
        this.joinDate=joinDate;
    }

    public Student(String fio, Group group, String type_stipend, LocalDate joinDate) {
        this.fio=fio;
        this.group=group;
        this.typeStipend=type_stipend;
        this.joinDate=joinDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getTypeStipend() {
        return typeStipend;
    }

    public void setTypeStipend(String typeStipend) {
        this.typeStipend = typeStipend;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (fio != null ? !fio.equals(student.fio) : student.fio != null) return false;
        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (joinDate != null ? !joinDate.equals(student.joinDate) : student.joinDate != null) return false;
        if (typeStipend != null ? !typeStipend.equals(student.typeStipend) : student.typeStipend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (typeStipend != null ? typeStipend.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", group=" + group +
                ", typeStipend='" + typeStipend + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}
