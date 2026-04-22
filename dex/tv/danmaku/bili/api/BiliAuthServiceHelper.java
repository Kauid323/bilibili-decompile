package tv.danmaku.bili.api;

import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import tv.danmaku.bili.api.bean.ApplyStatusBean;
import tv.danmaku.bili.api.bean.AuthConfBean;
import tv.danmaku.bili.api.bean.AuthContentCheckBean;
import tv.danmaku.bili.api.bean.CaptchaGeeBean;
import tv.danmaku.bili.api.bean.CardPictureBean;
import tv.danmaku.bili.api.bean.CardTypeBean;
import tv.danmaku.bili.api.bean.ChangeRealnamePersonBean;
import tv.danmaku.bili.api.bean.ChannelBean;
import tv.danmaku.bili.api.bean.CheckIDCradBean;
import tv.danmaku.bili.api.bean.ConfirmGeeBean;
import tv.danmaku.bili.api.bean.ConfirmZhiMaBean;
import tv.danmaku.bili.api.bean.ModifyAllowBean;
import tv.danmaku.bili.api.bean.ModifyStatusBean;
import tv.danmaku.bili.api.bean.OverrideSummary;
import tv.danmaku.bili.api.bean.TelInfoBean;
import tv.danmaku.bili.api.bean.ZhiMaAuthBizBean;

public class BiliAuthServiceHelper {
    private BiliAuthApiService mBiliAuthApiService;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class SingleInstanceHolder {
        public static BiliAuthServiceHelper sBiliAuthServiceHelper = new BiliAuthServiceHelper();

        private SingleInstanceHolder() {
        }
    }

    private BiliAuthServiceHelper() {
        if (this.mBiliAuthApiService == null) {
            this.mBiliAuthApiService = (BiliAuthApiService) ServiceGenerator.createService(BiliAuthApiService.class);
        }
    }

    public static BiliAuthServiceHelper getBiliPassportServiceHelper() {
        return SingleInstanceHolder.sBiliAuthServiceHelper;
    }

    public void getAuthConf(String tempCode, BiliApiDataCallback<AuthConfBean> cb) {
        this.mBiliAuthApiService.getAuthConf(tempCode).enqueue(cb);
    }

    public void getAuthApplyStatus(String accessKey, String tempCode, BiliApiDataCallback<ApplyStatusBean> cb) {
        this.mBiliAuthApiService.getAuthApplyStatus(accessKey, tempCode).enqueue(cb);
    }

    public void getOverrideSummary(String requestId, String overrideMid, BiliApiDataCallback<OverrideSummary> cb) {
        this.mBiliAuthApiService.getOverrideSummary(requestId, overrideMid).enqueue(cb);
    }

    public void overrideRealName(String requestId, String overrideMid, BiliApiDataCallback<Void> cb) {
        this.mBiliAuthApiService.overrideRealName(requestId, overrideMid).enqueue(cb);
    }

    public void contentCheck(String content, BiliApiDataCallback<AuthContentCheckBean> cb) {
        this.mBiliAuthApiService.contentCheck(content, "realname").enqueue(cb);
    }

    public void getTelInfo(String accessKey, BiliApiDataCallback<TelInfoBean> cb) {
        this.mBiliAuthApiService.getTelInfo(accessKey).enqueue(cb);
    }

    public void getAuthChannel(String accessKey, BiliApiDataCallback<List<ChannelBean>> cb) {
        this.mBiliAuthApiService.getAuthChannel(accessKey).enqueue(cb);
    }

    public void uploadAuthFile(String accessKey, RequestBody file, BiliApiDataCallback<CardPictureBean> cb) {
        this.mBiliAuthApiService.uploadAuthFile(accessKey, file).enqueue(cb);
    }

    public void captureGet(String accessToken, BiliApiDataCallback<Void> cb) {
        this.mBiliAuthApiService.captureGet(accessToken).enqueue(cb);
    }

    public void applyAuth(String accessToken, String realName, String cardNumber, String capture, String imgToken, BiliApiDataCallback<ZhiMaAuthBizBean> cb) {
        this.mBiliAuthApiService.applyAuth(accessToken, realName, cardNumber, capture, imgToken).enqueue(cb);
    }

    public void confirmAliAuth(String accessKey, BiliApiDataCallback<ConfirmZhiMaBean> cb) {
        this.mBiliAuthApiService.confirmAliAuth(accessKey).enqueue(cb);
    }

    public void getGeeCaptcha(String accessToken, BiliApiDataCallback<CaptchaGeeBean> cb) {
        this.mBiliAuthApiService.getGeeCaptcha(accessToken).enqueue(cb);
    }

    public void confirmGeeCaptcha(String accessToken, int remote, Map<String, String> captcha, BiliApiDataCallback<ConfirmGeeBean> cb) {
        this.mBiliAuthApiService.confirmGeeCaptcha(accessToken, remote, captcha).enqueue(cb);
    }

    public void confirmLocalCaptcha(String accessToken, int remote, BiliApiDataCallback<ConfirmGeeBean> cb) {
        this.mBiliAuthApiService.confirmLocalCaptcha(accessToken, remote).enqueue(cb);
    }

    public void checkModifyStatus(int remote, BiliApiDataCallback<ModifyStatusBean> cb) {
        this.mBiliAuthApiService.checkModifyStatus(remote).enqueue(cb);
    }

    public void checkIDCardDigits(String digits, BiliApiDataCallback<CheckIDCradBean> cb) {
        this.mBiliAuthApiService.checkIDCardDigits(digits).enqueue(cb);
    }

    public void changeRealnamePerson(String token_new, String token_old, String reason, String old_img_token_1, String old_img_token_2, String old_img_token_3, String new_img_token_1, String new_img_token_2, String new_img_token_3, String other_img_token_1, String other_img_token_2, String other_img_token_3, BiliApiDataCallback<ChangeRealnamePersonBean> cb) {
        this.mBiliAuthApiService.changeRealnamePerson(token_new, token_old, reason, old_img_token_1, old_img_token_2, old_img_token_3, new_img_token_1, new_img_token_2, new_img_token_3, other_img_token_1, other_img_token_2, other_img_token_3).enqueue(cb);
    }

    public void getModifyAllow(BiliApiDataCallback<ModifyAllowBean> cb) {
        this.mBiliAuthApiService.checkModifyAllow().enqueue(cb);
    }

    public void getCardTypes(String scene, String tmpCode, BiliApiDataCallback<List<CardTypeBean>> cb) {
        this.mBiliAuthApiService.getCardTypes(scene, tmpCode).enqueue(cb);
    }
}