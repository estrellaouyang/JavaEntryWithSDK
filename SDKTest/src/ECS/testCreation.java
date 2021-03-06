package ECS;

import java.util.UUID;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
//import com.google.gson.JsonParser;

public class testCreation {
    public static void main(String[] args) {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
            "cn-hangzhou",                     // 您的可用区ID
            "****",             // 您的AccessKey ID
            "****");        // 您的AccessKey Secret
        
        IAcsClient client = new DefaultAcsClient(profile);
        // 创建API请求并设置参数
        CreateInstanceRequest request = new CreateInstanceRequest();
        request.setImageId("alinux_17_01_64_20G_cloudinit_20171222.vhd");
        request.setInstanceName("MyEcsInstance");
        //request.setSecurityGroupId("<your-security-group-id>");
        request.setInstanceType("ecs.t1.small");
        request.setClientToken(UUID.randomUUID().toString());
        // 发起请求并处理应答或异常
        CreateInstanceResponse response;
        try {
            response = client.getAcsResponse(request);
            String instanceId = response.getInstanceId();
            System.out.println("Create instance success, instanceId = " + instanceId);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}