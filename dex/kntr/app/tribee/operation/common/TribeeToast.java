package kntr.app.tribee.operation.common;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;

/* compiled from: TribeeToast.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/tribee/operation/common/TribeeToast;", "", "content", "", "ts", "", "<init>", "(Ljava/lang/String;J)V", "getContent", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeToast {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final long ts;

    private final long component2() {
        return this.ts;
    }

    public static /* synthetic */ TribeeToast copy$default(TribeeToast tribeeToast, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tribeeToast.content;
        }
        if ((i & 2) != 0) {
            j = tribeeToast.ts;
        }
        return tribeeToast.copy(str, j);
    }

    public final String component1() {
        return this.content;
    }

    public final TribeeToast copy(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new TribeeToast(str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeToast) {
            TribeeToast tribeeToast = (TribeeToast) obj;
            return Intrinsics.areEqual(this.content, tribeeToast.content) && this.ts == tribeeToast.ts;
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ts);
    }

    public String toString() {
        String str = this.content;
        return "TribeeToast(content=" + str + ", ts=" + this.ts + ")";
    }

    public TribeeToast(String content, long ts) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.ts = ts;
    }

    public final String getContent() {
        return this.content;
    }

    /* compiled from: TribeeToast.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\nJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\t¨\u0006\f"}, d2 = {"Lkntr/app/tribee/operation/common/TribeeToast$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/operation/common/TribeeToast;", "error", "", "default", "", "(Ljava/lang/Throwable;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Object create$default(Companion companion, Throwable th, String str, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            return companion.create(th, str, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
            if (r3 != null) goto L15;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object create(Throwable error, String str, Continuation<? super TribeeToast> continuation) {
            TribeeToast$Companion$create$1 tribeeToast$Companion$create$1;
            Object displayString;
            String str2;
            if (continuation instanceof TribeeToast$Companion$create$1) {
                tribeeToast$Companion$create$1 = (TribeeToast$Companion$create$1) continuation;
                if ((tribeeToast$Companion$create$1.label & Integer.MIN_VALUE) != 0) {
                    tribeeToast$Companion$create$1.label -= Integer.MIN_VALUE;
                    Object $result = tribeeToast$Companion$create$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (tribeeToast$Companion$create$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (error != null) {
                                tribeeToast$Companion$create$1.L$0 = SpillingKt.nullOutSpilledVariable(error);
                                tribeeToast$Companion$create$1.L$1 = str;
                                tribeeToast$Companion$create$1.label = 1;
                                displayString = TribeeToastKt.toDisplayString(error, str, tribeeToast$Companion$create$1);
                                if (displayString == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str2 = (String) displayString;
                                break;
                            }
                            str2 = str;
                            String msg = str2;
                            if (StringsKt.isBlank(msg)) {
                                return null;
                            }
                            return new TribeeToast(msg, Clock.System.INSTANCE.now().toEpochMilliseconds());
                        case 1:
                            str = (String) tribeeToast$Companion$create$1.L$1;
                            Throwable th = (Throwable) tribeeToast$Companion$create$1.L$0;
                            ResultKt.throwOnFailure($result);
                            displayString = $result;
                            str2 = (String) displayString;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            tribeeToast$Companion$create$1 = new TribeeToast$Companion$create$1(this, continuation);
            Object $result2 = tribeeToast$Companion$create$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (tribeeToast$Companion$create$1.label) {
            }
        }

        public final TribeeToast create(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (content.length() == 0) {
                return null;
            }
            return new TribeeToast(content, Clock.System.INSTANCE.now().toEpochMilliseconds());
        }
    }
}