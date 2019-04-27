package evaluate.controller;


import com.taoqi.base.domain.Evaluate;
import evaluate.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    EvaluateService service;

    @GetMapping("/uget/{productid}")
    public Object getTouristEvaluate(@PathVariable("productid") long productid) {
        return service.touristServicefind(productid);
    }

    @GetMapping("/sget/{orderid}")
    public Object getShopEvaluate(@PathVariable("orderid") long orderid) {
        return service.shopServicefind(orderid);
    }

    @GetMapping("/get")
    public Object getAdminEvaluate() {
        return service.adminServicefind();
    }

    @PostMapping("/add")
    public Object addEvaluate(@RequestBody Evaluate evaluate) {
        return service.addServicEevaluate(evaluate);
    }

    @GetMapping("/delete/{orderid}")
    public Object deleteEvaluate(@PathVariable("orderid") long id) {
        return service.deleteServiceEvaluate(id);
    }
}
