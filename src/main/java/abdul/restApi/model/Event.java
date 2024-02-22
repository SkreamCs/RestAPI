package abdul.restApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "file_id")
    private File file;

    public Event(User user, File file) {
        this.user = user;
        this.file = file;
    }

    public Event() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", file=" + file.getId() +
                '}';
    }
}
