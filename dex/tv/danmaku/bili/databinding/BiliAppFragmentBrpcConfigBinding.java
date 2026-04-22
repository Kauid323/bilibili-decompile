package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppFragmentBrpcConfigBinding implements ViewBinding {
    public final TextView biz;
    public final Switch bizBrpcEnable;
    public final Switch brpcTestFallbackGrpcEncoding;
    public final Switch brpcTestHttpdns;
    public final Switch brpcTestNewChannel;
    public final Switch brpcTestOkhttpBridge;
    public final Switch brpcTestQuic;
    public final Switch brpcTestSerial;
    public final Switch brpcTestSerialInterval;
    public final Switch brpcTestUat;
    public final View dividerBiz;
    public final View dividerTest;
    public final View dividerTestDfm;
    public final View dividerTestProbe;
    public final View dividerTestRest;
    public final View dividerTestRoom;
    public final View dividerTestSuggest;
    public final View dividerTestTicket;
    public final View dividerTool;
    public final EditText editTestBroadcastHeartbeat;
    public final EditText editTestBroadcastHeartbeatRetry;
    public final EditText editTestBroadcastPort;
    public final EditText editTestCount;
    public final EditText editTestDfmAidCid;
    public final EditText editTestRoomId;
    public final EditText editTestSuggestKeyword;
    public final EditText editTestTimeout;
    public final Button getTicket;
    public final Guideline guideline;
    public final Guideline guideline2;
    public final Button restEcho;
    public final Button restEchoBody;
    public final Button restEchoDelete;
    public final Button restEchoError;
    public final Button restEchoPatch;
    private final ScrollView rootView;
    public final ScrollView scroll;
    public final TextView test;
    public final Button testBandwidthHeartbeat;
    public final Button testBandwidthSpaceArchive;
    public final Button testBandwidthSplash;
    public final Switch testBlockingApi;
    public final Button testBroadcastAppPushRegister;
    public final Button testBroadcastAppPushUnregister;
    public final TextView testBroadcastHeartbeat;
    public final Switch testBroadcastHeartbeatEnable;
    public final TextView testBroadcastHeartbeatRetry;
    public final Button testBroadcastModRegister;
    public final Button testBroadcastModUnregister;
    public final TextView testBroadcastPort;
    public final Button testBroadcastStart;
    public final Button testBroadcastStop;
    public final TextView testCount;
    public final TextView testDfm;
    public final Button testDfmRegMobile;
    public final Switch testDowngrade;
    public final Switch testFailover;
    public final TextView testLogUpload;
    public final Button testLogUploadAdd;
    public final Button testLogUploadAddRegister;
    public final Button testLogUploadAddUnregister;
    public final Button testLogUploadUnwatch;
    public final Button testLogUploadWatch;
    public final TextView testProbe;
    public final Button testProbeCode;
    public final TextView testRegion;
    public final Button testRegionNormal;
    public final Switch testRestContentTypeForm;
    public final LinearLayout testRestLayout1;
    public final LinearLayout testRestLayout2;
    public final TextView testRestTitle;
    public final TextView testRoom;
    public final TextView testRoomId;
    public final Button testRoomJoin;
    public final Button testRoomLeave;
    public final Button testRoomOnline;
    public final TextView testSuggest;
    public final TextView testSuggestKeyword;
    public final Button testSuggestMalformed;
    public final Button testSuggestNonexist;
    public final Button testSuggestNormal;
    public final Button testSuggestRetrofit;
    public final LinearLayout testTicketLayout1;
    public final TextView testTicketTitle;
    public final TextView testTimeout;
    public final Switch toolEnable;

    private BiliAppFragmentBrpcConfigBinding(ScrollView rootView, TextView biz, Switch bizBrpcEnable, Switch brpcTestFallbackGrpcEncoding, Switch brpcTestHttpdns, Switch brpcTestNewChannel, Switch brpcTestOkhttpBridge, Switch brpcTestQuic, Switch brpcTestSerial, Switch brpcTestSerialInterval, Switch brpcTestUat, View dividerBiz, View dividerTest, View dividerTestDfm, View dividerTestProbe, View dividerTestRest, View dividerTestRoom, View dividerTestSuggest, View dividerTestTicket, View dividerTool, EditText editTestBroadcastHeartbeat, EditText editTestBroadcastHeartbeatRetry, EditText editTestBroadcastPort, EditText editTestCount, EditText editTestDfmAidCid, EditText editTestRoomId, EditText editTestSuggestKeyword, EditText editTestTimeout, Button getTicket, Guideline guideline, Guideline guideline2, Button restEcho, Button restEchoBody, Button restEchoDelete, Button restEchoError, Button restEchoPatch, ScrollView scroll, TextView test, Button testBandwidthHeartbeat, Button testBandwidthSpaceArchive, Button testBandwidthSplash, Switch testBlockingApi, Button testBroadcastAppPushRegister, Button testBroadcastAppPushUnregister, TextView testBroadcastHeartbeat, Switch testBroadcastHeartbeatEnable, TextView testBroadcastHeartbeatRetry, Button testBroadcastModRegister, Button testBroadcastModUnregister, TextView testBroadcastPort, Button testBroadcastStart, Button testBroadcastStop, TextView testCount, TextView testDfm, Button testDfmRegMobile, Switch testDowngrade, Switch testFailover, TextView testLogUpload, Button testLogUploadAdd, Button testLogUploadAddRegister, Button testLogUploadAddUnregister, Button testLogUploadUnwatch, Button testLogUploadWatch, TextView testProbe, Button testProbeCode, TextView testRegion, Button testRegionNormal, Switch testRestContentTypeForm, LinearLayout testRestLayout1, LinearLayout testRestLayout2, TextView testRestTitle, TextView testRoom, TextView testRoomId, Button testRoomJoin, Button testRoomLeave, Button testRoomOnline, TextView testSuggest, TextView testSuggestKeyword, Button testSuggestMalformed, Button testSuggestNonexist, Button testSuggestNormal, Button testSuggestRetrofit, LinearLayout testTicketLayout1, TextView testTicketTitle, TextView testTimeout, Switch toolEnable) {
        this.rootView = rootView;
        this.biz = biz;
        this.bizBrpcEnable = bizBrpcEnable;
        this.brpcTestFallbackGrpcEncoding = brpcTestFallbackGrpcEncoding;
        this.brpcTestHttpdns = brpcTestHttpdns;
        this.brpcTestNewChannel = brpcTestNewChannel;
        this.brpcTestOkhttpBridge = brpcTestOkhttpBridge;
        this.brpcTestQuic = brpcTestQuic;
        this.brpcTestSerial = brpcTestSerial;
        this.brpcTestSerialInterval = brpcTestSerialInterval;
        this.brpcTestUat = brpcTestUat;
        this.dividerBiz = dividerBiz;
        this.dividerTest = dividerTest;
        this.dividerTestDfm = dividerTestDfm;
        this.dividerTestProbe = dividerTestProbe;
        this.dividerTestRest = dividerTestRest;
        this.dividerTestRoom = dividerTestRoom;
        this.dividerTestSuggest = dividerTestSuggest;
        this.dividerTestTicket = dividerTestTicket;
        this.dividerTool = dividerTool;
        this.editTestBroadcastHeartbeat = editTestBroadcastHeartbeat;
        this.editTestBroadcastHeartbeatRetry = editTestBroadcastHeartbeatRetry;
        this.editTestBroadcastPort = editTestBroadcastPort;
        this.editTestCount = editTestCount;
        this.editTestDfmAidCid = editTestDfmAidCid;
        this.editTestRoomId = editTestRoomId;
        this.editTestSuggestKeyword = editTestSuggestKeyword;
        this.editTestTimeout = editTestTimeout;
        this.getTicket = getTicket;
        this.guideline = guideline;
        this.guideline2 = guideline2;
        this.restEcho = restEcho;
        this.restEchoBody = restEchoBody;
        this.restEchoDelete = restEchoDelete;
        this.restEchoError = restEchoError;
        this.restEchoPatch = restEchoPatch;
        this.scroll = scroll;
        this.test = test;
        this.testBandwidthHeartbeat = testBandwidthHeartbeat;
        this.testBandwidthSpaceArchive = testBandwidthSpaceArchive;
        this.testBandwidthSplash = testBandwidthSplash;
        this.testBlockingApi = testBlockingApi;
        this.testBroadcastAppPushRegister = testBroadcastAppPushRegister;
        this.testBroadcastAppPushUnregister = testBroadcastAppPushUnregister;
        this.testBroadcastHeartbeat = testBroadcastHeartbeat;
        this.testBroadcastHeartbeatEnable = testBroadcastHeartbeatEnable;
        this.testBroadcastHeartbeatRetry = testBroadcastHeartbeatRetry;
        this.testBroadcastModRegister = testBroadcastModRegister;
        this.testBroadcastModUnregister = testBroadcastModUnregister;
        this.testBroadcastPort = testBroadcastPort;
        this.testBroadcastStart = testBroadcastStart;
        this.testBroadcastStop = testBroadcastStop;
        this.testCount = testCount;
        this.testDfm = testDfm;
        this.testDfmRegMobile = testDfmRegMobile;
        this.testDowngrade = testDowngrade;
        this.testFailover = testFailover;
        this.testLogUpload = testLogUpload;
        this.testLogUploadAdd = testLogUploadAdd;
        this.testLogUploadAddRegister = testLogUploadAddRegister;
        this.testLogUploadAddUnregister = testLogUploadAddUnregister;
        this.testLogUploadUnwatch = testLogUploadUnwatch;
        this.testLogUploadWatch = testLogUploadWatch;
        this.testProbe = testProbe;
        this.testProbeCode = testProbeCode;
        this.testRegion = testRegion;
        this.testRegionNormal = testRegionNormal;
        this.testRestContentTypeForm = testRestContentTypeForm;
        this.testRestLayout1 = testRestLayout1;
        this.testRestLayout2 = testRestLayout2;
        this.testRestTitle = testRestTitle;
        this.testRoom = testRoom;
        this.testRoomId = testRoomId;
        this.testRoomJoin = testRoomJoin;
        this.testRoomLeave = testRoomLeave;
        this.testRoomOnline = testRoomOnline;
        this.testSuggest = testSuggest;
        this.testSuggestKeyword = testSuggestKeyword;
        this.testSuggestMalformed = testSuggestMalformed;
        this.testSuggestNonexist = testSuggestNonexist;
        this.testSuggestNormal = testSuggestNormal;
        this.testSuggestRetrofit = testSuggestRetrofit;
        this.testTicketLayout1 = testTicketLayout1;
        this.testTicketTitle = testTicketTitle;
        this.testTimeout = testTimeout;
        this.toolEnable = toolEnable;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentBrpcConfigBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentBrpcConfigBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_brpc_config, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -128
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static tv.danmaku.bili.databinding.BiliAppFragmentBrpcConfigBinding bind(android.view.View r175) {
        /*
            Method dump skipped, instructions count: 1301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.databinding.BiliAppFragmentBrpcConfigBinding.bind(android.view.View):tv.danmaku.bili.databinding.BiliAppFragmentBrpcConfigBinding");
    }
}