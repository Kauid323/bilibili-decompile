package tv.danmaku.bili.ui.garb;

import android.view.View;
import com.bilibili.app.authorspace.ui.nft.utils.ImageLoadCallback;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: NftCardBgLoader.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014J\"\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardBgLoader;", "", "root", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mVerticalBgReady", "", "mVerticalBgSucCount", "", "mVerticalLightBg", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mVerticalTableBg", "mHorizontalBgReady", "mHorizontalBgSucCount", "mHorizontalLightBg", "mHorizontalTableBg", "init", "", "hCardLightUrl", "", "hCardShadowUrl", "vCardLightUrl", "vCardShadowUrl", "loadImage", "url", "view", "type", "Ltv/danmaku/bili/ui/garb/NftCardLayoutType;", "resetFlag", "mNeedShowVBg", "mNeedShowHBg", "showBg", "showVBg", "showHBg", "notifyShowBg", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardBgLoader {
    public static final int $stable = 8;
    private boolean mHorizontalBgReady;
    private int mHorizontalBgSucCount;
    private final BiliImageView mHorizontalLightBg;
    private final BiliImageView mHorizontalTableBg;
    private boolean mNeedShowHBg;
    private boolean mNeedShowVBg;
    private boolean mVerticalBgReady;
    private int mVerticalBgSucCount;
    private final BiliImageView mVerticalLightBg;
    private final BiliImageView mVerticalTableBg;

    /* compiled from: NftCardBgLoader.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NftCardLayoutType.values().length];
            try {
                iArr[NftCardLayoutType.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NftCardLayoutType.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NftCardBgLoader(View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        BiliImageView findViewById = root.findViewById(R.id.nft_cards_light_v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mVerticalLightBg = findViewById;
        BiliImageView findViewById2 = root.findViewById(R.id.nft_cards_table_v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mVerticalTableBg = findViewById2;
        BiliImageView findViewById3 = root.findViewById(R.id.nft_cards_light_h);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mHorizontalLightBg = findViewById3;
        BiliImageView findViewById4 = root.findViewById(R.id.nft_cards_table_h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mHorizontalTableBg = findViewById4;
    }

    public final void init(String hCardLightUrl, String hCardShadowUrl, String vCardLightUrl, String vCardShadowUrl) {
        if (this.mVerticalBgReady && this.mHorizontalBgReady) {
            return;
        }
        resetFlag();
        loadImage(vCardLightUrl, this.mVerticalLightBg, NftCardLayoutType.Vertical);
        loadImage(vCardShadowUrl, this.mVerticalTableBg, NftCardLayoutType.Vertical);
        loadImage(hCardLightUrl, this.mHorizontalLightBg, NftCardLayoutType.Horizontal);
        loadImage(hCardShadowUrl, this.mHorizontalTableBg, NftCardLayoutType.Horizontal);
    }

    private final void loadImage(String url, final BiliImageView view, final NftCardLayoutType type) {
        SpaceNftUtils.loadImage$default(SpaceNftUtils.INSTANCE, url, view, new ImageLoadCallback() { // from class: tv.danmaku.bili.ui.garb.NftCardBgLoader$loadImage$1

            /* compiled from: NftCardBgLoader.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[NftCardLayoutType.values().length];
                    try {
                        iArr[NftCardLayoutType.Horizontal.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[NftCardLayoutType.Vertical.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public void onSucceed(ImageInfo imageInfo) {
                int i;
                int i2;
                Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
                BLog.i(GarbManagerDelegateKt.TAG, "加载背景图成功：" + NftCardLayoutType.this);
                switch (WhenMappings.$EnumSwitchMapping$0[NftCardLayoutType.this.ordinal()]) {
                    case 1:
                        i = this.mHorizontalBgSucCount;
                        this.mHorizontalBgSucCount = i + 1;
                        BLog.i(GarbManagerDelegateKt.TAG, "横屏背景图加载成功，可以展示");
                        this.mHorizontalBgReady = true;
                        break;
                    case 2:
                        i2 = this.mVerticalBgSucCount;
                        this.mVerticalBgSucCount = i2 + 1;
                        this.mVerticalBgReady = true;
                        BLog.i(GarbManagerDelegateKt.TAG, "竖屏背景图加载成功，可以展示");
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                this.notifyShowBg(view);
            }

            public void onFailed(Throwable err) {
                BLog.e(GarbManagerDelegateKt.TAG, "加载背景图失败：" + NftCardLayoutType.this);
                switch (WhenMappings.$EnumSwitchMapping$0[NftCardLayoutType.this.ordinal()]) {
                    case 1:
                        this.mHorizontalBgReady = false;
                        return;
                    case 2:
                        this.mVerticalBgReady = false;
                        return;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }, false, 8, (Object) null);
    }

    private final void resetFlag() {
        this.mVerticalBgReady = false;
        this.mVerticalBgSucCount = 0;
        this.mHorizontalBgReady = false;
        this.mHorizontalBgSucCount = 0;
    }

    public final void showBg(NftCardLayoutType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                if (this.mVerticalBgReady) {
                    showVBg();
                    return;
                }
                this.mNeedShowHBg = false;
                this.mNeedShowVBg = true;
                return;
            case 2:
                if (this.mHorizontalBgReady) {
                    showHBg();
                    return;
                }
                this.mNeedShowHBg = true;
                this.mNeedShowVBg = false;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void showVBg() {
        this.mVerticalLightBg.setVisibility(0);
        this.mVerticalTableBg.setVisibility(0);
        this.mHorizontalLightBg.setVisibility(8);
        this.mHorizontalTableBg.setVisibility(8);
    }

    private final void showHBg() {
        this.mHorizontalLightBg.setVisibility(0);
        this.mHorizontalTableBg.setVisibility(0);
        this.mVerticalLightBg.setVisibility(8);
        this.mVerticalTableBg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyShowBg(BiliImageView view) {
        if (Intrinsics.areEqual(view.getTag(), 1)) {
            return;
        }
        if (this.mVerticalBgReady && this.mNeedShowVBg) {
            showVBg();
        } else if (this.mHorizontalBgReady && this.mNeedShowHBg) {
            showHBg();
        } else {
            view.setVisibility(8);
        }
        view.setTag(1);
    }
}