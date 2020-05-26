package invaid.users.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import invaid.users.job.MFWebCrawlJob;
import invaid.users.job.UITFWebCrawlJob;

public class WebCrawlQuartzListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		JobDetail mfjobDetail = JobBuilder.newJob(MFWebCrawlJob.class).withIdentity("mfwebcrawl", "webcrawler").build();
		JobDetail uitfjobDetail = JobBuilder.newJob(UITFWebCrawlJob.class).withIdentity("uitfwebcrawl", "webcrawler").build();
		
		try {
			Trigger mftrigger = TriggerBuilder.newTrigger().withIdentity("mfTrigger", "webcrawler")
									  .withSchedule(CronScheduleBuilder.cronSchedule("0 0 2 1/1 * ? *")).build();
			Trigger uitftrigger = TriggerBuilder.newTrigger().withIdentity("uitfTrigger", "webcrawler")
									  .withSchedule(CronScheduleBuilder.cronSchedule("0 0 2 1/1 * ? *")).build();
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
						
			scheduler.scheduleJob(mfjobDetail, mftrigger);
			scheduler.scheduleJob(uitfjobDetail, uitftrigger);
		} catch(SchedulerException se) {
			System.err.println(se.getMessage());
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Destroyed Context");
	}

}
