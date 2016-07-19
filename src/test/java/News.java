import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fiorenzo on 19/07/16.
 */
public class News implements Serializable {
    private Long id;
    private String name;
    private String content;

    public News() {
    }

    public News(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public static List<News> list() {
        List<News> list = new ArrayList<>();
        list.add(new News(1L, "nome1", "content1"));
        list.add(new News(2L, "nome2", "content2"));
        list.add(new News(3L, "nome3", "content3"));
        list.add(new News(4L, "nome4", "content4"));
        return list;
    }
}
