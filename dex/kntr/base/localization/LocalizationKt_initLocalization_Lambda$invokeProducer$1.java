package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalizationKt_initLocalization_Lambda.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.localization.LocalizationKt_initLocalization_Lambda", f = "LocalizationKt_initLocalization_Lambda.kt", i = {}, l = {30}, m = "invokeProducer", n = {}, s = {}, v = 1)
public final class LocalizationKt_initLocalization_Lambda$invokeProducer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalizationKt_initLocalization_Lambda this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalizationKt_initLocalization_Lambda$invokeProducer$1(LocalizationKt_initLocalization_Lambda localizationKt_initLocalization_Lambda, Continuation<? super LocalizationKt_initLocalization_Lambda$invokeProducer$1> continuation) {
        super(continuation);
        this.this$0 = localizationKt_initLocalization_Lambda;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invokeProducer((Continuation) this);
    }
}