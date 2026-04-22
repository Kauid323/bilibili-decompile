package im.session.common;

import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.transformer.ExposureAreaVisibilityTransformerKt;
import com.bilibili.framework.exposure.core.transformer.ExposureVisibleDurationTransformerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ExposureUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lim/session/common/SimpleExposureEntry;", "Lcom/bilibili/framework/exposure/core/ExposureEntry;", "debounceTime", "", "onExposure", "Lkotlin/Function0;", "", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleExposureEntry extends ExposureEntry {
    public static final int $stable = ExposureEntry.$stable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleExposureEntry(final long debounceTime, Function0<Unit> function0) {
        super(new Function1() { // from class: im.session.common.SimpleExposureEntry$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Flow _init_$lambda$0;
                _init_$lambda$0 = SimpleExposureEntry._init_$lambda$0(debounceTime, (Flow) obj);
                return _init_$lambda$0;
            }
        }, function0);
        Intrinsics.checkNotNullParameter(function0, "onExposure");
    }

    public /* synthetic */ SimpleExposureEntry(long j, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow _init_$lambda$0(long $debounceTime, Flow it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ExposureVisibleDurationTransformerKt.exposeImmediatelyWhenNoticeable(FlowKt.debounce(FlowKt.distinctUntilChanged(ExposureAreaVisibilityTransformerKt.noticeableWhenAreaPixelIsAtLeast(it, 1)), $debounceTime));
    }
}