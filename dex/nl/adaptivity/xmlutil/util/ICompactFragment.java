package nl.adaptivity.xmlutil.util;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import nl.adaptivity.xmlutil.IterableNamespaceContext;
import nl.adaptivity.xmlutil.XmlReader;
import nl.adaptivity.xmlutil.XmlSerializable;

/* compiled from: ICompactFragment.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\b\u0010\u0014\u001a\u00020\u0015H&R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/util/ICompactFragment;", "Lnl/adaptivity/xmlutil/XmlSerializable;", "isEmpty", "", "isEmpty$annotations", "()V", "()Z", "namespaces", "Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "getNamespaces", "()Lnl/adaptivity/xmlutil/IterableNamespaceContext;", "content", "", "getContent$annotations", "getContent", "()[C", "contentString", "", "getContentString", "()Ljava/lang/String;", "getXmlReader", "Lnl/adaptivity/xmlutil/XmlReader;", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = ICompactFragmentSerializer.class)
public interface ICompactFragment extends XmlSerializable {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ICompactFragment.kt */
    /* renamed from: nl.adaptivity.xmlutil.util.ICompactFragment$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = ICompactFragment.Companion;
        }

        @Transient
        public static /* synthetic */ void getContent$annotations() {
        }

        @Transient
        public static /* synthetic */ void isEmpty$annotations() {
        }
    }

    char[] getContent();

    String getContentString();

    IterableNamespaceContext getNamespaces();

    XmlReader getXmlReader();

    boolean isEmpty();

    /* compiled from: ICompactFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lnl/adaptivity/xmlutil/util/ICompactFragment$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnl/adaptivity/xmlutil/util/ICompactFragment;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<ICompactFragment> serializer() {
            return ICompactFragmentSerializer.INSTANCE;
        }
    }
}