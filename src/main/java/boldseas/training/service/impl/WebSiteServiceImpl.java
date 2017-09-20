package boldseas.training.service.impl;


import boldseas.training.service.WebSiteService;
import boldseas.training.service.model.WebSite;
import boldseas.training.service.model.WebSiteLink;
import org.springframework.stereotype.Service;

/**
 * @Author yefei
 * @Version 2017/9/19.
 */
@Service
public class WebSiteServiceImpl implements WebSiteService {
    @Override
    public WebSiteLink findByAlias(String alias) {
        return alias.equals("dealer_list_page") ? getAutoHomeDealerListLink() : getAutoHomePriceListLink();
    }

    /**
     * 获取经销商列表相关配置
     *
     * @return
     */
    private WebSiteLink getAutoHomeDealerListLink() {
        return new WebSiteLink(
                1,
                "http://dealer.autohome.com.cn/china?countyId=0&brandId=46&seriesId=0&factoryId=0&pageIndex=1&kindId=1&orderType=0&_abtest=0",
                "dealer_list_page",
                50,
                new WebSite(1, "auto_home", "http://dealer.autohome.com.cn"),
                false,
                ""
        );
    }

    /**
     * 获取报价页的相关配置
     *
     * @return
     */
    private WebSiteLink getAutoHomePriceListLink() {
        return new WebSiteLink(
                1,
                "http://dealer.autohome.com.cn/2029977/price.html",
                "price_list_page",
                50,
                new WebSite(1, "auto_home", "http://dealer.autohome.com.cn"),
                false,
                ""
        );
    }
}
