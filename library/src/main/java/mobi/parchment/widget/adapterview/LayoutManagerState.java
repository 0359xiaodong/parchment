package mobi.parchment.widget.adapterview;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by Emir Hasanbegovic on 2014-03-31.
 */
public class LayoutManagerState<Cell> extends View.BaseSavedState {

    private final int mOffset;
    private final int mStartCellPosition;

    LayoutManagerState(final Parcelable superState, final int offset, final int startOffset) {
        super(superState);
        mOffset = offset;
        mStartCellPosition = startOffset;
    }

    private LayoutManagerState(Parcel in) {
        super(in);
        mOffset = in.readInt();
        mStartCellPosition = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(mOffset);
        out.writeInt(mStartCellPosition);
    }

    public static final Parcelable.Creator<LayoutManagerState> CREATOR = new Parcelable.Creator<LayoutManagerState>() {
        public LayoutManagerState createFromParcel(Parcel in) {
            return new LayoutManagerState(in);
        }

        public LayoutManagerState[] newArray(int size) {
            return new LayoutManagerState[size];
        }
    };

    public int getOffset() {
        return mOffset;
    }

    public int getStartCellPosition() {
        return mStartCellPosition;
    }
}
