package com.hwj.basic.business.application.task;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Program: hwj
 * @Description: xxl-job使用示例
 * @author: peng.huang
 * @since: 2025-03-20 17:21:08
 */
@Component
public class TestTask {

    private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

    @XxlJob("testXxlJobHandler")
    public void testXxlJobHandler() {
        //日志输出
        XxlJobHelper.log("XXL-JOB, Hello World.");
        //获取任务运行参数
        String jobParam = XxlJobHelper.getJobParam();
        logger.info("Job Param:{}", jobParam);
        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
        }
        // default success
        //处理成功 -- 设置调度成功 失败就是XxlJobHelper.handleFail(xxxxx)
        XxlJobHelper.handleSuccess();
    }

}
