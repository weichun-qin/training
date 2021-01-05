package com.ives.training.aliyun.address;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.address_purification.model.v20191118.ClassifyPOIRequest;
import com.aliyuncs.address_purification.model.v20191118.ClassifyPOIResponse;
import com.aliyuncs.address_purification.model.v20191118.GetAddressDivisionCodeRequest;
import com.aliyuncs.address_purification.model.v20191118.GetAddressDivisionCodeResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/11/16 13:10
 */
@Component
public class AddressPurification {

    public String addressPurification(String address){
        DefaultProfile profile = DefaultProfile.getProfile();
        IAcsClient client = new DefaultAcsClient(profile);
        GetAddressDivisionCodeRequest request = new GetAddressDivisionCodeRequest();
        request.setServiceCode("addrp");
        request.setAppKey("Xcddpigfit8n");
        request.setText(address);
        GetAddressDivisionCodeResponse response = null;
        try {
            response = client.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println(response.getData());
        return response.getData();
    }
}
