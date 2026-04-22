package kntr.base.mod;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.KDownloader.KDownloader.IDownloader;
import kntr.base.mod.internal.KModImpl;
import kntr.base.neuron.IPlatformNeuron;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* compiled from: KMod.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"setUpMod", "Lkntr/base/mod/KMod;", "downloader", "Lkntr/base/KDownloader/KDownloader/IDownloader;", "neuron", "Lkntr/base/neuron/IPlatformNeuron;", "options", "Lkntr/base/mod/KModOptions;", "(Lkntr/base/KDownloader/KDownloader/IDownloader;Lkntr/base/neuron/IPlatformNeuron;Lkntr/base/mod/KModOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mod_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KModKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object setUpMod(IDownloader downloader, IPlatformNeuron neuron, KModOptions options, Continuation<? super KMod> continuation) {
        KModKt$setUpMod$1 kModKt$setUpMod$1;
        if (continuation instanceof KModKt$setUpMod$1) {
            kModKt$setUpMod$1 = (KModKt$setUpMod$1) continuation;
            if ((kModKt$setUpMod$1.label & Integer.MIN_VALUE) != 0) {
                kModKt$setUpMod$1.label -= Integer.MIN_VALUE;
                Object $result = kModKt$setUpMod$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kModKt$setUpMod$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KModImpl $this$setUpMod_u24lambda_u240 = new KModImpl(downloader, neuron, options);
                        kModKt$setUpMod$1.L$0 = SpillingKt.nullOutSpilledVariable(downloader);
                        kModKt$setUpMod$1.L$1 = SpillingKt.nullOutSpilledVariable(neuron);
                        kModKt$setUpMod$1.L$2 = SpillingKt.nullOutSpilledVariable(options);
                        kModKt$setUpMod$1.L$3 = $this$setUpMod_u24lambda_u240;
                        kModKt$setUpMod$1.L$4 = SpillingKt.nullOutSpilledVariable($this$setUpMod_u24lambda_u240);
                        kModKt$setUpMod$1.I$0 = 0;
                        kModKt$setUpMod$1.label = 1;
                        if ($this$setUpMod_u24lambda_u240.startUp(kModKt$setUpMod$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return $this$setUpMod_u24lambda_u240;
                    case 1:
                        int i = kModKt$setUpMod$1.I$0;
                        KModImpl kModImpl = (KModImpl) kModKt$setUpMod$1.L$4;
                        KModImpl kModImpl2 = (KModImpl) kModKt$setUpMod$1.L$3;
                        KModOptions kModOptions = (KModOptions) kModKt$setUpMod$1.L$2;
                        IPlatformNeuron iPlatformNeuron = (IPlatformNeuron) kModKt$setUpMod$1.L$1;
                        IDownloader iDownloader = (IDownloader) kModKt$setUpMod$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return kModImpl2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        kModKt$setUpMod$1 = new KModKt$setUpMod$1(continuation);
        Object $result2 = kModKt$setUpMod$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kModKt$setUpMod$1.label) {
        }
    }
}