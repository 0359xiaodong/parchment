package com.parchment.widget.adapterview;

/**
 * Created by Emir Hasanbegovic
 * Keeps track of Animation states between layouts.
 */
public class Animation {
	private static final int ANIMATION_ID_LIMIT = 100;
	private int mId;
	private int mDisplacement;

	void setId(final int id) {
		mId = id;
	}

	public int getId() {
		return mId;
	}

	void setDisplacement(final int displacemente) {
		mDisplacement = displacemente;
	}

	public int getDisplacement() {
		return mDisplacement;
	}

	void newAnimation() {
		mId = (mId + 1) % ANIMATION_ID_LIMIT;
		mDisplacement = 0;
	}

    @Override
    public String toString() {
        return " [ mid: "  +  mId + " mDisplacement: " + mDisplacement + " ] ";
    }
}
