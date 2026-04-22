package tv.danmaku.bili.bilow.domain;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.bilow.domain.model.DomainList;
import tv.danmaku.bili.bilow.ignet.util.IgExceptionKt;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: MultiApiDomain.kt */
@Deprecated(message = "Using MultiDomainInterceptor")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/bilow/domain/MultiApiDomain;", "Lokhttp3/Interceptor;", "<init>", "()V", "alter", "", "domains", "", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "proceed", "request", "Lokhttp3/Request;", "getAlterHost", "setAlterHost", "", ReportEvent.Tag.HOST, "isApiMultiDomainEnabled", "", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "r", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "kotlin.jvm.PlatformType", "w", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MultiApiDomain implements Interceptor {
    private String alter;
    private final List<String> domains;
    private final ReentrantReadWriteLock lock;
    private final ReentrantReadWriteLock.ReadLock r;
    private final ReentrantReadWriteLock.WriteLock w;

    public MultiApiDomain() {
        DomainList.Companion companion = DomainList.Companion;
        String apiMultiDomain = MultiDomainConfig.INSTANCE.getApiMultiDomain();
        List<String> parseDomain = companion.parseDomain(apiMultiDomain == null ? MultiDomainConfig.API_MULTI_DOMAIN : apiMultiDomain);
        this.domains = parseDomain == null ? CollectionsKt.emptyList() : parseDomain;
        this.lock = new ReentrantReadWriteLock();
        this.r = this.lock.readLock();
        this.w = this.lock.writeLock();
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpUrl url = request.url();
        if (StringsKt.equals("api.bilibili.com", url.host(), true) && isApiMultiDomainEnabled()) {
            Intrinsics.checkNotNull(request);
            return proceed(chain, request);
        }
        Response proceed = chain.proceed(request);
        Intrinsics.checkNotNull(proceed);
        return proceed;
    }

    private final Response proceed(Interceptor.Chain chain, Request request) {
        Exception lastException;
        Request request2 = request;
        String alternativeHost = getAlterHost();
        if (alternativeHost != null) {
            HttpUrl newUrl = request.url().newBuilder().host(alternativeHost).build();
            Request build = request.newBuilder().url(newUrl).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            request2 = build;
        }
        String lastHost = null;
        int i = 0;
        do {
            try {
                Response proceed = chain.proceed(request2);
                if (lastHost != null) {
                    String host = request2.url().host();
                    Intrinsics.checkNotNullExpressionValue(host, "host(...)");
                    setAlterHost(host);
                }
                Intrinsics.checkNotNull(proceed);
                return proceed;
            } catch (IOException e) {
                lastException = e;
                if ((e instanceof ConnectException) || (e instanceof SocketTimeoutException) || IgExceptionKt.ignetShouldTryDomainDowngrade(e)) {
                    lastHost = request2.url().host();
                    if (i < this.domains.size() - 1) {
                        i++;
                        HttpUrl backupUrl = request2.url().newBuilder().host(this.domains.get(i)).build();
                        Request build2 = request2.newBuilder().url(backupUrl).build();
                        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
                        request2 = build2;
                        if (i >= this.domains.size()) {
                            throw lastException;
                        }
                    }
                }
                throw e;
            }
        } while (i >= this.domains.size());
        throw lastException;
    }

    private final String getAlterHost() {
        ReentrantReadWriteLock.ReadLock readLock = this.r;
        Intrinsics.checkNotNullExpressionValue(readLock, "r");
        ReentrantReadWriteLock.ReadLock readLock2 = readLock;
        readLock2.lock();
        try {
            return this.alter;
        } finally {
            readLock2.unlock();
        }
    }

    private final void setAlterHost(String host) {
        ReentrantReadWriteLock.ReadLock readLock = this.r;
        Intrinsics.checkNotNullExpressionValue(readLock, "r");
        ReentrantReadWriteLock.WriteLock writeLock = readLock;
        writeLock.lock();
        try {
            if (Intrinsics.areEqual(host, this.alter)) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            writeLock.unlock();
            ReentrantReadWriteLock.WriteLock writeLock2 = this.w;
            Intrinsics.checkNotNullExpressionValue(writeLock2, "w");
            writeLock2.lock();
            try {
                this.alter = host;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        } finally {
        }
    }

    private final boolean isApiMultiDomainEnabled() {
        Boolean apiMultiDomainEnabled = MultiDomainConfig.INSTANCE.getApiMultiDomainEnabled();
        if (apiMultiDomainEnabled != null) {
            return apiMultiDomainEnabled.booleanValue();
        }
        return true;
    }
}