package lion.like.galleryapi.infra;

import lion.like.galleryapi.domain.Image;
import lion.like.galleryapi.domain.ImageRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InmemoryImageRepository implements ImageRepository {

    private Map<String, Image> store = new HashMap<>();

    ArrayList<String> imageIds = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    ArrayList<String> imageUrls = new ArrayList<>(Arrays.asList("1", "2", "3"));
    ArrayList<String> imageNames = new ArrayList<>(Arrays.asList("제목1", "제목2", "제목3"));
    ArrayList<String> imageTexts = new ArrayList<>(Arrays.asList("설명1", "설명2", "설명3"));
    int arraySize = imageUrls.size();

    public List<Image> imageAll(){
        for (int i = 0; i < arraySize; i++){
            Image image = new Image(imageIds.get(i), imageUrls.get(i), imageNames.get(i), imageTexts.get(i));
            store.put(image.getId(), image);
        }

        return store.values()
                .stream()
                .toList();
    }

    public Image findByImageId(String imageId){
        return store.get(imageId);
    }

    public int imageSize(){
        return arraySize;
    }

    public void clearStore(){
        store.clear();
    }
}
