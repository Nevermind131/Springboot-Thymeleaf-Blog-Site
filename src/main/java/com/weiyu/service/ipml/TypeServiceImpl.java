package com.weiyu.service.ipml;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiyu.entity.Type;
import com.weiyu.mapper.TypeMapper;
import com.weiyu.service.TypeService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TypeServiceImpl
        extends ServiceImpl<TypeMapper, Type>
        implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public PageInfo<Type> listType(int currentPage) throws Exception {
        PageHelper.startPage(currentPage, 10);
        List<Type> typeList = this.typeMapper.findAllByOrder();

        PageInfo<Type> pageInfo = new PageInfo(typeList);

        return pageInfo;
    }


    public List<Type> listType() throws Exception {
        QueryWrapper<Type> qw = new QueryWrapper();
        qw.orderByDesc("id");
        return this.typeMapper.selectList((Wrapper) qw);
    }


    public List<Type> listTypeTop(Integer size) throws Exception {
        Page<Type> page = new Page(1L, size.intValue());
        QueryWrapper<Type> qw = new QueryWrapper();
        qw.orderByDesc("number");
        page = (Page<Type>) this.typeMapper.selectPage((IPage) page, (Wrapper) qw);
        return page.getRecords();
    }


    public Type getByName(String name) {
        QueryWrapper<Type> wrapper = new QueryWrapper();
        wrapper.eq("name", name);
        return (Type) this.typeMapper.selectOne((Wrapper) wrapper);
    }


    public void sortType(List<Type> list) {
        Collections.sort(list, new Comparator<Type>() {
            @Override
            public int compare(Type o1, Type o2) {
                return (int) (o2.getNumber() - o1.getNumber());
            }
        });
    }
}


