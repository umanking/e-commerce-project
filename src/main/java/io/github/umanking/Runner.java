package io.github.umanking;

import io.github.umanking.domain.post.Post;
import io.github.umanking.domain.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(final ApplicationArguments args) throws Exception {

        for (int i = 1; i <= 40; i++) {
            final Post post = new Post();
            post.setTitle("제목 " + i);
            post.setContents("안녕하세요 컨텐츠 내용입니다. " + i);
            postService.savePost(post);
        }


    }
}
