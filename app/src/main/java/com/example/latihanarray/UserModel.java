package com.example.latihanarray;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String namaStr, jenisKelaminStr, pekerjaanStr;

    public UserModel(String namaStr, String jenisKelaminStr, String pekerjaanStr) {
        this.namaStr = namaStr;
        this.jenisKelaminStr = jenisKelaminStr;
        this.pekerjaanStr = pekerjaanStr;
    }

    protected UserModel(Parcel in) {
        namaStr = in.readString();
        jenisKelaminStr = in.readString();
        pekerjaanStr = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaStr);
        dest.writeString(jenisKelaminStr);
        dest.writeString(pekerjaanStr);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getNamaStr() {
        return namaStr;
    }

    public String getJenisKelaminStr() {
        return jenisKelaminStr;
    }

    public String getPekerjaanStr() {
        return pekerjaanStr;
    }
}
