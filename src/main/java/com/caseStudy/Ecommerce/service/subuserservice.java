package com.caseStudy.Ecommerce.service;

import com.caseStudy.Ecommerce.modal.blogs;
import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.modal.subscribe;
import com.caseStudy.Ecommerce.modal.subscribe1;
import com.caseStudy.Ecommerce.repository.blogrepository;
import com.caseStudy.Ecommerce.repository.subscribe1repository;
import com.caseStudy.Ecommerce.repository.subscriberepository;
import com.caseStudy.Ecommerce.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class subuserservice {
    @Autowired
    blogrepository br;
    @Autowired
    userrepository ur;
    @Autowired
    subscriberepository sb;
    @Autowired
    subscribe1repository sb1;
   public String addtosubscribe(Long userid, Long blogid)
   {
       login login=ur.findById(userid).get();
       blogs blog=br.findById(blogid).get();
       subscribe c=new subscribe();
       c.setLogin(login);
       c.setBlogs(blog);
       sb.save(c);
       return "addition of what subscribed in database";
   }
   public List<blogs> showall(Long userid)
   {
       login login1=ur.findById(userid).get();
       return br.findByLogin(login1);
   }
   @Transactional
   public String unsubscribe(Long userid,Long blogid)
   {
       login login=ur.findById(userid).get();
       blogs blogs=br.findById(blogid).get();
        sb.deleteByLoginAndBlogs(login,blogs);
        return "delete";
   }
   @Transactional
    public String unsub1(Long id)
   {
       blogs blogs=br.findById(id).get();
       br.deleteById(id);
       return "deletion of whole application";
   }
   public List<blogs> show1(Long userid)
   {
    login login=ur.findById(userid).get();
    return br.findByLogin(login);
   }
   @Transactional
public String del(Long userid,Long id)
{
    login login=ur.findById(userid).get();
    br.deleteByIdAndLogin(id,login);
    return "deletion of blog is done";
}
public blogs addnew(Long userid,blogs bt)
{
    blogs b=new blogs();
    b.setBlogname(bt.getBlogname());
    b.setContent(bt.getContent());
    b.setImage(bt.getImage());
    b.setParagraph(bt.getParagraph());
    b.setDate(bt.getDate());
    login login=ur.findById(userid).get();
    b.setLogin(login);
    return br.save(b);
}

    public blogs getdata(Long userid,Long id)
    {
        login login=ur.findById(userid).get();
        return br.findByIdAndLogin(id,login);

    }
    public List<blogs> getuser(Long userid,String name)
    {
        login login=ur.findByEmail(name).get();
        return br.findByLogin(login);
    }
public subscribe1 subscribe1(Long userid,String name)
{
    login login1=ur.findByEmail(name).get();
    login login=ur.findById(userid).get();
    subscribe1 st = new subscribe1();
    if(!sb1.findByLoginAndLogin1(login,login1).isPresent()) {
      //  subscribe1 st = new subscribe1();
        //st.setTimes(1);
        st.setLogin(login);
        st.setLogin1(login1);
      //  return sb1.save(st);
    }
    return sb1.save(st);
   // return sb1.save(st);
}
public List<subscribe1>showsubscribe1(Long userid)
{
    login login=ur.findById(userid).get();
 return sb1.findByLogin(login);
}
@Transactional
public String delfollower(Long userid,String email)
{
    login login=ur.findByEmail(email).get();
    login login1=ur.findById(userid).get();
    sb1.deleteByLoginAndLogin1(login1,login);
    return "deletion of my follower";
}
public Boolean following(Long userid,String email)
{ login login=ur.findByEmail(email).get();
    login login1=ur.findById(userid).get();
    if(sb1.findByLoginAndLogin1(login1,login).isPresent())
    {
        return true;
    }
    else
    {
        return false;
    }
}
}
