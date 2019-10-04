package com.caseStudy.Ecommerce.repository;


import com.caseStudy.Ecommerce.modal.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginrepository extends JpaRepository<login,Long> {

}
