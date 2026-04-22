package defpackage;

import com.bilibili.lib.accounts.subscribe.Topic;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;

/* compiled from: PassPortDataSource.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"LPassPortDataSource;", "", "isLogin", "", "getPassportRx3Observable", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "getMid", "", "getAccessToken", "", "mallcommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: PassPortDataSource  reason: default package */
public interface PassPortDataSource {
    String getAccessToken();

    long getMid();

    Observable<Topic> getPassportRx3Observable();

    boolean isLogin();
}