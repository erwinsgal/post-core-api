package dar.academy.postcoreapi.service.deprecated;

import dar.academy.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImplOld implements PostServiceOld {

    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {

        PostModel postModel1 = new PostModel(UUID.randomUUID().toString(), "1", "2",
                "Instax Mini", "Delivered");
        PostModel postModel2 = new PostModel(UUID.randomUUID().toString(), "2", "3",
                "IPhone", "Processing");
        PostModel postModel3 = new PostModel(UUID.randomUUID().toString(), "3", "1",
                "Instax Mini", "Arrived at the place of delivery");

        postMap.put(postModel1.getPostId(), postModel1);
        postMap.put(postModel2.getPostId(), postModel2);
        postMap.put(postModel3.getPostId(), postModel3);

    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        postMap.put(postId, postModel);
    }

    @Override
    public void deletePostById(String postId) {
        postMap.remove(postId);
    }
}
