package ECS;

import java.io.File;
import java.util.UUID;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
//import com.google.gson.JsonParser;

public class OSS  {
    public static void main(String[] args) {
    	String endpoint = "http://oss-cn-hongkong.aliyuncs.com";
    	String accessKeyId = "****";
    	String accessKeySecret = "****";
    	String bucketName = "qianqianram";
    	String objectName = "TT";
    	
    	// 创建OSSClient实例。
    	OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    	// 创建存储空间。
    	ossClient.createBucket(bucketName);
    	//上传本地文件
    	ossClient.putObject(bucketName, objectName, new File("/Users/miemie/Downloads/aaaaa.png"));
        //下载文件到本地
    	ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File("/Users/miemie/Downloads/SDKTestA.png"));    	
    	
    	// 关闭OSSClient。
    	ossClient.shutdown();
    	
       }
}





