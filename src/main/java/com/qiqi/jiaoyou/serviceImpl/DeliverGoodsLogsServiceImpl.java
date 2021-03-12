package com.qiqi.jiaoyou.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.DeliverGoodsLogsDao;
import com.qiqi.jiaoyou.pojo.DeliverGoodsLogs;
import com.qiqi.jiaoyou.pojo.OrderManage;
import com.qiqi.jiaoyou.service.DeliverGoodsLogsService;
import com.qiqi.jiaoyou.service.ExpressCodeService;
import com.qiqi.jiaoyou.service.OrderManageService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * 发货记录表(DeliverGoodsLogs)表服务实现类
 * @author nan
 * @since 2020-12-08 13:59:42
 */


@Service("deliverGoodsLogsService")
public class DeliverGoodsLogsServiceImpl extends ServiceImpl<DeliverGoodsLogsDao, DeliverGoodsLogs> implements DeliverGoodsLogsService {


    @Autowired
    private ExpressCodeService expressCodeService;
    @Autowired
    private OrderManageService orderManageService;
    @Override
    @Transactional
    public ResultUtils add(DeliverGoodsLogs deliverGoodsLogs) {
        /*因为是寄件的信息，所以需要在这里进行寄件，寄件操作成功之后，才会进行插入和继续操作，否则不进行*/

        ResultUtils resultUtils = new ResultUtils();
        String deliverCom = "";

        if(deliverGoodsLogs.getExpressType().equals(null) || deliverGoodsLogs.getExpressType().equals("")){
            resultUtils.setCode(400);
            resultUtils.setMessage("快递类型不能是空");
            return  resultUtils;
        }
//        else{
//          deliverCom =  expressCodeService.findCodeByName(deliverGoodsLogs.getExpressType());
//          if(deliverCom == "" || deliverCom == null){
//              resultUtils.setCode(400);
//              resultUtils.setMessage("快递类型查询失败，请检查重试！");
//          }
//        }

        //先进对接快递发货接口,订单表数据更新，在进行发货记录插入

        //将发货的信息放到订单信息里面
        //设置操作的信息标识，只有这个为true才算是完成
        Boolean updateInfo = true;

        Map<String, String> params = new HashMap<String, String>();
        params.put("secret_key", "9pz53gtiVBTcmgzyUZ");
        params.put("secret_code", "ddffadd3df4b4c0d8d6f9942c7a8c990");
        params.put("secret_sign", MD5Utils.encode("9pz53gtiVBTcmgzyUZc531ab41c583457b953608bf8fce1908").toUpperCase());
        params.put("com", deliverGoodsLogs.getExpressType());
        params.put("recManName", deliverGoodsLogs.getReceiveUserName());
        params.put("recManMobile", deliverGoodsLogs.getReceiveUserPhone());
        params.put("recManPrintAddr", deliverGoodsLogs.getReceiveUserLocation());
        params.put("sendManName", deliverGoodsLogs.getSendUserName());
        params.put("sendManMobile", deliverGoodsLogs.getSendUserPhone());
        params.put("sendManPrintAddr", deliverGoodsLogs.getSendUserLocation());
        params.put("cargo", deliverGoodsLogs.getGoodsName());
        params.put("weight", deliverGoodsLogs.getExpressWeight());
        params.put("remark", deliverGoodsLogs.getRemark());
        params.put("salt", "");
        params.put("callBackUrl", "http://152.136.139.71:6999/deliverLogs/orderBackUrl");
        if(deliverGoodsLogs.getPayType().equals("寄付")){
            params.put("payment","SHIPPER");
        }
        if(deliverGoodsLogs.getPayType().equals("到付")){
            params.put("payment", "CONSIGNEE");
        }

        params.put("dayType", "");
        params.put("pickupStartTime", "");
        params.put("pickupEndTime", "");
        String returnValue = post(params);
        JSONObject jsonObject = JSONObject.parseObject(returnValue);
        JSONObject jsonObject1 = null;
//        System.out.println(jsonObject);
        if(!jsonObject.getString("code").equals("200")){
            resultUtils.setCode(400);
            resultUtils.setMessage(jsonObject.getString("message"));
            updateInfo = false;
            return  resultUtils;
        }
        jsonObject1 = JSONObject.parseObject(jsonObject.getString("data"));
        System.out.println(jsonObject1.getString("orderId"));
        if(jsonObject1.getString("orderId") == ""){
            resultUtils.setCode(400);
            resultUtils.setMessage("订单id为空，请重试！");
            return resultUtils;
        }
//更新订单记录信息表
        DeliverGoodsLogs serverInfoType1 = new DeliverGoodsLogs();
        serverInfoType1.setCreateTime(new Date());
        serverInfoType1.setSendUserId(deliverGoodsLogs.getSendUserId());
        serverInfoType1.setOrderId(deliverGoodsLogs.getOrderId());
        serverInfoType1.setReceiveUserName(deliverGoodsLogs.getReceiveUserName());
        serverInfoType1.setReceiveUserPhone(deliverGoodsLogs.getReceiveUserPhone());
        serverInfoType1.setReceiveUserLocation(deliverGoodsLogs.getReceiveUserLocation());
        serverInfoType1.setSendUserName(deliverGoodsLogs.getSendUserName());
        serverInfoType1.setSendUserPhone(deliverGoodsLogs.getSendUserPhone());
        serverInfoType1.setSendUserLocation(deliverGoodsLogs.getSendUserLocation());

        serverInfoType1.setExpressType(deliverGoodsLogs.getExpressType());
        serverInfoType1.setExpressWeight(deliverGoodsLogs.getExpressWeight());
        serverInfoType1.setGoodsName(deliverGoodsLogs.getGoodsName());
        serverInfoType1.setPayType(deliverGoodsLogs.getPayType());
        serverInfoType1.setRemark(deliverGoodsLogs.getRemark());

        Integer i = baseMapper.insert(serverInfoType1);
        if (i > 0) {
            resultUtils.setStatus(200);
            resultUtils.setMessage("添加成功");
            updateInfo = true;
        } else {
            resultUtils.setStatus(200);
            resultUtils.setMessage("添加失败");
            updateInfo = false;
        }


        /*这里更新订单表里的某个订单的详细信息*/
        OrderManage orderManage = new OrderManage();
        orderManage.setId(deliverGoodsLogs.getOrderId());
        /*订单状态（1：待支付，2：待收货，3：已完成，4：已取消,5：已发货，6：未发货）*/
        orderManage.setOrderStatus("5");
        orderManage.setExpressCode(deliverGoodsLogs.getExpressType());
        orderManage.setExpressFrom(deliverGoodsLogs.getSendUserLocation());
        orderManage.setExpressTo(deliverGoodsLogs.getReceiveUserLocation());
        orderManage.setOrderId(jsonObject1.getString("orderId"));
        Boolean bollean = orderManageService.updateInfo(orderManage);
        if(bollean)
        {   updateInfo = true; }
        else{
            updateInfo = false;
        }

        if(updateInfo){
            resultUtils.setCode(200);
            resultUtils.setMessage("快递信息预约成功,请等待快递员联系取件！");
        }else{
            resultUtils.setCode(400);
            resultUtils.setMessage("快递发货预约失败");
        }
        return resultUtils;
    }


    /*发送信息到快递100的接口*/
    public String post(Map<String, String> params) {
        StringBuilder response = new StringBuilder("");
        BufferedReader reader = null;
        try {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, String> param : params.entrySet()) {
                if (builder.length() > 0) {
                    builder.append('&');
                }
                builder.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                builder.append('=');
                builder.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] bytes = builder.toString().getBytes("UTF-8");
            URL url = new URL("http://cloud.kuaidi100.com/api");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(bytes);
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response.toString();
    }
    /*设置MD5工具类，生成MD5编码*/
    static class MD5Utils {

        private static MessageDigest mdigest = null;

        private static char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        private static MessageDigest getMdInst() {

            if (null == mdigest) {

                try {

                    mdigest = MessageDigest.getInstance("MD5");

                } catch (NoSuchAlgorithmException e) {

                    e.printStackTrace();

                }

            }

            return mdigest;

        }

        public static String encode(String s) {

            if (null == s) {

                return "";

            }

            try {

                byte[] bytes = s.getBytes();

                getMdInst().update(bytes);

                byte[] md = getMdInst().digest();

                int j = md.length;

                char str[] = new char[j * 2];

                int k = 0;

                for (int i = 0; i < j; i++) {

                    byte byte0 = md[i];

                    str[k++] = digits[byte0 >>> 4 & 0xf];

                    str[k++] = digits[byte0 & 0xf];

                }

                return new String(str);

            } catch (Exception e) {

                e.printStackTrace();

                return null;

            }

        }
    }
}