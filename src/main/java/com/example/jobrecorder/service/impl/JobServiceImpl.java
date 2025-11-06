package com.example.jobrecorder.service.impl;

import com.example.jobrecorder.entity.Job;
import com.example.jobrecorder.repository.JobRepository;
import com.example.jobrecorder.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        return jobOptional.orElse(null);
    }

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Optional<Job> existingJobOptional = jobRepository.findById(id);
        if (existingJobOptional.isPresent()) {
            Job existingJob = existingJobOptional.get();
            // 更新字段
            existingJob.setCompanyName(job.getCompanyName());
            existingJob.setJobName(job.getJobName());
            existingJob.setSalary(job.getSalary());
            existingJob.setRequirements(job.getRequirements());
            existingJob.setLocation(job.getLocation());
            existingJob.setExperience(job.getExperience());
            existingJob.setEducation(job.getEducation());
            existingJob.setDescription(job.getDescription());
            existingJob.setContactInfo(job.getContactInfo());
            existingJob.setSource(job.getSource());
            existingJob.setStatus(job.getStatus());
            return jobRepository.save(existingJob);
        }
        return null;
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> searchJobs(String companyName, String jobName, String status) {
        if (status != null && !status.isEmpty()) {
            return jobRepository.findByStatus(status);
        } else if (companyName != null && !companyName.isEmpty() && jobName != null && !jobName.isEmpty()) {
            return jobRepository.findByCompanyNameContainingAndJobNameContaining(companyName, jobName);
        } else if (companyName != null && !companyName.isEmpty()) {
            return jobRepository.findByCompanyNameContaining(companyName);
        } else if (jobName != null && !jobName.isEmpty()) {
            return jobRepository.findByJobNameContaining(jobName);
        } else {
            return jobRepository.findAll();
        }
    }
}