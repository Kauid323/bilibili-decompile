package kntr.common.komponent;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J?\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\b\u000fH&JJ\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142'\u0010\u0015\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016¢\u0006\u0002\b\u000fH&¢\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\b\u000fH&J%\u0010\u001a\u001a\u00020\u00002\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\b\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lkntr/common/komponent/KomponentHostScope;", "Lkntr/common/komponent/KomponentLocalAccessScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "embed", "Lkntr/common/komponent/UiComposableLike;", "S", "child", "Lkntr/common/komponent/Komponent;", "provideLocals", "Lkotlin/Function1;", "Lkntr/common/komponent/ProvideLocalsScope;", "", "Lkotlin/ExtensionFunctionType;", "launch", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)V", "__sub", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface KomponentHostScope extends KomponentLocalAccessScope {
    KomponentHostScope __sub(Function1<? super ProvideLocalsScope, Unit> function1);

    KomponentHostScope __sub(CoroutineScope coroutineScope, Function1<? super ProvideLocalsScope, Unit> function1);

    <S> UiComposableLike<S> embed(Komponent<? extends S> komponent, Function1<? super ProvideLocalsScope, Unit> function1);

    CoroutineScope getCoroutineScope();

    void launch(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2);

    /* compiled from: Komponent.kt */
    /* renamed from: kntr.common.komponent.KomponentHostScope$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UiComposableLike embed$default(KomponentHostScope komponentHostScope, Komponent komponent, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function1 = null;
                }
                return komponentHostScope.embed(komponent, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: embed");
        }

        public static /* synthetic */ void launch$default(KomponentHostScope komponentHostScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
            }
            if ((i & 1) != 0) {
                coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
            }
            if ((i & 2) != 0) {
                coroutineStart = CoroutineStart.DEFAULT;
            }
            komponentHostScope.launch(coroutineContext, coroutineStart, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ KomponentHostScope __sub$default(KomponentHostScope komponentHostScope, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function1 = null;
                }
                return komponentHostScope.__sub(coroutineScope, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: __sub");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ KomponentHostScope __sub$default(KomponentHostScope komponentHostScope, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = null;
                }
                return komponentHostScope.__sub(function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: __sub");
        }
    }

    /* compiled from: Komponent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}