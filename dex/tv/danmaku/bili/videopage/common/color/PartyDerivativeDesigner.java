package tv.danmaku.bili.videopage.common.color;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.VectorTextView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PartyDerivativeDesigner.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J8\u0010\r\u001a\u00020\b2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\bH\u0007J@\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\bH\u0007J*\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0007R\u000e\u0010\u001a\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/videopage/common/color/PartyDerivativeDesigner;", "", "<init>", "()V", "setImageViewTintColor", "", "colors", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "type", "view", "Landroid/widget/ImageView;", "getTypeColorInt", "getTypeDrawable", "Landroid/graphics/drawable/Drawable;", "origin", "updateCompoundDrawablesLeft", "color", "Landroid/widget/TextView;", "getTintDrawable", "drawable", "setColorToVectorDrawable", "Ltv/danmaku/bili/widget/VectorTextView;", "size", "originDrawable", "NO_COLOR_ERROR", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PartyDerivativeDesigner {
    public static final PartyDerivativeDesigner INSTANCE = new PartyDerivativeDesigner();
    public static final int NO_COLOR_ERROR = 0;

    private PartyDerivativeDesigner() {
    }

    @JvmStatic
    public static final void setImageViewTintColor(HashMap<Integer, Integer> hashMap, int type, ImageView view2) {
        Integer num;
        Intrinsics.checkNotNullParameter(view2, "view");
        if (hashMap == null || (num = hashMap.get(Integer.valueOf(type))) == null) {
            return;
        }
        int color = num.intValue();
        view2.setColorFilter(color);
    }

    @JvmStatic
    public static final int getTypeColorInt(HashMap<Integer, Integer> hashMap, int type) {
        Integer num;
        if (hashMap == null || (num = hashMap.get(Integer.valueOf(type))) == null) {
            return 0;
        }
        return num.intValue();
    }

    @JvmStatic
    public static final Drawable getTypeDrawable(HashMap<Integer, Integer> hashMap, int type, Drawable origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        int color = getTypeColorInt(hashMap, type);
        if (color != 0) {
            return getTintDrawable(origin, color);
        }
        return origin;
    }

    @JvmStatic
    public static final void updateCompoundDrawablesLeft(int color, TextView view2) {
        Drawable drawable;
        if (view2 != null && (drawable = view2.getCompoundDrawables()[0]) != null) {
            Drawable result = getTintDrawable(drawable, color);
            view2.setCompoundDrawables(result, null, null, null);
        }
    }

    @JvmStatic
    public static final Drawable getTintDrawable(Drawable drawable, int color) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Drawable wrapper = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrapper, color);
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        Intrinsics.checkNotNull(wrapper);
        return wrapper;
    }

    @JvmStatic
    public static final void setColorToVectorDrawable(VectorTextView view2, int size, Drawable originDrawable, int color) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (originDrawable == null) {
            return;
        }
        Drawable tintDrawable = getTintDrawable(originDrawable, color);
        tintDrawable.setBounds(0, 0, size, size);
        view2.setVectorDrawables(tintDrawable, null, null, null);
    }
}