package im.contact;

import dagger.internal.Factory;
import im.contact.service.ContactLoadService;
import im.contact.service.ContactSearchService;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactPageStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lim/contact/IMContactPageStateMachine_Factory;", "Ldagger/internal/Factory;", "Lim/contact/IMContactPageStateMachine;", "loadServiceProvider", "Ljavax/inject/Provider;", "Lim/contact/service/ContactLoadService;", "searchServiceProvider", "Lim/contact/service/ContactSearchService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactPageStateMachine_Factory implements Factory<IMContactPageStateMachine> {
    public static final Companion Companion = new Companion(null);
    private final Provider<ContactLoadService> loadServiceProvider;
    private final Provider<ContactSearchService> searchServiceProvider;

    public IMContactPageStateMachine_Factory(Provider<ContactLoadService> provider, Provider<ContactSearchService> provider2) {
        Intrinsics.checkNotNullParameter(provider, "loadServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "searchServiceProvider");
        this.loadServiceProvider = provider;
        this.searchServiceProvider = provider2;
    }

    /* renamed from: get */
    public IMContactPageStateMachine m3135get() {
        Companion companion = Companion;
        Object obj = this.loadServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.searchServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance((ContactLoadService) obj, (ContactSearchService) obj2);
    }

    /* compiled from: IMContactPageStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lim/contact/IMContactPageStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lim/contact/IMContactPageStateMachine_Factory;", "loadServiceProvider", "Ljavax/inject/Provider;", "Lim/contact/service/ContactLoadService;", "searchServiceProvider", "Lim/contact/service/ContactSearchService;", "newInstance", "Lim/contact/IMContactPageStateMachine;", "loadService", "searchService", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMContactPageStateMachine_Factory create(Provider<ContactLoadService> provider, Provider<ContactSearchService> provider2) {
            Intrinsics.checkNotNullParameter(provider, "loadServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "searchServiceProvider");
            return new IMContactPageStateMachine_Factory(provider, provider2);
        }

        @JvmStatic
        public final IMContactPageStateMachine newInstance(ContactLoadService loadService, ContactSearchService searchService) {
            Intrinsics.checkNotNullParameter(loadService, "loadService");
            Intrinsics.checkNotNullParameter(searchService, "searchService");
            return new IMContactPageStateMachine(loadService, searchService);
        }
    }

    @JvmStatic
    public static final IMContactPageStateMachine_Factory create(Provider<ContactLoadService> provider, Provider<ContactSearchService> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final IMContactPageStateMachine newInstance(ContactLoadService loadService, ContactSearchService searchService) {
        return Companion.newInstance(loadService, searchService);
    }
}