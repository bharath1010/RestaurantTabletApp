package com.falconnect.buffetbee;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.falconnect.buffetbee.Adapter.Commonclass;
import java.util.List;

/**
 * Created by Android on 10/11/2017.
 */

public class Voice_popup implements RecognitionListener {
    Activity objActivity;
    Dialog Voice_Layout;
    SpeechRecognizer speech;
Commonclass.GetRequestDetails objGetRequestDetails;
    public Voice_popup(Activity objActivityv, Commonclass.GetRequestDetails objGetRequestDetailsv) {
        objActivity = objActivityv;
        objGetRequestDetails = objGetRequestDetailsv;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (android.support.v4.content.ContextCompat.checkSelfPermission(objActivity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                // Permission has never been accepted
                // So, I ask the user for permission
                ActivityCompat.requestPermissions(objActivity, new String[]{Manifest.permission.RECORD_AUDIO}, 100);
                return;
            }
        }
        Voice_Layout = new Dialog(objActivity, R.style.MaterialDialogSheet);
        Voice_Layout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Voice_Layout.setContentView(R.layout.voice_popup);
        Voice_Layout.setCancelable(true);
        Voice_Layout.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        WebView web_view = (WebView)Voice_Layout.findViewById(R.id.Webview);
        ImageView Backbutton = (ImageView)Voice_Layout.findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Voice_Layout.dismiss();
            }
        });
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setInitialScale(1);
        web_view.getSettings().setLoadWithOverviewMode(true);
        web_view.getSettings().setUseWideViewPort(true);
        web_view.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        web_view.loadUrl("file:///android_asset/test.html");
        web_view.setBackgroundColor(Color.parseColor("#FFFFFF"));
        StartVoiceRecognitionActivity();
    }

    public void Show() {
        if(Voice_Layout != null) {
            Voice_Layout.show();
        }
    }

    public void Dismiss() {
        Voice_Layout.dismiss();
    }

    private void StartVoiceRecognitionActivity() {
        String rec = PackageManager.FEATURE_MICROPHONE;
        if (rec != "android.hardware.microphone") {
            Commonclass.Alert_OK(objActivity, "You don't seem to have a microphone to record with");
            return;
        }
        // create the intent and start the activity
        speech = SpeechRecognizer.createSpeechRecognizer(objActivity);
        speech.setRecognitionListener(this);
        //// put a message on the modal dialog
        Intent recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //// you can specify other languages recognised here, for example
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, objActivity.getApplication().getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 2);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
        //// if there is more then 1.5s of silence, consider the speech over
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 1500);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS, 1500);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 15000);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, java.util.Locale.getDefault());
        speech.startListening(recognizerIntent);
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int i) {
        String message;
        switch (i) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        //message = "Didn't understand, please try again.";
        Commonclass.Alert_OK(objActivity, message);
        Dismiss();
    }

    @Override
    public void onResults(Bundle bundle) {
        List<String> matches = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (matches.size() != 0) {
            String textInput = matches.get(0);
            // limit the output to 500 characters
            if (textInput.length() > 500)
                textInput = textInput.substring(0, 500);
//            Speachtext.Text = textInput;
            if (objGetRequestDetails != null) objGetRequestDetails.Callback(textInput);
//            Commonclass.Alert_OK(objActivity, textInput);
        } else
            Commonclass.Alert_OK(objActivity, "No speech was recognised");
        //List<String> matches = results.GetStringArrayList(SpeechRecognizer.ResultsRecognition).ToList();
        //String text = "";
        // foreach (String result in matches)
        //    text += result + "\n";
        Dismiss();
        speech.stopListening();
        speech.cancel();
        speech.destroy();

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
