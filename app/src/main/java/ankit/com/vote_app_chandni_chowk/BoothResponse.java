package ankit.com.vote_app_chandni_chowk;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BoothResponse implements Serializable {
    @SerializedName("id")
    public String id;

    @SerializedName("address")
    public String address;

    @SerializedName("queue_count")
    public int queue_count;

    @SerializedName("latitude")
    public float latitude;

    @SerializedName("longitude")
    public float longitude;

    @SerializedName("img_url")
    public String ImageURL;

    @SerializedName("ramp")
    public boolean ramp;

    @SerializedName("drinking_water")
    public boolean drinking_water;

    @SerializedName("furniture")
    public boolean furniture;

    @SerializedName("medical_kit")
    public boolean medical_kit;

    @SerializedName("light")
    public boolean light;

    @SerializedName("help_desk")
    public boolean help_desk;

    @SerializedName("shed")
    public boolean shed;

    @SerializedName("toilet")
    public boolean toilet;

    @SerializedName("volunteers")
    public boolean volunteers;

    @SerializedName("creche")
    public boolean creche;

    @SerializedName("transport")
    public boolean transport;

    @Override
    public String toString() {
        return super.toString();
    }

}
