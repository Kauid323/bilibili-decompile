package faceverify;

import com.dtf.toyger.base.ToygerBiometricInfo;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.dtf.toyger.base.algorithm.ToygerBlobConfig;
import com.dtf.toyger.base.face.ToygerDepthInfo;
import com.dtf.toyger.base.face.ToygerFaceAttr;
import com.dtf.toyger.base.face.ToygerFaceInfo;
import java.util.List;
import java.util.Map;
import java2jni_do_not_delete_this.java2jni_do_not_delete_this_library_zkfv_1tj;

public abstract class w<Info extends ToygerBiometricInfo> {
    public static final String BLOB_ELEM_IMAGE_HASHCODE = "hash";
    public static final String BLOB_ELEM_IMAGE_RUNTIMEINFO = "runtimeInfo";
    public static final String BLOB_ELEM_IMAGE_TYPE = "ImageType";
    public static final String BLOB_ELEM_SUBTYPE_GYRO = "gyro";
    public static final String BLOB_ELEM_TYPE_DOC = "doc";
    public static final String BLOB_ELEM_TYPE_FACE = "face";
    public static final String BLOB_ELEM_TYPE_SENSOR = "sensor";
    public static final String BLOB_VERSION = "1.0";
    public static final int META_ALGRESULT_BAT = 3;
    public static final int META_ALGRESULT_DRAGONFLY = 2;
    public static final int META_ALGRESULT_VERIFY = 1;
    public static final String META_COLL_KEY_AUTH_INFO = "authInfo";
    public static final String META_COLL_KEY_IMAGE_SIG = "imageSig";
    public static final int META_SERIALIZER_JSON = 1;
    public static final int META_SERIALIZER_PB = 2;
    public static final String META_TYPE_DOC = "zdoc";
    public static final String META_TYPE_FACE = "zface";
    public static final String SUB_TYPE_DARK = "Dark";
    public static final String SUB_TYPE_DEPTH = "Depth";
    public static final String SUB_TYPE_DOC_IMAGE = "docimage";
    public static final String SUB_TYPE_IR = "SLIR";
    public static final String SUB_TYPE_NANO = "Nano";
    public static final String SUB_TYPE_PANO = "Pano";
    public static final String SUB_TYPE_SURVEILLANCE = "Surveillance";
    public static final String SUB_TYPE_VERSION = "1.0";
    public static final String TAG = "TOYGER_FLOW_BlobManager";
    public ToygerBlobConfig config;
    public y crypto;

    static {
        java2jni_do_not_delete_this_library_zkfv_1tj.loadLibrary();
    }

    public abstract byte[] generateBlob(List<Info> list, Map<String, Object> map);

    public abstract byte[] getKey();

    public abstract boolean isUTF8();

    public native byte[] processDepthInfo(ToygerDepthInfo toygerDepthInfo);

    public native byte[] processFrame(ToygerFaceInfo toygerFaceInfo, ToygerFaceAttr toygerFaceAttr, int i2, int i3, String str, boolean z, Map<String, Object> map);

    public native byte[] processFrame(ToygerFaceInfo toygerFaceInfo, ToygerFaceAttr toygerFaceAttr, String str, boolean z, Map<String, Object> map);

    public native byte[] processFrame(byte[] bArr);

    public byte[] processIRFrameInfo(TGFrame tGFrame, boolean z) {
        byte[] a;
        byte[] a2;
        int intValue = this.config.getDesiredWidth().intValue();
        int compressRate = (int) (this.config.getCompressRate() * 100.0f);
        if ((tGFrame == null || tGFrame.data == null) || (a = f.a(tGFrame, intValue, compressRate, "jpeg", z)) == null || (a2 = this.crypto.a(a)) == null) {
            return null;
        }
        return a2;
    }

    public native byte[] processSensorData(String str);
}