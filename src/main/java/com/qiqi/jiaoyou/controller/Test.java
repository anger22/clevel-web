package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.constants.PathParam;
import com.qiqi.jiaoyou.pojo.Agreement;
import com.qiqi.jiaoyou.util.JsonUtils;

public class Test {

    public static void main(String[] args) {
        String string = "{\"untitled\":1,\"aboutUS\":null,\"registrationAgreement\":null,\"memberDescription\":null,\"sharingRules\":null,\"greenCard\":\"<p style=\\\"text-align: center;\\\"><img src=\\\"http://app.hcsjapp.com/upload/2020-08-22/20200822145726906.png\\\" alt=\\\"\\\" width=\\\"397\\\" height=\\\"319\\\" /></p>\\n<p style=\\\"text-align: center;\\\">VVIP 24小时私人管家</p>\\n<p style=\\\"text-align: center;\\\">1V1专属服务</p>\\n<p style=\\\"text-align: center;\\\"><img src=\\\"http://app.hcsjapp.com/upload/2020-08-22/20200822145741379.png\\\" alt=\\\"\\\" width=\\\"123\\\" height=\\\"176\\\" /></p>\\n<p style=\\\"text-align: center;\\\">4个月会员权限</p>\\n<p style=\\\"text-align: center;\\\"><img src=\\\"http://app.hcsjapp.com/upload/2020-08-22/20200822145754127.png\\\" alt=\\\"\\\" width=\\\"273\\\" height=\\\"198\\\" /></p>\\n<p style=\\\"text-align: center;\\\">增送38888金钻</p>\\n<p style=\\\"text-align: center;\\\">&nbsp;</p>\",\"editTime\":null,\"privacy\":null}";
        Agreement agreement = JsonUtils.jsonToPojo(string, Agreement.class);
        System.out.println(agreement.toString());

    }
}
