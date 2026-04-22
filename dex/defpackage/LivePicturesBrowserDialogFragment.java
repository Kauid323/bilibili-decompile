package defpackage;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import com.bilibili.bililive.infra.log.LiveLogger;
import com.bilibili.bililive.infra.picturebrowser.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: LivePicturesBrowserDialogFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0002R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"LLivePicturesBrowserDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setWindowParams", "logTag", "", "getLogTag", "()Ljava/lang/String;", "Companion", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: LivePicturesBrowserDialogFragment  reason: default package */
public final class LivePicturesBrowserDialogFragment extends DialogFragment implements LiveLogger {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_PICS = "pics";
    private static final String KEY_POSITION = "position";
    public static final String TAG = "LivePicturesBrowserDialogFragment";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.LivePicBrowserDialog);
    }

    public void onStart() {
        super.onStart();
        setWindowParams();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.live_pic_browser_dialog_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ArrayList pic;
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle arguments = getArguments();
        if (arguments == null || (pic = arguments.getParcelableArrayList(KEY_PICS)) == null) {
            pic = new ArrayList();
        }
        Bundle arguments2 = getArguments();
        int position = arguments2 != null ? arguments2.getInt(KEY_POSITION, 0) : 0;
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i = R.id.v_container;
        Fragment create = LivePictureBrowserPagerFragment.Companion.create(pic, position);
        create.setPictureBrowserListener(new LivePictureBrowserListener() { // from class: LivePicturesBrowserDialogFragment$onViewCreated$1$1
            public void onImageViewClick() {
                LivePicturesBrowserDialogFragment.this.dismissAllowingStateLoss();
            }

            public void onDragRelease() {
                LivePicturesBrowserDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        Unit unit = Unit.INSTANCE;
        beginTransaction.add(i, create).commitAllowingStateLoss();
    }

    private final void setWindowParams() {
        String str;
        Window $this$setWindowParams_u24lambda_u240;
        try {
            Dialog dialog = getDialog();
            if (dialog != null && ($this$setWindowParams_u24lambda_u240 = dialog.getWindow()) != null) {
                $this$setWindowParams_u24lambda_u240.setLayout(-1, -1);
                $this$setWindowParams_u24lambda_u240.setWindowAnimations(R.style.LivePicBrowserDialogAnim);
                $this$setWindowParams_u24lambda_u240.setDimAmount(0.0f);
                $this$setWindowParams_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
                $this$setWindowParams_u24lambda_u240.addFlags(512);
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams lp = $this$setWindowParams_u24lambda_u240.getAttributes();
                    if (lp != null) {
                        lp.layoutInDisplayCutoutMode = 1;
                    }
                    $this$setWindowParams_u24lambda_u240.setAttributes(lp);
                }
            }
        } catch (Exception e) {
            LivePicturesBrowserDialogFragment $this$logError_u24default$iv = this;
            LiveLog.Companion this_$iv$iv = LiveLog.Companion;
            String tag$iv$iv = $this$logError_u24default$iv.getLogTag();
            if (this_$iv$iv.matchLevel(1)) {
                try {
                    str = "setWindowParams exception" + e;
                } catch (Exception e$iv$iv$iv) {
                    BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv);
                    str = null;
                }
                String msg$iv$iv$iv = str;
                if (msg$iv$iv$iv == null) {
                    msg$iv$iv$iv = "";
                }
                String message$iv$iv = msg$iv$iv$iv;
                LiveLogDelegate logDelegate = this_$iv$iv.getLogDelegate();
                if (logDelegate != null) {
                    logDelegate.onLog(1, tag$iv$iv, message$iv$iv, (Throwable) null);
                }
                BLog.e(tag$iv$iv, message$iv$iv);
            }
        }
    }

    /* compiled from: LivePicturesBrowserDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"LLivePicturesBrowserDialogFragment$Companion;", "", "<init>", "()V", "create", "LLivePicturesBrowserDialogFragment;", LivePicturesBrowserDialogFragment.KEY_PICS, "Ljava/util/ArrayList;", "LILivePictureData;", "Lkotlin/collections/ArrayList;", LivePicturesBrowserDialogFragment.KEY_POSITION, "", "TAG", "", "KEY_PICS", "KEY_POSITION", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: LivePicturesBrowserDialogFragment$Companion */
    /* loaded from: /data/np/file-convert/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ LivePicturesBrowserDialogFragment create$default(Companion companion, ArrayList arrayList, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.create(arrayList, i);
        }

        public final LivePicturesBrowserDialogFragment create(ArrayList<ILivePictureData> arrayList, int position) {
            Intrinsics.checkNotNullParameter(arrayList, LivePicturesBrowserDialogFragment.KEY_PICS);
            LivePicturesBrowserDialogFragment $this$create_u24lambda_u240 = new LivePicturesBrowserDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(LivePicturesBrowserDialogFragment.KEY_PICS, arrayList);
            bundle.putInt(LivePicturesBrowserDialogFragment.KEY_POSITION, position);
            $this$create_u24lambda_u240.setArguments(bundle);
            return $this$create_u24lambda_u240;
        }
    }

    public String getLogTag() {
        return TAG;
    }
}