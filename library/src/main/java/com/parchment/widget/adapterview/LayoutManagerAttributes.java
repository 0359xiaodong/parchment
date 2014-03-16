package com.parchment.widget.adapterview;

public class LayoutManagerAttributes {

	private static class DefaultValues {
		private static final SnapPosition SNAP_POSITION = SnapPosition.center;
	}

	private boolean mIsCircularScroll;
	private boolean mIsViewPager;
	private boolean mIsVertical;
	private int mViewPagerInterval;
	private boolean mSnapToPosition;
	private SnapPosition mSnapPosition;
	private int mCellSpacing;
	private boolean mSelectOnSnap;
	private boolean mSelectWhileScrolling;

	public LayoutManagerAttributes(final boolean isCircularScroll, final boolean snapToPosition, final boolean isViewPager, final int viewPagerInterval, final SnapPosition snapPosition, final int cellSpacing, final boolean selectOnSnap, final boolean selectWhileScrolling, final boolean isVertical) {
		super();

		if (snapPosition != null)
			mSnapPosition = snapPosition;
		else
			mSnapPosition = DefaultValues.SNAP_POSITION;

		mViewPagerInterval = viewPagerInterval;
		mIsViewPager = isViewPager;
		mIsCircularScroll = isCircularScroll;
		mSnapToPosition = snapToPosition;
		mCellSpacing = cellSpacing;
		mSelectOnSnap = selectOnSnap;
		mIsVertical = isVertical;
		mSelectWhileScrolling = selectWhileScrolling;
	}

	public boolean isCircularScroll() {
		return mIsCircularScroll;
	}

	public boolean isSnapToPosition() {
		return mSnapToPosition;
	}

	public SnapPosition getSnapPosition() {
		return mSnapPosition;
	}

	public boolean selectOnSnap() {
		return mSelectOnSnap;
	}

	public int getCellSpacing() {
		return mCellSpacing;
	}

	public boolean isViewPager() {
		return mIsViewPager;
	}

	public int getViewPagerInterval() {
		return mViewPagerInterval;
	}
	
	public boolean isVertical() {
		return mIsVertical;
	}

	public boolean usesCellSpacing(){
		return mSnapPosition == SnapPosition.floatStartWithCellSpacing
		||  mSnapPosition == SnapPosition.floatStartWithCellSpacing
		||  mSnapPosition == SnapPosition.floatEndWithCellSpacing
		||  mSnapPosition == SnapPosition.onScreenWithCellSpacing;
	}
	
	public boolean isSnapPositionOnScreen() {
		return mSnapPosition == SnapPosition.onScreen || mSnapPosition == SnapPosition.onScreenWithCellSpacing;
	}
	
	public boolean selectWhileScrolling() {
		return mSelectWhileScrolling;
	}
}
