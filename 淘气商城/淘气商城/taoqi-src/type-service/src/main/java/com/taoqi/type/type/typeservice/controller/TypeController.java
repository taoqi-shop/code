package com.taoqi.type.type.typeservice.controller;
/***
 * 功能描述:
 * 〈〉
 * @author: 冯培轩
 * @date: 2019-04-11 15:12
 */

import com.taoqi.base.domain.Type;
import com.taoqi.base.domain.User;

import com.taoqi.type.type.typeservice.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    TypeService types;

    /***
     * 功能描述:
     * 〈查询所有〉
     * @author: 冯培轩
     * @date: 2019-04-15 16:23
     */

    @ResponseBody
    @GetMapping("/allcate")
    public List<Type> allTypeall() {
//System.out.println(types.AllTypesall());
        return types.AllTypesall();

    }

    /***
     * 查询第一级分类
     * @return
     */
    @ResponseBody
    @GetMapping("/classification")
    public List<Type> allType() {
//System.out.println(types.AllTypes());
        return types.AllTypes();

    }

    /***
     * 查询第一级分类下面的第二级分类
     * @return
     */
    @ResponseBody
    @GetMapping("/subclassification")
    public List<Type> allType2() {

        return types.AllTypes2();

    }

    /***
     * 功能描述:
     * 〈查询第二级分类或第三级分类的的系统分类〉
     * @author: 冯培轩
     * @date: 2019-04-17 15:43
     */
    @ResponseBody
    @GetMapping("/selectid/{aa}")
    public List<Type> allType3(@PathVariable("aa") long t) {
       System.out.println(t);
      //  System.out.println(types.AllTypes3(t));
        return types.AllTypes3(t);

    }

    /***
     * 添加
     * @param t
     * @return
     */
    @ResponseBody
    @PostMapping("/addclassification")
    public String addType(@RequestBody Type t) {

        return types.addTypes(t);
    }

    /***
     * 功能描述:
     * 〈删除〉
     * @author: 冯培轩
     * @date: 2019-04-16 14:59
     */
    @ResponseBody
    @PostMapping("/delsubclassification")
    public String delType(@RequestBody User user) {
      //  System.out.println(user.getId());
        return types.delTypes(user.getId());
    }

    /***
     * 查询某个店铺分类
     * @param i
     * @return
     */
    @ResponseBody
    @PostMapping("/merchant")
    public List<Type> selectMerchant(@RequestBody Type i) {
System.out.println(i.getId());
        return types.selectmerchant2(i.getId());
    }

    /***
     * 功能描述:
     * 〈查询所有店铺分类〉
     * @author: 冯培轩
     * @date: 2019-04-16 14:57
     */

    @ResponseBody
    @GetMapping("/allshop")
    public List<Type> selectAllMerchant() {

        return types.selectAllMerchants();
    }


    /***
     * 功能描述:
     * 〈更具id查父类〉
     * @author: 冯培轩
     * @date: 2019-04-22 14:29
     */
    @ResponseBody
    @GetMapping("/selectfa/{id}")
    public List<Integer> selectfat(@PathVariable("id") long t) {

        return types.selectfats(t);
    }
}
