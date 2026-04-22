package tv.danmaku.biliplayerv2;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerSharingBundle.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"getParcelableCompat", "T", "Landroid/os/Parcelable;", "Landroid/os/Bundle;", "key", "", "clazz", "Ljava/lang/Class;", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerSharingBundleKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    public static final <T extends Parcelable> T getParcelableCompat(Bundle $this$getParcelableCompat, String key, Class<T> cls) {
        Intrinsics.checkNotNullParameter($this$getParcelableCompat, "<this>");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        T t = null;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                t = (Parcelable) $this$getParcelableCompat.getParcelable(key, cls);
            } else {
                Parcelable obj = $this$getParcelableCompat.getParcelable(key);
                if (obj == null) {
                    return null;
                }
                t = cls.cast(obj);
            }
        } catch (ClassCastException e) {
            BLog.e("Expected type " + cls + " for key " + key + " not found", e);
        }
        return t;
    }
}