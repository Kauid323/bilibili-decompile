package video.biz.offline.list.ui.widget;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;

/* compiled from: OfflineCompletedGridItem.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"OfflineCompletedGridItem", "", "cardModel", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "isEdit", "", "isChecked", "modifier", "Landroidx/compose/ui/Modifier;", "onClickToDetail", "Lkotlin/Function1;", "", "(Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;ZZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineCompletedGridItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedGridItem$lambda$2(OfflineCachedCardModel offlineCachedCardModel, boolean z, boolean z2, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        OfflineCompletedGridItem(offlineCachedCardModel, z, z2, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedGridItem$lambda$0$0(long it) {
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -121
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void OfflineCompletedGridItem(video.biz.offline.list.logic.model.OfflineCachedCardModel r133, boolean r134, boolean r135, androidx.compose.ui.Modifier r136, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r137, androidx.compose.runtime.Composer r138, int r139, int r140) {
        /*
            Method dump skipped, instructions count: 3458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: video.biz.offline.list.ui.widget.OfflineCompletedGridItemKt.OfflineCompletedGridItem(video.biz.offline.list.logic.model.OfflineCachedCardModel, boolean, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedGridItem$lambda$1$0$1$0$0(long $color, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, $color, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0L, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, new Stroke($this$Canvas.toPx-0680j_4(Dp.constructor-impl(1)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, (int) IjkMediaMeta.FF_PROFILE_H264_HIGH_10, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier OfflineCompletedGridItem$lambda$1$1$0$0(final OfflineCachedCardModel $cardModel, final Function1 $onClickToDetail, Modifier it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ClickableKt.clickable-oSLSa3U$default(it, false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCompletedGridItemKt$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit OfflineCompletedGridItem$lambda$1$1$0$0$0;
                OfflineCompletedGridItem$lambda$1$1$0$0$0 = OfflineCompletedGridItemKt.OfflineCompletedGridItem$lambda$1$1$0$0$0(OfflineCachedCardModel.this, $onClickToDetail);
                return OfflineCompletedGridItem$lambda$1$1$0$0$0;
            }
        }, 15, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedGridItem$lambda$1$1$0$0$0(OfflineCachedCardModel $cardModel, Function1 $onClickToDetail) {
        OfflineVideoEntity entity = $cardModel.getEntity();
        if (entity != null) {
            $onClickToDetail.invoke(Long.valueOf(entity.getAid()));
        }
        return Unit.INSTANCE;
    }
}