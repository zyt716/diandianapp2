package com.example.asus.diandianapp2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class cctv2HD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv2_hd);
        PlayerView playerView3=findViewById( R.id.player_view3 );
        //得到默认合适的带宽
        DefaultBandwidthMeter bandwidthMeter1 = new DefaultBandwidthMeter();
        // 创建跟踪的工厂
        TrackSelection.Factory videoTrackSelectionFactory1 = new AdaptiveTrackSelection.Factory(bandwidthMeter1);
        // 创建跟踪器
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory1);
        // 创建player
        SimpleExoPlayer player3= ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        // 开始播放，绑定player对象
        playerView3.setPlayer(player3);
        // 生成通过其加载媒体数据的DataSource实例
        com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory1 = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayer"), bandwidthMeter1);
        // 创建要播放的媒体的MediaSource
        Uri uri=Uri.parse( "http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221227207/index.m3u8" );
        MediaSource mediaSource1 = new HlsMediaSource.Factory(dataSourceFactory1).createMediaSource(uri);
        // 准备播放器的MediaSource
        player3.prepare(mediaSource1);
        // 当准备完毕后直接播放
        player3.setPlayWhenReady(true);
    }
}
