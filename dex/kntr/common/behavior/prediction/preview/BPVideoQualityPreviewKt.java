package kntr.common.behavior.prediction.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.behavior.prediction.IPredictionResult;
import kntr.common.behavior.prediction.KBehaviorPredictor;
import kntr.common.behavior.prediction.model.VideoQualityData;
import kntr.common.behavior.prediction.model.VideoQualityDeviceBehaviorData;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BPVideoQualityPreview.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a&\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"BPVideoQualityPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "handleClick", "tag", "", "inputs", "", "", "toaster", "Lkntr/common/trio/toast/Toaster;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BPVideoQualityPreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BPVideoQualityPreview$lambda$0(int i, Composer composer, int i2) {
        BPVideoQualityPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BPVideoQualityPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1099060719);
        ComposerKt.sourceInformation($composer2, "C(BPVideoQualityPreview)32@1352L2182:BPVideoQualityPreview.kt#9vm0wh");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1099060719, $changed, -1, "kntr.common.behavior.prediction.preview.BPVideoQualityPreview (BPVideoQualityPreview.kt:31)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$BPVideoQualityPreviewKt.INSTANCE.m1821getLambda$254434393$preview_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.behavior.prediction.preview.BPVideoQualityPreviewKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BPVideoQualityPreview$lambda$0;
                    BPVideoQualityPreview$lambda$0 = BPVideoQualityPreviewKt.BPVideoQualityPreview$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BPVideoQualityPreview$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleClick(int tag, List<String> list, Toaster toaster) {
        String mediaInfo;
        String str = "";
        switch (tag) {
            case 1:
                KBehaviorPredictor kBehaviorPredictor = KBehaviorPredictor.INSTANCE;
                String str2 = list.size() > 0 ? list.get(0) : "";
                if (1 < list.size()) {
                    str = list.get(1);
                }
                kBehaviorPredictor.update(new VideoQualityDeviceBehaviorData(null, str2, Intrinsics.areEqual(str, "1"), 1, null));
                Toaster.CC.showToast$default(toaster, "「用户标签」数据更新成功！", null, 2, null);
                return;
            case 2:
                String avid = list.size() > 0 ? list.get(0) : "";
                if (StringsKt.isBlank(avid)) {
                    toaster.showToast("更新失败：avid不能为空！", ToastDuration.Long);
                    return;
                }
                if (Intrinsics.areEqual(CollectionsKt.getOrNull(list, 1), "1")) {
                    mediaInfo = "{\"quality_tag\":\"高清优先\"}";
                } else {
                    if (2 < list.size()) {
                        str = list.get(2);
                    }
                    mediaInfo = str;
                }
                KBehaviorPredictor.INSTANCE.update(new VideoQualityData.Behavior(avid, mediaInfo));
                Toaster.CC.showToast$default(toaster, "「稿件标签」数据更新成功！", null, 2, null);
                return;
            case 3:
                if (list.size() > 0) {
                    str = list.get(0);
                }
                String avid2 = str;
                if (StringsKt.isBlank(avid2)) {
                    toaster.showToast("查询失败：avid不能为空！", ToastDuration.Long);
                    return;
                }
                String str3 = (String) CollectionsKt.getOrNull(list, 1);
                Integer autoMaxQn = str3 != null ? StringsKt.toIntOrNull(str3) : null;
                if (autoMaxQn == null) {
                    toaster.showToast("查询失败：默认的自动清晰度 应该为一个数字！", ToastDuration.Long);
                    return;
                }
                boolean isHighScreenRatio = Intrinsics.areEqual(CollectionsKt.getOrNull(list, 2), "1");
                boolean isWifi = Intrinsics.areEqual(CollectionsKt.getOrNull(list, 3), "1");
                IPredictionResult res = KBehaviorPredictor.INSTANCE.predict(new VideoQualityData.Context(avid2, autoMaxQn.intValue(), isHighScreenRatio, isWifi));
                if (res instanceof VideoQualityData.Result) {
                    toaster.showToast("推测的自动清晰度为：" + ((VideoQualityData.Result) res).getMaxQn(), ToastDuration.Long);
                    return;
                } else {
                    toaster.showToast("查询失败，请检查内部逻辑！", ToastDuration.Long);
                    return;
                }
            default:
                Toaster.CC.showToast$default(toaster, "请及时补充第 " + tag + " 个按钮的点击实现", null, 2, null);
                return;
        }
    }
}