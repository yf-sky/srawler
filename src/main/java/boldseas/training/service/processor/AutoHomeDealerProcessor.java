package boldseas.training.service.processor;

import boldseas.training.service.model.Dealer;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * @Author yefei
 * @Version 2017/9/12.
 */
public class AutoHomeDealerProcessor implements PageProcessor {

    private final String prefix = "dealerCode_";

    @Override
    public void process(Page page) {
        String pageUrl = page.getUrl().toString();
        if (pageUrl.contains("pageIndex=1")) {
            IntStream.rangeClosed(2, Integer.valueOf(page.getHtml().regex("dealerCount = (\\d+)").toString()))
                    .forEach(i -> page.addTargetRequest(pageUrl.replace("pageIndex=1", "pageIndex=" + i)));
        }
        extractDealerData(page);
    }

    private void extractDealerData(Page page) {
        page.getHtml().xpath("//ul[@class='list-box']/li[@class='list-item']").nodes()
                .forEach(s -> {
                    Dealer dealer = new Dealer();
                    dealer.setPhone(s.xpath("//span[@class='tel']/text()").toString());
                    dealer.setName(s.xpath("//li[@class='tit-row']/a/span/text()").toString());
                    dealer.setDealerCode(s.regex("//dealer.autohome.com.cn/(\\w+)/#pvareaid=").toString());
                    dealer.setAddress(s.xpath("//span[@class='info-addr']/text()").toString());
                    dealer.setUrl(page.getUrl().toString());
                    page.putField(prefix + dealer.getDealerCode(), dealer);
                });
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    }
}
