package com.example.mediaplayerdemo;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button play1, zan1, stop1;
	private Button play2, zan2, stop2;
	MediaPlayer player1, player2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		player1 = MediaPlayer.create(this, R.raw.akonrightnow);
		String sd_card = "";
		sd_card = Environment.getExternalStorageDirectory().getAbsolutePath();
		final Uri uri = Uri.parse(sd_card);
		Log.i("TAG", "" + sd_card);
		try {
			player2 = new MediaPlayer();
			player2.setDataSource(sd_card + "/test.mp3");
			player2.prepare();
			// mMP3Player.setDataSource("file:///sdcard/by2.mp3");
			// mMP3Player.prepare();
			// mMP3Player.setOnPreparedListener(new OnPreparedListener() {
			//
			// public void onPrepared(MediaPlayer mp) {
			// // TODO Auto-generated method stub
			// mp.start();
			// }
			// });

			// MP3_Player.reset();
			// MP3_Player.setDataSource("/mnt/sdcard/test.mp3");
			// MP3_Player.prepare();
			// MP3_Player.setOnPreparedListener(new OnPreparedListener() {
			//
			// @Override
			// public void onPrepared(MediaPlayer arg0) {
			// // TODO Auto-generated method stub
			// arg0.start();
			// }
			// });

			// public void stop() {
			// if (mPlayer != null) {
			// mPlayer.release();
			// mPlayer = null;
			// }
			// }
			//
			// public void play(Context c) {
			//
			// stop();
			//
			// mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
			//
			// mPlayer.setOnCompletionListener(new
			// MediaPlayer.OnCompletionListener() {
			// public void onCompletion(MediaPlayer mp) {
			// stop();
			// }
			// });
			//
			// mPlayer.start();
			// }

		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		play1 = (Button) findViewById(R.id.play1);
		zan1 = (Button) findViewById(R.id.zanting1);
		stop1 = (Button) findViewById(R.id.stop1);
		play2 = (Button) findViewById(R.id.play2);
		zan2 = (Button) findViewById(R.id.zanting2);
		stop2 = (Button) findViewById(R.id.stop2);
		play1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (player1 != null) {
					player1.stop();
				}
				try {
					player1.prepare();
					player1.start();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		zan1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {

					player1.pause();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		stop1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {

					player1.start();
					player1.pause();
					player1.seekTo((int) 0);
					// player1 = MediaPlayer.create(MainActivity.this,
					// R.raw.akonrightnow);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		play2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (player2 != null) {
					player2.stop();
				}
				try {
					player2.prepare();
					player2.start();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		zan2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {

					player2.pause();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		stop2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					player2.start();
					player2.pause();
					player2.seekTo((int) 0);
					Log.i("TAG", "" + player2.getCurrentPosition());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		/**
		 * 没啥用
		 */
		player2.setOnErrorListener(new OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				// TODO Auto-generated method stub
				player2.reset();
				return false;
			}
		});
		player1.setOnErrorListener(new OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				// TODO Auto-generated method stub
				player2.reset();
				return false;
			}
		});

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		player1.release();
		player2.release();
		super.onDestroy();
	}
}
