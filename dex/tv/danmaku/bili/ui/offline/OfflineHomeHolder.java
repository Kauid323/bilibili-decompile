package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.MainImageExtension;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.BitmapConfig;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineStatus;
import com.bilibili.offline.OfflineType;
import com.bilibili.playerbizcommonv2.utils.NumberExtensionKt;
import com.bilibili.ugc.offline.drama.DramaVideo;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.offline.OfflineHomeHolder;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter;
import tv.danmaku.biliplayerv2.utils.TimeFormater;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineHomeHolder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder;", "", "<init>", "()V", "SHOW_PLAYED_MIN_TIME", "", "OfflineDownloadingHolder", "DownloadedTitleHolder", "DownloadedVideoHolder", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineHomeHolder {
    public static final int $stable = 0;
    public static final OfflineHomeHolder INSTANCE = new OfflineHomeHolder();
    private static final long SHOW_PLAYED_MIN_TIME = 1000;

    private OfflineHomeHolder() {
    }

    /* compiled from: OfflineHomeHolder.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 &2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$OfflineDownloadingHolder;", "Ltv/danmaku/bili/widget/recycler/section/BaseSectionAdapter$ViewHolder;", "itemView", "Landroid/view/View;", "mOfflineHomeAdapter", "Ltv/danmaku/bili/ui/offline/OfflineHomeAdapter;", "<init>", "(Landroid/view/View;Ltv/danmaku/bili/ui/offline/OfflineHomeAdapter;)V", "mCover", "Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;", "mOverlay", "Landroid/widget/FrameLayout;", "mCount", "Landroid/widget/TextView;", "mTitle", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "mSubtitle", "mTip", "mTotalSize", "mProgressBar", "Ltv/danmaku/bili/ui/offline/OfflineProgress;", "bind", "", "data", "", "updateProgressInfo", "info", "Lcom/bilibili/offline/OfflineInfo;", "setTipMessage", "setSubTitle", "buildSpan", "", "count", "", "mItemClickListener", "Landroid/view/View$OnClickListener;", "displayImage", "imageView", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class OfflineDownloadingHolder extends BaseSectionAdapter.ViewHolder {
        private TextView mCount;
        private StaticImageView2 mCover;
        private final View.OnClickListener mItemClickListener;
        private final OfflineHomeAdapter mOfflineHomeAdapter;
        private FrameLayout mOverlay;
        private OfflineProgress mProgressBar;
        private TintTextView mSubtitle;
        private TintTextView mTip;
        private TintTextView mTitle;
        private TintTextView mTotalSize;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfflineDownloadingHolder(View itemView, OfflineHomeAdapter mOfflineHomeAdapter) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(mOfflineHomeAdapter, "mOfflineHomeAdapter");
            this.mOfflineHomeAdapter = mOfflineHomeAdapter;
            StaticImageView2 findViewById = itemView.findViewById(R.id.cover);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mCover = findViewById;
            View findViewById2 = itemView.findViewById(R.id.overlay);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.mOverlay = (FrameLayout) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.count);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.mCount = (TextView) findViewById3;
            TintTextView findViewById4 = itemView.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.mTitle = findViewById4;
            TintTextView findViewById5 = itemView.findViewById(R.id.subtitle);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.mSubtitle = findViewById5;
            TintTextView findViewById6 = itemView.findViewById(R.id.tip);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.mTip = findViewById6;
            TintTextView findViewById7 = itemView.findViewById(R.id.total_size);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.mTotalSize = findViewById7;
            View findViewById8 = itemView.findViewById(R.id.progress);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.mProgressBar = (OfflineProgress) findViewById8;
            this.mItemClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeHolder$OfflineDownloadingHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OfflineHomeHolder.OfflineDownloadingHolder.mItemClickListener$lambda$0(view2);
                }
            };
        }

        @Override // tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter.ViewHolder
        public void bind(Object data) {
            OfflineInfo info = data instanceof OfflineInfo ? (OfflineInfo) data : null;
            if (info == null) {
                return;
            }
            this.itemView.setOnClickListener(this.mItemClickListener);
            this.mTitle.setText(info.title);
            this.mCount.setText(buildSpan(String.valueOf(info.getPageCount())));
            displayImage(info, this.mCover);
            setSubTitle(info);
            updateProgressInfo(info);
            if (this.mOfflineHomeAdapter.isEditMode()) {
                this.itemView.setClickable(false);
                this.mOverlay.setBackgroundResource(R.drawable.shape_roundrect_4_gray_alpha50);
                this.mTitle.setTextColorById(com.bilibili.lib.theme.R.color.Ga5);
                this.mSubtitle.setTextColorById(com.bilibili.lib.theme.R.color.Ga5);
                return;
            }
            this.itemView.setClickable(true);
            this.mOverlay.setBackgroundResource(R.drawable.shape_roundrect_4_black_alpha50);
            this.mTitle.setTextColorById(com.bilibili.lib.theme.R.color.Ga10);
            this.mSubtitle.setTextColorById(com.bilibili.lib.theme.R.color.Ga10);
        }

        public final void updateProgressInfo(OfflineInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            setTipMessage(info);
            this.mTotalSize.setText(NumberExtensionKt.toFileSize(info.totalBytes));
            OfflineStatus offlineStatus = info.offlineStatus;
            boolean z = true;
            if (!(offlineStatus != null && offlineStatus.code == 5)) {
                OfflineStatus offlineStatus2 = info.offlineStatus;
                if (!(offlineStatus2 != null && offlineStatus2.code == 6)) {
                    OfflineStatus offlineStatus3 = info.offlineStatus;
                    if (!(offlineStatus3 != null && offlineStatus3.code == 7)) {
                        this.mProgressBar.setIndeterminate(false);
                        OfflineProgress offlineProgress = this.mProgressBar;
                        OfflineStatus offlineStatus4 = info.offlineStatus;
                        if (offlineStatus4 == null || offlineStatus4.code != 3) {
                            z = false;
                        }
                        offlineProgress.updateStatus(z);
                        this.mProgressBar.setProgress(OfflineUtil.INSTANCE.caclProgress(info));
                        return;
                    }
                }
            }
            this.mProgressBar.setIndeterminate(true);
        }

        private final void setTipMessage(OfflineInfo info) {
            TintTextView tintTextView = this.mTip;
            OfflineStatus offlineStatus = info.offlineStatus;
            boolean z = false;
            if (offlineStatus != null && offlineStatus.code == 2) {
                z = true;
            }
            tintTextView.setTextColorById(z ? com.bilibili.app.comm.baseres.R.color.theme_color_secondary : com.bilibili.lib.theme.R.color.Ga5);
            TintTextView tintTextView2 = this.mTip;
            OfflineStatus offlineStatus2 = info.offlineStatus;
            tintTextView2.setText(offlineStatus2 != null ? offlineStatus2.message : null);
        }

        private final void setSubTitle(OfflineInfo info) {
            String subTitle = OfflineUtil.getPageTitle(info);
            String str = info.title;
            if (str == null) {
                str = "";
            }
            if (StringsKt.equals(subTitle, str, true)) {
                this.mSubtitle.setText("");
            } else {
                this.mSubtitle.setText(subTitle);
            }
        }

        private final CharSequence buildSpan(String count) {
            Resources resources = this.itemView.getResources();
            int i = bili.resource.others.R.plurals.others_global_string_519;
            Integer intOrNull = StringsKt.toIntOrNull(count);
            String tip = resources.getQuantityString(i, intOrNull != null ? intOrNull.intValue() : 0, count);
            Intrinsics.checkNotNullExpressionValue(tip, "getQuantityString(...)");
            int textSize = this.itemView.getResources().getDimensionPixelSize(com.bilibili.lib.basecomponent.R.dimen.text_size_subtitle);
            TextAppearanceSpan span = new TextAppearanceSpan(null, 0, textSize, null, null);
            int start = StringsKt.indexOf$default(tip, count, 0, false, 6, (Object) null);
            int end = count.length() + start;
            SpannableString spannableString = SpannableString.valueOf(tip);
            spannableString.setSpan(span, start, end, 17);
            Intrinsics.checkNotNull(spannableString);
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void mItemClickListener$lambda$0(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            RouteRequest request = new RouteRequest.Builder("bilibili://offline/downloading").build();
            BLRouter.routeTo(request, v.getContext());
            OfflineReporter.reportHomeDownloadingClick();
        }

        private final void displayImage(final OfflineInfo info, StaticImageView2 imageView) {
            int thumbWidth;
            int thumbHeight;
            OfflineType offlineType = info.offlineType;
            boolean z = false;
            if (offlineType != null && offlineType.type == OfflineType.TYPE_AUDIO) {
                z = true;
            }
            if (z) {
                thumbWidth = 320;
                thumbHeight = 200;
            } else {
                thumbWidth = (int) TypedValue.applyDimension(1, 100.0f, imageView.getResources().getDisplayMetrics());
                thumbHeight = thumbWidth;
            }
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            biliImageLoader.with(context).url(info.cover).thumbnailUrlTransformStrategy(MainImageExtension.getThumbnailUrlTransformStrategy(thumbWidth, thumbHeight, true)).bitmapTransformation(new BitmapTransformation() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeHolder$OfflineDownloadingHolder$displayImage$1
                public /* synthetic */ BitmapConfig generateDestBitmapConfig(Bitmap bitmap) {
                    return BitmapTransformation.-CC.$default$generateDestBitmapConfig(this, bitmap);
                }

                public void transform(Bitmap bitmap) {
                    if (bitmap != null) {
                        NativeBlurFilter.iterativeBoxBlur(bitmap, 25, 3);
                    }
                }

                public String getCacheKey() {
                    return "blur_url_" + info.cover;
                }
            }).into((BiliImageView) imageView);
        }

        /* compiled from: OfflineHomeHolder.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$OfflineDownloadingHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$OfflineDownloadingHolder;", "parent", "Landroid/view/ViewGroup;", "adapter", "Ltv/danmaku/bili/ui/offline/OfflineHomeAdapter;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final OfflineDownloadingHolder create(ViewGroup parent, OfflineHomeAdapter adapter) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_offline_home_downloading, parent, false);
                Intrinsics.checkNotNull(view2);
                return new OfflineDownloadingHolder(view2, adapter);
            }
        }

        @JvmStatic
        public static final OfflineDownloadingHolder create(ViewGroup parent, OfflineHomeAdapter adapter) {
            return Companion.create(parent, adapter);
        }
    }

    /* compiled from: OfflineHomeHolder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedTitleHolder;", "Ltv/danmaku/bili/widget/recycler/section/BaseSectionAdapter$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "data", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DownloadedTitleHolder extends BaseSectionAdapter.ViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public DownloadedTitleHolder(View itemView) {
            super(itemView);
        }

        @Override // tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter.ViewHolder
        public void bind(Object data) {
        }

        /* compiled from: OfflineHomeHolder.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedTitleHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedTitleHolder;", "parent", "Landroid/view/ViewGroup;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final DownloadedTitleHolder create(ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_offline_home_sectitle, parent, false);
                return new DownloadedTitleHolder(view2);
            }
        }

        @JvmStatic
        public static final DownloadedTitleHolder create(ViewGroup parent) {
            return Companion.create(parent);
        }
    }

    /* compiled from: OfflineHomeHolder.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0001\u0018\u0000 22\u00020\u0001:\u000212B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedVideoHolder;", "Ltv/danmaku/bili/widget/recycler/section/BaseSectionAdapter$ViewHolder;", "itemView", "Landroid/view/View;", "mOfflineHomeAdapter", "Ltv/danmaku/bili/ui/offline/OfflineAdapter;", "mScene", "Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedVideoHolder$HolderScene;", "<init>", "(Landroid/view/View;Ltv/danmaku/bili/ui/offline/OfflineAdapter;Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedVideoHolder$HolderScene;)V", "mCheckBox", "Landroid/widget/CheckBox;", "mCover", "Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;", "mCoverDesc", "Landroid/widget/TextView;", "mLabel", "mTitle", "Ltv/danmaku/bili/ui/offline/OfflineTextView;", "getMTitle", "()Ltv/danmaku/bili/ui/offline/OfflineTextView;", "setMTitle", "(Ltv/danmaku/bili/ui/offline/OfflineTextView;)V", "mUpName", "mVideoSize", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "mInfo", "Lcom/bilibili/offline/OfflineInfo;", "mProgressBar", "Landroid/widget/ProgressBar;", "bind", "", "data", "", "updateVideoSizeOrVipTips", "info", "updateProgress", "updateCoverDesc", "updateVideoPageCount", "updateVideoLength", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mLongClickListener", "Landroid/view/View$OnLongClickListener;", "totalBytes", "", "parent", "HolderScene", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DownloadedVideoHolder extends BaseSectionAdapter.ViewHolder {
        private CheckBox mCheckBox;
        private final CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
        private StaticImageView2 mCover;
        private TextView mCoverDesc;
        private OfflineInfo mInfo;
        private TextView mLabel;
        private final View.OnLongClickListener mLongClickListener;
        private final OfflineAdapter mOfflineHomeAdapter;
        private final View.OnClickListener mOnClickListener;
        private ProgressBar mProgressBar;
        private final HolderScene mScene;
        private OfflineTextView mTitle;
        private TextView mUpName;
        private TintTextView mVideoSize;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* compiled from: OfflineHomeHolder.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedVideoHolder$HolderScene;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD_LIST", "DOWNLOAD_PAGE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public enum HolderScene {
            DOWNLOAD_LIST,
            DOWNLOAD_PAGE;
            
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

            public static EnumEntries<HolderScene> getEntries() {
                return $ENTRIES;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadedVideoHolder(View itemView, OfflineAdapter mOfflineHomeAdapter, HolderScene mScene) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(mOfflineHomeAdapter, "mOfflineHomeAdapter");
            Intrinsics.checkNotNullParameter(mScene, "mScene");
            this.mOfflineHomeAdapter = mOfflineHomeAdapter;
            this.mScene = mScene;
            View findViewById = itemView.findViewById(R.id.checkbox);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mCheckBox = (CheckBox) findViewById;
            StaticImageView2 findViewById2 = itemView.findViewById(R.id.cover);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.mCover = findViewById2;
            View findViewById3 = itemView.findViewById(R.id.cover_desc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.mCoverDesc = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.label);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.mLabel = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.mTitle = (OfflineTextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.up_name);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.mUpName = (TextView) findViewById6;
            TintTextView findViewById7 = itemView.findViewById(R.id.video_size);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.mVideoSize = findViewById7;
            View findViewById8 = itemView.findViewById(R.id.progress);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.mProgressBar = (ProgressBar) findViewById8;
            this.mOnClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeHolder$DownloadedVideoHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OfflineHomeHolder.DownloadedVideoHolder.mOnClickListener$lambda$0(OfflineHomeHolder.DownloadedVideoHolder.this, view2);
                }
            };
            this.mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeHolder$DownloadedVideoHolder$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    OfflineHomeHolder.DownloadedVideoHolder.mCheckedChangeListener$lambda$0(OfflineHomeHolder.DownloadedVideoHolder.this, compoundButton, z);
                }
            };
            this.mLongClickListener = new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeHolder$DownloadedVideoHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean mLongClickListener$lambda$0;
                    mLongClickListener$lambda$0 = OfflineHomeHolder.DownloadedVideoHolder.mLongClickListener$lambda$0(OfflineHomeHolder.DownloadedVideoHolder.this, view2);
                    return mLongClickListener$lambda$0;
                }
            };
        }

        public final OfflineTextView getMTitle() {
            return this.mTitle;
        }

        public final void setMTitle(OfflineTextView offlineTextView) {
            Intrinsics.checkNotNullParameter(offlineTextView, "<set-?>");
            this.mTitle = offlineTextView;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f4  */
        @Override // tv.danmaku.bili.widget.recycler.section.BaseSectionAdapter.ViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void bind(Object data) {
            boolean z;
            String str;
            OfflineInfo info = data instanceof OfflineInfo ? (OfflineInfo) data : null;
            if (info == null) {
                return;
            }
            this.mInfo = info;
            this.itemView.setTag(this);
            this.itemView.setOnClickListener(this.mOnClickListener);
            this.itemView.setOnLongClickListener(this.mLongClickListener);
            if (this.mOfflineHomeAdapter.isEditMode()) {
                View $this$isVisible$iv = this.mCheckBox;
                $this$isVisible$iv.setVisibility(0);
                this.mCheckBox.setTag(info);
                this.mCheckBox.setOnCheckedChangeListener(null);
                this.mCheckBox.setChecked(this.mOfflineHomeAdapter.isChecked(info));
                this.mCheckBox.setOnCheckedChangeListener(this.mCheckedChangeListener);
            } else {
                View $this$isVisible$iv2 = this.mCheckBox;
                $this$isVisible$iv2.setVisibility(8);
                this.mCheckBox.setOnCheckedChangeListener(null);
            }
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = this.mCover.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            biliImageLoader.with(context).url(info.cover).into(this.mCover);
            if (info.isChargeVideo()) {
                View $this$isVisible$iv3 = this.mLabel;
                $this$isVisible$iv3.setVisibility(0);
                this.mLabel.setText(this.itemView.getContext().getString(bili.resource.others.R.string.others_global_string_364));
                this.mLabel.setCompoundDrawablesRelativeWithIntrinsicBounds(AppCompatResources.getDrawable(this.itemView.getContext(), com.bilibili.playerbizcommonv2.R.drawable.bili_app_offline_charge_label), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                OfflineType offlineType = info.offlineType;
                if (offlineType != null && (str = offlineType.typeName) != null) {
                    if (str.length() > 0) {
                        z = true;
                        if (!z) {
                            View $this$isVisible$iv4 = this.mLabel;
                            $this$isVisible$iv4.setVisibility(0);
                            TextView textView = this.mLabel;
                            OfflineType offlineType2 = info.offlineType;
                            textView.setText(offlineType2 != null ? offlineType2.typeName : null);
                            this.mLabel.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        } else {
                            View $this$isVisible$iv5 = this.mLabel;
                            $this$isVisible$iv5.setVisibility(8);
                            this.mLabel.setText("");
                            this.mLabel.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            this.mTitle.setText(info.title);
            updateCoverDesc(info);
            String ownerName = info.getOwnerName();
            if ((ownerName != null && (StringsKt.isBlank(ownerName) ^ true)) && (this.mScene != HolderScene.DOWNLOAD_LIST || info.getPageCount() <= 1)) {
                this.mUpName.setText(info.getOwnerName());
                View $this$isVisible$iv6 = this.mUpName;
                $this$isVisible$iv6.setVisibility(0);
            } else {
                View $this$isInvisible$iv = this.mUpName;
                $this$isInvisible$iv.setVisibility(4);
            }
            updateVideoSizeOrVipTips(info);
            updateProgress(info);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
            if ((r0 != null && r0.type == com.bilibili.offline.OfflineType.TYPE_PAGE) != false) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void updateVideoSizeOrVipTips(OfflineInfo info) {
            if (info.isOnlySupportVip()) {
                if (info.getPageCount() != 1) {
                    OfflineType offlineType = info.offlineType;
                }
                this.mVideoSize.setText(this.itemView.getContext().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_990, NumberExtensionKt.toFileSize(totalBytes(info))));
                this.mVideoSize.setTextColor(ContextCompat.getColor(this.itemView.getContext(), com.bilibili.lib.theme.R.color.Pi5));
                return;
            }
            this.mVideoSize.setText(NumberExtensionKt.toFileSize(totalBytes(info)));
            this.mVideoSize.setTextColor(ContextCompat.getColor(this.itemView.getContext(), com.bilibili.lib.theme.R.color.Ga5));
        }

        private final void updateProgress(OfflineInfo info) {
            long playedTime = info.playedTime;
            if (playedTime == -1) {
                View $this$isVisible$iv = this.mProgressBar;
                $this$isVisible$iv.setVisibility(8);
            } else if (info.getPageCount() > 1 || playedTime < 1000 || playedTime == -2 || info.duration <= 0) {
                View $this$isVisible$iv2 = this.mProgressBar;
                $this$isVisible$iv2.setVisibility(8);
            } else {
                View $this$isVisible$iv3 = this.mProgressBar;
                $this$isVisible$iv3.setVisibility(0);
                this.mProgressBar.setProgress(info.duration > 0 ? (int) ((100 * playedTime) / info.duration) : 0);
            }
        }

        private final void updateCoverDesc(OfflineInfo info) {
            this.mCoverDesc.setCompoundDrawablePadding(0);
            this.mCoverDesc.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            if (info.getPageCount() <= 1) {
                updateVideoLength(info);
            } else {
                updateVideoPageCount(info);
            }
        }

        private final void updateVideoPageCount(OfflineInfo info) {
            int childCount = info.getPageCount();
            if (childCount <= 1) {
                View $this$isVisible$iv = this.mCoverDesc;
                $this$isVisible$iv.setVisibility(8);
                return;
            }
            View $this$isVisible$iv2 = this.mCoverDesc;
            $this$isVisible$iv2.setVisibility(0);
            this.mCoverDesc.setText(String.valueOf(childCount));
            this.mCoverDesc.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(this.itemView.getContext(), com.bilibili.playset.R.drawable.drawable_watch_later_p), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mCoverDesc.setCompoundDrawablePadding(ScreenUtil.dip2px(this.itemView.getContext(), 4.0f));
        }

        private final void updateVideoLength(OfflineInfo info) {
            long playedTime = info.playedTime;
            if (playedTime == -1) {
                this.mCoverDesc.setText(this.itemView.getContext().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_626));
            } else if (playedTime <= 1000 || playedTime == -2) {
                this.mCoverDesc.setText(TimeFormater.formatTime$default(TimeFormater.INSTANCE, info.duration, false, false, 6, null));
            } else {
                String time = this.itemView.getContext().getString(R.string.offline_video_played_time, TimeFormater.formatTime$default(TimeFormater.INSTANCE, info.playedTime, false, false, 6, null), TimeFormater.formatTime$default(TimeFormater.INSTANCE, info.duration, false, false, 6, null));
                Intrinsics.checkNotNullExpressionValue(time, "getString(...)");
                this.mCoverDesc.setText(time);
            }
            View $this$isVisible$iv = this.mCoverDesc;
            $this$isVisible$iv.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void mOnClickListener$lambda$0(final DownloadedVideoHolder this$0, View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Object tag = v.getTag();
            DownloadedVideoHolder holder = tag instanceof DownloadedVideoHolder ? (DownloadedVideoHolder) tag : null;
            if (holder == null) {
                return;
            }
            if (this$0.mOfflineHomeAdapter.isEditMode()) {
                holder.mCheckBox.toggle();
                return;
            }
            Context context = v.getContext();
            final OfflineInfo info = holder.mInfo;
            if (info == null) {
                return;
            }
            if (info.getPageCount() == 1) {
                ItemActionCallback.PlayAction playAction = this$0.mOfflineHomeAdapter.getPlayAction();
                if (playAction != null) {
                    playAction.play(context, info);
                }
                OfflineReporter.reportHomeDownloadedVideoClick(info.isChargeVideo());
                return;
            }
            RouteRequest request = new RouteRequest.Builder("bilibili://offline/downloaded-page").extras(new Function1() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeHolder$DownloadedVideoHolder$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit mOnClickListener$lambda$0$0;
                    mOnClickListener$lambda$0$0 = OfflineHomeHolder.DownloadedVideoHolder.mOnClickListener$lambda$0$0(info, this$0, (MutableBundleLike) obj);
                    return mOnClickListener$lambda$0$0;
                }
            }).build();
            BLRouter.routeTo(request, context);
            OfflineReporter.reportHomeDownloadedVideoGroupClick();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit mOnClickListener$lambda$0$0(OfflineInfo $info, DownloadedVideoHolder this$0, MutableBundleLike $this$extras) {
            long j;
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            $this$extras.put(DownloadedPageActivity.KEY_VIDEO_ID, String.valueOf($info.id));
            String str = $info.title;
            if (str == null) {
                str = "";
            }
            $this$extras.put(DownloadedPageActivity.KEY_VIDEO_TITLE, str);
            if (this$0.mScene == HolderScene.DOWNLOAD_LIST && ($info.typeInfo instanceof DramaVideo)) {
                j = 1;
            } else {
                j = 0;
            }
            $this$extras.put(DownloadedPageActivity.KEY_PAGE_SCENE, String.valueOf(j));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void mCheckedChangeListener$lambda$0(DownloadedVideoHolder this$0, CompoundButton buttonView, boolean isChecked) {
            Object tag = buttonView.getTag();
            OfflineInfo info = tag instanceof OfflineInfo ? (OfflineInfo) tag : null;
            if (info == null) {
                return;
            }
            if (isChecked) {
                this$0.mOfflineHomeAdapter.check(info);
            } else {
                this$0.mOfflineHomeAdapter.unCheck(info);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean mLongClickListener$lambda$0(DownloadedVideoHolder this$0, View it) {
            if (!this$0.mOfflineHomeAdapter.isEditMode()) {
                this$0.mOfflineHomeAdapter.check(this$0.mInfo);
                this$0.mOfflineHomeAdapter.enterEditMode();
                return false;
            }
            return false;
        }

        private final long totalBytes(OfflineInfo parent) {
            List<OfflineInfo> pageList = parent.pages;
            if (pageList.isEmpty()) {
                return parent.totalBytes;
            }
            long j = 0;
            for (OfflineInfo it : pageList) {
                j += it != null ? it.totalBytes : 0L;
            }
            return j;
        }

        /* compiled from: OfflineHomeHolder.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedVideoHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedVideoHolder;", "parent", "Landroid/view/ViewGroup;", "offlineAdapter", "Ltv/danmaku/bili/ui/offline/OfflineAdapter;", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/bili/ui/offline/OfflineHomeHolder$DownloadedVideoHolder$HolderScene;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final DownloadedVideoHolder create(ViewGroup parent, OfflineAdapter offlineAdapter, HolderScene scene) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(offlineAdapter, "offlineAdapter");
                Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_offline_home_downloaded, parent, false);
                Intrinsics.checkNotNull(itemView);
                return new DownloadedVideoHolder(itemView, offlineAdapter, scene);
            }
        }

        @JvmStatic
        public static final DownloadedVideoHolder create(ViewGroup parent, OfflineAdapter offlineAdapter, HolderScene scene) {
            return Companion.create(parent, offlineAdapter, scene);
        }
    }
}