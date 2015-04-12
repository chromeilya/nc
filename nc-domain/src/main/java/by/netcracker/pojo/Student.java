package by.netcracker.pojo;

import javax.persistence.*;
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

    @Column(name = "F_FIO")
    private String fio;

    @ManyToOne
    @JoinColumn(name = "F_GROUP_ID")
    private Group group;

    @Column(name = "F_TYPE_STIPEND")
    private String type_stipend;

    public Student() {
    }

    public Student(Integer id, String fio, Group group, String type_stipend) {
        this.id=id;
        this.fio=fio;
        this.group=group;
        this.type_stipend=type_stipend;
    }

    public Student(String fio, Group group, String type_stipend) {
        this.fio=fio;
        this.group=group;
        this.type_stipend=type_stipend;
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

    public String getType_stipend() {
        return type_stipend;
    }

    public void setType_stipend(String type_stipend) {
        this.type_stipend = type_stipend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (fio != null ? !fio.equals(student.fio) : student.fio != null) return false;
        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (type_stipend != null ? !type_stipend.equals(student.type_stipend) : student.type_stipend != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (type_stipend != null ? type_stipend.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", group=" + group +
                ", type_stipend='" + type_stipend + '\'' +
                '}';
    }
}
