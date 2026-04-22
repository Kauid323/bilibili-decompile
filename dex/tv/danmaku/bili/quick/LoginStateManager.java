package tv.danmaku.bili.quick;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: LoginStateManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u000eR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/quick/LoginStateManager;", "", "<init>", "()V", "observers", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/quick/LoginStateManager$ILoginStateObserver;", "Lkotlin/collections/ArrayList;", "addObserver", "", "l", "removeObserver", "notifyStateChanged", AuthResultCbHelper.ARGS_STATE, "", "STATE_QUICK_LOGIN", "STATE_NORMAL_LOGIN", "STATE", "ILoginStateObserver", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginStateManager {
    public static final int STATE_NORMAL_LOGIN = 2;
    public static final int STATE_QUICK_LOGIN = 1;
    public static final LoginStateManager INSTANCE = new LoginStateManager();
    private static final ArrayList<ILoginStateObserver> observers = new ArrayList<>();
    public static final int $stable = 8;

    /* compiled from: LoginStateManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/quick/LoginStateManager$ILoginStateObserver;", "", "onChange", "", AuthResultCbHelper.ARGS_STATE, "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ILoginStateObserver {
        void onChange(int i);
    }

    /* compiled from: LoginStateManager.kt */
    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ltv/danmaku/bili/quick/LoginStateManager$STATE;", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface STATE {
    }

    private LoginStateManager() {
    }

    public final void addObserver(ILoginStateObserver l) {
        Intrinsics.checkNotNullParameter(l, "l");
        observers.add(l);
    }

    public final void removeObserver(ILoginStateObserver l) {
        Intrinsics.checkNotNullParameter(l, "l");
        observers.remove(l);
    }

    public final void notifyStateChanged(int state) {
        Iterator<ILoginStateObserver> it = observers.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ILoginStateObserver next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ILoginStateObserver l = next;
            l.onChange(state);
        }
    }
}