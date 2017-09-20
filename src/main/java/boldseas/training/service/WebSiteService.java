package boldseas.training.service;


import boldseas.training.service.model.WebSiteLink;

/**
 * @Author yefei
 * @Version 2017/9/19.
 */
public interface WebSiteService {

    WebSiteLink findByAlias(String alias);
}
