package tv.danmaku.bili.ui.main2.mine.widgets;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import com.bapis.bilibili.dagw.component.avatar.v1.LayerTagConfig;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.avatar.layers.AvatarLayer;
import com.bilibili.lib.avatar.layers.plugin.AvatarPluginPainter;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineAvatarDrawPlugin.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/MineAvatarDrawPlugin;", "Lcom/bilibili/lib/avatar/layers/plugin/AvatarPluginPainter;", "layer", "Lcom/bilibili/lib/avatar/layers/AvatarLayer;", "data", "Lcom/bapis/bilibili/dagw/component/avatar/v1/LayerTagConfig;", "<init>", "(Lcom/bilibili/lib/avatar/layers/AvatarLayer;Lcom/bapis/bilibili/dagw/component/avatar/v1/LayerTagConfig;)V", "getLayer", "()Lcom/bilibili/lib/avatar/layers/AvatarLayer;", "getData", "()Lcom/bapis/bilibili/dagw/component/avatar/v1/LayerTagConfig;", "prepareData", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "rect", "Landroid/graphics/Rect;", "(Landroid/content/Context;Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareToDraw", "", "relatedLayers", "", "onDestroy", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineAvatarDrawPlugin extends AvatarPluginPainter {
    public static final int $stable = 8;
    private final LayerTagConfig data;
    private final AvatarLayer layer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineAvatarDrawPlugin(AvatarLayer layer, LayerTagConfig data) {
        super(data, layer);
        Intrinsics.checkNotNullParameter(layer, "layer");
        Intrinsics.checkNotNullParameter(data, "data");
        this.layer = layer;
        this.data = data;
    }

    public AvatarLayer getLayer() {
        return this.layer;
    }

    public LayerTagConfig getData() {
        return this.data;
    }

    public Object prepareData(Context context, Rect rect, Continuation<? super Drawable> continuation) {
        return new ShapeDrawable();
    }

    public void prepareToDraw(List<AvatarLayer> list) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(list, "relatedLayers");
        Application application = BiliContext.application();
        if (application == null || (applicationContext = application.getApplicationContext()) == null) {
            return;
        }
        Garb garb = GarbManager.getGarbWithNightMode(applicationContext);
        boolean useNightColor = garb.isPure() ? garb.isNight() : false;
        List<AvatarLayer> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            AvatarLayer it = (AvatarLayer) element$iv;
            it.tintPainterDayNight(useNightColor);
        }
    }

    public void onDestroy() {
    }
}