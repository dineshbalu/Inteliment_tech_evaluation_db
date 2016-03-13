package db.apps.android.intelimenttechevaluation.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dineshbalu on 13/03/16.
 */
public class TransportData implements Parcelable {

    public int id;
    public String name;
    public FromCentral fromcentral;
    public Location location;

    protected TransportData(Parcel in) {
    }

    public static final Creator<TransportData> CREATOR = new Creator<TransportData>() {
        @Override
        public TransportData createFromParcel(Parcel in) {
            return new TransportData(in);
        }

        @Override
        public TransportData[] newArray(int size) {
            return new TransportData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }


    public class FromCentral{
        public String car;
        public String train;
    }

    public class Location{
        public double latitude;
        public double longitude;
    }
}
