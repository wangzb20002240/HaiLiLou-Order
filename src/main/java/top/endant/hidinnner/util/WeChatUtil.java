package top.endant.hidinnner.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;

public class WeChatUtil {

    public static JSONObject getSessionKeyOrOpenId(String code) {
        //微信小程序官方接口
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //接口所需参数
        HashMap<String, Object> requestUrlParam = new HashMap<>();
        //TODO:小程序appId
        requestUrlParam.put("appid", "wx5107eed22ef8e616");
        //TODO:小程序secret
        requestUrlParam.put("secret", "512855118dc3667a708db1a83060ea17");
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数，固定写死即可
        requestUrlParam.put("grant_type", "authorization_code");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        String result = HttpUtil.get(requestUrl, requestUrlParam);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        String openid = jsonObject.get("openid", String.class);
        System.out.println("当前登录用户的id为:" + openid);
        System.out.println(code);
        return jsonObject;
    }

    public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) throws Exception {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + 1;
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, StandardCharsets.UTF_8);
                return JSONUtil.parseObj(result);
            }
        } catch (Exception e) {
            System.out.println("微信的锅");
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String code = "071VzFFa1OwymE0zrYHa1OihL72VzFFW";
        JSONObject jsonObject = WeChatUtil.getSessionKeyOrOpenId(code);
        String encryptedData = "kkY6US0WU7+7MzWj9NFdqBiUB/qqN++GcKP7y1FFINy7HFnXxal2cKdDApGGf94DirBB41aLmBG7dJpUupdCdXFb4LrmbLhth+Qp/UPNVLe9VUb2CaR/ymSV8+4Pj3fU1mZ/bBvxaSoHqNLlD5cvQUUMrZEOwIsJslP8uagz3VLT30mYxVBIWHVu3/tWQoo5AR32z587jmZcRNOIycUgeWc7MJUo9awtaT9Y9OhxE/EBwt/fqIDAArAN3UHN/2VqLU0IYe8MWc6FhvVRnAs2VlYMLzMNnFh1fW24XEHPmGzIKmCDW3DjXEgevYQdZLtp946qYxkYG/zLexWBApIGzsw7awAjVwnXDL4T8X3Gis6lPOvlnPzeetFKm+05W4aD116XO+UREXkSEv1EA8roxMX6wQrEXjkrKl0ojgtBMbXYyqeuG7A3GF1uGBIyU4675P+S7bIr2T/XQza3Qxcg/A==";
        String sessionKey = jsonObject.get("session_key", String.class);
        String iv = "jcsZhKop13HKZb1ynOvvww==";
        JSONObject userInfo = WeChatUtil.getUserInfo(encryptedData, sessionKey, iv);
        //0:未设置；1：男；2：女
        System.out.println(userInfo.get("gender"));
        //昵称
        System.out.println(userInfo.get("nickName"));
        System.out.println(userInfo);
        //o_Sg26q4l4IAeE34g1qVhN2p3xtw
    }
}
