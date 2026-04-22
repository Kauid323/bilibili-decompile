package baseverify;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import com.dtf.face.ToygerConfig;
import com.dtf.face.config.DeviceSetting;
import com.dtf.face.log.RecordService;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class c {
    public static c a;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = a;
            if (cVar == null) {
                a = new c();
                cVar = a;
            }
        }
        return cVar;
    }

    public Camera.Size a(List<Camera.Size> list, float f, int i, int i2) {
        Camera.Size next;
        int i3;
        if (list == null || list.size() == 0) {
            return null;
        }
        Collections.sort(list, new a(this, f, i2));
        Iterator<Camera.Size> it = list.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext() || (i3 = (next = it.next()).width) >= i) {
                break;
            } else if (i3 == next.height) {
                i4 = -1;
                break;
            } else {
                i4++;
            }
        }
        if (i4 == -1) {
            return a(list, i, 0, i2);
        }
        return list.get(i4 != list.size() ? i4 : 0);
    }

    /* loaded from: /data/np/file-convert/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f/20260223061017a7df215e-cc71-4f91-a72e-32f005bc9f3f.dex */
    public class a implements Comparator<Camera.Size> {
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f6b;

        public a(c cVar, int i) {
            this.a = 0.0f;
            this.f6b = 0.0f;
            this.f6b = i;
        }

        public final Integer a(int i, int i2, int i3, int i4) {
            if (i > i2) {
                if (i3 < i4) {
                    return 1;
                }
                float f = (i2 / i) - (i4 / i3);
                if (f > 0.0f) {
                    return -1;
                }
                return f < 0.0f ? 1 : null;
            }
            return null;
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            Camera.Size size3 = size;
            Camera.Size size4 = size2;
            int i = size3.width;
            int i2 = size3.height;
            if (i == i2) {
                int i3 = size4.width;
                if (i3 != size4.height) {
                    return 1;
                }
                return i - i3;
            }
            int i4 = size4.width;
            int i5 = size4.height;
            if (i4 == i5) {
                return -1;
            }
            float f = this.a;
            int i6 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i6 != 0) {
                float abs = i6 == 0 ? 0.0f : Math.abs((i / i2) - f) - Math.abs((size4.width / size4.height) - this.a);
                int i7 = size3.width > size4.width ? -1 : 1;
                if (Math.abs(abs) >= 0.01d) {
                    if (abs >= 0.0f) {
                        if (abs > 0.0f) {
                            return 1;
                        }
                    }
                }
                return i7;
            }
            if (this.f6b % 180.0f != 0.0f) {
                Integer a = a(i2, i, i5, i4);
                if (a != null) {
                    return a.intValue();
                }
            } else {
                Integer a2 = a(i, i2, i4, i5);
                if (a2 != null) {
                    return a2.intValue();
                }
            }
            int i8 = size3.width;
            int i9 = size4.width;
            if (i8 == i9) {
                return size3.height - size4.height;
            }
            if (i8 > i9) {
                return 1;
            }
            return -1;
        }

        public a(c cVar, float f, int i) {
            this.a = 0.0f;
            this.f6b = 0.0f;
            this.a = f;
            this.f6b = i;
        }
    }

    public Camera.Size a(List<Camera.Size> list, int i, int i2, int i3, DeviceSetting deviceSetting, int i4, Camera.CameraInfo cameraInfo) {
        Camera.Size size = null;
        if (list != null && list.size() != 0) {
            Collections.sort(list, new a(this, i3));
            for (Camera.Size size2 : list) {
                if (size2.width >= i && size2.height >= i2) {
                    size = size2;
                    break;
                }
                if (size2.height != size2.width) {
                    size = size2;
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                for (Camera.Size size3 : list) {
                    sb.append(size3.width).append(",").append(size3.height).append(";");
                }
                sb.append("suitableSize:").append(size.width).append(",").append(size.height).append(".");
                RecordService.getInstance().recordEvent(2, "previewSize", new String[]{"sizeList", sb.toString(), "angle", String.valueOf(i3), "displayAngle", deviceSetting == null ? "deviceSetting is NULL" : String.valueOf(deviceSetting.getDisplayAngle()), "displayAuto", deviceSetting == null ? "deviceSetting is NULL" : String.valueOf(deviceSetting.isDisplayAuto()), "rotation", String.valueOf(i4), "orientation", cameraInfo == null ? "cameraInfo is NULL" : String.valueOf(cameraInfo.orientation)});
            } catch (Throwable th) {
                RecordService.getInstance().recordException(th);
            }
            return size;
        }
        RecordService.getInstance().recordEvent(2, "previewSize", new String[]{"errMsg", "list is " + (list == null ? "null" : "empty")});
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(int i) {
        int i2;
        CameraManager cameraManager;
        String[] cameraIdList;
        int i3;
        Camera.CameraInfo cameraInfo;
        try {
        } catch (Throwable th) {
            RecordService.getInstance().recordException(th);
        }
        if (Integer.parseInt(Build.VERSION.SDK) > 8) {
            i2 = Camera.getNumberOfCameras();
            if (i2 <= 0) {
                try {
                    Context context = ToygerConfig.getInstance().getContext();
                    if (context != null && (cameraManager = (CameraManager) context.getSystemService("camera")) != null && (cameraIdList = cameraManager.getCameraIdList()) != null) {
                        i2 = cameraIdList.length;
                    }
                } catch (Throwable th2) {
                    RecordService.getInstance().recordException(th2);
                }
            }
            if (i2 == 0) {
                RecordService.getInstance().recordEvent(2, "noCamera", new String[0]);
            }
            for (i3 = 0; i3 < i2; i3++) {
                try {
                    cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i3, cameraInfo);
                } catch (Throwable th3) {
                    RecordService.getInstance().recordException(th3);
                }
                if (cameraInfo.facing == i) {
                    return i3;
                }
            }
            return -1;
        }
        i2 = -1;
        if (i2 <= 0) {
        }
        if (i2 == 0) {
        }
        while (i3 < i2) {
        }
        return -1;
    }
}