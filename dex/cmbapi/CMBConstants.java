package cmbapi;

import com.alipay.sdk.m.l.e;

public class CMBConstants {
    public static String Key_Params_URL = "url";
    public static String Key_Params_Data = e.m;
    public static String Key_Params_ShowNavigation = "showNavigation";
    public static String TAG = "CMBPAYSDK";
    public static String ResponseCode_Cancel_Positive = "8";
    public static String ResponseMsg_Cancel_Positive = "用户主动取消";
    public static String ResponseCode_Net_Error = "9";
    public static String ResponseMsgNet_Error = "网络异常";
    public static int RequestCode_Params_Error = -2;
    public static int RequestCode_Params_Well_Done = 0;
    public static String ResponseMsg_Params_Error_No_Params = "参数异常:参数为空";
    public static String ResponseMsg_Params_Error_No_Context = "参数异常:context为空";
    public static String ResponseMsg_Params_Error_Params_Error = "参数异常:参数错误：";
    public static String REQ_PARAMS = "&cmbpbsdk_version=%s&cmbpbsdk_appid=%s&cmbpbsdk_method=%s&sdk_deviceType=E&";
}