package kntr.common.opus.card;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: OpusCardViewProvider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"opusCardViewProvider", "Lkntr/common/opus/card/OpusCardViewProvider;", "getOpusCardViewProvider", "()Lkntr/common/opus/card/OpusCardViewProvider;", "opusCardViewProvider$delegate", "Lkotlin/Lazy;", "card_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OpusCardViewProviderKt {
    private static final Lazy opusCardViewProvider$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.opus.card.OpusCardViewProviderKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            OpusCardViewProvider opusCardViewProvider_delegate$lambda$0;
            opusCardViewProvider_delegate$lambda$0 = OpusCardViewProviderKt.opusCardViewProvider_delegate$lambda$0();
            return opusCardViewProvider_delegate$lambda$0;
        }
    });

    public static final OpusCardViewProvider getOpusCardViewProvider() {
        return (OpusCardViewProvider) opusCardViewProvider$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OpusCardViewProvider opusCardViewProvider_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((OpusCardComposeViewProviderEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(OpusCardComposeViewProviderEntryPoint.class))).getViewProvider();
    }
}