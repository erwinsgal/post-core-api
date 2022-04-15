package dar.academy.postcoreapi.service.post;

import dar.academy.postcoreapi.model.PostRequest;
import dar.academy.postcoreapi.model.PostResponse;
import dar.academy.postcoreapi.repository.PostEntity;
import dar.academy.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public PostResponse createPost(PostRequest postRequest) {

        postRequest.setPostId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);

        postEntity = postRepository.save(postEntity);

        return modelMapper.map(postEntity, PostResponse.class);

    }

    @Override
    public PostResponse updatePost(PostRequest postRequest) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);

        PostEntity dbEntity = postRepository.getPostEntityByPostId(postRequest.getPostId());

        postEntity.setId(dbEntity.getId());

        postEntity = postRepository.save(postEntity);

        return modelMapper.map(postEntity, PostResponse.class);

    }

    @Override
    public List<PostResponse> getAllPosts() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return postRepository.getPostEntitiesBy().stream().map(post -> modelMapper.map(post, PostResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String postId) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        PostEntity postEntity = postRepository.getPostEntityByPostId(postId);

        return modelMapper.map(postEntity, PostResponse.class);

    }

    @Override
    public void deletePostById(String postId) {

        postRepository.deletePostEntityByPostId(postId);

    }
}
