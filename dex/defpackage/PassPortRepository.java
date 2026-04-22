package defpackage;

import com.bilibili.base.Applications;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PassPortRepository.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"LPassPortRepository;", "LPassPortDataSource;", "<init>", "()V", "passportRx3Subject", "Lio/reactivex/rxjava3/subjects/BehaviorSubject;", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "getPassportRx3Subject", "()Lio/reactivex/rxjava3/subjects/BehaviorSubject;", "passportRx3Subject$delegate", "Lkotlin/Lazy;", "account", "Lcom/bilibili/lib/accounts/BiliAccounts;", "getAccount", "()Lcom/bilibili/lib/accounts/BiliAccounts;", "account$delegate", "isLogin", "", "getPassportRx3Observable", "Lio/reactivex/rxjava3/core/Observable;", "getMid", "", "getAccessToken", "", "mallcommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: PassPortRepository  reason: default package */
public final class PassPortRepository implements PassPortDataSource {
    public static final PassPortRepository INSTANCE = new PassPortRepository();
    private static final Lazy passportRx3Subject$delegate = LazyKt.lazy(new Function0() { // from class: PassPortRepository$$ExternalSyntheticLambda0
        public final Object invoke() {
            BehaviorSubject passportRx3Subject_delegate$lambda$0;
            passportRx3Subject_delegate$lambda$0 = PassPortRepository.passportRx3Subject_delegate$lambda$0();
            return passportRx3Subject_delegate$lambda$0;
        }
    });
    private static final Lazy account$delegate = LazyKt.lazy(new Function0() { // from class: PassPortRepository$$ExternalSyntheticLambda1
        public final Object invoke() {
            BiliAccounts account_delegate$lambda$0;
            account_delegate$lambda$0 = PassPortRepository.account_delegate$lambda$0();
            return account_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private PassPortRepository() {
    }

    private final BehaviorSubject<Topic> getPassportRx3Subject() {
        return (BehaviorSubject) passportRx3Subject$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BehaviorSubject passportRx3Subject_delegate$lambda$0() {
        Topic topic;
        if (INSTANCE.getAccount().isLogin()) {
            topic = Topic.SIGN_IN;
        } else {
            topic = Topic.SIGN_OUT;
        }
        final BehaviorSubject subject = BehaviorSubject.createDefault(topic);
        Intrinsics.checkNotNullExpressionValue(subject, "createDefault(...)");
        INSTANCE.getAccount().subscribeAllWithSwitch(new PassportObserver() { // from class: PassPortRepository$$ExternalSyntheticLambda2
            public final void onChange(Topic topic2) {
                subject.onNext(topic2);
            }
        });
        return subject;
    }

    private final BiliAccounts getAccount() {
        Object value = account$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (BiliAccounts) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliAccounts account_delegate$lambda$0() {
        return BiliAccounts.get(Applications.getCurrent());
    }

    @Override // defpackage.PassPortDataSource
    public boolean isLogin() {
        return getAccount().isLogin();
    }

    @Override // defpackage.PassPortDataSource
    public Observable<Topic> getPassportRx3Observable() {
        Observable<Topic> distinctUntilChanged = getPassportRx3Subject().distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(...)");
        return distinctUntilChanged;
    }

    @Override // defpackage.PassPortDataSource
    public long getMid() {
        return getAccount().mid();
    }

    @Override // defpackage.PassPortDataSource
    public String getAccessToken() {
        return getAccount().getAccessKey();
    }
}