package cst;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownLoadController {
	/**
	 * @param response
	 */
	@RequestMapping(value = "/downLoad1")
	public void downLoadTemplate1(HttpServletResponse response) {
		try {
			//获取resource文件下的文件
			ClassPathResource classPathResource = new ClassPathResource("excleTemplate/test.xlsx");
			//getInputStream方法底层也是首先获取类加载器，然后通过类加载器获取文件流
			InputStream inputStream =classPathResource.getInputStream();
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();  
			response.setContentType("application/vnd.ms-excel;charset=utf-8"); 
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(("test.xlsx").getBytes(), "iso-8859-1"));  
			response.getOutputStream().write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 这个下载模板使用了ClassPathResource
	 * @param response
	 */
	@RequestMapping(value = "/downLoad2")
	public void downLoadTemplate2(HttpServletResponse response) {
		try {
			//通过类加载器获取resource文件根目录下文件
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("excleTemplate/test.xlsx");
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();  
			response.setContentType("application/vnd.ms-excel;charset=utf-8"); 
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(("test.xlsx").getBytes(), "iso-8859-1"));  
			response.getOutputStream().write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/downLoad3")
	public void downLoadTemplate3(HttpServletResponse response) {
		try {
			//getResourceAsStream底层也是首先获取类加载器，方式同2
			InputStream inputStream = this.getClass().getResourceAsStream("/excleTemplate/test.xlsx");
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();  
			response.setContentType("application/vnd.ms-excel;charset=utf-8"); 
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(("test.xlsx").getBytes(), "iso-8859-1"));  
			response.getOutputStream().write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//上面三种底层都是使用了类加载器获取文件流，因此jar包运行在linux上也是可以正常读取到的
	//**************************************************************//
	//这种方法，是获取文件，无法通过api访问jar包中文件，因此这种方式在开发环境下可以读取到，jar包运行在linux服务器上就读取不到了
	
	@RequestMapping(value = "/downLoad4")
	public void downLoadTemplate4(HttpServletResponse response) {
		try {
			File file = ResourceUtils.getFile("classpath:excleTemplate/test.xlsx");
			InputStream inputStream = new FileInputStream(file);
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();  
			response.setContentType("application/vnd.ms-excel;charset=utf-8"); 
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(("test.xlsx").getBytes(), "iso-8859-1"));  
			response.getOutputStream().write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
