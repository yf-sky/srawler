package boldseas.training.service.processor;

import boldseas.training.service.model.Quotation;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author yefei
 * @Version 2017/9/20.
 */
public class AutoHomePriceProcessor implements PageProcessor {

    private final String quotesPageDealerCodeRegex = "http://dealer.autohome.com.cn/(\\d+)/price.html";
    private final String prefix = "quotation_";

    @Override
    public void process(Page page) {
        extractQuotesData(page);
    }

    private void extractQuotesData(Page page) {
        String dealerCode = page.getUrl().regex(quotesPageDealerCodeRegex).toString();

        page.getHtml().xpath("//div[@class='carprice-cont']/dl[@class='price-dl']").nodes()
                .forEach(s -> {
                    String modelName = s.xpath("//p[@class='name-text font-yh']/a/text()").toString();

                    List<Selectable> groups = s.xpath("table[@class='list-table']/tbody/tr").nodes();
                    IntStream.range(1, groups.size()).forEach(i -> {

                        Quotation quotation = new Quotation();
                        quotation.setGroupName(groups.get(i).xpath("//td[@class='txt-left']/a/text()").toString());
                        quotation.setFormPrice(groups.get(i).xpath("//p[@class='grey-999']/text()").toString());
                        quotation.setNakedPrice(groups.get(i).xpath("//p[@class='grey-999 text-line']/text()").toString());
                        quotation.setPromotionPrice(groups.get(i).xpath("//a[@class='font-bold font-arial']/text()").toString());
                        quotation.setDealerCode(dealerCode);
                        quotation.setModelName(modelName);

                        page.putField(prefix + quotation.getGroupName(), quotation);

                    });
                });
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    }
}
