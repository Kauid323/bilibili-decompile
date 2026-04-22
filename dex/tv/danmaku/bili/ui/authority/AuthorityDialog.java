package tv.danmaku.bili.ui.authority;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.R;
import tv.danmaku.bili.router.RouterProtocol;
import tv.danmaku.bili.widget.dialog.BaseDialog;

public class AuthorityDialog extends BaseDialog<AuthorityDialog> implements View.OnClickListener {
    private static final String BIND_PHONE_H5 = "https://passport.bilibili.com/mobile/index.html";
    private static final String CHANGE_PHONE_H5 = "https://passport.bilibili.com/mobile/changetel.html";
    private static final String INTAL_BIND_PHONE_H5 = "https://passport.bilibili.com/account/mobile/security/bindphone/phone/set?closebrowser=1";
    private TextView mHintTxt;
    private TextView mMsgTxt;
    private TextView mOKTxt;
    private AuthorityState mState;
    private TextView mTitleTxt;

    public AuthorityDialog(Context context, AuthorityState state) {
        super(context);
        this.mState = state;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public View onCreateView() {
        return LayoutInflater.from(this.mContext).inflate(R.layout.bili_app_player_view_danmaku_authority, (ViewGroup) null);
    }

    public void onViewCreated(View view) {
        this.mTitleTxt = (TextView) view.findViewById(R.id.title);
        this.mMsgTxt = (TextView) view.findViewById(R.id.message);
        this.mOKTxt = (TextView) view.findViewById(R.id.ok);
        this.mOKTxt.setOnClickListener(this);
        this.mHintTxt = (TextView) view.findViewById(R.id.hint);
        this.mHintTxt.setOnClickListener(this);
        this.mHintTxt.setPaintFlags(this.mHintTxt.getPaintFlags() | 8);
        view.findViewById(R.id.cancel).setOnClickListener(this);
        StaticImageView2 staticImageView2 = view.findViewById(R.id.image);
        staticImageView2.setImageTint(com.bilibili.lib.widget.R.color.auto_night_shade);
        BiliImageLoader.INSTANCE.with(this.mContext).url(AppResUtil.getImageUrl("bili_2233_authority_dialog_header.webp")).into(staticImageView2);
    }

    public void setUiBeforeShow() {
        switch (this.mState.state) {
            case NONE_AUTHORITY:
                this.mTitleTxt.setText(bili.resource.following.R.string.following_global_string_771);
                this.mMsgTxt.setText(TextUtils.isEmpty(this.mState.warning) ? this.mMsgTxt.getResources().getString(bili.resource.others.R.string.others_global_string_320) : this.mState.warning);
                this.mOKTxt.setText(bili.resource.following.R.string.following_global_string_508);
                this.mHintTxt.setVisibility(8);
                return;
            case ILLEGAL_NO:
                this.mTitleTxt.setText(bili.resource.others.R.string.others_global_string_13);
                this.mMsgTxt.setText(TextUtils.isEmpty(this.mState.warning) ? this.mMsgTxt.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1760) : this.mState.warning);
                this.mOKTxt.setText(bili.resource.others.R.string.others_global_string_248);
                this.mHintTxt.setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.ok) {
            String url = H5UrlConfigHelper.INSTANCE.getUrl("core", "url_bind_phone_h5", BIND_PHONE_H5);
            if (this.mState.state == AuthorityState.State.ILLEGAL_NO) {
                url = H5UrlConfigHelper.INSTANCE.getUrl("core", "url_change_phone_h5", CHANGE_PHONE_H5);
            }
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(url), v.getContext());
            dismiss();
        } else if (i == R.id.hint) {
            RouteRequest request = new RouteRequest.Builder(Uri.parse(RouterProtocol.URI_AUTH_LIVE_ROOM_IDENTIFY)).build();
            BLRouter.routeTo(request, v.getContext());
            dismiss();
        } else if (i == R.id.cancel) {
            dismiss();
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class AuthorityState implements Parcelable {
        public static final Parcelable.Creator<AuthorityState> CREATOR = new Parcelable.Creator<AuthorityState>() { // from class: tv.danmaku.bili.ui.authority.AuthorityDialog.AuthorityState.1
            @Override // android.os.Parcelable.Creator
            public AuthorityState createFromParcel(Parcel source) {
                return new AuthorityState(source);
            }

            @Override // android.os.Parcelable.Creator
            public AuthorityState[] newArray(int size) {
                return new AuthorityState[size];
            }
        };
        State state;
        String warning;

        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public enum State {
            NONE_AUTHORITY(61001),
            ILLEGAL_NO(61002);
            
            int status;

            State(int status) {
                this.status = status;
            }
        }

        public AuthorityState(int state, String warning) {
            this.state = State.NONE_AUTHORITY;
            this.warning = warning;
            this.state = state == State.NONE_AUTHORITY.status ? State.NONE_AUTHORITY : State.ILLEGAL_NO;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.warning);
            dest.writeInt(this.state.ordinal());
        }

        AuthorityState(Parcel in) {
            this.state = State.NONE_AUTHORITY;
            this.warning = in.readString();
            int tmpState = in.readInt();
            this.state = tmpState == -1 ? State.NONE_AUTHORITY : State.values()[tmpState];
        }
    }
}