package kntr.app.ad.domain.click.internal.action;

import java.util.Map;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.action.results.DownloadResult;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.action.results.WxOpenResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionResult.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000e\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "WxProgram", "BxProgram", "IMax", "BiliNative", "SchemeDoubleJump", "Scheme", "ULink", "AppStoreOpen", "AppStoreCallUp", "AppDownload", "BiliLink", "Hook", "MWeb", "AdWeb", "Lkntr/app/ad/domain/click/internal/action/ActionResult$AdWeb;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$AppDownload;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$AppStoreCallUp;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$AppStoreOpen;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$BiliLink;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$BiliNative;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$BxProgram;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$Hook;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$IMax;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$MWeb;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$Scheme;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$SchemeDoubleJump;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$ULink;", "Lkntr/app/ad/domain/click/internal/action/ActionResult$WxProgram;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ActionResult {
    public /* synthetic */ ActionResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$WxProgram;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$WxProgram;", "result", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$WxProgram;Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$WxProgram;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class WxProgram extends ActionResult {
        private final ActionParam.WxProgram param;
        private final WxOpenResult result;

        public static /* synthetic */ WxProgram copy$default(WxProgram wxProgram, ActionParam.WxProgram wxProgram2, WxOpenResult wxOpenResult, int i, Object obj) {
            if ((i & 1) != 0) {
                wxProgram2 = wxProgram.param;
            }
            if ((i & 2) != 0) {
                wxOpenResult = wxProgram.result;
            }
            return wxProgram.copy(wxProgram2, wxOpenResult);
        }

        public final ActionParam.WxProgram component1() {
            return this.param;
        }

        public final WxOpenResult component2() {
            return this.result;
        }

        public final WxProgram copy(ActionParam.WxProgram wxProgram, WxOpenResult wxOpenResult) {
            Intrinsics.checkNotNullParameter(wxProgram, "param");
            Intrinsics.checkNotNullParameter(wxOpenResult, "result");
            return new WxProgram(wxProgram, wxOpenResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WxProgram) {
                WxProgram wxProgram = (WxProgram) obj;
                return Intrinsics.areEqual(this.param, wxProgram.param) && Intrinsics.areEqual(this.result, wxProgram.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.WxProgram wxProgram = this.param;
            return "WxProgram(param=" + wxProgram + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WxProgram(ActionParam.WxProgram param, WxOpenResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.WxProgram getParam() {
            return this.param;
        }

        public final WxOpenResult getResult() {
            return this.result;
        }
    }

    private ActionResult() {
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$BxProgram;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BxProgram extends ActionResult {
        private final ActionParam.Url param;
        private final EasyResult result;

        public static /* synthetic */ BxProgram copy$default(BxProgram bxProgram, ActionParam.Url url, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                url = bxProgram.param;
            }
            if ((i & 2) != 0) {
                easyResult = bxProgram.result;
            }
            return bxProgram.copy(url, easyResult);
        }

        public final ActionParam.Url component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final BxProgram copy(ActionParam.Url url, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(url, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new BxProgram(url, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BxProgram) {
                BxProgram bxProgram = (BxProgram) obj;
                return Intrinsics.areEqual(this.param, bxProgram.param) && Intrinsics.areEqual(this.result, bxProgram.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Url url = this.param;
            return "BxProgram(param=" + url + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BxProgram(ActionParam.Url param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Url getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$IMax;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class IMax extends ActionResult {
        private final ActionParam.Url param;
        private final EasyResult result;

        public static /* synthetic */ IMax copy$default(IMax iMax, ActionParam.Url url, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                url = iMax.param;
            }
            if ((i & 2) != 0) {
                easyResult = iMax.result;
            }
            return iMax.copy(url, easyResult);
        }

        public final ActionParam.Url component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final IMax copy(ActionParam.Url url, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(url, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new IMax(url, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IMax) {
                IMax iMax = (IMax) obj;
                return Intrinsics.areEqual(this.param, iMax.param) && Intrinsics.areEqual(this.result, iMax.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Url url = this.param;
            return "IMax(param=" + url + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IMax(ActionParam.Url param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Url getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$BiliNative;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BiliNative extends ActionResult {
        private final ActionParam.Url param;
        private final EasyResult result;

        public static /* synthetic */ BiliNative copy$default(BiliNative biliNative, ActionParam.Url url, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                url = biliNative.param;
            }
            if ((i & 2) != 0) {
                easyResult = biliNative.result;
            }
            return biliNative.copy(url, easyResult);
        }

        public final ActionParam.Url component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final BiliNative copy(ActionParam.Url url, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(url, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new BiliNative(url, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BiliNative) {
                BiliNative biliNative = (BiliNative) obj;
                return Intrinsics.areEqual(this.param, biliNative.param) && Intrinsics.areEqual(this.result, biliNative.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Url url = this.param;
            return "BiliNative(param=" + url + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BiliNative(ActionParam.Url param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Url getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$SchemeDoubleJump;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$SchemeDoubleJump;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$SchemeDoubleJump;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$SchemeDoubleJump;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SchemeDoubleJump extends ActionResult {
        private final ActionParam.SchemeDoubleJump param;
        private final EasyResult result;

        public static /* synthetic */ SchemeDoubleJump copy$default(SchemeDoubleJump schemeDoubleJump, ActionParam.SchemeDoubleJump schemeDoubleJump2, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                schemeDoubleJump2 = schemeDoubleJump.param;
            }
            if ((i & 2) != 0) {
                easyResult = schemeDoubleJump.result;
            }
            return schemeDoubleJump.copy(schemeDoubleJump2, easyResult);
        }

        public final ActionParam.SchemeDoubleJump component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final SchemeDoubleJump copy(ActionParam.SchemeDoubleJump schemeDoubleJump, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(schemeDoubleJump, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new SchemeDoubleJump(schemeDoubleJump, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SchemeDoubleJump) {
                SchemeDoubleJump schemeDoubleJump = (SchemeDoubleJump) obj;
                return Intrinsics.areEqual(this.param, schemeDoubleJump.param) && Intrinsics.areEqual(this.result, schemeDoubleJump.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.SchemeDoubleJump schemeDoubleJump = this.param;
            return "SchemeDoubleJump(param=" + schemeDoubleJump + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SchemeDoubleJump(ActionParam.SchemeDoubleJump param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.SchemeDoubleJump getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$Scheme;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Scheme;", "result", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Scheme;Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Scheme;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Scheme extends ActionResult {
        private final ActionParam.Scheme param;
        private final CallUpResult result;

        public static /* synthetic */ Scheme copy$default(Scheme scheme, ActionParam.Scheme scheme2, CallUpResult callUpResult, int i, Object obj) {
            if ((i & 1) != 0) {
                scheme2 = scheme.param;
            }
            if ((i & 2) != 0) {
                callUpResult = scheme.result;
            }
            return scheme.copy(scheme2, callUpResult);
        }

        public final ActionParam.Scheme component1() {
            return this.param;
        }

        public final CallUpResult component2() {
            return this.result;
        }

        public final Scheme copy(ActionParam.Scheme scheme, CallUpResult callUpResult) {
            Intrinsics.checkNotNullParameter(scheme, "param");
            Intrinsics.checkNotNullParameter(callUpResult, "result");
            return new Scheme(scheme, callUpResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Scheme) {
                Scheme scheme = (Scheme) obj;
                return Intrinsics.areEqual(this.param, scheme.param) && Intrinsics.areEqual(this.result, scheme.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Scheme scheme = this.param;
            return "Scheme(param=" + scheme + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Scheme(ActionParam.Scheme param, CallUpResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Scheme getParam() {
            return this.param;
        }

        public final CallUpResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$ULink;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$ULink;", "result", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$ULink;Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$ULink;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ULink extends ActionResult {
        private final ActionParam.ULink param;
        private final CallUpResult result;

        public static /* synthetic */ ULink copy$default(ULink uLink, ActionParam.ULink uLink2, CallUpResult callUpResult, int i, Object obj) {
            if ((i & 1) != 0) {
                uLink2 = uLink.param;
            }
            if ((i & 2) != 0) {
                callUpResult = uLink.result;
            }
            return uLink.copy(uLink2, callUpResult);
        }

        public final ActionParam.ULink component1() {
            return this.param;
        }

        public final CallUpResult component2() {
            return this.result;
        }

        public final ULink copy(ActionParam.ULink uLink, CallUpResult callUpResult) {
            Intrinsics.checkNotNullParameter(uLink, "param");
            Intrinsics.checkNotNullParameter(callUpResult, "result");
            return new ULink(uLink, callUpResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ULink) {
                ULink uLink = (ULink) obj;
                return Intrinsics.areEqual(this.param, uLink.param) && Intrinsics.areEqual(this.result, uLink.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.ULink uLink = this.param;
            return "ULink(param=" + uLink + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ULink(ActionParam.ULink param, CallUpResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.ULink getParam() {
            return this.param;
        }

        public final CallUpResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$AppStoreOpen;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "intermediates", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;Ljava/util/Map;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "getIntermediates", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AppStoreOpen extends ActionResult {
        private final Map<String, String> intermediates;
        private final ActionParam.AppStore param;
        private final EasyResult result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AppStoreOpen copy$default(AppStoreOpen appStoreOpen, ActionParam.AppStore appStore, EasyResult easyResult, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                appStore = appStoreOpen.param;
            }
            if ((i & 2) != 0) {
                easyResult = appStoreOpen.result;
            }
            if ((i & 4) != 0) {
                map = appStoreOpen.intermediates;
            }
            return appStoreOpen.copy(appStore, easyResult, map);
        }

        public final ActionParam.AppStore component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final Map<String, String> component3() {
            return this.intermediates;
        }

        public final AppStoreOpen copy(ActionParam.AppStore appStore, EasyResult easyResult, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(appStore, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            Intrinsics.checkNotNullParameter(map, "intermediates");
            return new AppStoreOpen(appStore, easyResult, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AppStoreOpen) {
                AppStoreOpen appStoreOpen = (AppStoreOpen) obj;
                return Intrinsics.areEqual(this.param, appStoreOpen.param) && Intrinsics.areEqual(this.result, appStoreOpen.result) && Intrinsics.areEqual(this.intermediates, appStoreOpen.intermediates);
            }
            return false;
        }

        public int hashCode() {
            return (((this.param.hashCode() * 31) + this.result.hashCode()) * 31) + this.intermediates.hashCode();
        }

        public String toString() {
            ActionParam.AppStore appStore = this.param;
            EasyResult easyResult = this.result;
            return "AppStoreOpen(param=" + appStore + ", result=" + easyResult + ", intermediates=" + this.intermediates + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppStoreOpen(ActionParam.AppStore param, EasyResult result, Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(map, "intermediates");
            this.param = param;
            this.result = result;
            this.intermediates = map;
        }

        public final ActionParam.AppStore getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }

        public final Map<String, String> getIntermediates() {
            return this.intermediates;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$AppStoreCallUp;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;", "result", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AppStoreCallUp extends ActionResult {
        private final ActionParam.AppStore param;
        private final CallUpResult result;

        public static /* synthetic */ AppStoreCallUp copy$default(AppStoreCallUp appStoreCallUp, ActionParam.AppStore appStore, CallUpResult callUpResult, int i, Object obj) {
            if ((i & 1) != 0) {
                appStore = appStoreCallUp.param;
            }
            if ((i & 2) != 0) {
                callUpResult = appStoreCallUp.result;
            }
            return appStoreCallUp.copy(appStore, callUpResult);
        }

        public final ActionParam.AppStore component1() {
            return this.param;
        }

        public final CallUpResult component2() {
            return this.result;
        }

        public final AppStoreCallUp copy(ActionParam.AppStore appStore, CallUpResult callUpResult) {
            Intrinsics.checkNotNullParameter(appStore, "param");
            Intrinsics.checkNotNullParameter(callUpResult, "result");
            return new AppStoreCallUp(appStore, callUpResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AppStoreCallUp) {
                AppStoreCallUp appStoreCallUp = (AppStoreCallUp) obj;
                return Intrinsics.areEqual(this.param, appStoreCallUp.param) && Intrinsics.areEqual(this.result, appStoreCallUp.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.AppStore appStore = this.param;
            return "AppStoreCallUp(param=" + appStore + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppStoreCallUp(ActionParam.AppStore param, CallUpResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.AppStore getParam() {
            return this.param;
        }

        public final CallUpResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$AppDownload;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "params", "Lkntr/app/ad/domain/click/internal/action/ActionParam$AppDownload;", "result", "Lkntr/app/ad/domain/click/internal/action/results/DownloadResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$AppDownload;Lkntr/app/ad/domain/click/internal/action/results/DownloadResult;)V", "getParams", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$AppDownload;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/DownloadResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AppDownload extends ActionResult {
        private final ActionParam.AppDownload params;
        private final DownloadResult result;

        public static /* synthetic */ AppDownload copy$default(AppDownload appDownload, ActionParam.AppDownload appDownload2, DownloadResult downloadResult, int i, Object obj) {
            if ((i & 1) != 0) {
                appDownload2 = appDownload.params;
            }
            if ((i & 2) != 0) {
                downloadResult = appDownload.result;
            }
            return appDownload.copy(appDownload2, downloadResult);
        }

        public final ActionParam.AppDownload component1() {
            return this.params;
        }

        public final DownloadResult component2() {
            return this.result;
        }

        public final AppDownload copy(ActionParam.AppDownload appDownload, DownloadResult downloadResult) {
            Intrinsics.checkNotNullParameter(appDownload, "params");
            Intrinsics.checkNotNullParameter(downloadResult, "result");
            return new AppDownload(appDownload, downloadResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AppDownload) {
                AppDownload appDownload = (AppDownload) obj;
                return Intrinsics.areEqual(this.params, appDownload.params) && Intrinsics.areEqual(this.result, appDownload.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.params.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.AppDownload appDownload = this.params;
            return "AppDownload(params=" + appDownload + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppDownload(ActionParam.AppDownload params, DownloadResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(result, "result");
            this.params = params;
            this.result = result;
        }

        public final ActionParam.AppDownload getParams() {
            return this.params;
        }

        public final DownloadResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$BiliLink;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BiliLink extends ActionResult {
        private final ActionParam.Url param;
        private final EasyResult result;

        public static /* synthetic */ BiliLink copy$default(BiliLink biliLink, ActionParam.Url url, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                url = biliLink.param;
            }
            if ((i & 2) != 0) {
                easyResult = biliLink.result;
            }
            return biliLink.copy(url, easyResult);
        }

        public final ActionParam.Url component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final BiliLink copy(ActionParam.Url url, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(url, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new BiliLink(url, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BiliLink) {
                BiliLink biliLink = (BiliLink) obj;
                return Intrinsics.areEqual(this.param, biliLink.param) && Intrinsics.areEqual(this.result, biliLink.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Url url = this.param;
            return "BiliLink(param=" + url + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BiliLink(ActionParam.Url param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Url getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$Hook;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Hook extends ActionResult {
        private final ActionParam.Url param;
        private final EasyResult result;

        public static /* synthetic */ Hook copy$default(Hook hook, ActionParam.Url url, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                url = hook.param;
            }
            if ((i & 2) != 0) {
                easyResult = hook.result;
            }
            return hook.copy(url, easyResult);
        }

        public final ActionParam.Url component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final Hook copy(ActionParam.Url url, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(url, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new Hook(url, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Hook) {
                Hook hook = (Hook) obj;
                return Intrinsics.areEqual(this.param, hook.param) && Intrinsics.areEqual(this.result, hook.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Url url = this.param;
            return "Hook(param=" + url + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Hook(ActionParam.Url param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Url getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$MWeb;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Web;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Web;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Web;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class MWeb extends ActionResult {
        private final ActionParam.Web param;
        private final EasyResult result;

        public static /* synthetic */ MWeb copy$default(MWeb mWeb, ActionParam.Web web, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                web = mWeb.param;
            }
            if ((i & 2) != 0) {
                easyResult = mWeb.result;
            }
            return mWeb.copy(web, easyResult);
        }

        public final ActionParam.Web component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final MWeb copy(ActionParam.Web web, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(web, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new MWeb(web, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MWeb) {
                MWeb mWeb = (MWeb) obj;
                return Intrinsics.areEqual(this.param, mWeb.param) && Intrinsics.areEqual(this.result, mWeb.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Web web = this.param;
            return "MWeb(param=" + web + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MWeb(ActionParam.Web param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Web getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }

    /* compiled from: ActionResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionResult$AdWeb;", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "result", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;Lkntr/app/ad/domain/click/internal/action/results/EasyResult;)V", "getParam", "()Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "getResult", "()Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AdWeb extends ActionResult {
        private final ActionParam.Url param;
        private final EasyResult result;

        public static /* synthetic */ AdWeb copy$default(AdWeb adWeb, ActionParam.Url url, EasyResult easyResult, int i, Object obj) {
            if ((i & 1) != 0) {
                url = adWeb.param;
            }
            if ((i & 2) != 0) {
                easyResult = adWeb.result;
            }
            return adWeb.copy(url, easyResult);
        }

        public final ActionParam.Url component1() {
            return this.param;
        }

        public final EasyResult component2() {
            return this.result;
        }

        public final AdWeb copy(ActionParam.Url url, EasyResult easyResult) {
            Intrinsics.checkNotNullParameter(url, "param");
            Intrinsics.checkNotNullParameter(easyResult, "result");
            return new AdWeb(url, easyResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AdWeb) {
                AdWeb adWeb = (AdWeb) obj;
                return Intrinsics.areEqual(this.param, adWeb.param) && Intrinsics.areEqual(this.result, adWeb.result);
            }
            return false;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            ActionParam.Url url = this.param;
            return "AdWeb(param=" + url + ", result=" + this.result + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdWeb(ActionParam.Url param, EasyResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(result, "result");
            this.param = param;
            this.result = result;
        }

        public final ActionParam.Url getParam() {
            return this.param;
        }

        public final EasyResult getResult() {
            return this.result;
        }
    }
}