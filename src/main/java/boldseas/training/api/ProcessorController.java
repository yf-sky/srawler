package boldseas.training.api;

import boldseas.training.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yefei
 * @Version 2017/9/12.
 */
@RestController
@RequestMapping("/api/processor")
public class ProcessorController {

    @Autowired
    private SpiderService spiderService;

    @GetMapping("/alias/{alias}")
    public void spider(@PathVariable String alias) {
        spiderService.spider(alias);
    }
}
