package com.example.jobrecorder.controller;

import com.example.jobrecorder.entity.Job;
import com.example.jobrecorder.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class JobController {

    @Autowired
    private JobService jobService;

    // 显示岗位列表页面
    @GetMapping
    public String listJobs(Model model,
                          @RequestParam(value = "companyName", required = false) String companyName,
                          @RequestParam(value = "jobName", required = false) String jobName,
                          @RequestParam(value = "status", required = false) String status) {
        List<Job> jobs;
        if (companyName != null || jobName != null || status != null) {
            jobs = jobService.searchJobs(companyName, jobName, status);
        } else {
            jobs = jobService.getAllJobs();
        }
        model.addAttribute("jobs", jobs);
        model.addAttribute("studentInfo", "姓名：王凯旋 | 学号：20234113 | 班级：信2305-1");
        return "job/list";
    }

    // 显示添加岗位页面
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("studentInfo", "姓名：王凯旋 | 学号：20234113 | 班级：信2305-1");
        return "job/add";
    }

    // 添加岗位
    @PostMapping("/add")
    public String addJob(@ModelAttribute Job job) {
        jobService.saveJob(job);
        return "redirect:/";
    }

    // 显示编辑岗位页面
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return "redirect:/";
        }
        model.addAttribute("job", job);
        model.addAttribute("studentInfo", "姓名：王凯旋 | 学号：20234113 | 班级：信2305-1");
        return "job/edit";
    }

    // 更新岗位
    @PostMapping("/edit/{id}")
    public String updateJob(@PathVariable Long id, @ModelAttribute Job job) {
        jobService.updateJob(id, job);
        return "redirect:/";
    }

    // 删除岗位
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "redirect:/";
    }

    // 查看岗位详情
    @GetMapping("/detail/{id}")
    public String showJobDetail(@PathVariable Long id, Model model) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return "redirect:/";
        }
        model.addAttribute("job", job);
        model.addAttribute("studentInfo", "姓名：王凯旋 | 学号：20234113 | 班级：信2305-1");
        return "job/detail";
    }
}