package kntr.base.dd.preview;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.IDeviceDecisionUtils;
import kntr.base.dd.KDeviceDecision;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDebuggerPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$5$1$1", f = "DDDebuggerPreview.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$5$1$1  reason: invalid class name */
public final class ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isProp;
    final /* synthetic */ List<String> $list;
    final /* synthetic */ MutableState<Pair<String, String>> $tipsMsg$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$5$1$1(List<String> list, boolean z, MutableState<Pair<String, String>> mutableState, Continuation<? super ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$5$1$1> continuation) {
        super(2, continuation);
        this.$list = list;
        this.$isProp = z;
        this.$tipsMsg$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$5$1$1(this.$list, this.$isProp, this.$tipsMsg$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IDeviceDecisionUtils.DumpComponent type;
        String value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String key = this.$list.get(0);
                if (!StringsKt.isBlank(key)) {
                    if (this.$isProp) {
                        value = IDeviceDecisionProperty.CC.get$default(KDeviceDecision.INSTANCE.getProperty(), key, null, 2, null);
                        if (value == null) {
                            value = "";
                        }
                    } else {
                        value = DDDebuggerPreviewKt.getDebugger().getDecideDetailString(key);
                    }
                } else {
                    if (this.$isProp) {
                        type = IDeviceDecisionUtils.DumpComponent.Properties;
                    } else {
                        type = IDeviceDecisionUtils.DumpComponent.Values;
                    }
                    value = KDeviceDecision.INSTANCE.getUtils().dumpAsJson(CollectionsKt.listOf(type));
                }
                this.$tipsMsg$delegate.setValue(TuplesKt.to("查询结果", value));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}