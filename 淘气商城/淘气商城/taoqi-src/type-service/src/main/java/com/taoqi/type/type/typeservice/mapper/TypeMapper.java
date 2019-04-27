package com.taoqi.type.type.typeservice.mapper;

import com.taoqi.base.domain.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper {



    @Select("SELECT * FROM t_type where parent =0 and flag=0")
    List<Type> SelectAllTtpe();

    @Select("SELECT * FROM t_type where parent !=0 and flag=0")
    List<Type> Select2Ttpe();

    @Insert("INSERT INTO `t_type`(`name`, `parent`, `flag`) VALUES ( #{name}, #{parent},#{flag})")
    int addTypem(Type t);



    /***
     * 删除
     * @param i
     * @return
     */
    @Delete(" DELETE FROM t_type where id =#{id}")
    int delTypest(@Param("id") Long i);



    @Select("select * FROM t_type where flag=#{id}")
    List<Type> selectmer(@Param("id") Long i);


    @Select("SELECT * FROM t_type where  flag=0")
    List<Type> selectallca();

    @Select("SELECT * FROM t_type where  flag!=0")
    List<Type> selectAllMer();

    /***
     * 功能描述:
     * 〈查询第二级分类或第三级分类的的系统分类〉
     * @author: 冯培轩
     * @date: 2019-04-17 15:43
     */
    @Select("SELECT * FROM t_type where parent =#{id} and flag=0")
    List<Type> selectallca3(@Param("id") Long id);

    /***
     * 功能描述:
     * 〈更具id查父类〉
     * @author: 冯培轩
     * @date: 2019-04-22 14:29
     */
    @Select("SELECT parent FROM t_type where id =#{id} ")
    int selectfa(@Param("id") Long id);
}
