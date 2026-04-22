package facadeverify;

import com.dtf.face.network.mpass.biz.model.ZimInitGwRequest;
import com.dtf.face.network.mpass.biz.model.ZimInitGwResponse;
import com.dtf.face.network.mpass.biz.model.ZimOcrMobileRequest;
import com.dtf.face.network.mpass.biz.model.ZimOcrMobileResponse;
import com.dtf.face.network.mpass.biz.model.ZimSMSMobileRequest;
import com.dtf.face.network.mpass.biz.model.ZimSMSMobileResponse;
import com.dtf.face.network.mpass.biz.model.ZimValidateGwResponse;
import com.dtf.face.network.mpass.biz.model.ZimValidateJsonGwRequest;
import com.dtf.face.network.mpass.biz.rpc.FaceVerifyRpcService;
import java.util.List;

public class k extends FaceVerifyRpcService {
    public h a = new h();

    public ZimSMSMobileResponse checkSMSCode(ZimSMSMobileRequest zimSMSMobileRequest) {
        return ((f) this.a.a.a(f.class)).b(zimSMSMobileRequest);
    }

    public ZimInitGwResponse faceVerifyInit(ZimInitGwRequest zimInitGwRequest) {
        return ((e) this.a.a.a(e.class)).a(zimInitGwRequest);
    }

    public ZimValidateGwResponse faceVerifyValidate(ZimValidateJsonGwRequest zimValidateJsonGwRequest) {
        return ((e) this.a.a.a(e.class)).a(zimValidateJsonGwRequest);
    }

    public String getCurrentUrl() {
        return this.a.b;
    }

    public ZimOcrMobileResponse ocrIdentify(ZimOcrMobileRequest zimOcrMobileRequest) {
        return ((e) this.a.a.a(e.class)).a(zimOcrMobileRequest);
    }

    public ZimSMSMobileResponse sendSMSCode(ZimSMSMobileRequest zimSMSMobileRequest) {
        return ((f) this.a.a.a(f.class)).a(zimSMSMobileRequest);
    }

    public void setRemoteUrl(String str) {
        super.setRemoteUrl(str);
        this.a.b = str;
    }

    public void setUrls(List<String> list) {
        this.a.c = list;
    }
}