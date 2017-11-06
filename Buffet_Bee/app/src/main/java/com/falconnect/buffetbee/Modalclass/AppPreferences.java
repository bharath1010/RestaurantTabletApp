package com.falconnect.buffetbee.Modalclass;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Android on 10/13/2017.
 */

public class AppPreferences {

    private SharedPreferences mSharedPrefs;
    private SharedPreferences.Editor mPrefsEditor;
    private Context mContext;

    public AppPreferences(Context context) {
        this.mContext = context;
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mPrefsEditor = mSharedPrefs.edit();
    }

    public void Set_Watertime(String Watertime) {
        mPrefsEditor.putString("Watertime", Watertime);
        mPrefsEditor.commit();
    }

    public String Get_Watertime() {
        return mSharedPrefs.getString("Watertime", "");
    }

    public void Set_Napkintime(String Napkintime) {
        mPrefsEditor.putString("Napkintime", Napkintime);
        mPrefsEditor.commit();
    }

    public String Get_Napkintime() {
        return mSharedPrefs.getString("Napkintime", "");
    }

    public void Set_Othertime(String Othertime) {
        mPrefsEditor.putString("Othertime", Othertime);
        mPrefsEditor.commit();
    }

    public String Get_Othertime() {
        return mSharedPrefs.getString("Othertime", "");
    }

    public void Set_Alerttime(String Alerttime) {
        mPrefsEditor.putString("Alerttime", Alerttime);
        mPrefsEditor.commit();
    }

    public String Get_Alerttime() {
        return mSharedPrefs.getString("Alerttime", "");
    }

    public String Get_Branchcode() {
        return mSharedPrefs.getString("Branchcode", "");
    }

    public void Set_Branchcode(String Branchcode) {
        mPrefsEditor.putString("Branchcode", Branchcode);
        mPrefsEditor.commit();
    }


    public void Set_Tablecode(String Tablecode) {
        mPrefsEditor.putString("Tablecode", Tablecode);
        mPrefsEditor.commit();
    }

    public String Get_Tablecode() {
        return mSharedPrefs.getString("Tablecode", "");
    }

    public void Set_Branchdata(List<String> Branchdata) {
        mPrefsEditor.putInt("Status_size", Branchdata.size());

        for(int i=0;i<Branchdata.size();i++)
        {
            mPrefsEditor.putString("Status_" + i, Branchdata.get(i));
        }
        mPrefsEditor.commit();
    }

    public List<String> Get_Branchdata() {
        int size = mSharedPrefs.getInt("Status_size", 0);
        List<String> Branchdata = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            Branchdata.add(mSharedPrefs.getString("Status_" + i, null));
        }
        return Branchdata;
    }


}
