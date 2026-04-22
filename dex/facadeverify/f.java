package facadeverify;

import com.dtf.face.network.mpass.biz.model.ZimSMSMobileRequest;
import com.dtf.face.network.mpass.biz.model.ZimSMSMobileResponse;

public interface f {
    @e0("com.zoloz.zhub.zim.sms.send.json")
    ZimSMSMobileResponse a(ZimSMSMobileRequest zimSMSMobileRequest);

    @e0("com.zoloz.zhub.zim.sms.check.json")
    ZimSMSMobileResponse b(ZimSMSMobileRequest zimSMSMobileRequest);
}