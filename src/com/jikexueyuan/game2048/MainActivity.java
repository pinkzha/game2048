package com.jikexueyuan.game2048;



import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private MediaPlayer Mm,Mb;
	
	public MainActivity() {
		mainActivity = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvScore = (TextView) findViewById(R.id.tvScore);
		animLayer = (AnimLayer) findViewById(R.id.animLayer);
		Mm = MediaPlayer.create(this, R.raw.move);
		Mb = MediaPlayer.create(this, R.raw.bom);
	}


	@Override
	public void onDestroy(){
		super.onDestroy();
		Mm.stop();
		Mb.stop();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void startMove(){
		Mm.start();
	}
	public void startBom(){
		Mb.start();
	}
	public void clearScore(){
		score = 0;
		bom = 5;
		showScore();
	}
	
	public void showScore(){
		tvScore.setText(score+"	Õ¨µ¯:" + bom+"  ");
	}
	
	public void addScore(int s){
		score+=s;
		if(score - lastScore > 200){
			bom++;
			lastScore = score;
		}
		showScore();
	}

	public boolean reduceBom()
	{
		if(bom == 0)
	       return false;
		bom--;
		showScore();
		return true;
	}
	public AnimLayer getAnimLayer() {
		return animLayer;
	}

	private int bom = 5;
	private int score = 0;
	private int lastScore = 0;
	private TextView tvScore;
	private AnimLayer animLayer = null;
	
	private static MainActivity mainActivity = null;
	
	public static MainActivity getMainActivity() {
		return mainActivity;
	}

}
