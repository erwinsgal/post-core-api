package dar.academy.postcoreapi.controller;

import dar.academy.postcoreapi.model.PostRequest;
import dar.academy.postcoreapi.model.PostResponse;
import dar.academy.postcoreapi.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")

public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest postRequest){
        return postService.createPost(postRequest);
    }

    @PutMapping
    public PostResponse updatePost(@RequestParam String postId, @RequestBody PostRequest postRequest){
        postRequest.setPostId(postId);
        return postService.updatePost(postRequest);
    }

    @GetMapping
    public PostResponse getPostById(@RequestParam String postId){
        return postService.getPostById(postId);
    }

    @GetMapping("/all")
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    @DeleteMapping
    public void deletePost(@RequestParam String postId){
        postService.deletePostById(postId);
    }
}

