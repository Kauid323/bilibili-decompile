package io.ktor.client.plugins.cookies;

import ComposableSingletons$CustomBottomSheetKt$;
import io.ktor.client.plugins.cookies.AcceptAllCookiesStorage;
import io.ktor.http.Cookie;
import io.ktor.http.Url;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: AcceptAllCookiesStorage.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u0003*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/Function0;", "", "clock", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lio/ktor/http/Url;", "requestUrl", "", "Lio/ktor/http/Cookie;", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "()V", "timestamp", "cleanup", "(J)V", "createdAt", "maxAgeOrExpires", "(Lio/ktor/http/Cookie;J)Ljava/lang/Long;", "Lkotlin/jvm/functions/Function0;", "", "Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "container", "Ljava/util/List;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "CookieWithTimestamp", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AcceptAllCookiesStorage implements CookiesStorage {
    private final Function0<Long> clock;
    private final List<CookieWithTimestamp> container;
    private final Mutex mutex;
    private volatile /* synthetic */ long oldestCookie;

    public AcceptAllCookiesStorage() {
        this(null, 1, null);
    }

    public AcceptAllCookiesStorage(Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(function0, "clock");
        this.clock = function0;
        this.container = new ArrayList();
        this.oldestCookie = 0L;
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    public /* synthetic */ AcceptAllCookiesStorage(Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new Function0() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda2
            public final Object invoke() {
                long _init_$lambda$0;
                _init_$lambda$0 = AcceptAllCookiesStorage._init_$lambda$0();
                return Long.valueOf(_init_$lambda$0);
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _init_$lambda$0() {
        return DateJvmKt.getTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "", "Lio/ktor/http/Cookie;", "cookie", "", "createdAt", "<init>", "(Lio/ktor/http/Cookie;J)V", "component1", "()Lio/ktor/http/Cookie;", "component2", "()J", "copy", "(Lio/ktor/http/Cookie;J)Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage$CookieWithTimestamp;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/Cookie;", "getCookie", "J", "getCreatedAt", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CookieWithTimestamp {
        private final Cookie cookie;
        private final long createdAt;

        public static /* synthetic */ CookieWithTimestamp copy$default(CookieWithTimestamp cookieWithTimestamp, Cookie cookie, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                cookie = cookieWithTimestamp.cookie;
            }
            if ((i2 & 2) != 0) {
                j = cookieWithTimestamp.createdAt;
            }
            return cookieWithTimestamp.copy(cookie, j);
        }

        public final Cookie component1() {
            return this.cookie;
        }

        public final long component2() {
            return this.createdAt;
        }

        public final CookieWithTimestamp copy(Cookie cookie, long j) {
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            return new CookieWithTimestamp(cookie, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CookieWithTimestamp) {
                CookieWithTimestamp cookieWithTimestamp = (CookieWithTimestamp) obj;
                return Intrinsics.areEqual(this.cookie, cookieWithTimestamp.cookie) && this.createdAt == cookieWithTimestamp.createdAt;
            }
            return false;
        }

        public int hashCode() {
            return (this.cookie.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.createdAt);
        }

        public String toString() {
            return "CookieWithTimestamp(cookie=" + this.cookie + ", createdAt=" + this.createdAt + ')';
        }

        public CookieWithTimestamp(Cookie cookie, long createdAt) {
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.cookie = cookie;
            this.createdAt = createdAt;
        }

        public final Cookie getCookie() {
            return this.cookie;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[Catch: all -> 0x00eb, TryCatch #0 {all -> 0x00eb, blocks: (B:17:0x0064, B:19:0x0076, B:20:0x0079, B:21:0x008b, B:23:0x0091, B:25:0x00a5, B:27:0x00ab, B:28:0x00c7, B:30:0x00cd, B:31:0x00dd), top: B:37:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091 A[Catch: all -> 0x00eb, TryCatch #0 {all -> 0x00eb, blocks: (B:17:0x0064, B:19:0x0076, B:20:0x0079, B:21:0x008b, B:23:0x0091, B:25:0x00a5, B:27:0x00ab, B:28:0x00c7, B:30:0x00cd, B:31:0x00dd), top: B:37:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd A[Catch: all -> 0x00eb, LOOP:1: B:28:0x00c7->B:30:0x00cd, LOOP_END, TryCatch #0 {all -> 0x00eb, blocks: (B:17:0x0064, B:19:0x0076, B:20:0x0079, B:21:0x008b, B:23:0x0091, B:25:0x00a5, B:27:0x00ab, B:28:0x00c7, B:30:0x00cd, B:31:0x00dd), top: B:37:0x0064 }] */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object get(Url url, Continuation<? super List<Cookie>> continuation) {
        AcceptAllCookiesStorage$get$1 acceptAllCookiesStorage$get$1;
        AcceptAllCookiesStorage$get$1 acceptAllCookiesStorage$get$12;
        AcceptAllCookiesStorage acceptAllCookiesStorage;
        Url requestUrl;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        long now;
        try {
            if (continuation instanceof AcceptAllCookiesStorage$get$1) {
                acceptAllCookiesStorage$get$1 = (AcceptAllCookiesStorage$get$1) continuation;
                if ((acceptAllCookiesStorage$get$1.label & Integer.MIN_VALUE) != 0) {
                    acceptAllCookiesStorage$get$1.label -= Integer.MIN_VALUE;
                    acceptAllCookiesStorage$get$12 = acceptAllCookiesStorage$get$1;
                    Object $result = acceptAllCookiesStorage$get$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (acceptAllCookiesStorage$get$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            acceptAllCookiesStorage = this;
                            requestUrl = url;
                            $this$withLock_u24default$iv = acceptAllCookiesStorage.mutex;
                            owner$iv = null;
                            acceptAllCookiesStorage$get$12.L$0 = acceptAllCookiesStorage;
                            acceptAllCookiesStorage$get$12.L$1 = requestUrl;
                            acceptAllCookiesStorage$get$12.L$2 = $this$withLock_u24default$iv;
                            acceptAllCookiesStorage$get$12.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, acceptAllCookiesStorage$get$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) acceptAllCookiesStorage$get$12.L$2;
                            requestUrl = (Url) acceptAllCookiesStorage$get$12.L$1;
                            acceptAllCookiesStorage = (AcceptAllCookiesStorage) acceptAllCookiesStorage$get$12.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z = false;
                    now = ((Number) acceptAllCookiesStorage.clock.invoke()).longValue();
                    if (now >= acceptAllCookiesStorage.oldestCookie) {
                        acceptAllCookiesStorage.cleanup(now);
                    }
                    Iterable $this$filterTo$iv$iv = acceptAllCookiesStorage.container;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        CookieWithTimestamp it = (CookieWithTimestamp) element$iv$iv;
                        boolean z2 = z;
                        if (CookiesStorageKt.matches(it.getCookie(), requestUrl)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        z = z2;
                    }
                    Iterable $this$map$iv = (List) destination$iv$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        CookieWithTimestamp it2 = (CookieWithTimestamp) item$iv$iv;
                        destination$iv$iv2.add(it2.getCookie());
                    }
                    return (List) destination$iv$iv2;
                }
            }
            now = ((Number) acceptAllCookiesStorage.clock.invoke()).longValue();
            if (now >= acceptAllCookiesStorage.oldestCookie) {
            }
            Iterable $this$filterTo$iv$iv2 = acceptAllCookiesStorage.container;
            Collection destination$iv$iv3 = new ArrayList();
            while (r13.hasNext()) {
            }
            Iterable $this$map$iv2 = (List) destination$iv$iv3;
            Collection destination$iv$iv22 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            while (r11.hasNext()) {
            }
            return (List) destination$iv$iv22;
        } finally {
            $this$withLock_u24default$iv.unlock(owner$iv);
        }
        acceptAllCookiesStorage$get$1 = new AcceptAllCookiesStorage$get$1(this, continuation);
        acceptAllCookiesStorage$get$12 = acceptAllCookiesStorage$get$1;
        Object $result2 = acceptAllCookiesStorage$get$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (acceptAllCookiesStorage$get$12.label) {
        }
        boolean z3 = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[Catch: all -> 0x00bf, TryCatch #0 {all -> 0x00bf, blocks: (B:22:0x0076, B:24:0x00a1, B:26:0x00af, B:27:0x00b1), top: B:33:0x0076 }] */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addCookie(Url url, Cookie cookie, Continuation<? super Unit> continuation) {
        AcceptAllCookiesStorage$addCookie$1 acceptAllCookiesStorage$addCookie$1;
        AcceptAllCookiesStorage acceptAllCookiesStorage;
        final Cookie cookie2;
        final Url requestUrl;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv;
        Long maxAgeOrExpires;
        try {
            if (continuation instanceof AcceptAllCookiesStorage$addCookie$1) {
                acceptAllCookiesStorage$addCookie$1 = (AcceptAllCookiesStorage$addCookie$1) continuation;
                if ((acceptAllCookiesStorage$addCookie$1.label & Integer.MIN_VALUE) != 0) {
                    acceptAllCookiesStorage$addCookie$1.label -= Integer.MIN_VALUE;
                    Object $result = acceptAllCookiesStorage$addCookie$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (acceptAllCookiesStorage$addCookie$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            acceptAllCookiesStorage = this;
                            cookie2 = cookie;
                            requestUrl = url;
                            if (!StringsKt.isBlank(cookie2.getName())) {
                                Mutex $this$withLock_u24default$iv2 = acceptAllCookiesStorage.mutex;
                                owner$iv = null;
                                acceptAllCookiesStorage$addCookie$1.L$0 = acceptAllCookiesStorage;
                                acceptAllCookiesStorage$addCookie$1.L$1 = requestUrl;
                                acceptAllCookiesStorage$addCookie$1.L$2 = cookie2;
                                acceptAllCookiesStorage$addCookie$1.L$3 = $this$withLock_u24default$iv2;
                                acceptAllCookiesStorage$addCookie$1.label = 1;
                                if ($this$withLock_u24default$iv2.lock((Object) null, acceptAllCookiesStorage$addCookie$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                break;
                            } else {
                                return Unit.INSTANCE;
                            }
                        case 1:
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) acceptAllCookiesStorage$addCookie$1.L$3;
                            cookie2 = (Cookie) acceptAllCookiesStorage$addCookie$1.L$2;
                            requestUrl = (Url) acceptAllCookiesStorage$addCookie$1.L$1;
                            acceptAllCookiesStorage = (AcceptAllCookiesStorage) acceptAllCookiesStorage$addCookie$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CollectionsKt.removeAll(acceptAllCookiesStorage.container, new Function1() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            boolean addCookie$lambda$7$lambda$5;
                            addCookie$lambda$7$lambda$5 = AcceptAllCookiesStorage.addCookie$lambda$7$lambda$5(Cookie.this, requestUrl, (AcceptAllCookiesStorage.CookieWithTimestamp) obj);
                            return Boolean.valueOf(addCookie$lambda$7$lambda$5);
                        }
                    });
                    long createdAt = ((Number) acceptAllCookiesStorage.clock.invoke()).longValue();
                    acceptAllCookiesStorage.container.add(new CookieWithTimestamp(CookiesStorageKt.fillDefaults(cookie2, requestUrl), createdAt));
                    maxAgeOrExpires = acceptAllCookiesStorage.maxAgeOrExpires(cookie2, createdAt);
                    if (maxAgeOrExpires != null) {
                        long it = maxAgeOrExpires.longValue();
                        if (acceptAllCookiesStorage.oldestCookie > it) {
                            acceptAllCookiesStorage.oldestCookie = it;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return Unit.INSTANCE;
                }
            }
            CollectionsKt.removeAll(acceptAllCookiesStorage.container, new Function1() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    boolean addCookie$lambda$7$lambda$5;
                    addCookie$lambda$7$lambda$5 = AcceptAllCookiesStorage.addCookie$lambda$7$lambda$5(Cookie.this, requestUrl, (AcceptAllCookiesStorage.CookieWithTimestamp) obj);
                    return Boolean.valueOf(addCookie$lambda$7$lambda$5);
                }
            });
            long createdAt2 = ((Number) acceptAllCookiesStorage.clock.invoke()).longValue();
            acceptAllCookiesStorage.container.add(new CookieWithTimestamp(CookiesStorageKt.fillDefaults(cookie2, requestUrl), createdAt2));
            maxAgeOrExpires = acceptAllCookiesStorage.maxAgeOrExpires(cookie2, createdAt2);
            if (maxAgeOrExpires != null) {
            }
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
        acceptAllCookiesStorage$addCookie$1 = new AcceptAllCookiesStorage$addCookie$1(this, continuation);
        Object $result2 = acceptAllCookiesStorage$addCookie$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (acceptAllCookiesStorage$addCookie$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addCookie$lambda$7$lambda$5(Cookie $cookie, Url $requestUrl, CookieWithTimestamp cookieWithTimestamp) {
        Intrinsics.checkNotNullParameter(cookieWithTimestamp, "<destruct>");
        Cookie existingCookie = cookieWithTimestamp.component1();
        return Intrinsics.areEqual(existingCookie.getName(), $cookie.getName()) && CookiesStorageKt.matches(existingCookie, $requestUrl);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    private final void cleanup(final long timestamp) {
        CollectionsKt.removeAll(this.container, new Function1() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean cleanup$lambda$8;
                cleanup$lambda$8 = AcceptAllCookiesStorage.cleanup$lambda$8(AcceptAllCookiesStorage.this, timestamp, (AcceptAllCookiesStorage.CookieWithTimestamp) obj);
                return Boolean.valueOf(cleanup$lambda$8);
            }
        });
        Iterable $this$fold$iv = this.container;
        int $i$f$fold = 0;
        long accumulator$iv = Long.MAX_VALUE;
        for (Object element$iv : $this$fold$iv) {
            CookieWithTimestamp cookieWithTimestamp = (CookieWithTimestamp) element$iv;
            long acc = accumulator$iv;
            Cookie cookie = cookieWithTimestamp.component1();
            Iterable $this$fold$iv2 = $this$fold$iv;
            int $i$f$fold2 = $i$f$fold;
            long createdAt = cookieWithTimestamp.component2();
            Long maxAgeOrExpires = maxAgeOrExpires(cookie, createdAt);
            if (maxAgeOrExpires != null) {
                long it = maxAgeOrExpires.longValue();
                acc = Math.min(acc, it);
            }
            accumulator$iv = acc;
            $this$fold$iv = $this$fold$iv2;
            $i$f$fold = $i$f$fold2;
        }
        long newOldest = accumulator$iv;
        this.oldestCookie = newOldest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanup$lambda$8(AcceptAllCookiesStorage this$0, long $timestamp, CookieWithTimestamp cookieWithTimestamp) {
        Intrinsics.checkNotNullParameter(cookieWithTimestamp, "<destruct>");
        Cookie cookie = cookieWithTimestamp.component1();
        long createdAt = cookieWithTimestamp.component2();
        Long maxAgeOrExpires = this$0.maxAgeOrExpires(cookie, createdAt);
        if (maxAgeOrExpires != null) {
            long expires = maxAgeOrExpires.longValue();
            return expires < $timestamp;
        }
        return false;
    }

    private final Long maxAgeOrExpires(Cookie $this$maxAgeOrExpires, long createdAt) {
        Integer maxAgeInt = $this$maxAgeOrExpires.getMaxAgeInt();
        if (maxAgeInt != null) {
            int it = maxAgeInt.intValue();
            return Long.valueOf((it * 1000) + createdAt);
        }
        GMTDate expires = $this$maxAgeOrExpires.getExpires();
        if (expires != null) {
            return Long.valueOf(expires.getTimestamp());
        }
        return null;
    }
}