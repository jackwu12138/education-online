package com.github.education.framework.mybatis.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.education.framework.common.pojo.PageParam;
import com.github.education.framework.common.pojo.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 继承了 Mybatis-Plus 的 BaseMapper, 自定义封装了一些常用的方法
 *
 * @author jackwu
 */
public interface BaseMapperX<T> extends BaseMapper<T> {

    /**
     * 根据条件查询一条数据
     *
     * @param field 条件
     * @param value 条件的值
     * @return 查询到的数据
     */
    default T selectOne(SFunction<T, ?> field, Object value) {
        return selectOne(new LambdaQueryWrapper<T>()
                .eq(field, value));
    }

    /**
     * 根据条件查询一条数据
     *
     * @param field1 条件一
     * @param value1 条件一的值
     * @param field2 条件二
     * @param value2 条件二的值
     * @return 查询到的数据
     */
    default T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2) {
        return selectOne(new LambdaQueryWrapper<T>()
                .eq(field1, value1)
                .eq(field2, value2));
    }

    /**
     * 根据条件查询一条数据
     *
     * @param field1 条件一
     * @param value1 条件一的值
     * @param field2 条件二
     * @param value2 条件二的值
     * @param field3 条件三
     * @param value3 条件三的值
     * @return 查询到的数据
     */
    default T selectOne(SFunction<T, ?> field1, Object value1,
            SFunction<T, ?> field2, Object value2,
            SFunction<T, ?> field3, Object value3) {
        return selectOne(new LambdaQueryWrapper<T>()
                .eq(field1, value1)
                .eq(field2, value2)
                .eq(field3, value3));
    }

    /**
     * 查询数据库条数
     *
     * @return 数据库条数
     */
    default Long selectCount() {
        return selectCount(new LambdaQueryWrapper<>());
    }

    /**
     * 根据条件查询数据库条数
     *
     * @param field 条件一
     * @param value 条件一的值
     * @return 数据库条数
     */
    default Long selectCount(SFunction<T, ?> field, Object value) {
        return selectCount(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 根据条件查询数据库条数
     *
     * @param field1 条件一
     * @param value1 条件一的值
     * @param field2 条件二
     * @param value2 条件二的值
     * @return 数据库条数
     */
    default Long selectCount(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2) {
        return selectCount(new LambdaQueryWrapper<T>().eq(field1, value1).eq(field2, value2));
    }

    /**
     * 列表查询
     *
     * @return 查询到的列表
     */
    default List<T> selectList() {
        return selectList(new QueryWrapper<>());
    }

    /**
     * 根据条件进行列表查询
     *
     * @param field 条件
     * @param value 值
     * @return 查询到的列表
     */
    default List<T> selectList(SFunction<T, ?> field, Object value) {
        return selectList(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 列表查询
     *
     * @param field  条件
     * @param values 值的集合
     * @return 查询到的列表
     */
    default List<T> selectList(SFunction<T, ?> field, Collection<?> values) {
        return selectList(new LambdaQueryWrapper<T>().in(field, values));
    }

    /**
     * 分页查询
     *
     * @param param        分页参数
     * @param queryWrapper 查询条件
     * @return 分页列表
     */
    default PageResult<T> selectPage(PageParam param, @Param("ew") Wrapper<T> queryWrapper) {
        IPage<T> mpPage = new Page<>(param.getPage(), param.getSize());
        selectPage(mpPage, queryWrapper);
        return new PageResult<>(mpPage.getTotal(), mpPage.getCurrent(), mpPage.getSize(),
                mpPage.getPages(), mpPage.getRecords());
    }
}
