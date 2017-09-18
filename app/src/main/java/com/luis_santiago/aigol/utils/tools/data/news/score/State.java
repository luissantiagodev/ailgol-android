package com.luis_santiago.aigol.utils.tools.data.news.score;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Luis Fernando Santiago Ruiz on 9/17/17.
 */

public class State implements Parcelable {
    private boolean hasStarted;
    private boolean isDone;

    public State(boolean hasStarted, boolean isDone) {
        this.hasStarted = hasStarted;
        this.isDone = isDone;
    }

    protected State(Parcel in) {
        hasStarted = in.readByte() != 0;
        isDone = in.readByte() != 0;
    }

    public static final Creator<State> CREATOR = new Creator<State>() {
        @Override
        public State createFromParcel(Parcel in) {
            return new State(in);
        }

        @Override
        public State[] newArray(int size) {
            return new State[size];
        }
    };

    public boolean getHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (hasStarted ? 1 : 0));
        parcel.writeByte((byte) (isDone ? 1 : 0));
    }

    @Override
    public String toString() {
        return "State{" +
                "hasStarted=" + hasStarted +
                ", isDone=" + isDone +
                '}';
    }
}