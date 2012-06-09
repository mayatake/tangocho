package com.koyamalab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class QuestionActivity extends Activity {
	
	// create ViewFlipper, ViewPager instance
	ViewFlipper viewFlipper;
	ViewPager viewPager1;
	ViewPager viewPager2;
	ViewPager viewPager3;

	// create GestureDetector instance
	GestureDetector gestureDetector;
	
	// animation
	Animation inFromAbove;
	Animation inFromBelow;
	Animation outToAbove;
	Animation outToBelow;
	
	OnTouchListener onTouchListener = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if (gestureDetector.onTouchEvent(event)) {
				return true;
			}
			return false;
		}
	};
	
	OnGestureListener gestureListener = new OnGestureListener() {

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			
			float dx = Math.abs(velocityX);
			float dy = Math.abs(velocityY);
			if(dy > dx && dy > 150 ) {
				if(e1.getY() < e2.getY()) {
					viewFlipper.setInAnimation(inFromBelow);
					viewFlipper.setOutAnimation(outToAbove);
					viewFlipper.showPrevious();
					
					// 次の単語を読み込む処理
					// setWord(nextWord);
				} else {
					viewFlipper.setInAnimation(inFromAbove);
					viewFlipper.setOutAnimation(outToBelow);
					viewFlipper.showNext();
					
					// 前の単語を読み込む処理
					// setWord(previousWord);					
				}
				
				return true;
			}
			
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base);
		
		viewPager1 = (ViewPager)findViewById(R.id.viewPager1);
		viewPager2 = (ViewPager)findViewById(R.id.viewPager2);
		viewPager3 = (ViewPager)findViewById(R.id.viewPager3);
		
		viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
		
		PagerAdapter pagerAdapter1 = new MyPagerAdapter();
		viewPager1.setAdapter(pagerAdapter1);
		
		PagerAdapter pagerAdapter2 = new MyPagerAdapter();
		viewPager2.setAdapter(pagerAdapter2);
		
		PagerAdapter pagerAdapter3 = new MyPagerAdapter();
		viewPager3.setAdapter(pagerAdapter3);
		
		gestureDetector = new GestureDetector(this, gestureListener);
		
		// アニメーションの生成
		inFromAbove = AnimationUtils.loadAnimation(this, R.anim.in_from_above);
		inFromBelow = AnimationUtils.loadAnimation(this, R.anim.in_from_below);
		outToAbove = AnimationUtils.loadAnimation(this, R.anim.out_to_above);
		outToBelow = AnimationUtils.loadAnimation(this, R.anim.out_to_below);
		
		// フリック処理のためのイベント設定
		viewPager1.setOnTouchListener(onTouchListener);
		viewPager2.setOnTouchListener(onTouchListener);
		viewPager3.setOnTouchListener(onTouchListener);
		
	}
	
	private class MyPagerAdapter extends PagerAdapter {

		/* (non-Javadoc)
		 * @see android.support.v4.view.PagerAdapter#destroyItem(android.view.ViewGroup, int, java.lang.Object)
		 */
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager)container).removeView((View)object);
		}

		/* (non-Javadoc)
		 * @see android.support.v4.view.PagerAdapter#instantiateItem(android.view.ViewGroup, int)
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			int[] pages = {R.layout.question, R.layout.anser};
			LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			LinearLayout linearLayout = (LinearLayout)inflater.inflate(pages[position], null);
			container.addView(linearLayout);
			
			//return textView;
			return linearLayout;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view.equals(object);
		}
		
	}

}
