package boldseas.training.service.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Dealer {

    public void Dealer() {
        this.createTime = LocalDateTime.now();
    }
    private String phone;
    private String address;
    private String name;
    private String dealerCode;
    private String brandId;
    private String url;
    private String webSite;
    private LocalDateTime createTime;
    private String timeSpan;
}
