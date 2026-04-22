package kntr.base.avif.jni;

import BottomSheetItemData$;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NativeAvifDecoder.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086 J%\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0086 J-\u0010\u0014\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0086 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkntr/base/avif/jni/NativeAvifDecoder;", "", "<init>", "()V", "TAG", "", "soLoaderSuccess", "", "getSoLoaderSuccess", "()Z", "setSoLoaderSuccess", "(Z)V", "isAvifImage", "encoded", "Ljava/nio/ByteBuffer;", "length", "", "getInfo", "info", "Lkntr/base/avif/jni/NativeAvifDecoder$Info;", "decode", "bitmap", "Landroid/graphics/Bitmap;", "threadCount", "Info", "jni_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NativeAvifDecoder {
    public static final NativeAvifDecoder INSTANCE = new NativeAvifDecoder();
    public static final String TAG = "AvifDecoder";
    private static boolean soLoaderSuccess;

    public final native boolean decode(ByteBuffer byteBuffer, int i, Bitmap bitmap, int i2);

    public final native boolean getInfo(ByteBuffer byteBuffer, int i, Info info);

    public final native boolean isAvifImage(ByteBuffer byteBuffer, int i);

    private NativeAvifDecoder() {
    }

    public final boolean getSoLoaderSuccess() {
        return soLoaderSuccess;
    }

    public final void setSoLoaderSuccess(boolean z) {
        soLoaderSuccess = z;
    }

    static {
        boolean z;
        try {
            System.loadLibrary("avif");
            z = true;
        } catch (UnsatisfiedLinkError e) {
            KLog_androidKt.getKLog().e(TAG, "Failed to load libavif.so", e);
            z = false;
        }
        soLoaderSuccess = z;
    }

    /* compiled from: NativeAvifDecoder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lkntr/base/avif/jni/NativeAvifDecoder$Info;", "", "width", "", "height", "depth", "alphaPresent", "", "<init>", "(IIIZ)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getDepth", "setDepth", "getAlphaPresent", "()Z", "setAlphaPresent", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "jni_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Info {
        private boolean alphaPresent;
        private int depth;
        private int height;
        private int width;

        public Info() {
            this(0, 0, 0, false, 15, null);
        }

        public static /* synthetic */ Info copy$default(Info info, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = info.width;
            }
            if ((i4 & 2) != 0) {
                i2 = info.height;
            }
            if ((i4 & 4) != 0) {
                i3 = info.depth;
            }
            if ((i4 & 8) != 0) {
                z = info.alphaPresent;
            }
            return info.copy(i, i2, i3, z);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        public final int component3() {
            return this.depth;
        }

        public final boolean component4() {
            return this.alphaPresent;
        }

        public final Info copy(int i, int i2, int i3, boolean z) {
            return new Info(i, i2, i3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Info) {
                Info info = (Info) obj;
                return this.width == info.width && this.height == info.height && this.depth == info.depth && this.alphaPresent == info.alphaPresent;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.width * 31) + this.height) * 31) + this.depth) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.alphaPresent);
        }

        public String toString() {
            int i = this.width;
            int i2 = this.height;
            int i3 = this.depth;
            return "Info(width=" + i + ", height=" + i2 + ", depth=" + i3 + ", alphaPresent=" + this.alphaPresent + ")";
        }

        public Info(int width, int height, int depth, boolean alphaPresent) {
            this.width = width;
            this.height = height;
            this.depth = depth;
            this.alphaPresent = alphaPresent;
        }

        public /* synthetic */ Info(int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? false : z);
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setWidth(int i) {
            this.width = i;
        }

        public final int getHeight() {
            return this.height;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final int getDepth() {
            return this.depth;
        }

        public final void setDepth(int i) {
            this.depth = i;
        }

        public final boolean getAlphaPresent() {
            return this.alphaPresent;
        }

        public final void setAlphaPresent(boolean z) {
            this.alphaPresent = z;
        }
    }
}