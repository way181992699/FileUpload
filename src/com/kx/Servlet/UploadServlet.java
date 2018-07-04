package com.kx.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "Servlet",urlPatterns = "/Upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//通过导入的文件上传jar包 创建实例
        System.out.println("post");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");//解决http报头乱码，即中文文件名乱码
        //通过ServletFileUpload解析请求获取相关数据；
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem file : list) {
                //file.isFormField()表示文件是否是普通文本， 如果是普通文本 返回true；
                if (file.isFormField()) {
                    System.out.println(file.getFieldName());
                } else {

                    String fileName = file.getName();
                    String value =file.getString("UTF-8");//解决表单输入输乱码。
                    System.out.println(fileName);
                    System.out.println(value);
                    File f = new File("F:/"+fileName);
                    file.write(f);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//通过导入的文件上传jar包 创建实例
//        System.out.println("get");
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        //通过ServletFileUpload解析请求获取相关数据；
//        try {
//            List<FileItem> list = upload.parseRequest(request);
//            for (FileItem file : list) {
//                //file.isFormField()表示文件是否是普通文本， 如果是普通文本 返回true；
//                if (file.isFormField()) {
//                    System.out.println(file.getFieldName());
//                }else {
//                    String fileName = file.getName();
//                    File f = new File("c:/" + fileName);
//                    file.write(f);
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    }
}
