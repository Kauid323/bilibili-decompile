package kntr.app.tribee.consume.viewmodel;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortType;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: TribeeHomeStateAction.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0010\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0016\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\b0\u0007H\u0016\u0082\u0001\u0010\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(¨\u0006)À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "", "needCheckLogin", "", "needCheckPermission", "beObserved", "conflictedActionClassSet", "", "Lkotlin/reflect/KClass;", "Refresh", "FetchCategory", "Initial", "LoadMore", "ToJoinCandidatePool", "ToJoinTribeeByInviteCode", "ToJoinTribee", "ToExitTribee", "GoToPublish", "AwaitPublishResult", "AwaitSteamBindResult", "ReportNotification", "SwitchSubarea", "InsertFakeDyn", "SwitchRevisitSettings", "SwitchSortType", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$AwaitPublishResult;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$AwaitSteamBindResult;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$FetchCategory;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$GoToPublish;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$Initial;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$InsertFakeDyn;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$LoadMore;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$Refresh;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ReportNotification;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchRevisitSettings;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchSortType;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchSubarea;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToExitTribee;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinCandidatePool;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinTribee;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinTribeeByInviteCode;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeHomeStateAction {
    boolean beObserved();

    Set<KClass<? extends TribeeHomeStateAction>> conflictedActionClassSet();

    boolean needCheckLogin();

    boolean needCheckPermission();

    /* compiled from: TribeeHomeStateAction.kt */
    /* renamed from: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$needCheckLogin(TribeeHomeStateAction _this) {
            return false;
        }

        public static boolean $default$needCheckPermission(TribeeHomeStateAction _this) {
            return false;
        }

        public static boolean $default$beObserved(TribeeHomeStateAction _this) {
            return false;
        }

        public static Set $default$conflictedActionClassSet(TribeeHomeStateAction _this) {
            return SetsKt.emptySet();
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean needCheckLogin(TribeeHomeStateAction $this) {
            return CC.$default$needCheckLogin($this);
        }

        @Deprecated
        public static boolean needCheckPermission(TribeeHomeStateAction $this) {
            return CC.$default$needCheckPermission($this);
        }

        @Deprecated
        public static boolean beObserved(TribeeHomeStateAction $this) {
            return CC.$default$beObserved($this);
        }

        @Deprecated
        public static Set<KClass<? extends TribeeHomeStateAction>> conflictedActionClassSet(TribeeHomeStateAction $this) {
            return CC.$default$conflictedActionClassSet($this);
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b0\nH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$Refresh;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "showIndicator", "", "<init>", "(Z)V", "getShowIndicator", "()Z", "beObserved", "conflictedActionClassSet", "", "Lkotlin/reflect/KClass;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Refresh implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final boolean showIndicator;

        public Refresh() {
            this(false, 1, null);
        }

        public static /* synthetic */ Refresh copy$default(Refresh refresh, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = refresh.showIndicator;
            }
            return refresh.copy(z);
        }

        public final boolean component1() {
            return this.showIndicator;
        }

        public final Refresh copy(boolean z) {
            return new Refresh(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Refresh) && this.showIndicator == ((Refresh) obj).showIndicator;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showIndicator);
        }

        public String toString() {
            return "Refresh(showIndicator=" + this.showIndicator + ")";
        }

        public Refresh(boolean showIndicator) {
            this.showIndicator = showIndicator;
        }

        public /* synthetic */ Refresh(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final boolean getShowIndicator() {
            return this.showIndicator;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean beObserved() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public Set<KClass<? extends TribeeHomeStateAction>> conflictedActionClassSet() {
            return SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(LoadMore.class), Reflection.getOrCreateKotlinClass(FetchCategory.class)});
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f0\u000bH\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$FetchCategory;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "categoryId", "", "<init>", "(J)V", "getCategoryId", "()J", "beObserved", "", "conflictedActionClassSet", "", "Lkotlin/reflect/KClass;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FetchCategory implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final long categoryId;

        public static /* synthetic */ FetchCategory copy$default(FetchCategory fetchCategory, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = fetchCategory.categoryId;
            }
            return fetchCategory.copy(j);
        }

        public final long component1() {
            return this.categoryId;
        }

        public final FetchCategory copy(long j) {
            return new FetchCategory(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FetchCategory) && this.categoryId == ((FetchCategory) obj).categoryId;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.categoryId);
        }

        public String toString() {
            return "FetchCategory(categoryId=" + this.categoryId + ")";
        }

        public FetchCategory(long categoryId) {
            this.categoryId = categoryId;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final long getCategoryId() {
            return this.categoryId;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean beObserved() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public Set<KClass<? extends TribeeHomeStateAction>> conflictedActionClassSet() {
            return SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(LoadMore.class), Reflection.getOrCreateKotlinClass(Refresh.class)});
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$Initial;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Initial implements TribeeHomeStateAction {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initial) {
                Initial initial = (Initial) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1815317106;
        }

        public String toString() {
            return "Initial";
        }

        private Initial() {
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.Initial.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f0\u000bH\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$LoadMore;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "categoryId", "", "<init>", "(J)V", "getCategoryId", "()J", "beObserved", "", "conflictedActionClassSet", "", "Lkotlin/reflect/KClass;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadMore implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final long categoryId;

        public static /* synthetic */ LoadMore copy$default(LoadMore loadMore, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = loadMore.categoryId;
            }
            return loadMore.copy(j);
        }

        public final long component1() {
            return this.categoryId;
        }

        public final LoadMore copy(long j) {
            return new LoadMore(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadMore) && this.categoryId == ((LoadMore) obj).categoryId;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.categoryId);
        }

        public String toString() {
            return "LoadMore(categoryId=" + this.categoryId + ")";
        }

        public LoadMore(long categoryId) {
            this.categoryId = categoryId;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final long getCategoryId() {
            return this.categoryId;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean beObserved() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public Set<KClass<? extends TribeeHomeStateAction>> conflictedActionClassSet() {
            return SetsKt.setOf(new KClass[]{Reflection.getOrCreateKotlinClass(Refresh.class), Reflection.getOrCreateKotlinClass(FetchCategory.class)});
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinCandidatePool;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "<init>", "()V", "needCheckLogin", "", "needCheckPermission", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToJoinCandidatePool implements TribeeHomeStateAction {
        public static final int $stable = 0;
        public static final ToJoinCandidatePool INSTANCE = new ToJoinCandidatePool();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToJoinCandidatePool) {
                ToJoinCandidatePool toJoinCandidatePool = (ToJoinCandidatePool) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1335737020;
        }

        public String toString() {
            return "ToJoinCandidatePool";
        }

        private ToJoinCandidatePool() {
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.ToJoinCandidatePool.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckLogin() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckPermission() {
            return false;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinTribeeByInviteCode;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "inviteCode", "", "<init>", "(Ljava/lang/String;)V", "getInviteCode", "()Ljava/lang/String;", "needCheckLogin", "", "needCheckPermission", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToJoinTribeeByInviteCode implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final String inviteCode;

        public static /* synthetic */ ToJoinTribeeByInviteCode copy$default(ToJoinTribeeByInviteCode toJoinTribeeByInviteCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = toJoinTribeeByInviteCode.inviteCode;
            }
            return toJoinTribeeByInviteCode.copy(str);
        }

        public final String component1() {
            return this.inviteCode;
        }

        public final ToJoinTribeeByInviteCode copy(String str) {
            Intrinsics.checkNotNullParameter(str, "inviteCode");
            return new ToJoinTribeeByInviteCode(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToJoinTribeeByInviteCode) && Intrinsics.areEqual(this.inviteCode, ((ToJoinTribeeByInviteCode) obj).inviteCode);
        }

        public int hashCode() {
            return this.inviteCode.hashCode();
        }

        public String toString() {
            return "ToJoinTribeeByInviteCode(inviteCode=" + this.inviteCode + ")";
        }

        public ToJoinTribeeByInviteCode(String inviteCode) {
            Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
            this.inviteCode = inviteCode;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.ToJoinTribeeByInviteCode.conflictedActionClassSet():java.util.Set");
        }

        public final String getInviteCode() {
            return this.inviteCode;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckLogin() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckPermission() {
            return false;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinTribee;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "<init>", "()V", "needCheckLogin", "", "needCheckPermission", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToJoinTribee implements TribeeHomeStateAction {
        public static final int $stable = 0;
        public static final ToJoinTribee INSTANCE = new ToJoinTribee();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToJoinTribee) {
                ToJoinTribee toJoinTribee = (ToJoinTribee) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2121980526;
        }

        public String toString() {
            return "ToJoinTribee";
        }

        private ToJoinTribee() {
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.ToJoinTribee.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckLogin() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckPermission() {
            return true;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToExitTribee;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "<init>", "()V", "needCheckLogin", "", "needCheckPermission", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToExitTribee implements TribeeHomeStateAction {
        public static final int $stable = 0;
        public static final ToExitTribee INSTANCE = new ToExitTribee();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToExitTribee) {
                ToExitTribee toExitTribee = (ToExitTribee) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 803420806;
        }

        public String toString() {
            return "ToExitTribee";
        }

        private ToExitTribee() {
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.ToExitTribee.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckLogin() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckPermission() {
            return true;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$GoToPublish;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "resultKey", "", "<init>", "(Ljava/lang/String;)V", "getResultKey", "()Ljava/lang/String;", "needCheckLogin", "", "needCheckPermission", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class GoToPublish implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final String resultKey;

        public static /* synthetic */ GoToPublish copy$default(GoToPublish goToPublish, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = goToPublish.resultKey;
            }
            return goToPublish.copy(str);
        }

        public final String component1() {
            return this.resultKey;
        }

        public final GoToPublish copy(String str) {
            Intrinsics.checkNotNullParameter(str, "resultKey");
            return new GoToPublish(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GoToPublish) && Intrinsics.areEqual(this.resultKey, ((GoToPublish) obj).resultKey);
        }

        public int hashCode() {
            return this.resultKey.hashCode();
        }

        public String toString() {
            return "GoToPublish(resultKey=" + this.resultKey + ")";
        }

        public GoToPublish(String resultKey) {
            Intrinsics.checkNotNullParameter(resultKey, "resultKey");
            this.resultKey = resultKey;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.GoToPublish.conflictedActionClassSet():java.util.Set");
        }

        public final String getResultKey() {
            return this.resultKey;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckLogin() {
            return true;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public boolean needCheckPermission() {
            return true;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$AwaitPublishResult;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "resultKey", "", "<init>", "(Ljava/lang/String;)V", "getResultKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AwaitPublishResult implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final String resultKey;

        public static /* synthetic */ AwaitPublishResult copy$default(AwaitPublishResult awaitPublishResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = awaitPublishResult.resultKey;
            }
            return awaitPublishResult.copy(str);
        }

        public final String component1() {
            return this.resultKey;
        }

        public final AwaitPublishResult copy(String str) {
            Intrinsics.checkNotNullParameter(str, "resultKey");
            return new AwaitPublishResult(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AwaitPublishResult) && Intrinsics.areEqual(this.resultKey, ((AwaitPublishResult) obj).resultKey);
        }

        public int hashCode() {
            return this.resultKey.hashCode();
        }

        public String toString() {
            return "AwaitPublishResult(resultKey=" + this.resultKey + ")";
        }

        public AwaitPublishResult(String resultKey) {
            Intrinsics.checkNotNullParameter(resultKey, "resultKey");
            this.resultKey = resultKey;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.AwaitPublishResult.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final String getResultKey() {
            return this.resultKey;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$AwaitSteamBindResult;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AwaitSteamBindResult implements TribeeHomeStateAction {
        public static final int $stable = 0;
        public static final AwaitSteamBindResult INSTANCE = new AwaitSteamBindResult();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AwaitSteamBindResult) {
                AwaitSteamBindResult awaitSteamBindResult = (AwaitSteamBindResult) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -387264022;
        }

        public String toString() {
            return "AwaitSteamBindResult";
        }

        private AwaitSteamBindResult() {
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.AwaitSteamBindResult.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ReportNotification;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "inHomePage", "", "fromBubble", "<init>", "(ZZ)V", "getInHomePage", "()Z", "getFromBubble", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReportNotification implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final boolean fromBubble;
        private final boolean inHomePage;

        public static /* synthetic */ ReportNotification copy$default(ReportNotification reportNotification, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = reportNotification.inHomePage;
            }
            if ((i & 2) != 0) {
                z2 = reportNotification.fromBubble;
            }
            return reportNotification.copy(z, z2);
        }

        public final boolean component1() {
            return this.inHomePage;
        }

        public final boolean component2() {
            return this.fromBubble;
        }

        public final ReportNotification copy(boolean z, boolean z2) {
            return new ReportNotification(z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReportNotification) {
                ReportNotification reportNotification = (ReportNotification) obj;
                return this.inHomePage == reportNotification.inHomePage && this.fromBubble == reportNotification.fromBubble;
            }
            return false;
        }

        public int hashCode() {
            return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.inHomePage) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromBubble);
        }

        public String toString() {
            boolean z = this.inHomePage;
            return "ReportNotification(inHomePage=" + z + ", fromBubble=" + this.fromBubble + ")";
        }

        public ReportNotification(boolean inHomePage, boolean fromBubble) {
            this.inHomePage = inHomePage;
            this.fromBubble = fromBubble;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.ReportNotification.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final boolean getInHomePage() {
            return this.inHomePage;
        }

        public final boolean getFromBubble() {
            return this.fromBubble;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchSubarea;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "category", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;)V", "getCategory", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SwitchSubarea implements TribeeHomeStateAction {
        public static final int $stable = 8;
        private final KTribeeCategory category;

        public static /* synthetic */ SwitchSubarea copy$default(SwitchSubarea switchSubarea, KTribeeCategory kTribeeCategory, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeCategory = switchSubarea.category;
            }
            return switchSubarea.copy(kTribeeCategory);
        }

        public final KTribeeCategory component1() {
            return this.category;
        }

        public final SwitchSubarea copy(KTribeeCategory kTribeeCategory) {
            Intrinsics.checkNotNullParameter(kTribeeCategory, "category");
            return new SwitchSubarea(kTribeeCategory);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchSubarea) && Intrinsics.areEqual(this.category, ((SwitchSubarea) obj).category);
        }

        public int hashCode() {
            return this.category.hashCode();
        }

        public String toString() {
            return "SwitchSubarea(category=" + this.category + ")";
        }

        public SwitchSubarea(KTribeeCategory category) {
            Intrinsics.checkNotNullParameter(category, "category");
            this.category = category;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.SwitchSubarea.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final KTribeeCategory getCategory() {
            return this.category;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$InsertFakeDyn;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "resultKey", "", "categoryId", "", "fakeDyn", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;", "<init>", "(Ljava/lang/String;JLcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;)V", "getResultKey", "()Ljava/lang/String;", "getCategoryId", "()J", "getFakeDyn", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InsertFakeDyn implements TribeeHomeStateAction {
        public static final int $stable = 8;
        private final long categoryId;
        private final KTribeeDyn fakeDyn;
        private final String resultKey;

        public static /* synthetic */ InsertFakeDyn copy$default(InsertFakeDyn insertFakeDyn, String str, long j, KTribeeDyn kTribeeDyn, int i, Object obj) {
            if ((i & 1) != 0) {
                str = insertFakeDyn.resultKey;
            }
            if ((i & 2) != 0) {
                j = insertFakeDyn.categoryId;
            }
            if ((i & 4) != 0) {
                kTribeeDyn = insertFakeDyn.fakeDyn;
            }
            return insertFakeDyn.copy(str, j, kTribeeDyn);
        }

        public final String component1() {
            return this.resultKey;
        }

        public final long component2() {
            return this.categoryId;
        }

        public final KTribeeDyn component3() {
            return this.fakeDyn;
        }

        public final InsertFakeDyn copy(String str, long j, KTribeeDyn kTribeeDyn) {
            Intrinsics.checkNotNullParameter(str, "resultKey");
            Intrinsics.checkNotNullParameter(kTribeeDyn, "fakeDyn");
            return new InsertFakeDyn(str, j, kTribeeDyn);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InsertFakeDyn) {
                InsertFakeDyn insertFakeDyn = (InsertFakeDyn) obj;
                return Intrinsics.areEqual(this.resultKey, insertFakeDyn.resultKey) && this.categoryId == insertFakeDyn.categoryId && Intrinsics.areEqual(this.fakeDyn, insertFakeDyn.fakeDyn);
            }
            return false;
        }

        public int hashCode() {
            return (((this.resultKey.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.categoryId)) * 31) + this.fakeDyn.hashCode();
        }

        public String toString() {
            String str = this.resultKey;
            long j = this.categoryId;
            return "InsertFakeDyn(resultKey=" + str + ", categoryId=" + j + ", fakeDyn=" + this.fakeDyn + ")";
        }

        public InsertFakeDyn(String resultKey, long categoryId, KTribeeDyn fakeDyn) {
            Intrinsics.checkNotNullParameter(resultKey, "resultKey");
            Intrinsics.checkNotNullParameter(fakeDyn, "fakeDyn");
            this.resultKey = resultKey;
            this.categoryId = categoryId;
            this.fakeDyn = fakeDyn;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.InsertFakeDyn.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final String getResultKey() {
            return this.resultKey;
        }

        public final long getCategoryId() {
            return this.categoryId;
        }

        public final KTribeeDyn getFakeDyn() {
            return this.fakeDyn;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchRevisitSettings;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "checked", "", "<init>", "(Z)V", "getChecked", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SwitchRevisitSettings implements TribeeHomeStateAction {
        public static final int $stable = 0;
        private final boolean checked;

        public static /* synthetic */ SwitchRevisitSettings copy$default(SwitchRevisitSettings switchRevisitSettings, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = switchRevisitSettings.checked;
            }
            return switchRevisitSettings.copy(z);
        }

        public final boolean component1() {
            return this.checked;
        }

        public final SwitchRevisitSettings copy(boolean z) {
            return new SwitchRevisitSettings(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchRevisitSettings) && this.checked == ((SwitchRevisitSettings) obj).checked;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checked);
        }

        public String toString() {
            return "SwitchRevisitSettings(checked=" + this.checked + ")";
        }

        public SwitchRevisitSettings(boolean checked) {
            this.checked = checked;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.SwitchRevisitSettings.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final boolean getChecked() {
            return this.checked;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchSortType;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "sortType", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;)V", "getSortType", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SwitchSortType implements TribeeHomeStateAction {
        public static final int $stable = 8;
        private final KTribeeSortType sortType;

        public static /* synthetic */ SwitchSortType copy$default(SwitchSortType switchSortType, KTribeeSortType kTribeeSortType, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSortType = switchSortType.sortType;
            }
            return switchSortType.copy(kTribeeSortType);
        }

        public final KTribeeSortType component1() {
            return this.sortType;
        }

        public final SwitchSortType copy(KTribeeSortType kTribeeSortType) {
            Intrinsics.checkNotNullParameter(kTribeeSortType, "sortType");
            return new SwitchSortType(kTribeeSortType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchSortType) && Intrinsics.areEqual(this.sortType, ((SwitchSortType) obj).sortType);
        }

        public int hashCode() {
            return this.sortType.hashCode();
        }

        public String toString() {
            return "SwitchSortType(sortType=" + this.sortType + ")";
        }

        public SwitchSortType(KTribeeSortType sortType) {
            Intrinsics.checkNotNullParameter(sortType, "sortType");
            this.sortType = sortType;
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean beObserved() {
            return CC.$default$beObserved(this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.-CC.$default$conflictedActionClassSet(kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction):java.util.Set
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.util.Collections$EmptyList.get(Collections.java:4456)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ java.util.Set<kotlin.reflect.KClass<? extends kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction>> conflictedActionClassSet() {
            /*
                r1 = this;
                java.util.Set r0 = kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.CC.$default$conflictedActionClassSet(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction.SwitchSortType.conflictedActionClassSet():java.util.Set");
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckLogin() {
            return CC.$default$needCheckLogin(this);
        }

        @Override // kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction
        public /* bridge */ boolean needCheckPermission() {
            return CC.$default$needCheckPermission(this);
        }

        public final KTribeeSortType getSortType() {
            return this.sortType;
        }
    }
}