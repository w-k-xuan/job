package com.example.jobrecorder.service;

import com.example.jobrecorder.entity.Job;

import java.util.List;

public interface JobService {

    // 获取所有岗位
    List<Job> getAllJobs();

    // 根据ID获取岗位
    Job getJobById(Long id);

    // 添加岗位
    Job saveJob(Job job);

    // 更新岗位
    Job updateJob(Long id, Job job);

    // 删除岗位
    void deleteJob(Long id);

    // 根据条件筛选岗位
    List<Job> searchJobs(String companyName, String jobName, String status);
}