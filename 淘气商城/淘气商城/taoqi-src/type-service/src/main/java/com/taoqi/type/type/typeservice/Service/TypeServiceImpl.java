package com.taoqi.type.type.typeservice.Service;
/***
 * 功能描述:
 * 〈〉
 * @author: 冯培轩
 * @date: 2019-04-11 15:11
 */

import com.taoqi.base.domain.Type;

import com.taoqi.type.type.typeservice.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    TypeMapper tm;


    /***
     * 查询第一级分类
     * @return
     */
    public List<Type> AllTypes() {
        return tm.SelectAllTtpe();
    }

    /***
     * 查询第一级分类下面的第二级分类
     * @return
     */
    public List<Type> AllTypes2() {
        return tm.Select2Ttpe();
    }

    /***
     * 添加
     * @param t
     * @return
     */
    public String addTypes(Type t) {
        if (tm.addTypem(t) == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }


    }

    /***
     * 删除
     * @param i
     * @return
     */
    public String delTypes(Long i) {

        if (tm.delTypest(i) == 0) {
            return "删除失败";
        } else {
            return "删除成功";
        }

    }

    /***
     * 查询某个店铺分类
     * @param i
     * @return
     */
    public List<Type> selectmerchant2(Long i) {

        return tm.selectmer(i);
    }

    public List<Type> AllTypesall() {
        return tm.selectallca();
    }

    /***
     * 功能描述:
     * 〈查询所有店铺分类〉
     * @author: 冯培轩
     * @date: 2019-04-16 15:00
     */
    public List<Type> selectAllMerchants() {
        return tm.selectAllMer();
    }

    /***
     * 功能描述:
     * 〈查询第二级分类或第三级分类的的系统分类〉
     * @author: 冯培轩
     * @date: 2019-04-17 15:43
     */
    public List<Type> AllTypes3(Long id) {
        return tm.selectallca3(id);
    }



    /***
     * 功能描述:
     * 〈更具id查父类〉
     * @author: 冯培轩
     * @date: 2019-04-22 14:29
     */

    @Transactional
    public List<Integer> selectfats(Long id) {
        int i;
        List<Integer> list = new ArrayList<Integer>();
        i = tm.selectfa(id);

         System.out.println(i);
        do{
            i = tm.selectfa(id);
            list.add(i);
        }while( i==0 );

        return list;
    }

}
