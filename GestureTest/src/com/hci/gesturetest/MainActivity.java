package com.hci.gesturetest;

import com.hci.gesturetest.SimpleGestureFilter.SimpleGestureListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SimpleGestureListener, OnTouchListener {
	
	private SimpleGestureFilter detector;
	ScaleGestureDetector scaleGestureDetector;
	
	TextView text;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		scaleGestureDetector = new ScaleGestureDetector(getApplicationContext(), new simpleOnScaleGestureListener());
		detector = new SimpleGestureFilter(this,this);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	 // TODO Auto-generated method stub
	 scaleGestureDetector.onTouchEvent(event);
	 return true;
	}
	
	// for pinch zooming 
	public class simpleOnScaleGestureListener extends SimpleOnScaleGestureListener {

	 @Override
	 public boolean onScale(ScaleGestureDetector detector) {
	  //scaleGesture.setText(String.valueOf(detector.getScaleFactor()));
	  return true;
	 }

	 @Override
	 public boolean onScaleBegin(ScaleGestureDetector detector) {
	  // TODO Auto-generated method stub
	  //scaleGesture.setVisibility(View.VISIBLE);
	  return true;
	 }

	 @Override
	 public void onScaleEnd(ScaleGestureDetector detector) {
	  // TODO Auto-generated method stub
	  //scaleGesture.setVisibility(View.INVISIBLE);
		 Toast.makeText(getApplicationContext(), "pich", Toast.LENGTH_SHORT).show();
	 }

	}
	
	 @Override
	    public boolean dispatchTouchEvent(MotionEvent me){
	        // Call onTouchEvent of SimpleGestureFilter class
	         this.detector.onTouchEvent(me);
	       return super.dispatchTouchEvent(me);
	    }

	@Override
	public void onSwipe(int direction) {
		// TODO Auto-generated method stub
		String str = "";
	      
	      switch (direction) {
	      
	      case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
	                                               break;
	      case SimpleGestureFilter.SWIPE_LEFT : str = "Swipe Left";
	                                                     break;
	      case SimpleGestureFilter.SWIPE_DOWN : str = "Swipe Down";
	                                                     break;
	      case SimpleGestureFilter.SWIPE_UP : str = "Swipe Up";
	                                                     break;
	      
	      }
	       Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDoubleTap() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
	}
	
	@Override
    public void onLongPress() {
 	   Toast.makeText(this, "Long Press", Toast.LENGTH_LONG).show();
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
