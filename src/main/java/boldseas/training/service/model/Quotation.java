package boldseas.training.service.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Quotation {
    public void Price() {
        this.createTime = LocalDateTime.now();
    }

    private String nakedPrice;
    private String modelName;
    private String groupName;
    private String formPrice;
    private String promotionPrice;
    private String dealerCode;
    private String modelId;
    private String brandId;
    private String webSite;
    private String url;
    private LocalDateTime createTime;
    private String timeSpan;
}
