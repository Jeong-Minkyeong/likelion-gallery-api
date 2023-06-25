package lion.like.galleryapi.domain;

import lion.like.galleryapi.infra.InmemoryCommentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InmemoryCommentRepositoryTest {

    InmemoryCommentRepository inmemoryCommentRepository = new InmemoryCommentRepository();

    @AfterEach
    public void afterEach(){
        inmemoryCommentRepository.clearStore();
    }

    @DisplayName("댓글저장")
    @Test
    void save(){
        // given
        Image image = new Image("1","localhost:8080", "제목", "설명");
        Comment comment = new Comment(image, "이뻐요~");

        // when
        Comment savedComment = inmemoryCommentRepository.save(comment);

        // then
        assertThat(comment.getCommentBody()).isEqualTo(savedComment.getCommentBody());
    }
}


