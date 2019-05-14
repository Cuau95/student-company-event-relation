/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.student.company.event.relation.domain.repository;

import com.example.student.company.event.relation.domain.model.StudentEventCompanyRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEventCompanyRelationRepository extends CrudRepository<StudentEventCompanyRelationEntity, Integer> {
    
}
