package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kotlin.Metadata;

/* compiled from: OuroMark.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\u000eR\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMark;", "", "key", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "mergeRule", "Lkntr/common/ouro/core/model/mark/MergeRule;", "getMergeRule", "()Lkntr/common/ouro/core/model/mark/MergeRule;", "BuiltIn", "Override", "Inherit", "Custom", "Key", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroMark {

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u000e\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "Lkntr/common/ouro/core/model/mark/OuroFontSizeMark;", "Lkntr/common/ouro/core/model/mark/OuroFontWeightMark;", "Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroItalicMark;", "Lkntr/common/ouro/core/model/mark/OuroLineHeightMark;", "Lkntr/common/ouro/core/model/mark/OuroScriptMark;", "Lkntr/common/ouro/core/model/mark/OuroStrikethroughMark;", "Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;", "Lkntr/common/ouro/core/model/mark/OuroTextIndentMark;", "Lkntr/common/ouro/core/model/mark/OuroTextSpacingMark;", "Lkntr/common/ouro/core/model/mark/OuroUnderlineMark;", "Lkntr/common/ouro/core/model/mark/OuroUnmergableMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface BuiltIn extends OuroMark {
    }

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMark$Custom;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "mergeRule", "Lkntr/common/ouro/core/model/mark/MergeRule$Custom;", "getMergeRule", "()Lkntr/common/ouro/core/model/mark/MergeRule$Custom;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Custom extends OuroMark {
        @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
        MergeRule.Custom getMergeRule();
    }

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "MARK", "Lkntr/common/ouro/core/model/mark/OuroMark;", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Key<MARK extends OuroMark> {
    }

    Key<?> getKey();

    MergeRule getMergeRule();

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMark$Override;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "mergeRule", "Lkntr/common/ouro/core/model/mark/MergeRule$Override;", "getMergeRule", "()Lkntr/common/ouro/core/model/mark/MergeRule$Override;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Override extends OuroMark {
        @Override // 
        MergeRule.Override getMergeRule();

        /* compiled from: OuroMark.kt */
        /* renamed from: kntr.common.ouro.core.model.mark.OuroMark$Override$-CC */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static MergeRule.Override $default$getMergeRule(Override _this) {
                return MergeRule.Override.INSTANCE;
            }
        }

        /* compiled from: OuroMark.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static MergeRule.Override getMergeRule(Override $this) {
                return CC.$default$getMergeRule($this);
            }
        }
    }

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroMark$Inherit;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "mergeRule", "Lkntr/common/ouro/core/model/mark/MergeRule$Inherit;", "getMergeRule", "()Lkntr/common/ouro/core/model/mark/MergeRule$Inherit;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Inherit extends OuroMark {
        @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
        MergeRule.Inherit getMergeRule();

        /* compiled from: OuroMark.kt */
        /* renamed from: kntr.common.ouro.core.model.mark.OuroMark$Inherit$-CC */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static MergeRule.Inherit $default$getMergeRule(Inherit _this) {
                return MergeRule.Inherit.INSTANCE;
            }
        }

        /* compiled from: OuroMark.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static MergeRule.Inherit getMergeRule(Inherit $this) {
                return CC.$default$getMergeRule($this);
            }
        }
    }
}