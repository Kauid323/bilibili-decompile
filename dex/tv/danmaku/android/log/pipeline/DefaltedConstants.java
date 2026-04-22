package tv.danmaku.android.log.pipeline;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DefaltedConstants.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ltv/danmaku/android/log/pipeline/DefaltedConstants;", "", "()V", "COMPRESS_ERROR_HINT", "", "getCOMPRESS_ERROR_HINT", "()[B", "DROP_LOG", "getDROP_LOG", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DefaltedConstants {
    public static final DefaltedConstants INSTANCE = new DefaltedConstants();
    private static final byte[] COMPRESS_ERROR_HINT = {114, -14, -55, 79, 87, -16, -52, 43, 73, 45, -54, 75, -52, 81, 112, 45, 42, -54, 47, -78, 82, 112, 73, 77, -53, 73, 44, 73, 85, 112, 42, 77, 75, 75, 45, 82, -56, 44, 86, -56, -53, 47, 81, 72, -51, -53, 47, 77, -49, -48, 3, 0, 0, 0, -1, -1};
    private static final byte[] DROP_LOG = {114, -14, -55, 79, 87, -16, -52, 43, 73, 45, -54, 75, -52, 81, 112, 45, 42, -54, 47, -78, 82, 112, 41, -54, 47, 80, -56, -55, 79, -41, 3, 0, 0, 0, -1, -1};

    private DefaltedConstants() {
    }

    public final byte[] getCOMPRESS_ERROR_HINT() {
        return COMPRESS_ERROR_HINT;
    }

    public final byte[] getDROP_LOG() {
        return DROP_LOG;
    }
}