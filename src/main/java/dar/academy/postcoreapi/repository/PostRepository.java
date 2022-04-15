package dar.academy.postcoreapi.repository;

import dar.academy.postcoreapi.repository.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    PostEntity getPostEntityByPostId(String postId);
    List<PostEntity> getPostEntitiesBy();
    @Transactional
    void deletePostEntityByPostId(String postId);


}
