package faceverify;

import android.net.Uri;
import android.text.TextUtils;
import com.dtf.face.ToygerConfig;
import com.dtf.face.camera.CameraData;
import com.dtf.face.log.RecordService;
import com.dtf.face.photinus.OnVideoWriteListener;
import com.dtf.face.photinus.VideoEncoderHelper;
import com.dtf.face.photinus.VideoFormatConfig;
import com.dtf.face.utils.CameraUtil;
import com.dtf.face.utils.ClientConfigUtil;
import com.dtf.face.utils.FileUtil;
import com.dtf.face.utils.MiscUtil;
import com.dtf.face.utils.ZipUtils;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

public class k implements OnVideoWriteListener, j {
    public j a;
    public CopyOnWriteArrayList<CameraData> b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public int f1952d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f1953e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f1954f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f1955g = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f1956h = -1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1957i = false;

    public k(CopyOnWriteArrayList<CameraData> copyOnWriteArrayList, String str, j jVar) {
        this.a = jVar;
        this.b = copyOnWriteArrayList;
        this.c = str;
    }

    @Override // faceverify.j
    public void a(String str, String str2) {
        this.f1956h = System.currentTimeMillis();
        RecordService recordService = RecordService.getInstance();
        String str3 = this.c;
        String valueOf = String.valueOf(this.f1956h - this.f1955g);
        CopyOnWriteArrayList<CameraData> copyOnWriteArrayList = this.b;
        recordService.recordEvent(4, "VideoMakerSuccess", new String[]{"fileName", str3, "cost", valueOf, "fameCount", copyOnWriteArrayList != null ? String.valueOf(copyOnWriteArrayList.size()) : "0", "rotation", String.valueOf(this.f1952d), "width", String.valueOf(this.f1953e), "height", String.valueOf(this.f1954f), "hasZip", String.valueOf(this.f1957i)});
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(str, str2);
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f1955g > 0) {
                return;
            }
            this.f1955g = System.currentTimeMillis();
            CopyOnWriteArrayList<CameraData> copyOnWriteArrayList = this.b;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
                RecordService.getInstance().recordEvent(4, "VideoMaker", new String[]{"status", "start", "fileName", this.c, ContentDisposition.Parameters.Size, String.valueOf(this.b.size())});
                if ((this.f1952d == -1 || this.f1953e == -1 || this.f1954f == -1) && this.b.size() > 0) {
                    this.f1952d = this.b.get(0).getRotateAngle();
                    this.f1953e = this.b.get(0).getPreviewWidth();
                    this.f1954f = this.b.get(0).getPreviewHeight();
                }
                if (ClientConfigUtil.isVideoExDevice()) {
                    c();
                    return;
                } else {
                    VideoEncoderHelper.encode(ToygerConfig.getInstance().getContext(), CameraUtil.toBufferList(this.b), this.f1952d, this.f1953e, this.f1954f, this.c, VideoFormatConfig.L, this);
                    return;
                }
            }
            RecordService.getInstance().recordEvent(4, "VideoMakerError", new String[]{"errType", "start", "errMsg", "NOData", "fileName", this.c});
            a();
        }
    }

    public final void c() {
        try {
            this.f1957i = true;
            FileUtil.deleteFile(Uri.withAppendedPath(VideoEncoderHelper.getVideoStorePathUri(ToygerConfig.getInstance().getContext()), this.c + ".mp4").getPath());
            String path = Uri.withAppendedPath(VideoEncoderHelper.getVideoStorePathUri(ToygerConfig.getInstance().getContext()), this.c + ".zip").getPath();
            File file = new File(path);
            FileUtil.deleteFile(file);
            ZipUtils.zipFiles(CameraUtil.toBufferList(this.b), file, this.f1953e, this.f1954f, this.f1952d);
            a(path, MiscUtil.getFileMd5(path));
        } catch (Exception e2) {
            RecordService.getInstance().recordEvent(4, "VideoMakerError", new String[]{"errType", "zipVideoFrames", "errMsg", RecordService.getStackTraceString(e2), "fileName", this.c});
            a();
        }
    }

    public void onException(Throwable th) {
        RecordService.getInstance().recordEvent(4, "VideoMakerError", new String[]{"errType", "onException", "errMsg", RecordService.getStackTraceString(th), "fileName", this.c});
    }

    public void onVideoWriteError(String str) {
        RecordService recordService = RecordService.getInstance();
        if (str == null) {
            str = "";
        }
        recordService.recordEvent(4, "VideoMakerError", new String[]{"errType", "onVideoWriteError", "errMsg", str, "fileName", this.c});
        c();
    }

    public void onVideoWriteSuccess(Uri uri) {
        String str;
        if (uri == null || uri.getPath() == null) {
            str = "NoUri";
        } else {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                a(path, MiscUtil.getFileMd5(path));
                return;
            }
            str = "NoPath";
        }
        RecordService.getInstance().recordEvent(4, "VideoMakerError", new String[]{"errType", "onVideoWriteSuccess", "errMsg", str, "fileName", this.c});
        c();
    }

    @Override // faceverify.j
    public void a() {
        this.f1956h = System.currentTimeMillis();
        RecordService.getInstance().recordEvent(4, "VideoMakerFailed", new String[]{"fileName", this.c, "cost", String.valueOf(this.f1956h - this.f1955g), "hasZip", String.valueOf(this.f1957i)});
        j jVar = this.a;
        if (jVar != null) {
            jVar.a();
        }
    }
}