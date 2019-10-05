package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.controller.loginsignup;
import com.caseStudy.Ecommerce.modal.login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userrepository  extends JpaRepository<login,Long> {
}
