package baseverify;

import android.text.TextUtils;
import android.util.Pair;
import baseverify.e;
import com.dtf.face.ToygerConfig;
import com.dtf.face.config.OSSConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.utils.FileUtil;
import com.dtf.face.utils.MiscUtil;
import com.dtf.face.utils.ModelDownloadUtil;
import com.dtf.face.utils.OSSUploadUtils;
import java.io.File;

public class f implements Runnable {
    public final /* synthetic */ Pair a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e.c f11b;

    public f(e.c cVar, Pair pair) {
        this.f11b = cVar;
        this.a = pair;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        try {
            if (((File) this.a.first) != null) {
                byte[] fileToBytes = FileUtil.fileToBytes((File) this.a.first);
                if (fileToBytes != null) {
                    OSSConfig oSSConfig = ToygerConfig.getInstance().getOSSConfig();
                    str = "";
                    if (oSSConfig != null) {
                        OSSUploadUtils.OssInteralCB ossUploadFile = OSSUploadUtils.ossUploadFile(oSSConfig.OssEndPoint, oSSConfig.AccessKeyId, oSSConfig.AccessKeySecret, oSSConfig.SecurityToken, oSSConfig.BucketName, MiscUtil.genOssFileName(oSSConfig.FileNamePrefix, ((File) this.a.first).getName(), ""), fileToBytes);
                        RecordService.getInstance().recordEvent(2, "inValidModelUpload", new String[]{"uploadResult", String.valueOf(ossUploadFile.success), "presignedUrl", ossUploadFile.presignedUrl});
                    } else {
                        RecordService.getInstance().recordEvent(2, "inValidModelUpload", new String[]{"msg", "ossConfig is null"});
                    }
                } else {
                    str = "bytes is null";
                }
            } else {
                str = "file is null";
            }
            if (!TextUtils.isEmpty(str)) {
                RecordService.getInstance().recordEvent(2, "inValidModelUpload", new String[]{"errMsg", str});
            }
        } catch (Throwable th) {
            RecordService.getInstance().recordException(th);
        }
        e.c cVar = this.f11b;
        ModelDownloadUtil.cleanModel(cVar.c, cVar.d);
        cVar.onError("INVALID_FILE", "Null file", null);
    }
}