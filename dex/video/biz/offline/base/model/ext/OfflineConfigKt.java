package video.biz.offline.base.model.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"json", "Lkotlinx/serialization/json/Json;", "vipQualities", "", "", "getVipQualities", "()Ljava/util/List;", "vipQualities$delegate", "Lkotlin/Lazy;", "model_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineConfigKt {
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: video.biz.offline.base.model.ext.OfflineConfigKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$0;
            json$lambda$0 = OfflineConfigKt.json$lambda$0((JsonBuilder) obj);
            return json$lambda$0;
        }
    }, 1, (Object) null);
    private static final Lazy vipQualities$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.model.ext.OfflineConfigKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            List vipQualities_delegate$lambda$0;
            vipQualities_delegate$lambda$0 = OfflineConfigKt.vipQualities_delegate$lambda$0();
            return vipQualities_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setCoerceInputValues(true);
        return Unit.INSTANCE;
    }

    public static final List<Integer> getVipQualities() {
        return (List) vipQualities$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List vipQualities_delegate$lambda$0() {
        Iterable split$default;
        String config$default = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "ff_offline_vip_quality", (String) null, 2, (Object) null);
        if (config$default == null || (split$default = StringsKt.split$default(config$default, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            return CollectionsKt.listOf(new Integer[]{112, 116, 120, Integer.valueOf((int) Player.PLAYER_QUALITY_HDR), Integer.valueOf((int) Player.PLAYER_QUALITY_DOLBY_VISION), Integer.valueOf((int) Player.PLAYER_QUALITY_HDR_VIVID)});
        }
        Iterable $this$mapNotNull$iv = split$default;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            String it = (String) element$iv$iv$iv;
            Integer intOrNull = StringsKt.toIntOrNull(it);
            if (intOrNull != null) {
                destination$iv$iv.add(intOrNull);
            }
        }
        return (List) destination$iv$iv;
    }
}