package baseverify;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bilibili.upper.BR;
import com.dtf.face.camera.CameraConstants;
import com.dtf.face.camera.CameraData;
import com.dtf.face.camera.CameraParams;
import com.dtf.face.camera.ICameraCallback;
import com.dtf.face.camera.ICameraInterface;
import com.dtf.face.camera.ICameraTakePicture;
import com.dtf.face.camera.utils.DisplayUtil;
import com.dtf.face.config.DeviceSetting;
import com.dtf.face.log.RecordService;
import com.dtf.face.security.SecurityExt;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class a implements ICameraInterface {
    public static a x;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f4b;
    public Camera c;
    public Camera.Parameters d;
    public ICameraCallback e;
    public int g;
    public int j;
    public Camera.CameraInfo k;
    public boolean q;
    public boolean r;
    public boolean s;
    public int f = 90;
    public boolean h = true;
    public DeviceSetting i = new DeviceSetting();
    public final Object l = new Object();
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public boolean t = false;
    public int u = 0;
    public long v = 0;
    public boolean w = false;

    /* renamed from: baseverify.a$a  reason: collision with other inner class name */
    /* loaded from: /data/np/file-convert/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f.dex */
    public class C0008a implements Camera.PreviewCallback {
        public C0008a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr != null) {
                a aVar = a.this;
                if (aVar.e != null) {
                    aVar.u++;
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    a aVar2 = a.this;
                    CameraData cameraData = new CameraData(wrap, aVar2.m, aVar2.n, 0, (ByteBuffer) null, 0, 0, aVar2.o, aVar2.p);
                    cameraData.setRotateAngle(a.this.f);
                    a.this.e.onPreviewFrame(cameraData);
                    SecurityExt.lp(-824112624, (String) null);
                    return;
                }
            }
            String str = bArr == null ? "data is null" : "";
            if (a.this.e == null) {
                str = str + "mCameraCallback is null";
            }
            RecordService.getInstance().recordEvent(2, "cameraPreviewEx", new String[]{"msg", str});
        }
    }

    /* loaded from: /data/np/file-convert/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f.dex */
    public class b implements Camera.PictureCallback {
        public final /* synthetic */ ICameraTakePicture a;

        public b(ICameraTakePicture iCameraTakePicture) {
            this.a = iCameraTakePicture;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            try {
                SecurityExt.lp(-824112622, (String) null);
                if (bArr != null) {
                    a aVar = a.this;
                    int a = a.this.a(a.this.i);
                    aVar.f = a;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (a.this.w && decodeByteArray.getWidth() > a.this.o) {
                        SecurityExt.lp(-824112621, (String) null);
                        int width = decodeByteArray.getWidth();
                        int height = decodeByteArray.getHeight();
                        float f = a.this.o / width;
                        Matrix matrix = new Matrix();
                        matrix.postScale(f, f);
                        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, width, height, matrix, true);
                        if (createBitmap != decodeByteArray) {
                            decodeByteArray.recycle();
                        }
                        decodeByteArray = createBitmap;
                    }
                    if (decodeByteArray != null) {
                        Matrix matrix2 = new Matrix();
                        matrix2.setRotate(a);
                        Bitmap createBitmap2 = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix2, false);
                        if (createBitmap2 != decodeByteArray) {
                            decodeByteArray.recycle();
                        }
                        if (this.a != null) {
                            this.a.onTakenPicture(createBitmap2);
                        }
                    }
                    a.this.c.startPreview();
                    return;
                }
                throw new Exception("taken photo exception, image data null");
            } catch (Exception e) {
                RecordService.getInstance().recordException(e);
                ICameraTakePicture iCameraTakePicture = this.a;
                if (iCameraTakePicture != null) {
                    iCameraTakePicture.onTakenPicture((Bitmap) null);
                }
            }
        }
    }

    public a() {
        this.q = false;
        this.r = false;
        this.s = false;
        this.q = false;
        this.r = false;
        this.s = false;
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (x == null) {
                x = new a();
            }
            aVar = x;
        }
        return aVar;
    }

    public final boolean a(int i) {
        try {
            this.c = Camera.open(i);
            if (this.c == null) {
                if (this.e != null) {
                    this.e.onError((int) BR.clickable, new Throwable("mCamera == null"));
                }
                return false;
            }
            this.g = i;
            this.d = this.c.getParameters();
            a();
            this.c.setParameters(this.d);
            return true;
        } catch (Exception e) {
            ICameraCallback iCameraCallback = this.e;
            if (iCameraCallback != null) {
                iCameraCallback.onError((int) BR.clickable, e);
            }
            return false;
        } catch (Throwable th) {
            ICameraCallback iCameraCallback2 = this.e;
            if (iCameraCallback2 != null) {
                iCameraCallback2.onError((int) BR.clickable, th);
            }
            return false;
        }
    }

    public boolean beautifyAvatar(Bitmap bitmap) {
        return true;
    }

    public void closeCamera() {
        if (this.q) {
            this.q = false;
        }
    }

    public PointF colorToDepth(PointF pointF) {
        return null;
    }

    public PointF depthToColor(PointF pointF) {
        return null;
    }

    public Camera getCamera() {
        return this.c;
    }

    public CameraParams getCameraParams() {
        return null;
    }

    public int getCameraPictureAngle() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.g, cameraInfo);
        return cameraInfo.orientation;
    }

    public int getCameraRotation() {
        return a(this.i);
    }

    public String getCameraSN() {
        return null;
    }

    public int getCameraViewRotation() {
        return this.f;
    }

    public int getColorHeight() {
        return this.n;
    }

    public int getColorMode() {
        return 0;
    }

    public int getColorWidth() {
        return this.m;
    }

    public int getDepthHeight() {
        return 0;
    }

    public int getDepthWidth() {
        return 0;
    }

    public String getFirmwareVersion() {
        return null;
    }

    public int getPreviewHeight() {
        return this.p;
    }

    public int getPreviewWidth() {
        return this.o;
    }

    public Rect getROI() {
        return null;
    }

    public Object getUVCCamera() {
        return null;
    }

    public void initCamera(Context context, boolean z, boolean z2, DeviceSetting deviceSetting) {
        if (context != null) {
            if (context instanceof Activity) {
                this.f4b = (Activity) context;
            }
            context = context.getApplicationContext();
        }
        this.h = z;
        this.t = z2;
        if (deviceSetting != null) {
            this.i = deviceSetting;
        }
        if (!z) {
            this.f = BR.hasPlayedVideo;
            DeviceSetting deviceSetting2 = this.i;
            if (deviceSetting2 != null && this.r) {
                this.f = a(deviceSetting2);
            }
        }
        this.a = context;
    }

    public boolean isMirror() {
        return false;
    }

    public void lockCameraWhiteBalanceAndExposure() {
        synchronized (this.l) {
            if (this.c != null) {
                try {
                    Camera.Parameters parameters = this.c.getParameters();
                    parameters.setAutoExposureLock(true);
                    parameters.setAutoWhiteBalanceLock(true);
                    this.c.setParameters(parameters);
                } catch (Throwable th) {
                }
            }
        }
    }

    public void openCamera(DeviceSetting deviceSetting) {
        if (this.q) {
            return;
        }
        if (deviceSetting != null) {
            this.i = deviceSetting;
        }
        this.q = true;
    }

    public void releaseCamera() {
        this.f4b = null;
    }

    public void setCallback(ICameraCallback iCameraCallback) {
        this.e = iCameraCallback;
    }

    public boolean setDrawCapturing(boolean z) {
        return false;
    }

    public void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
    }

    public void setGLSurfaceViewListener(baseverify.b bVar) {
    }

    public void setRenderLayers(Map<String, Object> map) {
    }

    public void setTakeAsPreviewSize(boolean z) {
        this.w = z;
    }

    public void startCamera() {
        synchronized (this.l) {
            if (this.r) {
                return;
            }
            int i = 0;
            int a = c.a(0);
            if (a != -1) {
                i = a;
            }
            if (this.h && (i = c.a(1)) == -1) {
                i = 1;
            }
            if (a(i)) {
                this.r = true;
            }
        }
    }

    public void startFpsCheck() {
    }

    public void startPreview(SurfaceHolder surfaceHolder, float f, int i, int i2) {
        synchronized (this.l) {
            if (this.s) {
                return;
            }
            if (this.c != null) {
                if (surfaceHolder != null) {
                    try {
                        this.c.setPreviewDisplay(surfaceHolder);
                    } catch (Exception e) {
                        if (this.e != null) {
                            this.e.onError((int) BR.clickable, e);
                        }
                        return;
                    }
                }
                this.c.setPreviewCallback(new C0008a());
                this.u = 0;
                this.v = System.currentTimeMillis();
                this.c.startPreview();
                this.s = true;
            } else {
                RecordService.getInstance().recordEvent(2, "cameraPreviewEx", new String[]{"msg", "camera is null"});
            }
        }
    }

    public void stopCamera() {
        stopPreview();
        synchronized (this.l) {
            if (this.r) {
                this.e = null;
                if (this.c != null) {
                    try {
                        this.c.release();
                        this.c = null;
                        this.r = false;
                    } catch (Exception e) {
                        RecordService.getInstance().recordException(e);
                    }
                }
            }
        }
    }

    public void stopFpsCheck() {
    }

    public void stopPreview() {
        synchronized (this.l) {
            if (this.s) {
                long currentTimeMillis = System.currentTimeMillis() - this.v;
                if (currentTimeMillis != 0) {
                    float f = (float) (this.u / (currentTimeMillis / 1000));
                    RecordService.getInstance().recordEvent(2, "stopPreview", new String[]{"previewFrameCount", String.valueOf(this.u), "cost", String.valueOf(currentTimeMillis), "frameRatio", String.valueOf(f), "status", f < 20.0f ? "exception" : "normal"});
                }
                if (this.c != null) {
                    synchronized (this.l) {
                        try {
                            this.c.setOneShotPreviewCallback(null);
                            this.c.setPreviewCallback(null);
                            this.c.stopPreview();
                        } catch (Exception e) {
                            RecordService.getInstance().recordException(e);
                        }
                    }
                    this.s = false;
                }
            }
        }
    }

    public void takePhoto(ICameraTakePicture iCameraTakePicture) {
        Camera camera = this.c;
        if (camera != null) {
            camera.takePicture(null, null, new b(iCameraTakePicture));
        }
    }

    public void turnOffTakePhotoFlash() {
        Camera camera = this.c;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters == null) {
                    return;
                }
                parameters.setFlashMode("off");
                this.c.setParameters(parameters);
            } catch (Throwable th) {
                RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
            }
        }
    }

    public void turnOnTakePhotoFlash() {
        Camera camera = this.c;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters == null) {
                    return;
                }
                parameters.setFlashMode("torch");
                this.c.setParameters(parameters);
            } catch (Throwable th) {
                RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
            }
        }
    }

    public void unlockCameraWhiteBalanceAndExposure() {
        synchronized (this.l) {
            if (this.c != null) {
                try {
                    Camera.Parameters parameters = this.c.getParameters();
                    parameters.setAutoExposureLock(false);
                    parameters.setAutoWhiteBalanceLock(false);
                    this.c.setParameters(parameters);
                } catch (Throwable th) {
                }
            }
        }
    }

    public final int a(DeviceSetting deviceSetting) {
        int displayAngle;
        int i;
        if (deviceSetting != null) {
            if (deviceSetting.isDisplayAuto()) {
                int i2 = this.g;
                this.k = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, this.k);
                this.j = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getRotation();
                switch (this.j) {
                    case 0:
                    default:
                        i = 0;
                        break;
                    case 1:
                        i = 90;
                        break;
                    case 2:
                        i = BR.emoteImage;
                        break;
                    case 3:
                        i = BR.hasPlayedVideo;
                        break;
                }
                Camera.CameraInfo cameraInfo = this.k;
                if (cameraInfo.facing == 1) {
                    displayAngle = (360 - ((cameraInfo.orientation + i) % BR.loadingViewVisible)) % BR.loadingViewVisible;
                } else {
                    displayAngle = ((cameraInfo.orientation - i) + BR.loadingViewVisible) % BR.loadingViewVisible;
                }
            } else {
                displayAngle = deviceSetting.getDisplayAngle();
            }
            Activity activity = this.f4b;
            if (activity != null) {
                int findNStatus = DisplayUtil.getFindNStatus(activity);
                if (findNStatus == 1) {
                    return 90;
                }
                if (findNStatus == 2) {
                    return 0;
                }
                if (findNStatus == 3) {
                    return 90;
                }
            }
            return displayAngle;
        }
        throw new IllegalArgumentException("deviceSetting can't be null");
    }

    public final void a() {
        Camera.Size a;
        int min;
        Camera.Size a2;
        if (this.d != null) {
            DeviceSetting deviceSetting = this.i;
            if (deviceSetting != null) {
                this.f = a(deviceSetting);
            }
            Camera camera = this.c;
            if (camera != null) {
                camera.setDisplayOrientation(this.f);
            }
            DeviceSetting deviceSetting2 = this.i;
            if (deviceSetting2 != null && !deviceSetting2.isWidthAuto()) {
                a = c.a().a(this.d.getSupportedPreviewSizes(), this.i.getWidth(), this.i.getHeight(), this.f, this.i, this.j, this.k);
            } else if (this.t) {
                a = c.a().a(this.d.getSupportedPreviewSizes(), CameraConstants.CAMERA_MIN_WIDTH, CameraConstants.CAMERA_MIN_HEIGHT, this.f, this.i, this.j, this.k);
            } else {
                a = c.a().a(this.d.getSupportedPreviewSizes(), DisplayUtil.getScreenRate(this.a), CameraConstants.CAMERA_MIN_WIDTH, this.f);
            }
            if (a != null) {
                this.o = a.width;
                this.p = a.height;
                int i = this.o;
                this.m = i;
                int i2 = this.p;
                this.n = i2;
                this.d.setPreviewSize(i, i2);
                if (!this.t && (a2 = c.a().a(this.d.getSupportedPictureSizes(), DisplayUtil.getScreenRate(this.a), CameraConstants.CAMERA_MIN_WIDTH, this.f)) != null) {
                    this.d.setPictureSize(a2.width, a2.height);
                }
            }
            if (this.i != null && this.d.isZoomSupported() && (min = Math.min(Math.max(this.i.getZoom(), 0), this.d.getMaxZoom())) != this.d.getZoom()) {
                this.d.setZoom(min);
            }
            List<String> supportedFocusModes = this.d.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                if (supportedFocusModes.contains("continuous-video")) {
                    this.d.setFocusMode("continuous-video");
                } else if (supportedFocusModes.contains(TtmlNode.TEXT_EMPHASIS_AUTO)) {
                    this.d.setFocusMode(TtmlNode.TEXT_EMPHASIS_AUTO);
                }
            }
        }
    }
}