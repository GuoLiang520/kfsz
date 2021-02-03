package com.gl.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author 郭亮
 * @date 2021/1/26 15:42
 **/
public class MyScheduler1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyScheduler1:" + System.currentTimeMillis());
    }
}
