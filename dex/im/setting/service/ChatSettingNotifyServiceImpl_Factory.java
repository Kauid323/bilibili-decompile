package im.setting.service;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSettingNotifyServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lim/setting/service/ChatSettingNotifyServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lim/setting/service/ChatSettingNotifyServiceImpl;", "sessionIDProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSettingNotifyServiceImpl_Factory implements Factory<ChatSettingNotifyServiceImpl> {
    private final Provider<KSessionId> sessionIDProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatSettingNotifyServiceImpl_Factory(Provider<KSessionId> provider) {
        Intrinsics.checkNotNullParameter(provider, "sessionIDProvider");
        this.sessionIDProvider = provider;
    }

    /* renamed from: get */
    public ChatSettingNotifyServiceImpl m3405get() {
        Companion companion = Companion;
        Object obj = this.sessionIDProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((KSessionId) obj);
    }

    /* compiled from: ChatSettingNotifyServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lim/setting/service/ChatSettingNotifyServiceImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lim/setting/service/ChatSettingNotifyServiceImpl_Factory;", "sessionIDProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "newInstance", "Lim/setting/service/ChatSettingNotifyServiceImpl;", "sessionID", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatSettingNotifyServiceImpl_Factory create(Provider<KSessionId> provider) {
            Intrinsics.checkNotNullParameter(provider, "sessionIDProvider");
            return new ChatSettingNotifyServiceImpl_Factory(provider);
        }

        @JvmStatic
        public final ChatSettingNotifyServiceImpl newInstance(KSessionId sessionID) {
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            return new ChatSettingNotifyServiceImpl(sessionID);
        }
    }

    @JvmStatic
    public static final ChatSettingNotifyServiceImpl_Factory create(Provider<KSessionId> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final ChatSettingNotifyServiceImpl newInstance(KSessionId sessionID) {
        return Companion.newInstance(sessionID);
    }
}