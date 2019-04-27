package com.taoqi.type.type.typeservice.Service;
/***
 * 功能描述:
 * 〈〉
 * @author: 冯培轩
 * @date: 2019-04-11 15:12
 */
import com.taoqi.base.domain.Type;


import java.util.List;

public interface TypeService {
    /***
     * 查询第一级分类
     * @return
     */
     List<Type> AllTypes();

    /***
     * 查询第一级分类下面的第二级分类
     * @return
     */
    List<Type> AllTypes2();

    /***
     * 插入分类
     * @param t
     * @return
     */
   String addTypes(Type t);

    /***
     * 删除
     * @param i
     * @return
     */
    String delTypes(Long i);

    /***
     * 查询某个店铺分类
     * @param i
     * @return
     */
    List<Type> selectmerchant2(Long i);

    /***
     * 功能描述:
     * 〈查询全部〉
     * @author: 冯培轩
     * @date: 2019-04-15 16:25
     */

    List<Type> AllTypesall();

    List<Type> selectAllMerchants();


    /***
     * 功能描述:
     * 〈查询第二级分类或第三级分类的的系统分类〉
     * @author: 冯培轩
     * @date: 2019-04-17 15:43
     */
    List<Type> AllTypes3(Long id);




    /***
     * 功能描述:
     * 〈更具id查父类〉
     * @author: 冯培轩
     * @date: 2019-04-22 14:29
     */
    List<Integer> selectfats(Long id);
}
