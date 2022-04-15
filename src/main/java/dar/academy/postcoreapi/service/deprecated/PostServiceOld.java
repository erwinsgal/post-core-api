package dar.academy.postcoreapi.service.deprecated;

import dar.academy.postcoreapi.model.PostModel;

import java.util.List;

public interface PostServiceOld {

    void createPost(PostModel postModel);

    List<PostModel> getAllPosts();

    PostModel getPostById(String postId);

    void updatePostById(String postId, PostModel postModel);

    void deletePostById(String postId);

}
