package net.gitschthaler.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class Comment {

    @Id @GeneratedValue
    private long id;
    private String author;
    private String text;
    private String title;
    private Long articleId;
    private ZonedDateTime created = ZonedDateTime.now();

    private String path;

    @ManyToOne
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    @OrderColumn
    private List<Comment> replies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }
}
