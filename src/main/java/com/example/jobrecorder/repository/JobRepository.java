package com.example.jobrecorder.repository;

import com.example.jobrecorder.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    // 根据企业名称模糊查询
    List<Job> findByCompanyNameContaining(String companyName);

    // 根据岗位名称模糊查询
    List<Job> findByJobNameContaining(String jobName);

    // 根据状态查询
    List<Job> findByStatus(String status);

    // 复合查询：根据企业名称和岗位名称模糊查询
    List<Job> findByCompanyNameContainingAndJobNameContaining(String companyName, String jobName);
}