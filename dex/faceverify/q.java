package faceverify;

import android.content.Context;
import android.graphics.PointF;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.ToygerBiometricInfo;
import com.dtf.toyger.base.algorithm.IToygerDelegate;
import com.dtf.toyger.base.algorithm.TGDepthFrame;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.vivo.identifier.IdentifierConstant;
import faceverify.p;
import faceverify.r;
import faceverify.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class q<C extends r, State extends s, Attr extends ToygerAttr, Info extends ToygerBiometricInfo, AlgorithmConfig extends p> implements IToygerDelegate<State, Attr, Info> {
    public static final String ASSET_DOC = "toyger.doc.dat";
    public static final String ASSET_FACE = "toyger.face.dat";
    public static final String ASSET_LICENSE = "toyger.license";
    public static final String ASSET_MOUTH = "toyger.mouth.dat";
    public static final String ASSET_QUALITY = "toyger.quality.dat";
    public static final String KEY_ALGORITHM_CONFIG = "algorithm";
    public static final String KEY_ASYNC_BLOB = "AsyncBlob";
    public static final String KEY_CAMERA_CONFIG = "camera_config";
    public static final String KEY_COLLECT_SIG = "collectInfoSig";
    public static final String KEY_COMPLETE_BLOB = "CompleteBlob";
    public static final String KEY_CONTENT_ATTR = "elementContentAttr";
    public static final String KEY_CONTENT_BITMAP = "elementContentBitmap";
    public static final String KEY_CONTENT_FACE_ATTR = "elementFaceAttr";
    public static final String KEY_CONTENT_MD5 = "elementContentMd5";
    public static final String KEY_CONTENT_SIG = "contentSig";
    public static final String KEY_DOC_FRAME_RECT = "docFrameRect";
    public static final String KEY_ELEMENT_CONTENT = "elementContent";
    public static final String KEY_ENABLE_CAPTURE_CONFIG = "enableCapture";
    public static final String KEY_ENABLE_ENCUP = "enableEncUp";
    public static final String KEY_ENABLE_VIDEO_CAPTURE_CONFIG = "enableVideoCapture";
    public static final String KEY_FACE_AREA = "faceArea";
    public static final String KEY_IFFA_MSG = "IFFAMsg";
    public static final String KEY_IS_MIRROR = "is_mirror";
    public static final String KEY_LOCAL_MATCHING_COMMAND = "LocalMatchingCommand";
    public static final String KEY_META_SERIALIZER = "meta_serializer";
    public static final String KEY_NINE_SHOT_BLOB = "NineShootBlob";
    public static final String KEY_PHOTINUS_CONFIG = "photinus";
    public static final String KEY_PUBLIC_KEY = "pubkey";
    public static final String KEY_RES_9_CONTENT = "content";
    public static final String KEY_RES_9_IS_UTF8 = "isUTF8";
    public static final String KEY_RES_9_KEY = "key";
    public static final String KEY_ROTATE_TIMES = "rotateTimes";
    public static final String KEY_TOKEN = "TOKEN";
    public static final String KEY_UPLOAD_CONFIG = "upload";
    public static final String KEY_USER_ID = "USER_ID";
    public static final String P_TAG_ANDROID = "TOYGER_FLOW_ANDROID";
    public static final String P_TAG_NATIVE = "TOYGER_FLOW_NATIVE";
    public static final String TAG = "TOYGER_FLOW_ANDROID";
    public static final String TAG_NATIVE = "TOYGER_FLOW_NATIVE";
    public C mToygerCallback;

    public static boolean preLoad(Context context) {
        return false;
    }

    public abstract boolean config(Map<String, Object> map);

    public abstract void finishPhotinus();

    public PointF handleAlignDepthPoint(PointF pointF) {
        return this.mToygerCallback.a(pointF);
    }

    public abstract void handleCaptureCompleted(int i2, List<Info> list, Map<String, Object> map);

    public void handleEventTriggered(int i2, String str) {
        HashMap hashMap;
        if (i2 == -16 || i2 == -15) {
            HashMap hashMap2 = new HashMap();
            if (str != null) {
                hashMap2.put("DragonflyLiveness", str);
            } else {
                hashMap2.put("DragonflyLiveness", IdentifierConstant.OAID_STATE_DEFAULT);
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        this.mToygerCallback.a(i2, hashMap);
    }

    public abstract void handleInfoReady(TGFrame tGFrame, Attr attr);

    public abstract void handleLog(int i2, HashMap<String, Object> hashMap);

    public abstract void handleScanCompleted(int i2, List<Info> list, Map<String, Object> map);

    public abstract void handleStateUpdated(State state, Attr attr);

    public abstract boolean init(Context context, C c, String str, String str2, Map<String, Object> map);

    public abstract boolean init(Context context, boolean z, C c);

    public abstract boolean processImage(List<TGFrame> list, TGDepthFrame tGDepthFrame);

    public abstract void release();

    public abstract void reset();

    public abstract void retry(int i2);

    public abstract void setCanCompleteWhenCaptureDone(boolean z);

    public abstract void setCanContinueDetectAction(boolean z);

    public abstract void setCanHandleHighQualityImage(boolean z);

    public abstract void setUiShowAction(int i2);

    public abstract void updateFaceCaptureRegion(String str);
}