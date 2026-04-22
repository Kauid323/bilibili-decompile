package facadeverify;

import com.dtf.face.network.mpass.biz.model.ZimInitGwRequest;
import com.dtf.face.network.mpass.biz.model.ZimInitGwResponse;
import com.dtf.face.network.mpass.biz.model.ZimOcrMobileRequest;
import com.dtf.face.network.mpass.biz.model.ZimOcrMobileResponse;
import com.dtf.face.network.mpass.biz.model.ZimValidateGwResponse;
import com.dtf.face.network.mpass.biz.model.ZimValidateJsonGwRequest;

public interface e {
    @e0("com.zoloz.zhub.zim.init.json")
    ZimInitGwResponse a(ZimInitGwRequest zimInitGwRequest);

    @e0("com.zoloz.zhub.zim.ocr.json")
    ZimOcrMobileResponse a(ZimOcrMobileRequest zimOcrMobileRequest);

    @e0("com.zoloz.zhub.zim.verify.json")
    ZimValidateGwResponse a(ZimValidateJsonGwRequest zimValidateJsonGwRequest);
}