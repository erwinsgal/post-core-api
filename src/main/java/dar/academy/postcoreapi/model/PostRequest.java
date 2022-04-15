package dar.academy.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PostRequest {

    @NotNull(message = "Post ID can not be empty")
    private String postId;
    @NotNull(message = "Client ID can not be empty")
    private String clientId;
    @NotNull(message = "Recipient ID can not be empty")
    private String postRecipientId;
    private String postItem;
    private String status;

}
