package evaluate.service;


import com.taoqi.base.domain.Evaluate;
import evaluate.mapper.EvaluateMapper;
import evaluate.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateServiceImp implements EvaluateService {

    @Autowired
    EvaluateMapper mapper;

    @Override
    public Object touristServicefind(long productid) {
        return ResultUtil.succes(mapper.touristfind(productid));
    }

    @Override
    public Object shopServicefind(long orderid) {
        return ResultUtil.succes(mapper.shopfind(orderid));
    }

    @Override
    public Object adminServicefind() {
        return ResultUtil.succes(mapper.adminfind());
    }

    @Override
    public Object addServicEevaluate(Evaluate evaluate) {
        String msg;
        int eva = mapper.addevaluate(evaluate);
        if (eva == 1) {
            msg = "操作成功";
            return ResultUtil.succes(msg);
        } else {
            msg = "操作成功";
            return ResultUtil.error(msg);
        }
    }

    @Override
    public Object deleteServiceEvaluate(long id) {
        String msg;
        int eva = mapper.deleteevaluate(id);
        if (eva == 1) {
            msg = "操作成功";
            return ResultUtil.succes(msg);
        } else {
            msg = "操作成功";
            return ResultUtil.error(msg);
        }


    }


}
