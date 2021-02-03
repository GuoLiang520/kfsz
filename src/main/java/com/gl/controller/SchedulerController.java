package com.gl.controller;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 郭亮
 * @date 2021/1/26 15:52
 **/
@RestController
@RequestMapping(value = "/scheduler")
public class SchedulerController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping(value = "/pause")
    public Object pause(String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.pauseJob(jobKey);
        return "succ";
    }

    @GetMapping(value = "/resume")
    public Object resume(String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.resumeJob(jobKey);
        return "succ";
    }
}
