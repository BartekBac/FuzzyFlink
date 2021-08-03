package fuzzy.dtos;

public class WalkVelocity {
    public long id;
    public String description;
    public int age;

    public WalkVelocity() {}

    public WalkVelocity(long id, String description, int age) {
        this.id = id;
        this.description = description;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
