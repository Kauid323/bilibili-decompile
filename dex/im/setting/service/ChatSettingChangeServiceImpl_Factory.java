package im.setting.service;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSettingChangeServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lim/setting/service/ChatSettingChangeServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lim/setting/service/ChatSettingChangeServiceImpl;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSettingChangeServiceImpl_Factory implements Factory<ChatSettingChangeServiceImpl> {
    private final Provider<KSessionId> sessionIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatSettingChangeServiceImpl_Factory(Provider<KSessionId> provider) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        this.sessionIdProvider = provider;
    }

    /* renamed from: get */
    public ChatSettingChangeServiceImpl m3404get() {
        Companion companion = Companion;
        Object obj = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((KSessionId) obj);
    }

    /* compiled from: ChatSettingChangeServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lim/setting/service/ChatSettingChangeServiceImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lim/setting/service/ChatSettingChangeServiceImpl_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "newInstance", "Lim/setting/service/ChatSettingChangeServiceImpl;", "sessionId", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatSettingChangeServiceImpl_Factory create(Provider<KSessionId> provider) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            return new ChatSettingChangeServiceImpl_Factory(provider);
        }

        @JvmStatic
        public final ChatSettingChangeServiceImpl newInstance(KSessionId sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return new ChatSettingChangeServiceImpl(sessionId);
        }
    }

    @JvmStatic
    public static final ChatSettingChangeServiceImpl_Factory create(Provider<KSessionId> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final ChatSettingChangeServiceImpl newInstance(KSessionId sessionId) {
        return Companion.newInstance(sessionId);
    }
}