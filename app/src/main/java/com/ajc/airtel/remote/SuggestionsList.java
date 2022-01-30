package com.ajc.airtel.remote;


import android.os.Parcel;
import android.os.Parcelable;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

public class SuggestionsList implements SearchSuggestion {

    private final String addressName;

    public SuggestionsList(String suggestion) {
        this.addressName = suggestion.toLowerCase();
    }

    public SuggestionsList(Parcel source) {
        this.addressName = source.readString();

    }

    @Override
    public String getBody() {
        return addressName;
    }

    public static final Parcelable.Creator<SuggestionsList> CREATOR = new Parcelable.Creator<SuggestionsList>() {
        @Override
        public SuggestionsList createFromParcel(Parcel in) {
            return new SuggestionsList(in);
        }

        @Override
        public SuggestionsList[] newArray(int size) {
            return new SuggestionsList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(addressName);
    }
}

