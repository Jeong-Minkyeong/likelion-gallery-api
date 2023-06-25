package lion.like.galleryapi.domain;


import lion.like.galleryapi.infra.InmemoryImageRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InmemoryImageRepositoryTest {

    InmemoryImageRepository inmemoryImageRepository = new InmemoryImageRepository();

    @AfterEach
    void afterEach(){
        inmemoryImageRepository.clearStore();
    }

    @Test
    void findAllImage(){
        //given
        List<Image> images =  inmemoryImageRepository.imageAll();
        String imageName = images.get(0).getImageName();

        //when & then
        Assertions.assertThat(imageName).isEqualTo("제목1");
    }
}