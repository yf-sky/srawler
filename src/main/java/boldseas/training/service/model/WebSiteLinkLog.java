package boldseas.training.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author yefei
 * @Version 2017/9/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSiteLinkLog implements Serializable {
    private long id;
    private String link;
    private WebSiteLink webSiteLink;
    private int state;
    private int resultCode;
    private String resultMessage;
}
