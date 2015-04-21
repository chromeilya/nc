package by.netcracker.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is Group pojo.
 * @author Hromenkov Ilya
 * @version 1.0
 */
@Entity
@Table(name = "T_GROUP")
public class Group implements Serializable {

    private static final Long serialVersionUID = 143654621345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ID")
    private Integer id;

    @Column(name = "F_NUM")
    private Integer group_num;

    @Column(name = "F_FACULT")
    private String facult;

    public Group() {
    }

    public Group(Integer id, Integer group_num, String facult) {
        this.id = id;
        this.group_num = group_num;
        this.facult = facult;
    }

    public Group(Integer group_num, String facult) {
        this.group_num = group_num;
        this.facult = facult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroup_num() {
        return group_num;
    }

    public void setGroup_num(Integer group_num) {
        this.group_num = group_num;
    }

    public String getFacult() {
        return facult;
    }

    public void setFacult(String facult) {
        this.facult = facult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        if (facult != null ? !facult.equals(group.facult) : group.facult != null) return false;
        if (group_num != null ? !group_num.equals(group.group_num) : group.group_num != null) return false;
        if (id != null ? !id.equals(group.id) : group.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (group_num != null ? group_num.hashCode() : 0);
        result = 31 * result + (facult != null ? facult.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", group_num=" + group_num +
                ", facult='" + facult + '\'' +
                '}';
    }
}
