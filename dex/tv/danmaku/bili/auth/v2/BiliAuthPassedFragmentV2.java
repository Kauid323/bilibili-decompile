package tv.danmaku.bili.auth.v2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.app.auth.R;
import com.bilibili.bottomoptionsheet.BottomOptionSheet;
import com.bilibili.bottomoptionsheet.SheetItem;
import com.bilibili.bottomoptionsheet.listeners.OnSheetItemClickListener;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthAgreementLinkHelper;
import tv.danmaku.bili.auth.BiliAuthExtsKt;
import tv.danmaku.bili.auth.LinkItemListener;
import tv.danmaku.bili.report.DefaultAuthReporter;

/* compiled from: BiliAuthPassedFragmentV2.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthPassedFragmentV2;", "Ltv/danmaku/bili/auth/v2/BaseAuthFragmentV2;", "<init>", "()V", "mName", "Landroid/widget/TextView;", "mCard", "mBottomOptionSheet", "Lcom/bilibili/bottomoptionsheet/BottomOptionSheet;", "BUNDLE_KEY_MODIFY", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "handleAgreement", "view", "onViewCreated", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "refreshUi", "ID_MODIFY", "showSelectPhotoDialog", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthPassedFragmentV2 extends BaseAuthFragmentV2 {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthPassedFragmentV2";
    private final String BUNDLE_KEY_MODIFY = "modify_bundle_key";
    private final String ID_MODIFY = "id_modify";
    private BottomOptionSheet mBottomOptionSheet;
    private TextView mCard;
    private TextView mName;

    /* compiled from: BiliAuthPassedFragmentV2.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthPassedFragmentV2$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/v2/BiliAuthPassedFragmentV2;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthPassedFragmentV2 newInstance(Bundle params) {
            BiliAuthPassedFragmentV2 fragment = new BiliAuthPassedFragmentV2();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_sucess2, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mName = (TextView) view.findViewById(R.id.name);
        this.mCard = (TextView) view.findViewById(R.id.card);
        handleAgreement(view);
        return view;
    }

    private final void handleAgreement(final View view) {
        TextView agreement = (TextView) view.findViewById(R.id.tv_modify_agreement);
        String agreementUrl_facial = AuthAgreementLinkHelper.INSTANCE.getFacialAgreementLink();
        String agreementUrl_auth = AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink();
        String agreementHighLight = getString(bili.resource.account.R.string.account_global_string_254);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight, "getString(...)");
        String agreementHighLight1 = getString(bili.resource.account.R.string.account_global_string_312);
        Intrinsics.checkNotNullExpressionValue(agreementHighLight1, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_226);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(agreement, string, agreementHighLight, agreementUrl_facial, FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthPassedFragmentV2$handleAgreement$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BiliAuthPassedFragmentV2.this.getActivity(), view, 0);
            }
        }, (r23 & 64) != 0 ? "" : agreementHighLight1, (r23 & BR.cover) != 0 ? "" : agreementUrl_auth, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        refreshUi();
        DefaultAuthReporter.reportAuthResultShow$default(DefaultAuthReporter.INSTANCE, sourceEvent(), 1, null, 4, null);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (BiliAuthExtsKt.getRealnameMadifyControl()) {
            inflater.inflate(R.menu.menu_more, menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (BiliAuthExtsKt.getRealnameMadifyControl()) {
            int itemId = item.getItemId();
            if (itemId == R.id.realname_manage) {
                showSelectPhotoDialog();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void refreshUi() {
        Bundle extra = getArguments();
        if (extra != null) {
            String name = extra.getString("key_real_name");
            if (name == null) {
                name = "";
            }
            String string = extra.getString("key_card");
            String card = string != null ? string : "";
            TextView textView = this.mName;
            if (textView != null) {
                textView.setText(name);
            }
            TextView textView2 = this.mCard;
            if (textView2 != null) {
                textView2.setText(card);
            }
        }
    }

    private final void showSelectPhotoDialog() {
        BottomOptionSheet bottomOptionSheet;
        if (this.mBottomOptionSheet == null) {
            Context it = getContext();
            if (it != null) {
                this.mBottomOptionSheet = new BottomOptionSheet(it);
                BottomOptionSheet bottomOptionSheet2 = this.mBottomOptionSheet;
                if (bottomOptionSheet2 != null) {
                    bottomOptionSheet2.addSheetItem(new SheetItem(it, this.ID_MODIFY, bili.resource.account.R.string.account_global_string_263));
                }
            }
            BottomOptionSheet bottomOptionSheet3 = this.mBottomOptionSheet;
            if (bottomOptionSheet3 != null) {
                bottomOptionSheet3.sheetItemClickListener(new OnSheetItemClickListener() { // from class: tv.danmaku.bili.auth.v2.BiliAuthPassedFragmentV2$$ExternalSyntheticLambda0
                    public final void onItemClick(SheetItem sheetItem) {
                        BiliAuthPassedFragmentV2.showSelectPhotoDialog$lambda$1(BiliAuthPassedFragmentV2.this, sheetItem);
                    }
                });
            }
            BottomOptionSheet bottomOptionSheet4 = this.mBottomOptionSheet;
            if (bottomOptionSheet4 != null) {
                bottomOptionSheet4.show();
                return;
            }
            return;
        }
        BottomOptionSheet bottomOptionSheet5 = this.mBottomOptionSheet;
        boolean z = false;
        if (bottomOptionSheet5 != null && bottomOptionSheet5.isShowing()) {
            z = true;
        }
        if (z || (bottomOptionSheet = this.mBottomOptionSheet) == null) {
            return;
        }
        bottomOptionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectPhotoDialog$lambda$1(final BiliAuthPassedFragmentV2 this$0, SheetItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (Intrinsics.areEqual(item.getId(), this$0.ID_MODIFY)) {
            Uri parse = Uri.parse("bilibili://auth/modify");
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest request = new RouteRequest.Builder(parse).extras(new Function1() { // from class: tv.danmaku.bili.auth.v2.BiliAuthPassedFragmentV2$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit showSelectPhotoDialog$lambda$1$0;
                    showSelectPhotoDialog$lambda$1$0 = BiliAuthPassedFragmentV2.showSelectPhotoDialog$lambda$1$0(BiliAuthPassedFragmentV2.this, (MutableBundleLike) obj);
                    return showSelectPhotoDialog$lambda$1$0;
                }
            }).build();
            BLRouter.routeTo(request, this$0.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showSelectPhotoDialog$lambda$1$0(BiliAuthPassedFragmentV2 this$0, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String str = this$0.BUNDLE_KEY_MODIFY;
        Bundle arguments = this$0.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        $this$extras.put(str, arguments);
        return Unit.INSTANCE;
    }
}