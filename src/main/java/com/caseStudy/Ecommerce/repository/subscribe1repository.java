package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.modal.subscribe1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface subscribe1repository extends JpaRepository<subscribe1,Long> {
public List<subscribe1> findByLogin(login login);
public void deleteByLoginAndLogin1(login login,login login1);
}
