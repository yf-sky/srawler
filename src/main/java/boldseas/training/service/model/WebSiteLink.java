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
public class WebSiteLink implements Serializable {
    private long id;
    private String link;
    private String alias;
    private int interval;
    private WebSite website;
    private boolean isRepeat;
    private String modelJson;
}
