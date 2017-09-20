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
public class WebSite implements Serializable {
    private long id ;
    private String name;
    private String homeLink;
}
