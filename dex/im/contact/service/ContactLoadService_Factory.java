package im.contact.service;

import dagger.internal.Factory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ContactLoadService_Factory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lim/contact/service/ContactLoadService_Factory;", "Ldagger/internal/Factory;", "Lim/contact/service/ContactLoadService;", "<init>", "()V", "get", "Companion", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContactLoadService_Factory implements Factory<ContactLoadService> {
    public static final Companion Companion = new Companion(null);
    private static final ContactLoadService_Factory INSTANCE = new ContactLoadService_Factory();

    /* renamed from: get */
    public ContactLoadService m3161get() {
        return Companion.newInstance();
    }

    /* compiled from: ContactLoadService_Factory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lim/contact/service/ContactLoadService_Factory$Companion;", "", "<init>", "()V", "INSTANCE", "Lim/contact/service/ContactLoadService_Factory;", "create", "newInstance", "Lim/contact/service/ContactLoadService;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ContactLoadService_Factory create() {
            return ContactLoadService_Factory.INSTANCE;
        }

        @JvmStatic
        public final ContactLoadService newInstance() {
            return new ContactLoadService();
        }
    }

    @JvmStatic
    public static final ContactLoadService_Factory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final ContactLoadService newInstance() {
        return Companion.newInstance();
    }
}