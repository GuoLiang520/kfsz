package com.gl.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.nio.file.Files;

/**
 *
 * @author 郭亮
 * @date 2021/1/26 15:14
 **/
@Component
public class SchedulerRunner implements ApplicationRunner {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("scheduler.json");
        String config = new String(Files.readAllBytes(resource.getFile().toPath()));
        JSONArray jsonArray = JSON.parseArray(config);
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            String classname = json.getString("classname");
            String jobName = json.getString("jobName");
            String corn = json.getString("corn");
            JobDetail job = JobBuilder.newJob(((Job) Class.forName(classname).newInstance()).getClass())
                    .withIdentity(jobName)
                    .build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(corn);
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName).withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(job, trigger);
        }
        scheduler.start();
    }
}
