package io.github.umanking.domain.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    public PostService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Post savePost(final Post post) {
        return postRepository.save(post);
    }

    public Page<Post> findPostList(final Pageable pageable) {
        return postRepository.findAll(pageable);

    }

    public Post findById(final Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not exist post"));
    }

    @Transactional
    public void delete(final Long id) {
        postRepository.deleteById(id);
    }


    public Page<Post> findPostByKeyword(final String keyword, final Pageable pageable) {
        return postRepository.findPostByContentsContaining(keyword, pageable);
    }
}
