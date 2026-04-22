package tv.danmaku.bili.ui.main.opdialog;

import android.app.Activity;
import android.graphics.Bitmap;
import com.bilibili.lib.image2.bean.BaseImageDataSubscriber;
import com.bilibili.lib.image2.bean.DecodedImageHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.StaticBitmapImageHolder;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper;

/* compiled from: OpBizDialogHelper.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u0006H\u0014J\u001c\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"tv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$dealWithDialog$1", "Lcom/bilibili/lib/image2/bean/BaseImageDataSubscriber;", "Lcom/bilibili/lib/image2/bean/DecodedImageHolder;", "onNewResultImpl", "", "dataSource", "Lcom/bilibili/lib/image2/bean/ImageDataSource;", "onFailureImpl", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OpBizDialogHelper$dealWithDialog$1 extends BaseImageDataSubscriber<DecodedImageHolder<?>> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ OpBizDialogHelper.OpDialogInfo $info;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpBizDialogHelper$dealWithDialog$1(Activity $activity, OpBizDialogHelper.OpDialogInfo $info) {
        this.$activity = $activity;
        this.$info = $info;
    }

    protected void onNewResultImpl(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
        if (this.$activity.isFinishing()) {
            return;
        }
        DecodedImageHolder decodedImageHolder = imageDataSource != null ? (DecodedImageHolder) imageDataSource.getResult() : null;
        StaticBitmapImageHolder staticBitmapImageHolder = decodedImageHolder instanceof StaticBitmapImageHolder ? (StaticBitmapImageHolder) decodedImageHolder : null;
        Bitmap bitmap = staticBitmapImageHolder != null ? staticBitmapImageHolder.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        BLog.i(OpBizDialogHelper.TAG, "Op biz dialog image fetch success.");
        this.$info.setImageBm(Bitmap.createBitmap(bitmap));
        OpBizDialogHelper.INSTANCE.dealWithDialogWithImage(this.$activity, this.$info);
    }

    protected void onFailureImpl(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
        BLog.e(OpBizDialogHelper.TAG, "Op biz dialog image fetch error.");
        Neurons.trackT(false, "main.recommend.popups.no-pop.track", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", this.$info.getReportData()), TuplesKt.to("reason", "1")}), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$dealWithDialog$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean onFailureImpl$lambda$0;
                onFailureImpl$lambda$0 = OpBizDialogHelper$dealWithDialog$1.onFailureImpl$lambda$0();
                return Boolean.valueOf(onFailureImpl$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onFailureImpl$lambda$0() {
        return true;
    }
}