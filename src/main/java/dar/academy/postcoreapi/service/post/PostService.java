package dar.academy.postcoreapi.service.post;

import dar.academy.postcoreapi.model.PostRequest;
import dar.academy.postcoreapi.model.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse createPost(PostRequest postRequest);
    PostResponse updatePost(PostRequest postRequest);
    List<PostResponse> getAllPosts();
    PostResponse getPostById(String postId);
    void deletePostById(String postId);
}
