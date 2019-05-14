package testthree.magggaz.model;

import javax.persistence.*;

@Entity
@Table(name="parts")

public class Part {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="name")
    String name;
    @Column(name = "need")
    boolean need;
    @Column(name = "count")
    int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", need=" + need +
                ", count=" + count +
                '}';
    }
}
