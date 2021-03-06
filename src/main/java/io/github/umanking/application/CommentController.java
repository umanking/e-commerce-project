package io.github.umanking.application;

import io.github.umanking.domain.post.Comment;
import io.github.umanking.domain.post.CommentService;
import io.github.umanking.domain.post.Post;
import io.github.umanking.domain.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Geonguk Han
 * @since 2020-01-10
 */
@Controller
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    @PostMapping
    @ResponseBody
    public String saveComment(@RequestBody final Comment comment) {
        final Post byId = postService.findById(comment.getPostId());
        byId.getCommentList().add(comment);

        postService.savePost(byId);
        return "SUCCESS";

    }

    @GetMapping
    public String findCommentList(final Model model, final Long postId) {
        final Post byId = postService.findById(postId);
        model.addAttribute("commentList", byId.getCommentList());
        return "comment";
    }

}
