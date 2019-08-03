package com.fh.shop.util.uploadUtil;


import com.fh.shop.util.dataUtil.Date2Str;
import com.fh.shop.util.macro.Macro;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class UploadImg {
    /*图片上传*/
   /* public static String uploadImage(MultipartFile file, HttpServletRequest request){
        //获得原始文件名
        String filename = file.getOriginalFilename();
        String newFileName =  UUID.randomUUID().toString().replaceAll("\\-","")+ filename.substring(filename.lastIndexOf("."));
//       UUID.randomUUID()局唯一标识符,是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的，
        String path = request.getServletContext().getRealPath(Macro.IMAGE);
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        if (!file.isEmpty()){
            try{
                FileOutputStream fos = new FileOutputStream(path+newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while((b = in.read())!=-1){
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Macro.IMAGE + newFileName;
    }*/
    
    /*图片上传到OSS服务器*/
   // public static String uploadImage(InputStream in, String fileName){
      /*  OSS ossClient = null;
        String fileNewName = null;
        try {
            *//*处理文件名,获取文件后缀*//*
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
            *//*获取当前日期,作为文件夹使用*//*
            String floder = Date2Str.date2Str(new Date(), Date2Str.Y_M_D);
            *//*以UUID作为文件名,解决文件名重复,文件会覆盖的问题,加上后缀*//*
            fileNewName = floder + "/" + UUID.randomUUID().toString() + fileSuffix;
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(Macro.OSS_URL, Macro.OSS_ACCESSKEYID, Macro.OSS_ACCESSKEYSECRET);
            // 上传文件。第一个参数为Bucket名字,新文件名,文件输出流;
            ossClient.putObject(Macro.OSS_filesName, fileNewName,in);
        } finally {
            if(null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(null != ossClient){
            // 关闭OSSClient。
            ossClient.shutdown();
            }
        }
        return Macro.OSS_BUCKET_URL + fileNewName;
    }*/

    /*删除OSS上单个图片*/
    //public static void deleteImage(String fileName){
       /* OSS ossClient = null;
        try {
            String replace = fileName.replace("https://lzgly.oss-cn-beijing.aliyuncs.com/", "");
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(Macro.OSS_URL, Macro.OSS_ACCESSKEYID, Macro.OSS_ACCESSKEYSECRET);
            // 删除文件。
            try {
                ossClient.deleteObject(Macro.OSS_filesName, replace);
            } catch (OSSException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (ClientException e) {
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally{
            if(null != ossClient){
                // 关闭OSSClient。
                ossClient.shutdown();
            }
        }*/
  //  }
    
}
