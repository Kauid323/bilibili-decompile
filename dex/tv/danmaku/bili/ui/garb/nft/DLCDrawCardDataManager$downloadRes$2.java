package tv.danmaku.bili.ui.garb.nft;

import android.app.Application;
import com.bilibili.base.BiliContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;
import tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLCDrawCardDataManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$downloadRes$2", f = "DLCDrawCardDataManager.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DLCDrawCardDataManager$downloadRes$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DLCDrawCardDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCDrawCardDataManager$downloadRes$2(DLCDrawCardDataManager dLCDrawCardDataManager, Continuation<? super DLCDrawCardDataManager$downloadRes$2> continuation) {
        super(2, continuation);
        this.this$0 = dLCDrawCardDataManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DLCDrawCardDataManager$downloadRes$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DLCCardDrawModel dLCCardDrawModel;
        DLCCardDrawModel dLCCardDrawModel2;
        DLCResDownloader resDownloader;
        HashMap it;
        HashMap it2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final DLCDrawCardDataManager dLCDrawCardDataManager = this.this$0;
                this.L$0 = dLCDrawCardDataManager;
                this.label = 1;
                Continuation uCont$iv = (Continuation) this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuation continuation = cancellableContinuationImpl;
                final Ref.ObjectRef animUrls = new Ref.ObjectRef();
                animUrls.element = new ArrayList();
                dLCCardDrawModel = dLCDrawCardDataManager.drawCardItem;
                if (dLCCardDrawModel != null && (it2 = dLCCardDrawModel.getAnimDrawMap()) != null) {
                    Boxing.boxBoolean(((ArrayList) animUrls.element).addAll(it2.values()));
                }
                dLCCardDrawModel2 = dLCDrawCardDataManager.drawCardItem;
                if (dLCCardDrawModel2 != null && (it = dLCCardDrawModel2.getAnimEntryMap()) != null) {
                    Boxing.boxBoolean(((ArrayList) animUrls.element).addAll(it.values()));
                }
                if (!((ArrayList) animUrls.element).isEmpty()) {
                    dLCDrawCardDataManager.resSuccCount = 0;
                    Application app = BiliContext.application();
                    if (app == null) {
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    } else {
                        final Ref.BooleanRef failed = new Ref.BooleanRef();
                        resDownloader = dLCDrawCardDataManager.getResDownloader();
                        resDownloader.downloadRes(app, (List) animUrls.element, new Function1<Boolean, Unit>() { // from class: tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$downloadRes$2$1$3
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke(((Boolean) p1).booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean success) {
                                int i;
                                int i2;
                                DLCResDownloader resDownloader2;
                                if (success) {
                                    DLCDrawCardDataManager dLCDrawCardDataManager2 = DLCDrawCardDataManager.this;
                                    i = DLCDrawCardDataManager.this.resSuccCount;
                                    dLCDrawCardDataManager2.resSuccCount = i + 1;
                                    i2 = DLCDrawCardDataManager.this.resSuccCount;
                                    if (i2 == ((ArrayList) animUrls.element).size()) {
                                        CancellableContinuation<Boolean> cancellableContinuation = continuation;
                                        Result.Companion companion2 = Result.Companion;
                                        resDownloader2 = DLCDrawCardDataManager.this.getResDownloader();
                                        cancellableContinuation.resumeWith(Result.constructor-impl(Boolean.valueOf(resDownloader2.checkFilesExists((ArrayList) animUrls.element))));
                                    }
                                } else if (!failed.element) {
                                    CancellableContinuation<Boolean> cancellableContinuation2 = continuation;
                                    Result.Companion companion3 = Result.Companion;
                                    cancellableContinuation2.resumeWith(Result.constructor-impl(false));
                                    failed.element = true;
                                }
                            }
                        });
                    }
                } else {
                    Result.Companion companion2 = Result.Companion;
                    continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
                }
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            case 1:
                DLCDrawCardDataManager dLCDrawCardDataManager2 = (DLCDrawCardDataManager) this.L$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}