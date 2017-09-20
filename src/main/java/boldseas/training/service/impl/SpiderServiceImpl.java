package boldseas.training.service.impl;

import boldseas.training.service.*;
import boldseas.training.service.model.WebSiteLink;
import boldseas.training.service.pipeline.ConsolePipeline;
import boldseas.training.service.processor.AutoHomeDealerProcessor;
import boldseas.training.service.processor.AutoHomePriceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Author yefei
 * @Version 2017/9/20.
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    @Autowired
    private WebSiteService webSiteService;

    public void spider(String alias) {
        WebSiteLink webSiteLink = webSiteService.findByAlias(alias);
        Spider.create(getPageProcessor(alias))
                .addUrl(webSiteLink.getLink())
                .addPipeline(new ConsolePipeline())
                .thread(1)
                .start();
    }

    private PageProcessor getPageProcessor(String alias) {
        //todo 改为spring boot的反射机制
        return alias.equals("dealer_list_page") ? new AutoHomeDealerProcessor() : new AutoHomePriceProcessor();
    }
}
