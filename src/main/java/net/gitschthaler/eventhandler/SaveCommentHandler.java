package net.gitschthaler.eventhandler;


import net.gitschthaler.CommentRepo;
import net.gitschthaler.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;


@RepositoryEventHandler(Comment.class)
@Component
public class SaveCommentHandler {

    @Autowired
    private CommentRepo repo;

    //FIXME deal with updates and deletes...

    @HandleAfterCreate
    public void onAfterCreate(Comment comment) {
        String path ="";
        if(comment.getParent() != null){
            path = comment.getParent().getPath();
        }
        comment.setPath(path + fillZeroes(comment.getId(), 6));
        repo.save(comment);
    }

    public static String fillZeroes(Long l, int n) {
        return String.format("%0" + n + "d", l);
    }
}