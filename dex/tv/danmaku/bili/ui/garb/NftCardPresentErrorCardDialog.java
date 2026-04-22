package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bilibili.lib.projection.internal.base.BaseProjectionDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: NftCardPresentErrorCardDialog.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardPresentErrorCardDialog;", "Lcom/bilibili/lib/projection/internal/base/BaseProjectionDialogFragment;", ReportUtilKt.POS_TITLE, "", "contentTemplate", "highlightParams", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getContentTemplate", "getHighlightParams", "()Ljava/util/List;", "onStart", "", "compatDialogLayout", "mCloseBtn", "Landroid/widget/ImageView;", "mTitleView", "Landroid/widget/TextView;", "mContentView", "mConfirmBtn", "initView", "view", "Landroid/view/View;", "getDialogViewRes", "", "replaceHighlightText", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardPresentErrorCardDialog extends BaseProjectionDialogFragment {
    public static final String TAG = "NftCardPresentErrorCardDialog";
    private final String contentTemplate;
    private final List<String> highlightParams;
    private ImageView mCloseBtn;
    private TextView mConfirmBtn;
    private TextView mContentView;
    private TextView mTitleView;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NftCardPresentErrorCardDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardPresentErrorCardDialog$Companion;", "", "<init>", "()V", "TAG", "", ReportEvent.EVENT_TYPE_SHOW, "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", ReportUtilKt.POS_TITLE, "contentTemplate", "highlightParams", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void show(Activity activity, String title, String contentTemplate, List<String> list) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            if (!activity.isFinishing() && !activity.isDestroyed() && (activity instanceof FragmentActivity)) {
                FragmentManager fm = ((FragmentActivity) activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(fm, "getSupportFragmentManager(...)");
                BaseProjectionDialogFragment fragment = fm.findFragmentByTag(NftCardPresentErrorCardDialog.TAG);
                if (fragment == null) {
                    fragment = (Fragment) new NftCardPresentErrorCardDialog(title, contentTemplate, list);
                }
                if ((fragment instanceof BaseProjectionDialogFragment) && !fragment.isAdded()) {
                    fragment.showNow(fm, NftCardPresentErrorCardDialog.TAG);
                }
            }
        }
    }

    public NftCardPresentErrorCardDialog(String title, String contentTemplate, List<String> list) {
        this.title = title;
        this.contentTemplate = contentTemplate;
        this.highlightParams = list;
    }

    public final String getContentTemplate() {
        return this.contentTemplate;
    }

    public final List<String> getHighlightParams() {
        return this.highlightParams;
    }

    public final String getTitle() {
        return this.title;
    }

    public void onStart() {
        compatDialogLayout();
        super.onStart();
    }

    private final void compatDialogLayout() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window != null ? window.getAttributes() : null;
        if (lp != null) {
            lp.width = -1;
        }
        if (lp != null) {
            lp.height = -1;
        }
        if (window != null) {
            window.setAttributes(lp);
        }
    }

    protected void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.nft_transfer_close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mCloseBtn = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.nft_transfer_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mTitleView = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.nft_transfer_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mContentView = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.nft_transfer_i_know);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mConfirmBtn = (TextView) findViewById4;
        ImageView imageView = this.mCloseBtn;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardPresentErrorCardDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NftCardPresentErrorCardDialog.this.dismiss();
            }
        });
        TextView textView2 = this.mConfirmBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardPresentErrorCardDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NftCardPresentErrorCardDialog.this.dismiss();
            }
        });
        String it = this.title;
        if (it != null) {
            TextView textView3 = this.mTitleView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                textView3 = null;
            }
            textView3.setText(it);
        }
        if (this.contentTemplate != null && this.highlightParams != null) {
            TextView textView4 = this.mContentView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            } else {
                textView = textView4;
            }
            textView.setText(replaceHighlightText(this.contentTemplate, this.highlightParams));
        }
    }

    protected int getDialogViewRes() {
        return R.layout.bili_app_nft_transfer_dialog;
    }

    private final CharSequence replaceHighlightText(String contentTemplate, List<String> list) {
        Resources resource;
        List oldString = StringsKt.split$default(contentTemplate, new String[]{"{{}}"}, false, 0, 6, (Object) null);
        SpannableStringBuilder builder = new SpannableStringBuilder();
        Object indexList = new ArrayList();
        ArrayList arrayList = (List) indexList;
        if (list != null) {
            List<String> $this$forEachIndexed$iv = list;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String s = (String) item$iv;
                builder.append((CharSequence) oldString.get(index));
                builder.append((CharSequence) s);
                arrayList.add(new Pair(Integer.valueOf(builder.length() - s.length()), Integer.valueOf(builder.length())));
                index = index$iv;
            }
        }
        if (!StringsKt.endsWith$default(contentTemplate, "{{}}", false, 2, (Object) null)) {
            builder.append((CharSequence) oldString.get(oldString.size() - 1));
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (resource = activity.getResources()) != null) {
            ArrayList $this$forEach$iv = arrayList;
            for (Object element$iv : $this$forEach$iv) {
                Pair it = (Pair) element$iv;
                builder.setSpan(new ForegroundColorSpan(resource.getColor(R.color.bili_nft_transfer_highlight)), ((Number) it.getFirst()).intValue(), ((Number) it.getSecond()).intValue(), 33);
            }
        }
        return builder;
    }
}