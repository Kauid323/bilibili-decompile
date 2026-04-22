package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.blens.Lens;
import faceverify.q;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: IMToast.kt */
@Lens.Ignore
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0087\u0002J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÂ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\rHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lim/base/IMToast;", "", q.KEY_RES_9_CONTENT, "", "ts", "", "<init>", "(Ljava/lang/String;J)V", "getContent$annotations", "()V", "getContent", "()Ljava/lang/String;", "compareTo", "", "other", "component1", "component2", "copy", "equals", "", "hashCode", "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMToast {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final long ts;

    public /* synthetic */ IMToast(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    private final long component2() {
        return this.ts;
    }

    private final IMToast copy(String str, long j) {
        return new IMToast(str, j);
    }

    static /* synthetic */ IMToast copy$default(IMToast iMToast, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iMToast.content;
        }
        if ((i2 & 2) != 0) {
            j = iMToast.ts;
        }
        return iMToast.copy(str, j);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public final String component1() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMToast) {
            IMToast iMToast = (IMToast) obj;
            return Intrinsics.areEqual(this.content, iMToast.content) && this.ts == iMToast.ts;
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ts);
    }

    public String toString() {
        String str = this.content;
        return "IMToast(content=" + str + ", ts=" + this.ts + ")";
    }

    private IMToast(String content, long ts) {
        this.content = content;
        this.ts = ts;
    }

    public final String getContent() {
        return this.content;
    }

    /* compiled from: IMToast.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2(\b\u0002\u0010\f\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tJ\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\u0012"}, d2 = {"Lim/base/IMToast$Companion;", "", "<init>", "()V", "create", "Lim/base/IMToast;", "error", "", "default", "", "ts", "Lkotlinx/datetime/Instant;", "extraHandler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Ljava/lang/String;Lkotlinx/datetime/Instant;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBlocking", q.KEY_RES_9_CONTENT, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
            if (r3 != null) goto L15;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object create(Throwable error, String str, Instant ts, Function2<? super Throwable, ? super Continuation<? super String>, ? extends Object> function2, Continuation<? super IMToast> continuation) {
            IMToast$Companion$create$1 iMToast$Companion$create$1;
            Object displayString;
            String str2;
            if (continuation instanceof IMToast$Companion$create$1) {
                iMToast$Companion$create$1 = (IMToast$Companion$create$1) continuation;
                if ((iMToast$Companion$create$1.label & Integer.MIN_VALUE) != 0) {
                    iMToast$Companion$create$1.label -= Integer.MIN_VALUE;
                    Object $result = iMToast$Companion$create$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (iMToast$Companion$create$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (error != null) {
                                iMToast$Companion$create$1.L$0 = SpillingKt.nullOutSpilledVariable(error);
                                iMToast$Companion$create$1.L$1 = str;
                                iMToast$Companion$create$1.L$2 = ts;
                                iMToast$Companion$create$1.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                                iMToast$Companion$create$1.label = 1;
                                displayString = IMToastKt.toDisplayString(error, str, function2, iMToast$Companion$create$1);
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
                            return new IMToast(msg, ts.toEpochMilliseconds(), null);
                        case 1:
                            Function2 function22 = (Function2) iMToast$Companion$create$1.L$3;
                            ts = (Instant) iMToast$Companion$create$1.L$2;
                            str = (String) iMToast$Companion$create$1.L$1;
                            Throwable th = (Throwable) iMToast$Companion$create$1.L$0;
                            ResultKt.throwOnFailure($result);
                            displayString = $result;
                            str2 = (String) displayString;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            iMToast$Companion$create$1 = new IMToast$Companion$create$1(this, continuation);
            Object $result2 = iMToast$Companion$create$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (iMToast$Companion$create$1.label) {
            }
        }

        public static /* synthetic */ IMToast createBlocking$default(Companion companion, Throwable th, Instant instant, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                instant = Clock.System.INSTANCE.now();
            }
            if ((i2 & 4) != 0) {
                str = "";
            }
            return companion.createBlocking(th, instant, str);
        }

        public final IMToast createBlocking(Throwable error, Instant ts, String str) {
            String msg;
            Intrinsics.checkNotNullParameter(ts, "ts");
            Intrinsics.checkNotNullParameter(str, "default");
            if (error == null || (msg = IMToastKt.toDisplayStringBlocking(error, str)) == null) {
                msg = str;
            }
            if (StringsKt.isBlank(msg)) {
                return null;
            }
            return new IMToast(msg, ts.toEpochMilliseconds(), null);
        }

        public static /* synthetic */ IMToast create$default(Companion companion, String str, Instant instant, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                instant = Clock.System.INSTANCE.now();
            }
            return companion.create(str, instant);
        }

        public final IMToast create(String content, Instant ts) {
            Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
            Intrinsics.checkNotNullParameter(ts, "ts");
            if (content.length() == 0) {
                return null;
            }
            return new IMToast(content, ts.toEpochMilliseconds(), null);
        }
    }

    public final int compareTo(IMToast other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.ts, other.ts);
    }
}