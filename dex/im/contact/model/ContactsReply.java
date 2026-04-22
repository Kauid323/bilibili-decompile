package im.contact.model;

import com.bapis.bilibili.app.im.v1.KContactTab;
import com.bapis.bilibili.app.im.v1.KContactTab$;
import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bapis.bilibili.app.im.v1.KContactTabTypeSerializer;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KPaginationParams$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: ContactReply.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B=\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\"\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000eHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001d¨\u00063"}, d2 = {"Lim/contact/model/ContactsReply;", "", "contacts", "", "Lim/contact/model/IMContactItem;", "tab", "Lcom/bapis/bilibili/app/im/v1/KContactTab;", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "paginationParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KContactTabType;Lcom/bapis/bilibili/app/im/v1/KPaginationParams;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KContactTabType;Lcom/bapis/bilibili/app/im/v1/KPaginationParams;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContacts$annotations", "()V", "getContacts", "()Ljava/util/List;", "getTab$annotations", "getTab", "getCurrentTab$annotations", "getCurrentTab", "()Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getPaginationParams$annotations", "getPaginationParams", "()Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$contact_debug", "$serializer", "Companion", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ContactsReply {
    private final List<IMContactItem> contacts;
    private final KContactTabType currentTab;
    private final KPaginationParams paginationParams;
    private final List<KContactTab> tab;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.contact.model.ContactsReply$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ContactsReply._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.contact.model.ContactsReply$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ContactsReply._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null};

    public ContactsReply() {
        this((List) null, (List) null, (KContactTabType) null, (KPaginationParams) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContactsReply copy$default(ContactsReply contactsReply, List list, List list2, KContactTabType kContactTabType, KPaginationParams kPaginationParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = contactsReply.contacts;
        }
        if ((i2 & 2) != 0) {
            list2 = contactsReply.tab;
        }
        if ((i2 & 4) != 0) {
            kContactTabType = contactsReply.currentTab;
        }
        if ((i2 & 8) != 0) {
            kPaginationParams = contactsReply.paginationParams;
        }
        return contactsReply.copy(list, list2, kContactTabType, kPaginationParams);
    }

    @SerialName("contacts")
    @ProtoNumber(number = 1)
    @ProtoPacked
    public static /* synthetic */ void getContacts$annotations() {
    }

    @SerialName("currentTab")
    @ProtoNumber(number = 3)
    public static /* synthetic */ void getCurrentTab$annotations() {
    }

    @SerialName("paginationParams")
    @ProtoNumber(number = 4)
    public static /* synthetic */ void getPaginationParams$annotations() {
    }

    @SerialName("tab")
    @ProtoNumber(number = 2)
    @ProtoPacked
    public static /* synthetic */ void getTab$annotations() {
    }

    public final List<IMContactItem> component1() {
        return this.contacts;
    }

    public final List<KContactTab> component2() {
        return this.tab;
    }

    public final KContactTabType component3() {
        return this.currentTab;
    }

    public final KPaginationParams component4() {
        return this.paginationParams;
    }

    public final ContactsReply copy(List<IMContactItem> list, List<KContactTab> list2, KContactTabType kContactTabType, KPaginationParams kPaginationParams) {
        Intrinsics.checkNotNullParameter(list, "contacts");
        Intrinsics.checkNotNullParameter(list2, "tab");
        Intrinsics.checkNotNullParameter(kContactTabType, "currentTab");
        return new ContactsReply(list, list2, kContactTabType, kPaginationParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactsReply) {
            ContactsReply contactsReply = (ContactsReply) obj;
            return Intrinsics.areEqual(this.contacts, contactsReply.contacts) && Intrinsics.areEqual(this.tab, contactsReply.tab) && Intrinsics.areEqual(this.currentTab, contactsReply.currentTab) && Intrinsics.areEqual(this.paginationParams, contactsReply.paginationParams);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.contacts.hashCode() * 31) + this.tab.hashCode()) * 31) + this.currentTab.hashCode()) * 31) + (this.paginationParams == null ? 0 : this.paginationParams.hashCode());
    }

    public String toString() {
        List<IMContactItem> list = this.contacts;
        List<KContactTab> list2 = this.tab;
        KContactTabType kContactTabType = this.currentTab;
        return "ContactsReply(contacts=" + list + ", tab=" + list2 + ", currentTab=" + kContactTabType + ", paginationParams=" + this.paginationParams + ")";
    }

    /* compiled from: ContactReply.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/contact/model/ContactsReply$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/contact/model/ContactsReply;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ContactsReply> serializer() {
            return new GeneratedSerializer<ContactsReply>() { // from class: im.contact.model.ContactsReply$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.contact.model.ContactsReply", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<im.contact.model.ContactsReply> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<im.contact.model.ContactsReply> A[REMOVE]) =  im.contact.model.ContactsReply$$serializer.INSTANCE im.contact.model.ContactsReply$$serializer)
                         in method: im.contact.model.ContactsReply.Companion.serializer():kotlinx.serialization.KSerializer<im.contact.model.ContactsReply>, file: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1257)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("im.contact.model.ContactsReply")
                          (wrap: im.contact.model.ContactsReply$$serializer : 0x0009: SGET  (r1v0 im.contact.model.ContactsReply$$serializer A[REMOVE]) =  im.contact.model.ContactsReply$$serializer.INSTANCE im.contact.model.ContactsReply$$serializer)
                          (4 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: im.contact.model.ContactsReply$$serializer.<clinit>():void, file: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: im.contact.model.ContactsReply$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        im.contact.model.ContactsReply$$serializer r0 = im.contact.model.ContactsReply$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: im.contact.model.ContactsReply.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ ContactsReply(int seen0, List contacts, List tab, KContactTabType currentTab, KPaginationParams paginationParams, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.contacts = CollectionsKt.emptyList();
                } else {
                    this.contacts = contacts;
                }
                if ((seen0 & 2) == 0) {
                    this.tab = CollectionsKt.emptyList();
                } else {
                    this.tab = tab;
                }
                if ((seen0 & 4) == 0) {
                    this.currentTab = KContactTabType.Companion.fromValue(0);
                } else {
                    this.currentTab = currentTab;
                }
                if ((seen0 & 8) == 0) {
                    this.paginationParams = null;
                } else {
                    this.paginationParams = paginationParams;
                }
            }

            public ContactsReply(List<IMContactItem> list, List<KContactTab> list2, KContactTabType currentTab, KPaginationParams paginationParams) {
                Intrinsics.checkNotNullParameter(list, "contacts");
                Intrinsics.checkNotNullParameter(list2, "tab");
                Intrinsics.checkNotNullParameter(currentTab, "currentTab");
                this.contacts = list;
                this.tab = list2;
                this.currentTab = currentTab;
                this.paginationParams = paginationParams;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(IMContactItem$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(KContactTab$.serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$contact_debug(ContactsReply self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.contacts, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.contacts);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.tab, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.tab);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.currentTab, KContactTabType.Companion.fromValue(0))) {
                    output.encodeSerializableElement(serialDesc, 2, KContactTabTypeSerializer.INSTANCE, self.currentTab);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.paginationParams != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, KPaginationParams$.serializer.INSTANCE, self.paginationParams);
                }
            }

            public /* synthetic */ ContactsReply(List list, List list2, KContactTabType kContactTabType, KPaginationParams kPaginationParams, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4) != 0 ? KContactTabType.Companion.fromValue(0) : kContactTabType, (i2 & 8) != 0 ? null : kPaginationParams);
            }

            public final List<IMContactItem> getContacts() {
                return this.contacts;
            }

            public final List<KContactTab> getTab() {
                return this.tab;
            }

            public final KContactTabType getCurrentTab() {
                return this.currentTab;
            }

            public final KPaginationParams getPaginationParams() {
                return this.paginationParams;
            }
        }