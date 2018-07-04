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
//ͨ��������ļ��ϴ�jar�� ����ʵ��
        System.out.println("post");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");//���http��ͷ���룬�������ļ�������
        //ͨ��ServletFileUpload���������ȡ������ݣ�
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem file : list) {
                //file.isFormField()��ʾ�ļ��Ƿ�����ͨ�ı��� �������ͨ�ı� ����true��
                if (file.isFormField()) {
                    System.out.println(file.getFieldName());
                } else {

                    String fileName = file.getName();
                    String value =file.getString("UTF-8");//��������������롣
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
//ͨ��������ļ��ϴ�jar�� ����ʵ��
//        System.out.println("get");
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        //ͨ��ServletFileUpload���������ȡ������ݣ�
//        try {
//            List<FileItem> list = upload.parseRequest(request);
//            for (FileItem file : list) {
//                //file.isFormField()��ʾ�ļ��Ƿ�����ͨ�ı��� �������ͨ�ı� ����true��
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
