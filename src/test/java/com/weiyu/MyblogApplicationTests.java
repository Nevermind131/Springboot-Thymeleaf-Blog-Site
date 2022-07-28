package com.weiyu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.weiyu.entity.*;
import com.weiyu.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MyblogApplicationTests {


    @Autowired
    private QueryBlogMapper listBlogMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogTagsMapper blogTagsMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BlogMapper blogMapper;


    @Test
    void testHello(){
        System.out.println("hello");
    }

    @Test
    void testSelectCount(){
        QueryWrapper<Blog> qw=new QueryWrapper<>();
        System.out.println("countResult is:"+blogMapper.selectCount(qw));
    }

    @Test
    void testJson(){
//        List<Comment> replyComments=new ArrayList<>();
//        replyComments.add(new Comment(1L,"hehe",null,"86",new Date(),null,null,null,new ArrayList<>()));
//
//        Comment comment=new Comment(29L,"hehe",null,"86",new Date(),null,null,null,replyComments);
//        commentMapper.updateById(comment);
    }


    @Test
    void testInsert(){

        BlogTags blogTags=new BlogTags();
        blogTags.setBlogId(39L);
        blogTags.setTagId(11L);
        int insert = blogTagsMapper.insert(blogTags);
        System.out.println("*****************************");
        System.out.println("result:"+blogTags.getId());
        System.out.println("*****************************");

    }

    @Test
    void testBlob(){
        String s="asdf";
    }

    @Test
    void testSelectIds(){
        List<Long> ids=new ArrayList<>();
        ids.add(11L);
        ids.add(12L);
        ids.add(15L);
        ids.add(16L);
        ids.add(21L);
        List<Tag> tagList = tagMapper.selectBatchIds(ids);
        for (Tag tag : tagList) {
            System.out.print(tag.getId()+":");
            System.out.println(tag.getName());
        }
    }

    @Test
    void testSelectPage(){

        Page<Type> page=new Page<>(1,2);

        QueryWrapper<Type> qw=new QueryWrapper<>();
        qw.orderByDesc("id");

        page = typeMapper.selectPage(page, qw);

        List<Type> typeList = page.getRecords();



        for (Type type : typeList) {
            System.out.println(type);
        }
    }



    @Test
    void testPageHelper() {

//        QueryWrapper<QueryBlog> qw = new QueryWrapper<>();

        PageHelper.startPage(1, 10);

        Blog blog=new Blog();
//        blog.setTitle("分布式");
//        blog.setTypeId(0L);
//        blog.setRecommend(1);

        List<QueryBlog> blogList = listBlogMapper.findAllByOrder(blog);

        PageInfo<QueryBlog> pageInfo = new PageInfo<>(blogList);

        List<QueryBlog> list = pageInfo.getList();


        System.out.println("***********************************");
        for (QueryBlog listBlog : list) {
            System.out.println(listBlog.getType().getName());

        }
        System.out.println("***********************************");
    }
}



//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        System.out.println(sdf.format(new Date()));


//        QueryWrapper<Blog> qw = new QueryWrapper<>();
//        List<Blog> blogList = blogMapper.selectList(qw);
//
//        Collections.sort(blogList, new Comparator<Blog>() {
//            @Override
//            public int compare(Blog o1, Blog o2) {
//                return o2.getDate().compareTo(o1.getDate());
//            }
//        });
//
//        for (Blog blog : blogList) {
//            System.out.println(blog);
//        }



//        Integer num=null;
//        System.out.println(Strings.isNotEmpty(String.valueOf(num)));
//        System.out.println(num!=null);


//        Blog blog = new Blog();
//        blog.setTitle("测试数据");
//        blog.setTags(new Integer[]{1, 2, 3, 4});
//        List<Comment> comments=new ArrayList<>();
////        comments.add(new Comment(null,"测试用户","aaa",37,null,"alksdjfl",null,"alsdkfj"));
//        blog.setComments(comments);
//
//        boolean count = blogService.save(blog);
//
//        System.out.println(count);
//    }
//
//
//}
