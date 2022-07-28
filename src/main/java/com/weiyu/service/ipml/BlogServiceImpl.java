package com.weiyu.service.ipml;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiyu.entity.ArchiveResult;
import com.weiyu.entity.Blog;
import com.weiyu.entity.BlogTags;
import com.weiyu.entity.QueryBlog;
import com.weiyu.entity.Tag;
import com.weiyu.entity.Type;
import com.weiyu.exception.NotFoundException;
import com.weiyu.mapper.BlogMapper;
import com.weiyu.mapper.BlogTagsMapper;
import com.weiyu.mapper.QueryBlogMapper;
import com.weiyu.mapper.TagMapper;
import com.weiyu.mapper.TypeMapper;
import com.weiyu.service.BlogService;
import com.weiyu.util.MarkdownUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl
        extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Autowired
    private QueryBlogMapper queryBlogMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogTagsMapper blogTagsMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagMapper tagMapper;



    public PageInfo<QueryBlog> listBlog(int currentPage, Blog blog) throws Exception {
        PageHelper.startPage(currentPage, 10);
        List<QueryBlog> blogList = this.queryBlogMapper.findAllByOrder(blog);
        PageInfo<QueryBlog> pageInfo = new PageInfo(blogList);

        return pageInfo;
    }


    public PageInfo<QueryBlog> listBlog(int currentPage, int pageSize, Blog blog) throws Exception {
        PageHelper.startPage(currentPage, pageSize);
        List<QueryBlog> blogList = this.queryBlogMapper.findPublishedByOrder(blog);
        PageInfo<QueryBlog> pageInfo = new PageInfo(blogList);
        return pageInfo;
    }


    public PageInfo<QueryBlog> listBlog(int currentPage, int pageSize, String query) throws Exception {
        PageHelper.startPage(currentPage, pageSize);
        List<QueryBlog> blogList = this.queryBlogMapper.findByQuery(query);
        PageInfo<QueryBlog> pageInfo = new PageInfo(blogList);
        return pageInfo;
    }


    public PageInfo<QueryBlog> listBlog(int currentPage, int pageSize, Long tagId) throws Exception {
        PageHelper.startPage(currentPage, pageSize);
        List<QueryBlog> blogList = this.queryBlogMapper.findByTagId(tagId);
        for (QueryBlog queryBlog : blogList) {
            List<Tag> tagList = this.queryBlogMapper.getTagsOfBlog(queryBlog.getId());
            queryBlog.setTags(tagList);
        }
        PageInfo<QueryBlog> pageInfo = new PageInfo(blogList);
        return pageInfo;
    }


    public List<QueryBlog> listRecommendBlogTop(int pageSize) throws Exception {
        PageHelper.startPage(1, pageSize);
        return this.queryBlogMapper.findRecommendByOrder();
    }


    public ArchiveResult archiveBlog(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<String> years = this.blogMapper.getGroupYear();
        PageInfo<String> pageInfo = new PageInfo(years);

        Map<String, List<Blog>> map = new HashMap<>();
        for (String year : years) {
            map.put(year, this.blogMapper.getByYear(year));
        }
        List<Map.Entry<String, List<Blog>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, List<Blog>>>() {
            @Override
            public int compare(Map.Entry<String, List<Blog>> o1, Map.Entry<String, List<Blog>> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });

        return new ArchiveResult(pageInfo, list);
    }


    public Long countBlog() {
        QueryWrapper<Blog> qw = new QueryWrapper();
        return Long.valueOf(this.blogMapper.selectCount((Wrapper) qw).intValue());
    }


    @Transactional
    public boolean saveBlog(Blog blog) throws Exception {
        if (blog.getId() == null) {

            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(Long.valueOf(0L));
        }
        int insert = this.blogMapper.insert(blog);
        if (insert == 0) {
            return false;
        }


        Long blogId = blog.getId();

        List<Tag> tagList = blog.getTags();
        if (tagList != null && tagList.size() > 0) {
            for (Tag tag : tagList) {
                BlogTags blogTags = new BlogTags();
                blogTags.setBlogId(blogId);
                blogTags.setTagId(tag.getId());
                int insert1 = this.blogTagsMapper.insert(blogTags);
                if (insert1 == 0) {
                    return false;
                }
            }
        }

        updateNumber();
        return true;
    }


    @Transactional
    public boolean update(Blog blog) {
        QueryWrapper<BlogTags> qw = new QueryWrapper();
        qw.eq("blog_id", blog.getId());
        int delete = this.blogTagsMapper.delete((Wrapper) qw);


        Long blogId = blog.getId();

        List<Tag> tagList = blog.getTags();
        if (tagList != null && tagList.size() > 0) {
            for (Tag tag : tagList) {
                BlogTags blogTags = new BlogTags();
                blogTags.setBlogId(blogId);
                blogTags.setTagId(tag.getId());
                int insert1 = this.blogTagsMapper.insert(blogTags);
                if (insert1 == 0) {
                    return false;
                }
            }
        }
        blog.setUpdateTime(new Date());

        updateNumber();
        return (this.blogMapper.updateByPrimaryKeySelective(blog) > 0);
    }


    public QueryBlog getBlogDetails(Long id) {
        return this.queryBlogMapper.findOneById(id);
    }


    @Transactional
    public QueryBlog getAndConvert(Long id) {


        Blog updateBlog = (Blog) this.blogMapper.selectById(id);
        updateBlog.setViews(Long.valueOf(updateBlog.getViews().longValue() + 1L));
        this.blogMapper.updateById(updateBlog);

        QueryBlog queryBlog = this.queryBlogMapper.findOneById(id);
        if (queryBlog == null) {
            throw new NotFoundException("该博客不存在");
        }

        QueryBlog blog = new QueryBlog();
        BeanUtils.copyProperties(queryBlog, blog);

        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));

        return blog;
    }


    @Transactional
    public void deleteById(Long id) {
        this.blogMapper.deleteById(id);

        updateNumber();
    }


    public Blog getLast(Date createTime) {
        return this.blogMapper.getLast(createTime);
    }


    public Blog getNext(Date createTime) {
        return this.blogMapper.getNext(createTime);
    }


    @Transactional
    public void updateNumber() {
        QueryWrapper<Type> qwType = new QueryWrapper();
        List<Type> typeList = this.typeMapper.selectList((Wrapper) qwType);
        for (Type type : typeList) {
            this.typeMapper.updateNumber(type);
        }

        QueryWrapper<Tag> qwTag = new QueryWrapper();
        List<Tag> tagList = this.tagMapper.selectList((Wrapper) qwTag);
        for (Tag tag : tagList)
            this.tagMapper.updateNumber(tag);
    }
}


