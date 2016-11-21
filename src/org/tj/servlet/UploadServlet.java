package org.tj.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        //上传文件的保存目录。放到WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        
        File file = new File(savePath);
        if(!file.exists()||!file.isDirectory()){
            System.out.println(savePath+"目录不存在,需要创建");
            //创建目录
            file.mkdir();
        }
        //用来保存上传结果信息
        String message = "";
        //使用apache的文件上传组件进行上传文档
        //1.创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setProgressListener(new ProgressListener(){
        	   public void update(long pBytesRead, long pContentLength, int arg2) {
        	        System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead + "百分比：" + (pBytesRead/pContentLength)*100 +"%");
        	      }
        	 });

        //解决乱码问题
        upload.setHeaderEncoding("UTF-8");
      //3.判断提交上来的数据是否属于上传表单数据
        if(!ServletFileUpload.isMultipartContent(request)){
            //在这里不做处理了，这表示是按传统方式提交的，就按我们以前的方式解析就行
            return;
        }
      //4.使用ServletFileUpload解析器解析上传数据返回一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                //判断fileitem中是否封装的是普通输入项的数据
                if(fileItem.isFormField()){
                    //获得名字
                    String name = fileItem.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = fileItem.getString("UTF-8");
                    System.out.println("name:"+name+",value:"+value);
                }else{
                    //表示fileItem中封装的是上传文件
                    //得到上传文件的名字
                    String fileName = fileItem.getName();
                    System.out.println("上传文件的名字："+fileName);
                    //名字无效，不进行出来，表示可能该<input type ="file" />没有上传
                    if(fileName==null || "".equals(fileName.trim())){
                        continue;
                    }
                    
                    //这里需要留意一下：不同的浏览器提交的文件名可能是不一致的，有些会带上路径名，有些则是只有文件名称，我们需要截取
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                    //获取该fileItem的输入流
                    InputStream in = fileItem.getInputStream();
                    FileOutputStream out = new FileOutputStream(savePath+File.separatorChar+fileName);
                    //以下代码为文件拷贝
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    
                    while((len = in.read(buffer))!=-1){
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    //文件拷贝结束
                    //删除处理文件上传时产生的临时文件
                    fileItem.delete();
                    message="文件上传成功！";
                }
            }
        } catch (FileUploadException e) {
            message="文件上传失败";
            e.printStackTrace();
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);

        
        
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
