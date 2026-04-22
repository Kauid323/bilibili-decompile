package tv.danmaku.bili.auth.modify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.auth.R;
import com.bilibili.bottomoptionsheet.BottomOptionSheet;
import com.bilibili.bottomoptionsheet.SheetItem;
import com.bilibili.bottomoptionsheet.listeners.OnSheetItemClickListener;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.TipLinkHelper;
import tv.danmaku.bili.auth.helper.AlbumHelper;
import tv.danmaku.bili.auth.helper.ReasonType;
import tv.danmaku.bili.auth.helper.RequestUploadPhotoListener;
import tv.danmaku.bili.auth.helper.ViewHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.utils.PhotoUtil;

/* compiled from: BiliAuthUploadFragment.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001XB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u00102\u001a\u0004\u0018\u00010\u00162\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\"\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020\u0016H\u0002J\u0010\u0010A\u001a\u00020:2\b\u0010B\u001a\u0004\u0018\u00010\u0010J$\u0010C\u001a\u00020:2\b\u0010B\u001a\u0004\u0018\u00010\u00102\b\u0010D\u001a\u0004\u0018\u00010,2\b\u0010E\u001a\u0004\u0018\u00010,J\u0012\u0010F\u001a\u00020:2\b\u0010E\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010G\u001a\u00020:2\b\u0010H\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010L\u001a\u00020:H\u0002J\u000e\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020)J\u0010\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020\tH\u0002J\b\u0010Q\u001a\u00020\u001eH\u0002J\b\u0010R\u001a\u00020:H\u0002J\u0010\u0010S\u001a\u00020:2\u0006\u0010T\u001a\u00020\tH\u0016J\u0012\u0010S\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010U\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010,2\u0006\u0010V\u001a\u00020\u001eH\u0016J\b\u0010W\u001a\u00020:H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020,X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthUploadFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "Landroid/view/View$OnClickListener;", "Ltv/danmaku/bili/auth/helper/ViewHelper;", "<init>", "()V", "actvity", "Landroid/app/Activity;", "mReasonType", "", "mRVList", "", "Landroidx/recyclerview/widget/RecyclerView;", "mNextBtn", "Landroid/widget/Button;", "mTvTips1", "Landroid/widget/TextView;", "mTvTips2", "mTvTips3", "mCheckBox", "Landroid/widget/CheckBox;", "mCheckBoxContainer", "Landroid/view/View;", "mAgreementTips", "includedLayout1", "includedLayout2", "includedLayout3", "mUri", "Landroid/net/Uri;", "mIsChecked", "", "mCurrentAdapter", "Ltv/danmaku/bili/auth/modify/SelectPhotoAdapter;", "mBottomOptionSheet", "Lcom/bilibili/bottomoptionsheet/BottomOptionSheet;", "mAlbumHelper", "Ltv/danmaku/bili/auth/helper/AlbumHelper;", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "mPhotoList", "", "Ltv/danmaku/bili/auth/modify/UploadPhotoData;", "mTokenList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "jobs", "Lkotlinx/coroutines/Job;", "ID_SELECT_ALBUM", "ID_SELECT_CAMERA", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "initView", "view", "setTipLink", "mTv", "setTipDownload", "message", "url", "downloadEvent", "onClick", "v", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "isCancel", "nextClickEvent", "uploadTask", "photo", "checkCount", "count", "checkPhotoNum", "showSelectPhotoDialog", "showTip", "resId", "showProgressDialog", SplashCustomReporterKt.STATE_CANCEL, "dismissProgress", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthUploadFragment extends BaseAuthModifyFragment implements View.OnClickListener, ViewHelper {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthUploadFragment";
    private Activity actvity;
    private View includedLayout1;
    private View includedLayout2;
    private View includedLayout3;
    private boolean isCancel;
    private TextView mAgreementTips;
    private AlbumHelper mAlbumHelper;
    private BottomOptionSheet mBottomOptionSheet;
    private CheckBox mCheckBox;
    private View mCheckBoxContainer;
    private SelectPhotoAdapter mCurrentAdapter;
    private boolean mIsChecked;
    private Button mNextBtn;
    private TintProgressDialog mProgressDialog;
    private List<? extends RecyclerView> mRVList;
    private int mReasonType;
    private TextView mTvTips1;
    private TextView mTvTips2;
    private TextView mTvTips3;
    private Uri mUri;
    private List<UploadPhotoData> mPhotoList = new ArrayList();
    private ArrayList<String> mTokenList = new ArrayList<>();
    private final List<Job> jobs = new ArrayList();
    private final String ID_SELECT_ALBUM = "id_select_album";
    private final String ID_SELECT_CAMERA = "id_select_camera";
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override // tv.danmaku.bili.auth.helper.ViewHelper
    public /* synthetic */ void updateUIAfterUpPic(Uri uri) {
        ViewHelper.CC.$default$updateUIAfterUpPic(this, uri);
    }

    /* compiled from: BiliAuthUploadFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthUploadFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthUploadFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthUploadFragment newInstance(Bundle params) {
            BiliAuthUploadFragment fragment = new BiliAuthUploadFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        this.mReasonType = arguments != null ? arguments.getInt(getBUNDLE_KEY_MODIFY_REASON$auth_debug()) : 0;
        if (this.mReasonType == 1) {
            view = inflater.inflate(R.layout.fragment_auth_modify_commit_photo1, container, false);
        } else {
            view = inflater.inflate(R.layout.fragment_auth_modify_commit_photo2, container, false);
        }
        Intrinsics.checkNotNull(view);
        initView(view);
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        SelectPhotoAdapter selectPhotoAdapter;
        if (resultCode == -1) {
            switch (requestCode) {
                case BR.exposureEntry /* 202 */:
                    if (data != null && (selectPhotoAdapter = this.mCurrentAdapter) != null) {
                        selectPhotoAdapter.addPhoto(new UploadPhotoData(data.getData()));
                        break;
                    }
                    break;
                case 301:
                    if (PhotoUtil.hasSdcard()) {
                        this.mUri = Uri.fromFile(PhotoUtil.getTempFile());
                        SelectPhotoAdapter selectPhotoAdapter2 = this.mCurrentAdapter;
                        if (selectPhotoAdapter2 != null) {
                            selectPhotoAdapter2.addPhoto(new UploadPhotoData(this.mUri));
                            break;
                        }
                    }
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private final void initView(View view) {
        this.actvity = (Activity) requireHostActivity();
        this.mProgressDialog = new TintProgressDialog(getActivity());
        TintProgressDialog $this$initView_u24lambda_u240 = this.mProgressDialog;
        if ($this$initView_u24lambda_u240 != null) {
            $this$initView_u24lambda_u240.setIndeterminate(true);
            $this$initView_u24lambda_u240.setCancelable(true);
        }
        this.mAlbumHelper = new AlbumHelperImpl(getActivity(), this);
        this.mNextBtn = (Button) view.findViewById(R.id.btn_next);
        Button button = this.mNextBtn;
        if (button != null) {
            button.setOnClickListener(this);
        }
        Button button2 = this.mNextBtn;
        if (button2 != null) {
            button2.setEnabled(false);
        }
        this.mTvTips1 = (TextView) view.findViewById(R.id.upload_tips1);
        this.mTvTips2 = (TextView) view.findViewById(R.id.upload_tips2);
        this.mTvTips3 = (TextView) view.findViewById(R.id.upload_tips3);
        setTipLink(this.mTvTips1);
        setTipLink(this.mTvTips2);
        if (this.mReasonType == ReasonType.KINSHIP.getValue()) {
            setTipDownload(this.mTvTips3, getString(bili.resource.account.R.string.account_global_string_205), getURL_BILI_AUTH_TEMPLATE_CONFIRMATION$auth_debug());
        } else if (this.mReasonType == ReasonType.JOBCHANGE.getValue()) {
            setTipDownload(this.mTvTips3, getString(bili.resource.account.R.string.account_global_string_211), getURL_BILI_AUTH_TEMPLATE_AGREEMENT$auth_debug());
        }
        this.includedLayout1 = view.findViewById(R.id.photo_container1);
        this.includedLayout2 = view.findViewById(R.id.photo_container2);
        this.includedLayout3 = view.findViewById(R.id.photo_container3);
        this.mCheckBoxContainer = view.findViewById(R.id.facial_ag_checkbox_container);
        this.mCheckBox = (CheckBox) view.findViewById(R.id.facial_ag_checkbox);
        CheckBox checkBox = this.mCheckBox;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthUploadFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BiliAuthUploadFragment.this.mIsChecked = z;
                }
            });
        }
        this.mAgreementTips = (TextView) view.findViewById(R.id.tv_facial_agreement);
        handleAgreement(this.mAgreementTips);
        View view2 = this.mCheckBoxContainer;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        TextView textView = this.mAgreementTips;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        View view3 = this.includedLayout1;
        RecyclerView recyclerView1 = view3 != null ? (RecyclerView) view3.findViewById(R.id.photo_container1) : null;
        View view4 = this.includedLayout2;
        RecyclerView recyclerView2 = view4 != null ? (RecyclerView) view4.findViewById(R.id.photo_container2) : null;
        View view5 = this.includedLayout3;
        RecyclerView recyclerView3 = view5 != null ? (RecyclerView) view5.findViewById(R.id.photo_container3) : null;
        this.mRVList = CollectionsKt.listOf(new RecyclerView[]{recyclerView1, recyclerView2, recyclerView3});
        Iterable iterable = this.mRVList;
        if (iterable != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                RecyclerView recyclerView = (RecyclerView) element$iv;
                if (recyclerView != null) {
                    SelectPhotoAdapter $this$initView_u24lambda_u242_u240_u240 = new SelectPhotoAdapter();
                    $this$initView_u24lambda_u242_u240_u240.setListener(new SelectPhotoListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthUploadFragment$initView$3$1$1$1
                        @Override // tv.danmaku.bili.auth.modify.SelectPhotoListener
                        public void openAblum(SelectPhotoAdapter adapter) {
                            Intrinsics.checkNotNullParameter(adapter, "adapter");
                            BiliAuthUploadFragment.this.mCurrentAdapter = adapter;
                            BiliAuthUploadFragment.this.showSelectPhotoDialog();
                        }
                    });
                    recyclerView.setAdapter($this$initView_u24lambda_u242_u240_u240);
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
                }
            }
        }
        if (this.mReasonType == 0) {
            SelectPhotoAdapter adapter = (SelectPhotoAdapter) (recyclerView3 != null ? recyclerView3.getAdapter() : null);
            if (adapter != null) {
                adapter.setMaxNum(1);
            }
        }
    }

    public final void setTipLink(TextView mTv) {
        TipLinkHelper tipLinkHelper = TipLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_331);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(bili.resource.account.R.string.account_global_string_426);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        tipLinkHelper.setLink(mTv, string, string2, new ClickableSpan() { // from class: tv.danmaku.bili.auth.modify.BiliAuthUploadFragment$setTipLink$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                RouteRequest request = new RouteRequest.Builder(BiliAuthUploadFragment.this.getURL_BILI_AUTH_MODIFY_UPLOAD_NORM$auth_debug()).build();
                BiliAuthUploadFragment.this.showFragmentByRoute(BiliAuthUploadFragment.this.getContext(), (Fragment) BiliAuthUploadFragment.this, request, BIliAuthUploadNormFragment.TAG);
            }
        });
    }

    public final void setTipDownload(TextView mTv, String message, final String url) {
        TipLinkHelper tipLinkHelper = TipLinkHelper.INSTANCE;
        String str = message == null ? "" : message;
        String string = getString(bili.resource.account.R.string.account_global_string_311);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        tipLinkHelper.setLink(mTv, str, string, new ClickableSpan() { // from class: tv.danmaku.bili.auth.modify.BiliAuthUploadFragment$setTipDownload$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                BiliAuthUploadFragment.this.downloadEvent(url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadEvent(String url) {
        AlbumHelper albumHelper = this.mAlbumHelper;
        if (albumHelper != null) {
            albumHelper.downloadImageToAlbum(this, url);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.btn_next;
        if (valueOf != null && valueOf.intValue() == i) {
            nextClickEvent();
            return;
        }
        int i2 = R.id.facial_ag_checkbox_container;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.tv_facial_agreement;
            if (valueOf == null || valueOf.intValue() != i3) {
                return;
            }
        }
        CheckBox $this$onClick_u24lambda_u240 = this.mCheckBox;
        if ($this$onClick_u24lambda_u240 != null) {
            $this$onClick_u24lambda_u240.setChecked(!$this$onClick_u24lambda_u240.isChecked());
            Button button = this.mNextBtn;
            if (button != null) {
                button.setEnabled($this$onClick_u24lambda_u240.isChecked());
            }
        }
    }

    private final void nextClickEvent() {
        this.mPhotoList.clear();
        this.jobs.clear();
        this.counter.set(0);
        this.mTokenList.clear();
        this.isCancel = true;
        if (!checkPhotoNum()) {
            ToastHelper.showToastShort(getContext(), bili.resource.account.R.string.account_global_string_272);
        } else if (!this.mPhotoList.isEmpty() && this.mPhotoList.size() >= 7) {
            showProgressDialog(getString(bili.resource.account.R.string.account_global_string_304), true);
            CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            Iterable $this$forEach$iv = this.mPhotoList;
            for (Object element$iv : $this$forEach$iv) {
                UploadPhotoData photo = (UploadPhotoData) element$iv;
                this.isCancel = false;
                Job job = BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new BiliAuthUploadFragment$nextClickEvent$1$job$1(photo, this, null), 3, (Object) null);
                this.jobs.add(job);
            }
        }
    }

    public final void uploadTask(final UploadPhotoData photo) {
        Intrinsics.checkNotNullParameter(photo, "photo");
        AlbumHelper albumHelper = this.mAlbumHelper;
        boolean success = albumHelper != null ? albumHelper.uploadCardPic(photo.getMUri(), new RequestUploadPhotoListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthUploadFragment$uploadTask$success$1
            @Override // tv.danmaku.bili.auth.helper.RequestUploadPhotoListener
            public void onSuccess(String token) {
                ArrayList arrayList;
                AtomicInteger atomicInteger;
                UploadPhotoData uploadPhotoData = UploadPhotoData.this;
                if (uploadPhotoData != null) {
                    uploadPhotoData.setMToken(token);
                }
                arrayList = this.mTokenList;
                arrayList.add(token == null ? "" : token);
                BiliAuthUploadFragment biliAuthUploadFragment = this;
                atomicInteger = this.counter;
                biliAuthUploadFragment.checkCount(atomicInteger.incrementAndGet());
            }

            @Override // tv.danmaku.bili.auth.helper.RequestUploadPhotoListener
            public void onError() {
                AtomicInteger atomicInteger;
                BiliAuthUploadFragment biliAuthUploadFragment = this;
                atomicInteger = this.counter;
                biliAuthUploadFragment.checkCount(atomicInteger.incrementAndGet());
            }

            @Override // tv.danmaku.bili.auth.helper.RequestUploadPhotoListener
            public boolean onCancel() {
                boolean z;
                FragmentActivity activity = this.getActivity();
                if (!(activity != null ? activity.isDestroyed() : false)) {
                    z = this.isCancel;
                    if (!z) {
                        return false;
                    }
                }
                return true;
            }
        }) : false;
        if (!success) {
            checkCount(this.counter.incrementAndGet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkCount(int count) {
        if (count != this.mPhotoList.size()) {
            return;
        }
        dismissProgress();
        if (this.mTokenList.size() == this.mPhotoList.size()) {
            Iterable $this$forEach$iv = this.jobs;
            for (Object element$iv : $this$forEach$iv) {
                Job job = (Job) element$iv;
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.jobs.clear();
            Bundle bundle = getArguments();
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putStringArrayList(getBUNDLE_KEY_PHOTOS$auth_debug(), this.mTokenList);
            showFragmentWithBundle(getContext(), bundle, (Fragment) this, getURL_BILI_AUTH_MODIFY_PERSON_ORIGINAL$auth_debug(), "BiliAuthNewNameFragment");
            return;
        }
        ToastHelper.showToastShort(getContext(), bili.resource.account.R.string.account_global_string_235);
    }

    private final boolean checkPhotoNum() {
        List list;
        List<UploadPhotoData> photoList;
        List list2;
        List<UploadPhotoData> photoList2;
        List list3;
        List<UploadPhotoData> photoList3;
        List<? extends RecyclerView> list4 = this.mRVList;
        RecyclerView it = list4 != null ? list4.get(0) : null;
        SelectPhotoAdapter adapter = (SelectPhotoAdapter) (it != null ? it.getAdapter() : null);
        if (!Intrinsics.areEqual(adapter != null ? Integer.valueOf(adapter.getMaxNum()) : null, (adapter == null || (photoList3 = adapter.getPhotoList()) == null) ? null : Integer.valueOf(photoList3.size()))) {
            this.mPhotoList.clear();
            return false;
        }
        if (adapter != null && (list3 = adapter.getPhotoList()) != null) {
            this.mPhotoList.addAll(list3);
        }
        List<? extends RecyclerView> list5 = this.mRVList;
        RecyclerView it2 = list5 != null ? list5.get(1) : null;
        SelectPhotoAdapter adapter2 = (SelectPhotoAdapter) (it2 != null ? it2.getAdapter() : null);
        if (!Intrinsics.areEqual(adapter2 != null ? Integer.valueOf(adapter2.getMaxNum()) : null, (adapter2 == null || (photoList2 = adapter2.getPhotoList()) == null) ? null : Integer.valueOf(photoList2.size()))) {
            this.mPhotoList.clear();
            return false;
        }
        if (adapter2 != null && (list2 = adapter2.getPhotoList()) != null) {
            this.mPhotoList.addAll(list2);
        }
        List<? extends RecyclerView> list6 = this.mRVList;
        RecyclerView it3 = list6 != null ? list6.get(2) : null;
        SelectPhotoAdapter adapter3 = (SelectPhotoAdapter) (it3 != null ? it3.getAdapter() : null);
        if (!((adapter3 == null || (photoList = adapter3.getPhotoList()) == null || !(photoList.isEmpty() ^ true)) ? false : true)) {
            this.mPhotoList.clear();
            return false;
        }
        if (adapter3 != null && (list = adapter3.getPhotoList()) != null) {
            this.mPhotoList.addAll(list);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSelectPhotoDialog() {
        BottomOptionSheet bottomOptionSheet;
        if (this.mBottomOptionSheet == null) {
            Context it = getContext();
            if (it != null) {
                this.mBottomOptionSheet = new BottomOptionSheet(it);
                BottomOptionSheet bottomOptionSheet2 = this.mBottomOptionSheet;
                if (bottomOptionSheet2 != null) {
                    bottomOptionSheet2.addSheetItem(new SheetItem(it, this.ID_SELECT_ALBUM, bili.resource.account.R.string.account_global_string_466));
                }
                BottomOptionSheet bottomOptionSheet3 = this.mBottomOptionSheet;
                if (bottomOptionSheet3 != null) {
                    bottomOptionSheet3.addSheetItem(new SheetItem(it, this.ID_SELECT_CAMERA, bili.resource.account.R.string.account_global_string_467));
                }
            }
            BottomOptionSheet bottomOptionSheet4 = this.mBottomOptionSheet;
            if (bottomOptionSheet4 != null) {
                bottomOptionSheet4.sheetItemClickListener(new OnSheetItemClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthUploadFragment$$ExternalSyntheticLambda1
                    public final void onItemClick(SheetItem sheetItem) {
                        BiliAuthUploadFragment.showSelectPhotoDialog$lambda$1(BiliAuthUploadFragment.this, sheetItem);
                    }
                });
            }
            BottomOptionSheet bottomOptionSheet5 = this.mBottomOptionSheet;
            if (bottomOptionSheet5 != null) {
                bottomOptionSheet5.show();
                return;
            }
            return;
        }
        BottomOptionSheet bottomOptionSheet6 = this.mBottomOptionSheet;
        boolean z = false;
        if (bottomOptionSheet6 != null && bottomOptionSheet6.isShowing()) {
            z = true;
        }
        if (z || (bottomOptionSheet = this.mBottomOptionSheet) == null) {
            return;
        }
        bottomOptionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectPhotoDialog$lambda$1(BiliAuthUploadFragment this$0, SheetItem item) {
        AlbumHelper albumHelper;
        AlbumHelper albumHelper2;
        Intrinsics.checkNotNullParameter(item, "item");
        String id = item.getId();
        if (Intrinsics.areEqual(id, this$0.ID_SELECT_ALBUM)) {
            if (this$0.getActivity() == null || this$0.mAlbumHelper == null) {
                return;
            }
            Activity activity = this$0.actvity;
            if (!(activity != null ? activity instanceof BaseAppCompatActivity : true) || (albumHelper2 = this$0.mAlbumHelper) == null) {
                return;
            }
            albumHelper2.openAlbum(this$0);
        } else if (!Intrinsics.areEqual(id, this$0.ID_SELECT_CAMERA) || this$0.getActivity() == null || this$0.mAlbumHelper == null) {
        } else {
            Activity activity2 = this$0.actvity;
            if (!(activity2 != null ? activity2 instanceof BaseAppCompatActivity : true) || (albumHelper = this$0.mAlbumHelper) == null) {
                return;
            }
            albumHelper.startCamera(this$0);
        }
    }

    @Override // tv.danmaku.bili.auth.helper.ViewHelper
    public void showTip(int resId) {
        ToastHelper.showToast(getActivity(), resId, 0);
    }

    @Override // tv.danmaku.bili.auth.helper.ViewHelper
    public void showTip(String message) {
    }

    @Override // tv.danmaku.bili.auth.helper.ViewHelper
    public void showProgressDialog(String message, boolean cancel) {
        TintProgressDialog tintProgressDialog;
        if (this.mProgressDialog == null) {
            return;
        }
        TintProgressDialog tintProgressDialog2 = this.mProgressDialog;
        if (tintProgressDialog2 != null) {
            tintProgressDialog2.setCanceledOnTouchOutside(cancel);
        }
        TintProgressDialog tintProgressDialog3 = this.mProgressDialog;
        if (tintProgressDialog3 != null) {
            tintProgressDialog3.setMessage(message);
        }
        TintProgressDialog tintProgressDialog4 = this.mProgressDialog;
        boolean z = false;
        if (tintProgressDialog4 != null && tintProgressDialog4.isShowing()) {
            z = true;
        }
        if (z || (tintProgressDialog = this.mProgressDialog) == null) {
            return;
        }
        tintProgressDialog.show();
    }

    @Override // tv.danmaku.bili.auth.helper.ViewHelper
    public void dismissProgress() {
        TintProgressDialog tintProgressDialog;
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing() || this.mProgressDialog == null) {
            return;
        }
        TintProgressDialog tintProgressDialog2 = this.mProgressDialog;
        boolean z = false;
        if (tintProgressDialog2 != null && tintProgressDialog2.isShowing()) {
            z = true;
        }
        if (!z || (tintProgressDialog = this.mProgressDialog) == null) {
            return;
        }
        tintProgressDialog.dismiss();
    }
}