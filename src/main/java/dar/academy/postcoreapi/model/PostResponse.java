package dar.academy.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PostResponse {

    private String postId;
    private String clientId;
    private String postRecipientId;
    private String postItem;
    private String status;

}
