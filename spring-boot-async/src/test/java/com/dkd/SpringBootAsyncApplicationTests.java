package com.dkd;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAsyncApplicationTests {
	
	@Autowired
	private Task task;
	
	@Test
	public void contextLoads() throws InterruptedException {
		
		long start = System.currentTimeMillis();
		
		Future<String> taskOne = task.taskOne();
		Future<String> taskTwo = task.taskTwo();
		Future<String> taskThree = task.taskThree();
		
		//当三个任务都执行完毕后跳出循环
		while(true) {
			if(taskOne.isDone() && taskTwo.isDone() &&  taskThree.isDone()) {
				break;
			}
			Thread.sleep(1000);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

}
